package com.example.nikki.plunochecker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nikki on 16/3/17.
 */

public class ProductsAdapter extends ArrayAdapter<Fresh> {
    public ProductsAdapter(Context context, ArrayList<Fresh> products) { super(context , 0, products);}

    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
        Fresh product = getItem(position);

        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_product, parent , false);
        }

        TextView textViewName = (TextView) convertView.findViewById(R.id.textViewProductName);
        TextView textViewBrand = (TextView) convertView.findViewById(R.id.textViewBrand);
        TextView textViewSKU = (TextView) convertView.findViewById(R.id.textViewSKU);
        TextView textViewPLU = (TextView) convertView.findViewById(R.id.textViewPLU);

        textViewName.setText(product.getProductName());
        textViewBrand.setText(product.getBrand());
        textViewSKU.setText(product.getSKU());
        textViewPLU.setText(product.getPLU());

        return convertView;
    }}
