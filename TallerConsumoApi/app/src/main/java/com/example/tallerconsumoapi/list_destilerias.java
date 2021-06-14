package com.example.tallerconsumoapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tallerconsumoapi.apimanager.RetrofitClient;
import com.example.tallerconsumoapi.models.Destileria;
import com.example.tallerconsumoapi.models.Whisky;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class list_destilerias extends AppCompatActivity {

    ListView ListDestilerias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_destilerias);
        ListDestilerias = findViewById(R.id.listDestilerias);
        getFromInternetDestilerias();
    }

    private void getFromInternetDestilerias(){
        Call<List<Destileria>> call = RetrofitClient.getInstance().getMyApi().getDestilerias();
        call.enqueue(new Callback<List<Destileria>>() {

            @Override
            public void onResponse(Call<List<Destileria>> call, Response<List<Destileria>> response) {
                List<Destileria> myDestilerias = response.body();
                DestileriaAdapter adapter = new DestileriaAdapter(list_destilerias.this, myDestilerias);
                ListDestilerias.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Destileria>> call, Throwable t) {
                Toast.makeText(list_destilerias.this, "Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}