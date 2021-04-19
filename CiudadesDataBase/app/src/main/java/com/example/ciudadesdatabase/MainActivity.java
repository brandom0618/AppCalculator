package com.example.ciudadesdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import models.Ciudad;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtId;
    private EditText txtNombre;
    private EditText txtPoblacion;
    private EditText txtLatitud;
    private EditText txtLongitud;
    private Button btnRegistrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView();

        btnRegistrar.setOnClickListener(this);
        ObtenerSgteId();
    }

    public void setContentView(){
        txtId = findViewById(R.id.txtIdCiudad);
        txtNombre = findViewById(R.id.txtNombreCiudad);
        txtPoblacion = findViewById(R.id.txtPoblacionCiudad);
        txtLatitud = findViewById(R.id.txtLatitud);
        txtLongitud = findViewById(R.id.txtLongitud);
        btnRegistrar = findViewById(R.id.btnCrearCiudad);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnCrearCiudad){
            CrearCiudad();
        }
    }

    public void CrearCiudad(){

        //VALIDAR DATOS
        if(txtId.getText().toString().equals("")){
            Toast.makeText(this, "DEBE ESPECIFICAR UN ID", Toast.LENGTH_LONG).show();
            return;
        }else if(txtNombre.getText().toString().equals("")){
            Toast.makeText(this, "DEBE ESPECIFICAR UN NOMBRE", Toast.LENGTH_LONG).show();
            return;
        }else if(txtPoblacion.getText().toString().equals("")){
            Toast.makeText(this, "DEBE ESPECIFICAR UNA POBLACIÓN", Toast.LENGTH_LONG).show();
            return;
        }else if(txtLatitud.getText().toString().equals("")){
            Toast.makeText(this, "DEBE ESPECIFICAR UNA LATITUD", Toast.LENGTH_LONG).show();
            return;
        }else if (txtLongitud.getText().toString().equals("")){
            Toast.makeText(this, "DEBE ESPECIFICAR UNA LONGITUD", Toast.LENGTH_LONG).show();
            return;
        }

        //RECOGEMOS LOS DATOS
        int id = Integer.parseInt(txtId.getText().toString());
        String nombre = txtNombre.getText().toString();
        int poblacion = Integer.parseInt(txtPoblacion.getText().toString());
        double latitud = Double.parseDouble(txtLatitud.getText().toString());
        double longitud = Double.parseDouble(txtLongitud.getText().toString());

        //INSTANCIAR CLASE
        Ciudad ciudad = new Ciudad();

        //ENVIAR DATOS MEDIANTE METODOS SET
        ciudad.setId(id);
        ciudad.setNombre(nombre);
        ciudad.setPoblacion(poblacion);
        ciudad.setLatitud(latitud);
        ciudad.setLongitud(longitud);

        //INSTANCIAR DB
        MyDbHelper db = new MyDbHelper(this);

        //LLAMADO DEL METODO INSERTAR
        db.InsertCiudad(db.getWritableDatabase(),ciudad);

        //LIMPIAR DATOS
        txtId.setText("");
        txtNombre.setText("");
        txtPoblacion.setText("");
        txtLatitud.setText("");
        txtLongitud.setText("");

        //CONSULTAR CIUDADES
        ConsultarCiudades();
        ObtenerSgteId();
    }

    public void ConsultarCiudades(){
        MyDbHelper db = new MyDbHelper(this);

        ArrayList<Ciudad> ciudades = db.selectCiudad(db.getWritableDatabase());

        int i = 1;
        for(Ciudad ciudadSelected : ciudades){
            System.out.println("Ciudad Id: " + ciudadSelected.getId() + " Nombre: " + ciudadSelected.getNombre());
        }
    }

    public void ObtenerSgteId(){
        MyDbHelper db = new MyDbHelper(this);
        int idNext = db.selectNextId (db.getWritableDatabase());
        txtId.setText(String.valueOf(idNext));
    }
}