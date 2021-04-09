package com.example.parcial1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import models.Producto;

public class ExentosActivity extends AppCompatActivity {

    private TextView lblInformacion;
    private List<Producto> listaProd = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exentos);

        lblInformacion = findViewById(R.id.txtInformacion);

        MainActivity main = new MainActivity();
        listaProd= main.listaProducto;

        Exentos();
    }

    public void Exentos(){

        //ORDENAR LA LISTA DE LOS PRODUCTOS POR EL CAMPO EXENTO
        Collections.sort(listaProd, new Comparator<Producto>() {
            public int compare(Producto obj1, Producto obj2) {
                return obj1.getExentoIVA().compareTo(obj2.getExentoIVA());
            }
        });

        //CREAR LISTA QUE CONTENDRÁ LOS CODIGOS EXENTOS DE IVA
        List<String> listaCodigosExentos  = new ArrayList<>();
        for(int i=0; i< listaProd.size(); i++){

            //VALIDAR SI ES EXENTO O NO DE IVA
            if(listaProd.get(i).getExentoIVA() == true){
                //VALIDAR QUE EL CODIGO NO ESTE CREADO EN EL ARRAY
                if(listaCodigosExentos.contains(listaProd.get(i).getCodigoProducto()) == false){
                    listaCodigosExentos.add(listaProd.get(i).getCodigoProducto());
                }
            }

        }

        //ORDENAR LA LISTA DE LOS CODIGOS POR EL CAMPO EXENTO
        Collections.sort(listaCodigosExentos);

        for(int i=0; i< listaCodigosExentos.size(); i++){
            String nombreProd = "";
            for(int j=0; j<listaProd.size();j++){
                if(listaCodigosExentos.get(i).equals(listaProd.get(j).getCodigoProducto())){
                    nombreProd = listaProd.get(j).getNombreProducto();
                }
            }
            String cadena;
            cadena = lblInformacion.getText().toString() + "\n • NOMBRE: "+ nombreProd + " / CODIGO: " +listaCodigosExentos.get(i)+"\n";
            lblInformacion.setText(cadena);
        }
    }
}