package com.example.petadoption;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.petadoption.databinding.HomePageBinding;

public class HomePage extends AppCompatActivity {
    ImageView adopt,cat,dog,home,profile, add;
    HomePageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = HomePageBinding.inflate(getLayoutInflater());
        setContentView(R.layout.home_page);

        setContentView(binding.getRoot());

        adopt = findViewById(R.id.ad);
        adopt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform any login logic here if needed
                // For now, let's navigate to MainActivity
                Intent i = new Intent(HomePage.this, QuestionsActivity.class);
                startActivity(i);
            }
        });

        home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform any login logic here if needed
                // For now, let's navigate to MainActivity
                Intent i = new Intent(HomePage.this, HomePage.class);
                startActivity(i);
            }
        });

        profile = findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform any login logic here if needed
                // For now, let's navigate to MainActivity
                Intent i = new Intent(HomePage.this, LisaProfile.class);
                startActivity(i);
            }
        });

        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(HomePage.this, AdoptionForm.class);
                startActivity(i);
            }
        });

        cat = findViewById(R.id.catButton);
        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this, Cats.class);
                startActivity(i);
            }
        });

        dog = findViewById(R.id.dogButton);
        dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomePage.this, Dogs.class);
                startActivity(i);
            }
        });

        String[] petName = {"Ginger", "Olaf", "Farosa", "Floffy"};
        int[] petImages = {R.drawable.ginger, R.drawable.olaf, R.drawable.farosa, R.drawable.floffy};

        GridAdapter gridAdapter = new GridAdapter(HomePage.this, petName, petImages);
        binding.grid.setAdapter(gridAdapter);


        binding.grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(HomePage.this, "You Clicked on" + petName[position], Toast.LENGTH_SHORT).show();
                setContentView(R.layout.activity_pet_profile);
            }
        });


    }
}

