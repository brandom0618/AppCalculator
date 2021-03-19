package com.example.formularioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ib.custom.toast.CustomToastView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtName;
    private EditText txtLastName;
    private EditText txtEmail;
    private Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView();

        btnAceptar.setOnClickListener(this);
    }

    private void setContentView(){
        txtName = findViewById(R.id.txtName);
        txtLastName = findViewById(R.id.txtLastName);
        txtEmail = findViewById(R.id.txtEmail);
        btnAceptar = findViewById(R.id.btnAceptar);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnAceptar) {
            Redireccionar();
        }
    }

    public void Redireccionar(){
        String Nombre = txtName.getText().toString();
        String Apellido = txtLastName.getText().toString();
        String Correo = txtEmail.getText().toString();

        if(Nombre.equals("")){
            CustomToastView.makeErrorToast(this, "Falta diligenciar Nombre", R.layout.custom_toast).show();
            txtName.requestFocus();
            return;
        }else if(Apellido.equals("")){
            CustomToastView.makeErrorToast(this, "Falta diligenciar Apellido", R.layout.custom_toast).show();
            txtLastName.requestFocus();
            return;
        }else if(IsValidEmail(Correo) == false){
            CustomToastView.makeErrorToast(this, "Correo no válido", R.layout.custom_toast).show();
            txtEmail.requestFocus();
            return;
        }

        //REDIRECCIONAR A OTRO LAYOUT O ACTIVITY
        Intent CalculatorIMC = new Intent(this, ImcActivity.class);

        //Enviar parametros a otro intent
        CalculatorIMC.putExtra("Nombre",Nombre);
        CalculatorIMC.putExtra("Apellido",Apellido);
        CalculatorIMC.putExtra("Correo",Correo);

        //Iniciar el otro layout
        startActivity(CalculatorIMC);
    }

    private boolean IsValidEmail(String email){
        Pattern pattern = Patterns.EMAIL_ADDRESS;

        return  pattern.matcher(email).matches();
    }
}