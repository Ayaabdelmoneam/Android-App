package com.example.petadoption;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.petadoption.R;

public class Dogs extends AppCompatActivity {


    ImageView home, profile, add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dogs);


        home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform any login logic here if needed
                // For now, let's navigate to MainActivity
                Intent i = new Intent(Dogs.this, HomePage.class);
                startActivity(i);
            }
        });

        profile = findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform any login logic here if needed
                // For now, let's navigate to MainActivity
                Intent i = new Intent(Dogs.this, LisaProfile.class);
                startActivity(i);
            }
        });

        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Dogs.this, AdoptionForm.class);
                startActivity(i);
            }
        });

        GridView gridView = findViewById(R.id.gridView);


        String[] itemNames = {"Buddy", "Oli", "Lucy", "Alvin", "Milo", "Luna"};
        String[] itemGenders = {"Male", "Male", "Female", "Male", "Male","Female"};
        String[] itemAges = {"3 months", "2 months", "4 months", "1 month", "7 months", "1/2 month"};
        int[] itemImages = {R.drawable.buddy, R.drawable.oli, R.drawable.lucy, R.drawable.alvin, R.drawable.milo, R.drawable.luna};

        MyAdapter adapter = new MyAdapter(this, itemNames, itemGenders, itemAges, itemImages);
        gridView.setAdapter(adapter);
    }
}