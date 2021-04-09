package com.example.parcial1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import com.ib.custom.toast.CustomToastView;

import java.util.ArrayList;
import java.util.List;

import models.Producto;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtCodigoProducto;
    private EditText txtNombreProducto;
    private EditText txtDescripcionProducto;
    private EditText txtValorProducto;
    private Boolean exento = false;
    private Switch switchIvaProducto;
    private Button btnAgregarProducto;
    private Button btnPantallaExentos;
    private Button btnPantallaCostosos;
    private Button btnPantallaEconomicos;
    private Button btnPromedioValor;

    public static List<Producto> listaProducto = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView();
        btnAgregarProducto.setOnClickListener(this);
        btnPantallaExentos.setOnClickListener(this);
        btnPantallaCostosos.setOnClickListener(this);
        btnPantallaEconomicos.setOnClickListener(this);
        btnPromedioValor.setOnClickListener(this);
        switchIvaProducto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    exento = true;
                }else{
                    exento = false;
                }
            }
        });
    }

    public void setContentView(){
        txtCodigoProducto = findViewById(R.id.txtCodigoProducto);
        txtNombreProducto = findViewById(R.id.txtNombreProducto);
        txtDescripcionProducto = findViewById(R.id.txtDescripcionProducto);
        txtValorProducto = findViewById(R.id.txtValorProducto);
        switchIvaProducto = findViewById(R.id.swIvaProducto);
        btnAgregarProducto = findViewById(R.id.btnAgregarProducto);
        btnPantallaExentos = findViewById(R.id.btnPantallaExentos);
        btnPantallaCostosos = findViewById(R.id.btnPantallaCostosos);
        btnPantallaEconomicos = findViewById(R.id.btnPantallaBaratos);
        btnPromedioValor = findViewById(R.id.btnPromedioValorProductos);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnAgregarProducto){
            String codigoProducto = "";
            String nombreProducto = "";
            String descripcionProducto = "";
            int valorProducto;
            if(txtValorProducto.getText().toString().equals("")){
                valorProducto = 0;
            }else{
                valorProducto = Integer.parseInt(txtValorProducto.getText().toString());
            }


            codigoProducto = txtCodigoProducto.getText().toString();
            nombreProducto = txtNombreProducto.getText().toString();
            descripcionProducto = txtDescripcionProducto.getText().toString();

            AgregarProducto(codigoProducto,nombreProducto,valorProducto,exento,descripcionProducto);
        }else if(v.getId() == R.id.btnPantallaExentos){

            if(listaProducto.size() == 0){
                CustomToastView.makeWarningToast(this, "NO EXISTE NINGUN PRODUCTO", R.layout.custom_toast).show();
            }else {
                //CREAR INTENT PARA ENVIAR A OTRA PANTALLA
                Intent pantallaExentos = new Intent(this, ExentosActivity.class);

                //INICIAR OTRO ACTIVITY
                startActivity(pantallaExentos);
            }
        }else if(v.getId() == R.id.btnPantallaCostosos){
            if(listaProducto.size() == 0){
                CustomToastView.makeWarningToast(this, "NO EXISTE NINGUN PRODUCTO", R.layout.custom_toast).show();
            }else {
                //CREAR INTENT PARA ENVIAR A OTRA PANTALLA
                Intent pantallaCostosos = new Intent(this, CostososActivity.class);

                //INICIAR OTRO ACTIVITY
                startActivity(pantallaCostosos);
            }
        }else if(v.getId() == R.id.btnPantallaBaratos){
            if(listaProducto.size() == 0){
                CustomToastView.makeWarningToast(this, "NO EXISTE NINGUN PRODUCTO", R.layout.custom_toast).show();
            }else {
                //CREAR INTENT PARA ENVIAR A OTRA PANTALLA
                Intent pantallaEconomicos = new Intent(this, EconomicosActivity.class);

                //INICIAR OTRO ACTIVITY
                startActivity(pantallaEconomicos);
            }
        }else if(v.getId() == R.id.btnPromedioValorProductos){
            PromedioValorProductos();
        }
    }

    public void AgregarProducto(String codigoProducto, String nombreProducto, Integer valorProducto, Boolean exentoIVA, String descripcionProducto){

        //VALIDAR CAMPOS
        if(codigoProducto.equals("")){
            CustomToastView.makeErrorToast(this, "Falta diligenciar un código", R.layout.custom_toast).show();
            return;
        }else if(nombreProducto.equals("")){
            CustomToastView.makeErrorToast(this, "Falta diligenciar un nombre ", R.layout.custom_toast).show();
            return;
        }else if(valorProducto == 0){
            CustomToastView.makeErrorToast(this, "Falta diligenciar un valor ", R.layout.custom_toast).show();
            return;
        }else if(descripcionProducto.equals("")){
            CustomToastView.makeErrorToast(this, "Falta diligenciar una descripción", R.layout.custom_toast).show();
            return;
        }

        //INSTANCIAR LA CLASE PRODUCTO
        Producto producto = new Producto(codigoProducto,nombreProducto,valorProducto,exentoIVA,descripcionProducto);

        //AGREGAR PRODUCTO A LA LISTA
        listaProducto.add(producto);

        //LIMPIAR CAMPOS
        txtCodigoProducto.setText("");
        txtNombreProducto.setText("");
        txtDescripcionProducto.setText("");
        txtValorProducto.setText("");
        switchIvaProducto.setChecked(false);
    }

    public void PromedioValorProductos(){
        int acumuladorValor=0;
        for(int i=0; i< listaProducto.size(); i++){
            acumuladorValor = acumuladorValor + listaProducto.get(i).getValorProducto();
        }

        double promedio = acumuladorValor/listaProducto.size();
        CustomToastView.makeSuccessToast(this, "EL VALOR PROMEDIO DE LOS PRODUCTOS ES DE: " + promedio, R.layout.custom_toast).show();
    }
}