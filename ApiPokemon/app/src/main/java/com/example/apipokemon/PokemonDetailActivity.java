package com.example.apipokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.apipokemon.apimanager.RetrofitClient;
import com.example.apipokemon.models.Habilidad;
import com.example.apipokemon.models.HabilidadRespuesta;
import com.example.apipokemon.models.Pokemon;
import com.example.apipokemon.models.PokemonGenero;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonDetailActivity extends AppCompatActivity {
    private String id;
    private TextView tvName;
    private TextView tvHeight;
    private TextView tvWeigth;
    private TextView tvGender;
    private ImageView imgPokemon;
    private EditText etAbilityInfo;
    HabilidadRespuesta myHabilidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        tvName = findViewById(R.id.tvNamePokemon);
        imgPokemon = findViewById(R.id.imgPokemon);
        tvHeight = findViewById(R.id.tvheightInfo);
        tvWeigth = findViewById(R.id.tvWeigthinfo);
        tvGender = findViewById(R.id.tvGenderInfo);
        etAbilityInfo = findViewById(R.id.etAbilityInfo);

        Bundle in = getIntent().getExtras();
        id = in.getString("id");

        getFromInternetDetail(id);
    }

    private void getFromInternetDetail(String id){
        Call<Pokemon> call = RetrofitClient.getInstance().getMyApi().getDetallePokemon(id);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                if(response.isSuccessful()){
                    Pokemon pokemon = response.body();
                    tvName.setText(pokemon.getName());
                    tvHeight.setText(String.valueOf(pokemon.getHeight())+" dm");
                    tvWeigth.setText(String.valueOf(pokemon.getWeight())+" hg");
                    Glide.with(getApplicationContext())
                            .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + id + ".png")
                            .centerCrop()
                            .diskCacheStrategy(DiskCacheStrategy.ALL)
                            .into(imgPokemon);
                }
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                Toast.makeText(PokemonDetailActivity.this, "Ocurrió un error detalle", Toast.LENGTH_SHORT).show();
            }
        });

        Call<PokemonGenero> callGender = RetrofitClient.getInstance().getMyApi().getPokemonGenero(id);
        callGender.enqueue(new Callback<PokemonGenero>() {
            @Override
            public void onResponse(Call<PokemonGenero> call, Response<PokemonGenero> response) {
                if(response.isSuccessful()){
                    PokemonGenero pokemon = response.body();
                    tvGender.setText(pokemon.getName());
                }else{
                    tvGender.setText("Not Register");
                }
            }

            @Override
            public void onFailure(Call<PokemonGenero> call, Throwable t) {
                Toast.makeText(PokemonDetailActivity.this, "Ocurrió un error genero", Toast.LENGTH_SHORT).show();
            }
        });

        Call<HabilidadRespuesta> callAbility = RetrofitClient.getInstance().getMyApi().getPokemonHabilidad(id);
        callAbility.enqueue(new Callback<HabilidadRespuesta>() {
            @Override
            public void onResponse(Call<HabilidadRespuesta> call, Response<HabilidadRespuesta> response) {
                if(response.isSuccessful()){
                    myHabilidad = response.body();
                    ArrayList<Habilidad> listaHabilidad = myHabilidad.getEffect_entries();
                    etAbilityInfo.setText(listaHabilidad.get(1).getShort_effect());
                }
            }

            @Override
            public void onFailure(Call<HabilidadRespuesta> call, Throwable t) {
                Toast.makeText(PokemonDetailActivity.this, "Ocurrió un error habilidad", Toast.LENGTH_SHORT).show();
            }
        });
    }
}