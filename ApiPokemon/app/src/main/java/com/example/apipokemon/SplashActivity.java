package com.example.apipokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;

public class SplashActivity extends AppCompatActivity {

    private SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        preferencias = getSharedPreferences("preferenciasFile", MODE_PRIVATE);

        Thread hilo = new Thread(){

            @Override
            public void run() {
                try {
                    sleep(1000);

                    Intent activity_login = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(activity_login);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }


        };
        hilo.start();
    }
}