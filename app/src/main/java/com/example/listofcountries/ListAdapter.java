package com.example.listofcountries;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Country>
    {
    public ListAdapter(Context context, ArrayList<Country> countryArrayList){
        super(context, R.layout.list_view, countryArrayList);
    }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            Country country = getItem(position);
            if(convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent, false);
            }
            ImageView imageView = convertView.findViewById(R.id.countryInfo);
            TextView countryName = convertView.findViewById(R.id.countryName);

            imageView.setImageResource(country.imageId);
            countryName.setText(country.countryN);

            return convertView;
        }
    }
