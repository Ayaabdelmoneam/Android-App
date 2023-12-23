// PetProfile.java
package com.example.petadoption;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PetProfile extends AppCompatActivity {
    private Button adoptMeButton;
    private ImageButton backButton,meowButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_profile);
        meowButton = findViewById(R.id.sound);
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PetProfile.this, HomePage.class);
                startActivity(i);
            }
        });

        adoptMeButton = findViewById(R.id.adoptMeButton);
        adoptMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Your existing adoption code
                Intent adoptionIntent = new Intent("com.example.petadoption.ADOPTION_REQUEST_SUBMITTED");
                sendBroadcast(adoptionIntent);

                Toast.makeText(PetProfile.this, "Adoption request submitted!", Toast.LENGTH_SHORT).show();

                Intent dialerIntent = new Intent(Intent.ACTION_DIAL);
                dialerIntent.setData(Uri.parse("tel:01151234569"));
                startActivity(dialerIntent);
            }
        });


        meowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the MediaPlayerService to play the meow sound
                Intent serviceIntent = new Intent(PetProfile.this, MediaPlayerService.class);
                startService(serviceIntent);
            }
        });
    }
}
