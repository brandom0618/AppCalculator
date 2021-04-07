package com.example.formulariocontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import models.Persona;

public class VentanaDetalleActivity extends AppCompatActivity {

    public  static List<Persona> listaPersonasVentana = new ArrayList<>();
    private TextView txtInfor;
    private TextView txtInfor2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_detalle);

        txtInfor = findViewById(R.id.txtInformacion);
        txtInfor2 = findViewById(R.id.txtInformacion2);
        DisplayMetrics medidasVentana = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(medidasVentana);

        int ancho = medidasVentana.widthPixels;
        int alto = medidasVentana.heightPixels;

        getWindow().setLayout((int)(ancho*0.90),(int)(alto * 0.50));

        MainActivity main = new MainActivity();

        listaPersonasVentana = main.listaPersonas;
        Grupos();
    }

    public void Grupos(){


        Collections.sort(listaPersonasVentana, new Comparator<Persona>() {
            public int compare(Persona obj1, Persona obj2) {
                return obj1.getCargo().compareTo(obj2.getCargo());
            }
        });

        List<String> listaCargos  = new ArrayList<>();
        //MANDAR LA LISTA AGRUPADA CONVERTIDA EN STRING PARA MOSTRAR EN POPUP
        for(int i=0; i< this.listaPersonasVentana.size(); i++){
            //VALIDAR QUE EL CARGO NO ESTE CREADO EN EL ARRAY
            if(listaCargos.contains(this.listaPersonasVentana.get(i).getCargo()) == false){
                listaCargos.add(this.listaPersonasVentana.get(i).getCargo());
            }
        }

        //CANTIDAD DE PERSONAS POR CARGO
        for(int j=0; j<listaCargos.size(); j++){
            int contPersonas = 0;
            String cargo = "";
            for(int i=0;i<this.listaPersonasVentana.size(); i++){
                if(listaCargos.get(j).equals(listaPersonasVentana.get(i).getCargo())){
                    contPersonas++;
                    cargo = listaPersonasVentana.get(i).getCargo();
                }
            }
            String cadena;
            cadena = txtInfor.getText().toString() + "\n- Cargo: " + cargo + " N° Personas: "+contPersonas+"\n";
            txtInfor.setText(cadena);
        }

        //SALARIO PROMEDIO POR CARGO
        for(int j=0; j<listaCargos.size(); j++){
            int acumSalario = 0;
            int numPersonas = 0;
            String cargo = "";
            for(int i=0;i<this.listaPersonasVentana.size(); i++){
                if(listaCargos.get(j).equals(listaPersonasVentana.get(i).getCargo())){
                    acumSalario=acumSalario+listaPersonasVentana.get(i).getSalario();
                    numPersonas++;
                    cargo = listaPersonasVentana.get(i).getCargo();
                }
            }

            double promedio = acumSalario/numPersonas;
            String cadena;
            cadena = txtInfor2.getText().toString() + "\n- Cargo: " + cargo + " Promedio: "+promedio+"\n";
            txtInfor2.setText(cadena);
        }
    }
}