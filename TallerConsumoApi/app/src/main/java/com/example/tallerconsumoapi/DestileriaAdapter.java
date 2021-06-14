package com.example.tallerconsumoapi;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tallerconsumoapi.models.Destileria;
import com.example.tallerconsumoapi.models.Whisky;

import java.util.List;

public class DestileriaAdapter extends BaseAdapter {
    protected Activity activity;
    protected List<Destileria> myDestileria;

    public DestileriaAdapter(Activity activity, List<Destileria> myDestileria) {
        this.activity = activity;
        this.myDestileria = myDestileria;
    }

    @Override
    public int getCount() {
        return myDestileria.size();
    }

    @Override
    public Object getItem(int position) {
        return myDestileria.get(position);
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
            v = inf.inflate(R.layout.item_destileria,null);
        }

        Destileria destileria = myDestileria.get(position);
        TextView name = v.findViewById(R.id.tvName);
        name.setText(destileria.getName());

        TextView country = v.findViewById(R.id.tvCountry);
        country.setText(destileria.getCountry());

        TextView rating = v.findViewById(R.id.tvRating);
        rating.setText(destileria.getWhiskyBaseRating());
        return v;
    }
}
