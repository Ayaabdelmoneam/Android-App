package com.example.petadoption;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button signup, forgot;
    EditText email;
    EditText password;
    SharedPreferences preferences;
    ImageButton SI_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        email = findViewById(R.id.emailEditText);
        password = findViewById(R.id.passwordEditText);
        SI_login = findViewById(R.id.SI_login);
        signup = findViewById(R.id.signup);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("user", Context.MODE_PRIVATE);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SignUp.class);
                startActivity(i);
            }
        });

        SI_login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Check for empty fields
                String enteredEmail = email.getText().toString().trim();
                String enteredPassword = password.getText().toString().trim();

                if (TextUtils.isEmpty(enteredEmail) || TextUtils.isEmpty(enteredPassword)) {
                    Toast.makeText(MainActivity.this, "Please enter both email and password", Toast.LENGTH_SHORT).show();
                    return;
                }
                // Check for valid email and password
                if (enteredEmail.equals(sp.getString("Email", "")) && enteredPassword.equals(sp.getString("Password", ""))) {
                    // Successfully logged in
                    Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();

                    // Navigate to the home page (adjust the destination activity accordingly)
                    Intent homeNav = new Intent(MainActivity.this, HomePage.class);
                    startActivity(homeNav);

                } else {
                    // Incorrect email or password
                    Toast.makeText(MainActivity.this, "Incorrect email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        forgot = findViewById(R.id.forgetButton);
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ForgetActivity.class);
                startActivity(i);
            }
        });
    }
}
