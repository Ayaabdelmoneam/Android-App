package com.example.petadoption;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdoptionForm extends AppCompatActivity {
    EditText ageEditText, weightEditText, petNameInput, petBreedInput, petDescriptionInput, ownerInfoInput, petLocationInput;
    RadioGroup radioGroup1, radioGroup2;
    boolean flag;
    ImageView submitButton, backButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adoption_form);
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AdoptionForm.this, HomePage.class);
                startActivity(i);
            }
        });
        submitButton = findViewById(R.id.SubmitButtonForm);
        ageEditText = findViewById(R.id.petAgeInput);
        weightEditText = findViewById(R.id.petWeightInput);
        petNameInput = findViewById(R.id.petNameInput);
        petBreedInput = findViewById(R.id.petBreedInput);
        petLocationInput = findViewById(R.id.petLocationInput);
        petDescriptionInput = findViewById(R.id.petDescriptionInput);
        ownerInfoInput = findViewById(R.id.ownerInfoInput);

        radioGroup1 = findViewById(R.id.radioGroupPetType);
        radioGroup2 = findViewById(R.id.radioGroupPetGender);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = true; // Reset the flag before each validation
                if (areAllFieldsEmpty()) {
                    showErrorToast("Please fill in your pet's information");
                    return;
                }
                validateAgeAndWeight();
                validateRadioGroups();
                validateTextInput(petNameInput, "Please enter your pet's name");
                validateTextInput(petBreedInput, "Please enter your pet's breed");
                validateTextInput(petDescriptionInput, "Please enter your pet's description");
                validatePhoneNumber(ownerInfoInput, "Please enter a valid phone number");

                if (flag) {
                    updateData();
                    navigateBackToHomepage();
                }
            }
        });
    }
    private boolean areAllFieldsEmpty() {
        return ageEditText.getText().toString().isEmpty() &&
                weightEditText.getText().toString().isEmpty() &&
                petNameInput.getText().toString().isEmpty() &&
                petBreedInput.getText().toString().isEmpty() &&
                petDescriptionInput.getText().toString().isEmpty() &&
                ownerInfoInput.getText().toString().isEmpty() &&
                radioGroup1.getCheckedRadioButtonId() == -1 &&
                radioGroup2.getCheckedRadioButtonId() == -1;
    }
    private void validateAgeAndWeight() {
        boolean isAgeValid = isValidNumber(ageEditText.getText().toString(), "age");
        boolean isWeightValid = isValidNumber(weightEditText.getText().toString(), "weight");

        if (!isAgeValid) {
            showErrorToast("Please enter a valid age between 0.1 and 20");
        }
        if (!isWeightValid) {
            showErrorToast("Please enter a valid weight");
        }
        else{
            System.out.print("Age and Weight saved.");
        }
    }
    private void validateRadioGroups() {
        int selectedRadioButtonId1 = radioGroup1.getCheckedRadioButtonId();
        int selectedRadioButtonId2 = radioGroup2.getCheckedRadioButtonId();

        if (selectedRadioButtonId1 == -1) {
            showErrorToast("Please select a pet category");
        }

        if (selectedRadioButtonId2 == -1) {
            showErrorToast("Please select a pet gender");
        }
        else{
            System.out.print("Gender and Pet Saved.");
        }
    }
    private void validateTextInput(EditText editText, String errorMessage) {
        if (editText.getText().toString().isEmpty()) {
            showErrorToast(errorMessage);
        }
        else{
            System.out.print("Text inputs saved.");
        }
    }
    private void validatePhoneNumber(EditText editText, String errorMessage) {
        String phoneInput = editText.getText().toString();
        if (!isValidPhoneNumber(phoneInput)) {
            showErrorToast(errorMessage);
        }
        else{
            System.out.print("Phone number saved.");
        }

    }
    private void showErrorToast(String message) {
        Toast.makeText(AdoptionForm.this, message, Toast.LENGTH_SHORT).show();
        flag = false;
    }
    private void navigateBackToHomepage() {
        Intent intent = new Intent(AdoptionForm.this, PetProfile.class);
        startActivity(intent);
    }
    private void updateData(){
        PetDatabaseHelper dbHelper = new PetDatabaseHelper(AdoptionForm.this);

// Inside the form submission logic
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PetDatabaseHelper.COLUMN_AGE, Double.parseDouble(ageEditText.getText().toString()));
        values.put(PetDatabaseHelper.COLUMN_WEIGHT, Double.parseDouble(weightEditText.getText().toString()));
        values.put(PetDatabaseHelper.COLUMN_NAME, petNameInput.getText().toString());
        values.put(PetDatabaseHelper.COLUMN_LOCATION, petNameInput.getText().toString());
        values.put(PetDatabaseHelper.COLUMN_BREED, petBreedInput.getText().toString());
        values.put(PetDatabaseHelper.COLUMN_DESCRIPTION, petDescriptionInput.getText().toString());
        values.put(PetDatabaseHelper.COLUMN_OWNER_INFO, ownerInfoInput.getText().toString());

// Get selected radio button IDs
        int typeRadioButtonId = radioGroup1.getCheckedRadioButtonId();
        int genderRadioButtonId = radioGroup2.getCheckedRadioButtonId();

// Get the text of the selected radio buttons
        RadioButton typeRadioButton = findViewById(typeRadioButtonId);
        RadioButton genderRadioButton = findViewById(genderRadioButtonId);

        values.put(PetDatabaseHelper.COLUMN_TYPE, typeRadioButton.getText().toString());
        values.put(PetDatabaseHelper.COLUMN_GENDER, genderRadioButton.getText().toString());

// Insert the data into the database
        long newRowId = db.insert(PetDatabaseHelper.TABLE_NAME, null, values);
// Close the database connection

        Cursor cursor = dbHelper.getAllPets();

        if (cursor != null) {
            while (cursor.moveToNext()) {
                // Retrieve data from the cursor
                int petId = cursor.getInt(cursor.getColumnIndexOrThrow(PetDatabaseHelper.COLUMN_ID));
                String petName = cursor.getString(cursor.getColumnIndexOrThrow(PetDatabaseHelper.COLUMN_NAME));

                Log.d("Database", "Pet ID: " + petId + ", Pet Name: " + petName);
            }

            // Close the cursor
            cursor.close();
        }

        db.close();
}
    private boolean isValidNumber(String input, String fieldName) {
        try {
            double enteredNumber = Double.parseDouble(input);
            if (fieldName.equals("age")) {
                return enteredNumber >= 0.1 && enteredNumber <= 20.0;
            } else if (fieldName.equals("weight")) {
                return enteredNumber >= 0.1 && enteredNumber <= 30.0;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            // Handle the case where the input is not a valid double
            return false;
        }
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        // Remove any spaces or dashes from the phone number
        String cleanedPhoneNumber = phoneNumber.replaceAll("[\\s\\-]+", "");

        // Use Android's Patterns class to check if the cleaned phone number matches a valid pattern
        return Patterns.PHONE.matcher(cleanedPhoneNumber).matches();
    }
}