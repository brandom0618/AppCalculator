package com.example.tallerconsumoapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tallerconsumoapi.apimanager.RetrofitClient;
import com.example.tallerconsumoapi.models.Whisky;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleWhisky extends AppCompatActivity implements View.OnClickListener {

    private String slug;
    private String url;
    List<Whisky> whisky;
    private TextView tvUrl;
    private TextView tvWinningBidMean;
    private TextView tvWinningBidMin;
    private TextView tvTradingVolume;
    private TextView tvDate;
    private Button btnSitio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_whisky);
        tvUrl = findViewById(R.id.txtUrl);
        tvWinningBidMean = findViewById(R.id.tvWinningBidMean);
        tvWinningBidMin = findViewById(R.id.tvWinningBidMin);
        tvTradingVolume = findViewById(R.id.tvTradingVolume);
        tvDate = findViewById(R.id.tvDate);
        btnSitio = findViewById(R.id.btnSitio);

        Bundle in = getIntent().getExtras();
        slug = in.getString("slug");
        url = in.getString("url");
        getWhiskyBySlug(slug,url);

        btnSitio.setOnClickListener(this);
    }

    public void getWhiskyBySlug(String slug, String url){
        Call<List<Whisky>> call = RetrofitClient.getInstance().getMyApi().getWhisky(slug);
        call.enqueue(new Callback<List<Whisky>>() {
            @Override
            public void onResponse(Call<List<Whisky>> call, Response<List<Whisky>> response) {
                whisky = response.body();
                tvUrl.setText(url);
                tvDate.setText(whisky.get(0).getDate());
                tvTradingVolume.setText(whisky.get(0).getTradingVolume());
                tvWinningBidMean.setText(whisky.get(0).getWinningBidMean());
                tvWinningBidMin.setText(whisky.get(0).getWinningBidMin());
            }

            @Override
            public void onFailure(Call<List<Whisky>> call, Throwable t) {
                Toast.makeText(DetalleWhisky.this, "Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnSitio){
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    }
}