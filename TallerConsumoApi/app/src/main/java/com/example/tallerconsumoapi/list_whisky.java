package com.example.tallerconsumoapi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tallerconsumoapi.apimanager.RetrofitClient;
import com.example.tallerconsumoapi.models.Whisky;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class list_whisky extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView ListWhisky;
    List<Whisky> myWhisky;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_whisky);
        ListWhisky = findViewById(R.id.listWhisky);
        getFromInternetWhisky();
        ListWhisky.setOnItemClickListener(this);
    }

    private void getFromInternetWhisky(){
        Call<List<Whisky>> call = RetrofitClient.getInstance().getMyApi().getWhiskys();
        call.enqueue(new Callback<List<Whisky>>() {

            @Override
            public void onResponse(Call<List<Whisky>> call, Response<List<Whisky>> response) {
                myWhisky = response.body();
                WhiskyAdapter adapter = new WhiskyAdapter(list_whisky.this, myWhisky);
                ListWhisky.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Whisky>> call, Throwable t) {
                Toast.makeText(list_whisky.this, "Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       Intent in = new Intent(this,DetalleWhisky.class);
       in.putExtra("slug", myWhisky.get(position).getSlugWhisky());
       in.putExtra("url", myWhisky.get(position).getUrlWhisky());
       startActivity(in);
    }
}