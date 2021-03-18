package com.example.applogins;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity implements View.OnClickListener {

    //CREACIÓN DE VARIABLES
    private EditText txtUser;
    private EditText txtPassword;
    private Button btnLoginPlay;
    private Button btnCreatePlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        setContentView();

        //IMPLEMENTAR INTERFACE
        btnLoginPlay.setOnClickListener(this);
    }

    //CARGAR TODOS LOS ELEMENTOS EN UN MISMO METODO DE CONTENIDO
    private void setContentView(){
        txtUser = findViewById(R.id.txtUserPlay);
        txtPassword = findViewById(R.id.txtPasswordPlay);
        btnLoginPlay = findViewById(R.id.btnSingInPlay);
        btnCreatePlay = findViewById(R.id.btnCreatePlay);
    }

    @Override
    public void onClick(View v) {
        //SE VALIDA QUE VISTA TRAE PARA HACER LA OPERACIÓN DESEADA PARA DICHA VISTA
        if(v.getId() == R.id.btnSingInPlay){
            //LLAMADA A METODO DESEADO
            login();
        }
    }

    public void login(){
        //OBTENER VALOR DE CAJA DE TEXTO USUARIO
        String userText = txtUser.getText().toString();
        String passText = txtPassword.getText().toString();


        if(userText.equals("brandom") && passText.equals("3801821090")){

            //REDIRECCIONAR A OTRO LAYOUT O ACTIVITY
            //Intent nombreIntent = new Intent(origen (this), destino nombreActivity.class);
            Intent inicioIntent = new Intent(this, SnapActivity.class);
            startActivity(inicioIntent);

            //MENSAJE POPUP
            //Toast.makeText(this, "BIENVENIDO", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Usuario y/o Contraseña Incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}