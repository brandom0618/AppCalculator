package com.example.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import models.Producto;

public class EconomicosActivity extends AppCompatActivity {

    private TextView lblInformacion;
    private List<Producto> listaProd = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_economicos);

        lblInformacion = findViewById(R.id.txtInformacion);

        MainActivity main = new MainActivity();
        listaProd= main.listaProducto;

        DiezMasBaratos();
    }

    public void DiezMasBaratos(){
        //ORDENAR LA LISTA DE LOS PRODUCTOS POR EL CAMPO VALOR
        Collections.sort(listaProd, new Comparator<Producto>() {
            public int compare(Producto obj1, Producto obj2) {
                return obj1.getValorProducto().compareTo(obj2.getValorProducto());
            }
        });
        int tope=0;
        if(listaProd.size() >= 10){
            tope=10;
        }else{
            tope=listaProd.size();
        }

        for(int i=0;i < tope;i++){
            String cadena;
            cadena = lblInformacion.getText().toString() + "\n• NOMBRE: " + listaProd.get(i).getNombreProducto() +" / VALOR: "+listaProd.get(i).getValorProducto()+"\n";
            lblInformacion.setText(cadena);
        }
    }
}