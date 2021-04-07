package com.example.formulariocontrol;


import androidx.appcompat.app.AppCompatActivity;
import com.ib.custom.toast.CustomToastView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import models.Persona;


public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    private EditText txtEdad;
    private EditText txtSalario;
    private EditText txtNombre;
    private EditText txtApellido;
    private EditText txtCargo;
    private EditText txtEmail;
    private Button btnAgregar;
    private Button btnMenor;
    private Button btnMayor;
    private Button btnSalarioBajo;
    private Button btnSalarioAlto;
    private Button btnPromedio;
    private Button btnListaDetalle;
    public  static List<Persona> listaPersonas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView();

        btnAgregar.setOnClickListener(this);
        btnMenor.setOnClickListener(this);
        btnMayor.setOnClickListener(this);
        btnSalarioBajo.setOnClickListener(this);
        btnSalarioAlto.setOnClickListener(this);
        btnPromedio.setOnClickListener(this);
        btnListaDetalle.setOnClickListener(this);
    }

    public void setContentView(){
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtEmail = findViewById(R.id.txtEmail);
        txtSalario = findViewById(R.id.txtSalario);
        txtCargo = findViewById(R.id.txtCargo);
        txtEdad = findViewById(R.id.txtEdad);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnMenor = findViewById(R.id.btnJoven);
        btnMayor = findViewById(R.id.btnMayor);
        btnSalarioBajo = findViewById(R.id.btnSalarioBajo);
        btnSalarioAlto = findViewById(R.id.btnSalarioAlto);
        btnPromedio = findViewById(R.id.btnPromedio);
        btnListaDetalle = findViewById(R.id.btnListaDetalle);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnAgregar){
            //RECOGER DATOS
            String Nombre = txtNombre.getText().toString();
            String Apellido = txtApellido.getText().toString();
            String Cargo = txtCargo.getText().toString();
            String Email = txtEmail.getText().toString();
            int Salario;
            if(txtSalario.getText().toString().equals("")){
                 Salario = 0;
            }else{
                Salario = Integer.parseInt(txtSalario.getText().toString());
            }
            int Edad;

            if(txtEdad.getText().toString().equals("")){
                Edad = 0;
            }else{
                Edad = Integer.parseInt(txtEdad.getText().toString());
            }

            //METODO CREAR PERSONA
            CrearPersona(Nombre,Apellido,Cargo,Email,Salario,Edad);

        }else if(v.getId() == R.id.btnJoven){
            //METODO CONOCER PERSONA MAS JOVEN
            PersonaMenor();
        }else if(v.getId() == R.id.btnMayor){
            //METODO CONOCER PERSONA MAYOR
            PersonaMayor();
        }else if(v.getId() == R.id.btnSalarioBajo){
            //METODO CONOCER PERSONA CON MENOR SALARIO
            PersonaSalarioBajo();
        }else if(v.getId() == R.id.btnSalarioAlto){
            //METODO CONOCER PERSONA CON MAYOR SALARIO
            PersonaSalarioAlto();
        } else if (v.getId() == R.id.btnPromedio) {
            //CONOCER PROMEDIO SALARIAL
            PromedioSalarial();
        }else if(v.getId() == R.id.btnListaDetalle){

            //ABRIR POPUP DETALLE
            AbrirPopUp();
        }
    }

    private boolean IsValidEmail(String email){
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return  pattern.matcher(email).matches();
    }

    public void CrearPersona(String Nombre,String Apellido,String Cargo, String Email,int Salario, int Edad){

        //VALIDAR CAMPOS
        if(Nombre.equals("")){
            CustomToastView.makeErrorToast(this, "Falta diligenciar Nombre", R.layout.custom_toast).show();
            txtNombre.requestFocus();
            return;
        }else if(Apellido.equals("")){
            CustomToastView.makeErrorToast(this, "Falta diligenciar Apellido", R.layout.custom_toast).show();
            txtApellido.requestFocus();
            return;
        }else if(IsValidEmail(Email) == false){
            CustomToastView.makeErrorToast(this, "Correo no válido", R.layout.custom_toast).show();
            txtEmail.requestFocus();
            return;
        }else if(Cargo.equals("")) {
            CustomToastView.makeErrorToast(this, "Falta diligenciar el Cargo", R.layout.custom_toast).show();
            txtCargo.requestFocus();
            return;
        }else if(Salario == 0){
            CustomToastView.makeErrorToast(this, "Falta diligenciar el Salario", R.layout.custom_toast).show();
            txtSalario.requestFocus();
            return;
        }else if(Edad == 0){
            CustomToastView.makeErrorToast(this, "Falta diligenciar la Edad", R.layout.custom_toast).show();
            txtEdad.requestFocus();
            return;
        }
        //INSTANCIAR OBJETO PERSONA
        Persona persona = new Persona(Nombre,Apellido,Cargo,Email,Salario,Edad);

        //AGREGAR OBJETO PERSONA A LA LISTA
        this.listaPersonas.add(persona);

        //LIMPIAR CAMPOS APRA AGREGAR OTRA PERSONA
        txtNombre.setText("");
        txtApellido.setText("");
        txtCargo.setText("");
        txtEmail.setText("");
        txtSalario.setText("");
        txtEdad.setText("");
    }

    public void PersonaMenor(){
        int menor = 1000000000;
        String nombreCompleto = "";
        for(int i =0; i < this.listaPersonas.size();i++){
            if(this.listaPersonas.get(i).getEdad() < menor)
            {
                menor=this.listaPersonas.get(i).getEdad();
                nombreCompleto=this.listaPersonas.get(i).getNombre() + " " + listaPersonas.get(i).getApellido();
            }
        }
        CustomToastView.makeSuccessToast(this, "La persona con menor edad es: " + nombreCompleto , R.layout.custom_toast).show();
    }

    public void PersonaMayor(){
        int mayor = 0;
        String nombreCompleto = "";
        for(int i =0; i < this.listaPersonas.size();i++){
            if(this.listaPersonas.get(i).getEdad() > mayor)
            {
                mayor=this.listaPersonas.get(i).getEdad();
                nombreCompleto=this.listaPersonas.get(i).getNombre() + " " + listaPersonas.get(i).getApellido();
            }
        }
        CustomToastView.makeSuccessToast(this, "La persona de más edad es: " + nombreCompleto , R.layout.custom_toast).show();
    }

    public void PersonaSalarioBajo(){
        int menor = 1000000000;
        String nombreCompleto = "";
        int salario = 0;
        for(int i =0; i < this.listaPersonas.size();i++){
            if(this.listaPersonas.get(i).getSalario() < menor)
            {
                menor=this.listaPersonas.get(i).getSalario();
                nombreCompleto=this.listaPersonas.get(i).getNombre() + " " + listaPersonas.get(i).getApellido();
                salario=this.listaPersonas.get(i).getSalario();
            }
        }
        CustomToastView.makeSuccessToast(this, "La persona con menor salario es: " + nombreCompleto + " con un salario de: " + salario, R.layout.custom_toast).show();
    }

    public void PersonaSalarioAlto(){
        int mayor = 0;
        String nombreCompleto = "";
        int salario = 0;
        for(int i =0; i < this.listaPersonas.size();i++){
            if(this.listaPersonas.get(i).getSalario() > mayor)
            {
                mayor=this.listaPersonas.get(i).getSalario();
                nombreCompleto=this.listaPersonas.get(i).getNombre() + " " + listaPersonas.get(i).getApellido();
                salario=this.listaPersonas.get(i).getSalario();
            }
        }
        CustomToastView.makeSuccessToast(this, "La persona con mayor salario es: " + nombreCompleto + " con un salario de: " + salario, R.layout.custom_toast).show();
    }

    public void PromedioSalarial(){
        int sumatoriaSalarios = 0;
        double promedio = 0.0;
        for(int i =0; i < this.listaPersonas.size();i++){
            sumatoriaSalarios=sumatoriaSalarios+this.listaPersonas.get(i).getSalario();
        }
        promedio = (sumatoriaSalarios/this.listaPersonas.size());
        CustomToastView.makeSuccessToast(this, "El promedio salarial es: " + promedio , R.layout.custom_toast).show();
    }

    public void AbrirPopUp(){
        //CREAR INTENT
        Intent ventanaIntent = new Intent(this,VentanaDetalleActivity.class);

        //LANZAR INTENT
        startActivity(ventanaIntent);
    }
}