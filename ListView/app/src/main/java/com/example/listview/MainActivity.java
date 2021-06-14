package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listview.models.Car;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView ListNames;
    public static List<Car> listCarsRecib = new ArrayList<Car>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListNames = findViewById(R.id.listViewNames);
        RegisterCarActivity register = new RegisterCarActivity();
        listCarsRecib = register.listCars;

        //CARROS DE PRUEBA
        listCarsRecib.add(new Car("Jetta","2000","2008","22000000","https://http2.mlstatic.com/D_NQ_NP_619267-MCO44826686936_022021-O.jpg"));
        listCarsRecib.add(new Car("Audi","2000","2008","88000000","https://http2.mlstatic.com/D_NQ_NP_619267-MCO44826686936_022021-O.jpg"));

        AdapterCar adapter = new AdapterCar(this, (ArrayList<Car>) listCarsRecib);

        //MANDAR ADAPTER QUE CONTIENE EL ARRAY
        ListNames.setAdapter(adapter);

        //OBTENER CLIC DE LOS ITEM DE LA LISTA
        ListNames.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "A pulsado el elemento: " + position, Toast.LENGTH_SHORT).show();
    }
}