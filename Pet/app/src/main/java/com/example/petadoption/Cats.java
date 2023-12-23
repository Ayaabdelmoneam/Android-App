package com.example.petadoption;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Cats extends AppCompatActivity {
    ImageView catbtn,home,profile,add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cats);

        home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform any login logic here if needed
                // For now, let's navigate to MainActivity
                Intent i = new Intent(Cats.this, HomePage.class);
                startActivity(i);
            }
        });

        profile = findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform any login logic here if needed
                // For now, let's navigate to MainActivity
                Intent i = new Intent(Cats.this, LisaProfile.class);
                startActivity(i);
            }
        });

        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Cats.this, AdoptionForm.class);
                startActivity(i);
            }
        });


        GridView gridView = findViewById(R.id.gridView);

        String[] itemNames = {"Emily", "alvin", "snow", "soso", "Cat 5"};
        String[] itemGenders = {"Female", "Male", "Male", "Female", "Male"};
        String[] itemAges = {"2 years", "3 years", "1 year", "4 years", "2 years"};
        int[] itemImages = {R.drawable.emily, R.drawable.alvin, R.drawable.snow, R.drawable.soso, R.drawable.lilo};

        MyAdapter adapter = new MyAdapter(this, itemNames, itemGenders, itemAges, itemImages);
        gridView.setAdapter(adapter);

        catbtn = findViewById(R.id.meow);
        catbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Cats.this, PetProfile.class);
                startActivity(i);
            }
        });
    }
}

