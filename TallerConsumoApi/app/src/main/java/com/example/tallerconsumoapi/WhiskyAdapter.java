package com.example.tallerconsumoapi;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tallerconsumoapi.models.Whisky;

import java.util.List;

public class WhiskyAdapter extends BaseAdapter {
    protected Activity activity;
    protected List<Whisky> myWhiskys;

    public WhiskyAdapter(Activity activity, List<Whisky> myWhiskys) {
        this.activity = activity;
        this.myWhiskys = myWhiskys;
    }

    @Override
    public int getCount() {
        return myWhiskys.size();
    }

    @Override
    public Object getItem(int position) {
        return myWhiskys.get(position);
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
            v = inf.inflate(R.layout.item_whisky,null);
        }

        Whisky whisky = myWhiskys.get(position);
        TextView nameWhisky = v.findViewById(R.id.tvName);
        nameWhisky.setText(whisky.getNameWhisky());

        TextView baseWhisky = v.findViewById(R.id.tvBaseCurrency);
        baseWhisky.setText(whisky.getBaseWhisky());

        TextView urlWhisky = v.findViewById(R.id.tvUrl);
        urlWhisky.setText(whisky.getUrlWhisky());
        return v;
    }
}
