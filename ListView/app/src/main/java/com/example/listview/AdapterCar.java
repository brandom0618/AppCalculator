package com.example.listview;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listview.models.Car;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterCar extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<Car> cars;

    public AdapterCar(Activity activity, ArrayList<Car> cars) {
        this.activity = activity;
        this.cars = cars;
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public void addCar(ArrayList<Car> carsElements){
        cars.addAll(carsElements);
    }

    @Override
    public int getCount() {
        return cars.size();
    }

    @Override
    public Object getItem(int position) {
        return cars.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if(convertView == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.car_item,null);
        }

        Car carElement = cars.get(position);

        ImageView urlCar = v.findViewById(R.id.carImageView);


        TextView nameCar = v.findViewById(R.id.carName);
        nameCar.setText(carElement.getName());

        TextView valueCar = v.findViewById(R.id.carValue);
        valueCar.setText(carElement.getValue());

        TextView modelCar = v.findViewById(R.id.carModel);
        modelCar.setText(carElement.getModel());

        TextView cylinderCapacityCar = v.findViewById(R.id.carCylinderCapacity);
        cylinderCapacityCar.setText(carElement.getModel());
        return v;
    }
    
}
