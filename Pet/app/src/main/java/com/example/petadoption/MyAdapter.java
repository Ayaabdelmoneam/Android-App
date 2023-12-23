package com.example.petadoption;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private String[] itemNames;
    private String[] itemGenders;
    private String[] itemAges;
    private int[] itemImages;

    public MyAdapter(Context context, String[] itemNames, String[] itemGenders, String[] itemAges, int[] itemImages) {
        this.context = context;
        this.itemNames = itemNames;
        this.itemGenders = itemGenders;
        this.itemAges = itemAges;
        this.itemImages = itemImages;
    }

    @Override
    public int getCount() {
        return itemNames.length;
    }

    @Override
    public Object getItem(int position) {
        return itemNames[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridView = convertView;
        if (gridView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView = inflater.inflate(R.layout.grid_item2, parent, false);
        }

        ImageView imageView = gridView.findViewById(R.id.catbtn);
        TextView nameTextView = gridView.findViewById(R.id.name);
        TextView genderTextView = gridView.findViewById(R.id.name1);
        TextView ageTextView = gridView.findViewById(R.id.name2);

        imageView.setImageResource(itemImages[position]);
        nameTextView.setText(itemNames[position]);
        genderTextView.setText(itemGenders[position]);
        ageTextView.setText( itemAges[position]);

        return gridView;
    }
}
