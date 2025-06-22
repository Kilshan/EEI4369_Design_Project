package com.example.eei4369dp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SingupAc extends AppCompatActivity {
    private EditText userNameInput, emailInput, passwordInput, againPasswordInput;
    private Button createAccountButton, loginButton;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_create);

        // Initialize views
        userNameInput = findViewById(R.id.userNameInput);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        againPasswordInput = findViewById(R.id.againPasswordInput);
        createAccountButton = findViewById(R.id.createAccountButton);
        loginButton = findViewById(R.id.loginButton);
        dbHelper = new DatabaseHelper(this);

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userNameInput.getText().toString().trim();
                String email = emailInput.getText().toString().trim();
                String password = passwordInput.getText().toString().trim();
                String confirmPassword = againPasswordInput.getText().toString().trim();

                // Validation checkings
                if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(SingupAc.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirmPassword)) {
                    Toast.makeText(SingupAc.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else {
                    // Check if email already exists
                    if (dbHelper.checkUserCredentials(email, password)) {
                        Toast.makeText(SingupAc.this, "Email already exists", Toast.LENGTH_SHORT).show();
                    } else {
                        // Insert new user
                        boolean isInserted = dbHelper.insertUser(email, password);
                        if (isInserted) {
                            Toast.makeText(SingupAc.this, "Account created successfully", Toast.LENGTH_SHORT).show();
                            // Navigate to Dashboard
                            Intent intent = new Intent(SingupAc.this, Dashboard.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(SingupAc.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to login screen
                Intent intent = new Intent(SingupAc.this, EmailLoginActivity.class);
                startActivity(intent);
            }
        });
    }
}