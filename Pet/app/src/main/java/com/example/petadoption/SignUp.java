package com.example.petadoption;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    Button loginButton;
    EditText email;
    EditText fullname;
    EditText username;
    EditText password;
    EditText confirm;
    ImageButton signin;
    ImageButton showHideButton1;
    ImageButton showHideButton2;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        email = findViewById(R.id.SUemail);
        password = findViewById(R.id.SUpassword);
        showHideButton1 = findViewById(R.id.hiddenEye1);
        showHideButton2 = findViewById(R.id.hiddenEye2);
        confirm=findViewById(R.id.SUconfirmPass);
        username=findViewById(R.id.SUusername);
        fullname=findViewById(R.id.SUname);
        signin=findViewById(R.id.SUsignIn);
        preferences = getSharedPreferences("user" , Context.MODE_PRIVATE);
        showHideButton1.setImageResource(R.drawable.ic_hide_pwd);
        showHideButton2.setImageResource(R.drawable.ic_hide_pwd);
        loginButton = findViewById(R.id.SUloginHere);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform any login logic here if needed
                // For now, let's navigate to MainActivity
                Intent intent = new Intent(SignUp.this, MainActivity.class);
                startActivity(intent);
            }
        });


        showHideButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(password.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    showHideButton1.setImageResource(R.drawable.ic_hide_pwd);

                }else {
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    showHideButton1.setImageResource(R.drawable.ic_show_pwd);

                }
            }
        });
        showHideButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(confirm.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())){
                    confirm.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    showHideButton2.setImageResource(R.drawable.ic_hide_pwd);

                }else {
                    confirm.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    showHideButton2.setImageResource(R.drawable.ic_show_pwd);
                }
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname = fullname.getText().toString();
                String pass1 = password.getText().toString();
                String pass2 = confirm.getText().toString();
                String uname = username.getText().toString();
                String el = email.getText().toString();
                if (TextUtils.isEmpty(el)) {
                    email.setError("This field is required");
                }
                else if (TextUtils.isEmpty(fname)) {
                    fullname.setError( "This field is required");
                }
                else if (TextUtils.isEmpty(pass1)) {
                    password.setError( "This field is required");
                }
                else if (TextUtils.isEmpty(pass2)) {
                    confirm.setError( "This field is required");
                }
               else if (TextUtils.isEmpty(uname)) {
                    username.setError( "This field is required");
                }
                else if(pass1.equals(pass2)){
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Password", pass1);
                    editor.putString("full_name", fname);
                    editor.putString("Email", el);
                    editor.putString("user_name", uname);
                    editor.commit();
                    Intent i =new Intent(SignUp.this, MainActivity.class);
                    startActivity(i);
                }else{
                    Toast.makeText(SignUp.this,"please confirm your password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
