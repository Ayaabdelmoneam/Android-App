package com.example.petadoption;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class QuestionsActivity extends AppCompatActivity {

    private TextView textView4;
    private TextView textView2;
    private TextView textView3;
    private ImageView yesButton;
    private ImageView noButton,add,profile,home;
    private ImageView submitImageView;
    private int clickCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qts);


        home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform any login logic here if needed
                // For now, let's navigate to MainActivity
                Intent i = new Intent(QuestionsActivity.this, HomePage.class);
                startActivity(i);
            }
        });

        profile = findViewById(R.id.profile);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform any login logic here if needed
                // For now, let's navigate to MainActivity
                Intent i = new Intent(QuestionsActivity.this, LisaProfile.class);
                startActivity(i);
            }
        });

        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(QuestionsActivity.this, AdoptionForm.class);
                startActivity(i);
            }
        });

        textView4 = findViewById(R.id.textView4);
        textView3 = findViewById(R.id.textView3);
        textView2 = findViewById(R.id.textView2);
        submitImageView = findViewById(R.id.submit);
        noButton = findViewById(R.id.no);
        yesButton = findViewById(R.id.yes);
        submitImageView.setVisibility(View.GONE);
        // Set a click listener for the Yes ImageView
        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Change all the text in textView3 when the ImageView is clicked
                if (clickCount == 0) {
                    textView3.setText("Are you looking for a pet that requires regular outdoor\n" +
                            "exercises and playtime?");
                    textView2.setText("Question 2");
                    textView4.setText("2/5");
                    clickCount = 1;
                } else if (clickCount == 1) {
                    textView3.setText("Are you comfortable with a pet that may require grooming and shed hair?");
                    textView2.setText("Question 3");
                    textView4.setText("3/5");
                    clickCount = 2;
                } else if (clickCount == 2) {
                    textView3.setText("Are you willing to provide mental stimulation and interactive toys for your pet?");
                    textView2.setText("Question 4");
                    textView4.setText("4/5");
                    clickCount = 3;
                } else if (clickCount == 3) {
                        textView3.setText("Are you open to the idea of training a pet and investing time in obedience training?");
                        textView2.setText("Question 5");
                    textView4.setText("5/5");
                        clickCount = 4;

                }
                else if (clickCount == 4) {
                    textView3.setText("Are you open to the idea of training a pet and investing time in obedience training?");
                    textView2.setText("Question 5");
                    textView4.setText("5/5");
                    submitImageView.setVisibility(View.VISIBLE);
                    submitImageView.setImageResource(R.drawable.submit);
                    clickCount = 5;

                }else {

                }
            }
        });
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Change all the text in textView3 when the ImageView is clicked
                if (clickCount == 0) {
                    textView3.setText("Are you looking for a pet that requires regular outdoor\n" +
                            "exercises and playtime?");
                    textView2.setText("Question 2");
                    textView4.setText("2/5");
                    clickCount = 1;
                } else if (clickCount == 1) {
                    textView3.setText("Are you comfortable with a pet that may require grooming and shed hair?");
                    textView2.setText("Question 3");
                    textView4.setText("3/5");
                    clickCount = 2;
                } else if (clickCount == 2) {
                    textView3.setText("Are you willing to provide mental stimulation and interactive toys for your pet?");
                    textView2.setText("Question 4");
                    textView4.setText("4/5");
                    clickCount = 3;
                } else if (clickCount == 3) {
                    textView3.setText("Are you open to the idea of training a pet and investing time in obedience training?");
                    textView2.setText("Question 5");
                    textView4.setText("5/5");
                    clickCount = 4;
                }
                else if (clickCount == 4) {
                    textView3.setText("Are you open to the idea of training a pet and investing time in obedience training?");
                    textView2.setText("Question 5");
                    textView4.setText("5/5");
                    submitImageView.setVisibility(View.VISIBLE);
                    submitImageView.setImageResource(R.drawable.submit);
                    clickCount = 5;

                }else {

                }
            }
        });
        submitImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuestionsActivity.this,ResultActivity.class);
                startActivity(intent);
            }
        });
    }
    }



