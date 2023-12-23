package com.example.petadoption;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class  ForgetActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        ImageButton forgetSendButton = findViewById(R.id.sendBtn);

        forgetSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Reset password link sent!", Snackbar.LENGTH_SHORT).show();

                Intent i = new Intent(ForgetActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}
