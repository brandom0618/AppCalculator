package com.example.appcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.VolumeShaper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnNum0;
    private Button btnNum1;
    private Button btnNum2;
    private Button btnNum3;
    private Button btnNum4;
    private Button btnNum5;
    private Button btnNum6;
    private Button btnNum7;
    private Button btnNum8;
    private Button btnNum9;
    private Button btnSuma;
    private Button btnResta;
    private Button btnIgual;
    private Button btnLimpiar;
    private Button btnMultiplicar;
    private Button btnDividir;
    private TextView txtResul;
    private Double NumResul=0.0;
    private Double NumTemp=0.0;
    private Boolean suma = false;
    private Boolean resta = false;
    private Boolean multiplicacion = false;
    private Boolean division = false;
    private String cadena = "";
    private Integer cont=0;
    private Double priNum=0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView();

        btnNum0.setOnClickListener(this);
        btnNum1.setOnClickListener(this);
        btnNum2.setOnClickListener(this);
        btnNum3.setOnClickListener(this);
        btnNum4.setOnClickListener(this);
        btnNum5.setOnClickListener(this);
        btnNum6.setOnClickListener(this);
        btnNum7.setOnClickListener(this);
        btnNum8.setOnClickListener(this);
        btnNum9.setOnClickListener(this);
        btnSuma.setOnClickListener(this);
        btnResta.setOnClickListener(this);
        btnIgual.setOnClickListener(this);
        btnLimpiar.setOnClickListener(this);
        btnMultiplicar.setOnClickListener(this);
        btnDividir.setOnClickListener(this);
    }

    private void setContentView(){
        btnNum0 = findViewById(R.id.btnNum0);
        btnNum1 = findViewById(R.id.btnNum1);
        btnNum2 = findViewById(R.id.btnNum2);
        btnNum3 = findViewById(R.id.btnNum3);
        btnNum4 = findViewById(R.id.btnNum4);
        btnNum5 = findViewById(R.id.btnNum5);
        btnNum6 = findViewById(R.id.btnNum6);
        btnNum7 = findViewById(R.id.btnNum7);
        btnNum8 = findViewById(R.id.btnNum8);
        btnNum9 = findViewById(R.id.btnNum9);
        btnSuma = findViewById(R.id.btnSuma);
        btnResta = findViewById(R.id.btnResta);
        btnIgual = findViewById(R.id.btnIgual);
        txtResul = findViewById(R.id.txtResultado);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnDividir = findViewById(R.id.btnDividir);
    }

    @Override
    public void onClick(View v) {
        
        if(v.getId() == R.id.btnNum0){
            MandarNum(0);
        }else if(v.getId() == R.id.btnNum1){
            MandarNum(1);
        }else if(v.getId() == R.id.btnNum2){
            MandarNum(2);
        }else if(v.getId() == R.id.btnNum3){
            MandarNum(3);
        }else if(v.getId() == R.id.btnNum4){
            MandarNum(4);
        }else if(v.getId() == R.id.btnNum5){
            MandarNum(5);
        }else if(v.getId() == R.id.btnNum6){
            MandarNum(6);
        }else if(v.getId() == R.id.btnNum7){
            MandarNum(7);
        }else if(v.getId() == R.id.btnNum8){
            MandarNum(8);
        }else if(v.getId() == R.id.btnNum9){
            MandarNum(9);
        }else if(v.getId() == R.id.btnSuma){
            suma= true;
            cadena = cadena + "+";
            txtResul.setTextSize(50);
            txtResul.setText(cadena);
        }else if(v.getId() == R.id.btnResta){
            resta = true;
            cadena = cadena + "-";
            txtResul.setTextSize(50);
            txtResul.setText(cadena);
        }else if(v.getId() == R.id.btnIgual){
            Igual();
        }else if(v.getId() == R.id.btnLimpiar){
            Limpiar();
        }else if(v.getId() == R.id.btnMultiplicar){
            multiplicacion = true;
            cadena = cadena + "x";
            txtResul.setTextSize(50);
            txtResul.setText(cadena);
        }else if(v.getId() == R.id.btnDividir){
            division = true;
            cadena = cadena + "/";
            txtResul.setTextSize(50);
            txtResul.setText(cadena);
        }
    }

    public void Limpiar(){
        txtResul.setText("");
        NumResul=0.0;
        NumTemp=0.0;
        suma = false;
        multiplicacion=false;
        division=false;
        resta = false;
        cadena = "";
        cont=0;
        priNum=0.0;
    }

    public void MandarNum(double num){
        cont++;
        if(cont == 1){
            priNum = num;
            cadena = cadena + num + "";
            txtResul.setTextSize(50);
            txtResul.setText(cadena);
        }else{
            cadena = cadena + num + "";
            NumTemp = num;
            txtResul.setTextSize(50);
            txtResul.setText(cadena);
        }
    }

    public void Igual(){
        if(suma == true){
            if(cont == 1){
                Log.d("NUMRESUL",NumResul.toString());
                Log.d("PRINUM",priNum.toString());
                NumResul = NumResul+priNum;
            }else {
                NumResul = NumResul + NumTemp;
                Log.d("NUMRESUL",NumResul.toString());
                Log.d("NUMTEMP",NumTemp.toString());
            }
        }else if(resta == true){
            if(cont == 1){
                Log.d("NUMRESUL",NumResul.toString());
                Log.d("PRINUM",priNum.toString());
                NumResul = NumResul-priNum;
            }else {
                Log.d("NUMRESUL",NumResul.toString());
                Log.d("NUMTEMP",NumTemp.toString());
                NumResul = NumResul - NumTemp;
            }
        }else if(multiplicacion == true){
            if(cont == 1){
                Log.d("NUMRESUL",NumResul.toString());
                Log.d("PRINUM",priNum.toString());
                NumResul = NumResul * priNum;

            }else {
                Log.d("NUMRESUL",NumResul.toString());
                Log.d("NUMTEMP",NumTemp.toString());
                NumResul = NumResul * NumTemp;
            }
            Log.d("RESULTADO",NumResul.toString());
        }else if(division == true){
            if(cont == 1){
                Log.d("NUMRESUL",NumResul.toString());
                Log.d("PRINUM",priNum.toString());
                NumResul = (NumResul / priNum);
            }else {
                Log.d("NUMRESUL",NumResul.toString());
                Log.d("NUMTEMP",NumTemp.toString());
                NumResul = (NumResul / NumTemp);
            }
        }

        cadena = NumResul.toString();
        suma = false;
        resta = false;
        multiplicacion = false;
        division = false;
        txtResul.setTextSize(50);
        txtResul.setText(cadena.toString());
    }
}