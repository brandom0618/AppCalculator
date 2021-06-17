package com.example.apipokemon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.apipokemon.apimanager.Api;
import com.example.apipokemon.apimanager.RetrofitClient;
import com.example.apipokemon.models.Pokemon;
import com.example.apipokemon.models.PokemonAdapter;
import com.example.apipokemon.models.PokemonRespuesta;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PokemonAdapter pokemonAdapter;
    private PokemonRespuesta myPokemon;
    private int offset;
    private boolean Cargar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        pokemonAdapter = new PokemonAdapter(this);
        recyclerView.setAdapter(pokemonAdapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    int visibleItemCount = layoutManager.getChildCount();
                    int totalItemCount = layoutManager.getItemCount();
                    int pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                    if (Cargar) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            Cargar = false;
                            offset += 20;
                            getFromInternetPokemon(offset);
                        }
                    }
                }
            }
        });
        Cargar = true;
        offset = 0;
        getFromInternetPokemon(offset);

    }

    private void getFromInternetPokemon(int offset){
        Call<PokemonRespuesta> call = RetrofitClient.getInstance().getMyApi().getListaPokemon(20,offset);
        call.enqueue(new Callback<PokemonRespuesta>() {
            @Override
            public void onResponse(Call<PokemonRespuesta> call, Response<PokemonRespuesta> response) {
                Cargar = true;
                if(response.isSuccessful()){
                    myPokemon = response.body();
                    ArrayList<Pokemon> listaPokemon = myPokemon.getResults();
                    pokemonAdapter.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //MANDAR AL OTRO INTENT Y CONSULTAR MÁS INFORMACION DEL ID

                            Intent in = new Intent(getApplicationContext(), PokemonDetailActivity.class);
                            String id = String.valueOf(listaPokemon.get(recyclerView.getChildAdapterPosition(v)).getNumber());
                            in.putExtra("id", id);
                            startActivity(in);
                        }
                    });

                    pokemonAdapter.addPokemon(listaPokemon);

                }else{
                        Log.d("TAG", "Error: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<PokemonRespuesta> call, Throwable t) {
                Cargar = true;
                Toast.makeText(MainActivity.this, "Ocurrió un error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}