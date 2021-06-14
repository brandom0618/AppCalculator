package com.example.tallerconsumoapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imgWhisky;
    ImageView imgDestilerias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgWhisky = findViewById(R.id.imgWhisky);
        imgDestilerias = findViewById(R.id.imgDestileria);

        imgWhisky.setOnClickListener(this);
        imgDestilerias.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.imgWhisky){
            Intent intent = new Intent(MainActivity.this, list_whisky.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(MainActivity.this, list_destilerias.class);
            startActivity(intent);
        }
    }
}