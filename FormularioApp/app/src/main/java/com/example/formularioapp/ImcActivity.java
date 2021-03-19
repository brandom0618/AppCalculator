package com.example.formularioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ib.custom.toast.CustomToastView;

public class ImcActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtAltura;
    private EditText txtPeso;
    private Button btnCalcular;
    private TextView lblInformacion;
    private TextView lblResultado;
    private ImageView imgResul;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_imc);
        setContentView();

        //RECIBIR INTENT
        Intent intent = getIntent();
        
        //OBTENER PARAMETROS ENVIADOS DESDE EL OTRO INTENT
        String Nombre = intent.getStringExtra("Nombre");
        String Apellido = intent.getStringExtra("Apellido");
        String Correo = intent.getStringExtra("Correo");
        String Mesagge = "Hola <b>" + Nombre + " "+ Apellido + "</b> es un gusto tenerte aca, su correo para el informe es: \n<b>" +Correo+"</b>";
        lblInformacion.setText((Html.fromHtml(Mesagge)));
        btnCalcular.setOnClickListener(this);
    }

    public void setContentView(){
        txtAltura = findViewById(R.id.txtAltura);
        txtPeso = findViewById(R.id.txtPeso);
        lblInformacion = findViewById(R.id.lblInformacion);
        lblResultado = findViewById(R.id.lblResultado);
        btnCalcular = findViewById(R.id.btnCalcular);
        imgResul = findViewById(R.id.imgResul);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnCalcular){
            CalcIMC();
        }
    }

    public void CalcIMC(){
        String Altura = txtAltura.getText().toString();
        String Peso = txtPeso.getText().toString();
        String calificacion = "";
        double CalcIMC = Double.parseDouble(Peso)/Math.pow(Double.parseDouble(Altura),2);

        if(CalcIMC < 18.5){
            calificacion = "Bajo de peso";
            imgResul.setImageResource(R.drawable.flaco);
        }else if(CalcIMC > 18.5 && CalcIMC < 24.9){
            calificacion = "Normal";
            imgResul.setImageResource(R.drawable.normal);
        }else if(CalcIMC > 25.0 && CalcIMC < 29.9){
            calificacion = "SobrePeso";
            imgResul.setImageResource(R.drawable.sobrepeso);
        }else if(CalcIMC > 30.0){
            calificacion ="Obeso";
            imgResul.setImageResource(R.drawable.obeso);
        }

        lblResultado.setText((Html.fromHtml("Su IMC es:" + Math.round(CalcIMC) + " Calificación: <b>" + calificacion+"</b>")));
    }
}