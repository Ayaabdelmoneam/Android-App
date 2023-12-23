package com.example.petadoption;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AdoptionReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        // Handle the adoption request or any other logic here.
        String action = intent.getAction();
        if ("com.example.petadoption.ADOPTION_REQUEST_SUBMITTED".equals(action)) {
            showToast(context, "Adoption request received!");
            // You can add additional logic here based on the adoption request.
        }
    }

    private void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}