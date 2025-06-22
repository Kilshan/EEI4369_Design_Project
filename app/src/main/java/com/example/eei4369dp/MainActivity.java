package com.example.eei4369dp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the Email button by its ID
        Button emailButton = findViewById(R.id.Email);
        // Set click listener for the Email button
        emailButton.setOnClickListener(v -> {
            // Create Email login activity
            Intent intent = new Intent(MainActivity.this, EmailLoginActivity.class);
            startActivity(intent);
        });

        // Find the Create Account button by its ID
        Button acccreateButton = findViewById(R.id.acccreate);
        // Set click listener for the Create Account button
        acccreateButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SingupAc.class);
            startActivity(intent);
        });
    }
}