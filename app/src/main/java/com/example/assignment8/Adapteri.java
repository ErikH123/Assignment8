package com.example.assignment8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Adapteri extends ArrayAdapter {
    private Context context;
    ArrayList<Teksti> dataset;

    public Adapteri(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.teksti_layout, parent,false);
        LinearLayout linearLayout = (LinearLayout) v;

        TextView teksti = v.findViewById(R.id.teksti);

        if (dataset != null)
            teksti.setText(dataset.get(position).getTeksti());

        return v;
    }
}
