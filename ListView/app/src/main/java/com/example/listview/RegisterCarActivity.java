package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.listview.models.Car;

import java.util.ArrayList;
import java.util.List;

public class RegisterCarActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtUrl;
    private EditText txtName;
    private EditText txtCylinder;
    private EditText txtModel;
    private EditText txtValue;
    private Button btnRegistrar;
    private Button btnListar;

    public static List<Car> listCars = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_car);

        setContentView();

        btnRegistrar.setOnClickListener(this);
        btnListar.setOnClickListener(this);
    }

    public void setContentView(){
        txtUrl = findViewById(R.id.txtUrlImage);
        txtName = findViewById(R.id.txtName);
        txtCylinder = findViewById(R.id.txtCylinderCapacity);
        txtModel = findViewById(R.id.txtModel);
        txtValue = findViewById(R.id.txtValue);
        btnRegistrar = findViewById(R.id.btnCrearCarro);
        btnListar = findViewById(R.id.btnListadoCarros);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnCrearCarro){

            if(txtName.getText().toString().equals("")){
                Toast.makeText(this, "Especifique una marca", Toast.LENGTH_SHORT).show();
                return;
            }else if(txtCylinder.getText().toString().equals("")){
                Toast.makeText(this, "Especifique un cilindraje", Toast.LENGTH_SHORT).show();
                return;
            }else if(txtModel.getText().toString().equals("")){
                Toast.makeText(this, "Especifique un modelo", Toast.LENGTH_SHORT).show();
                return;
            }else if(txtValue.getText().toString().equals("")){
                Toast.makeText(this, "Especifique una valor", Toast.LENGTH_SHORT).show();
                return;
            }else if(txtUrl.getText().toString().equals("")){
                Toast.makeText(this, "Especifique una URL", Toast.LENGTH_SHORT).show();
                return;
            }

            String url = txtName.getText().toString();
            String name = txtName.getText().toString();
            String cylinder = txtCylinder.getText().toString();
            String model = txtModel.getText().toString();
            String value = txtValue.getText().toString();

            Car car = new Car(name,cylinder,model,value,url);
            listCars.add(car);

            Toast.makeText(this, "Carro agregado con éxito", Toast.LENGTH_SHORT).show();

            txtUrl.setText("");
            txtName.setText("");
            txtCylinder.setText("");
            txtModel.setText("");
            txtValue.setText("");
        }else if(v.getId() == R.id.btnListadoCarros){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}