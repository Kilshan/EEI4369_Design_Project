package com.example.eei4369dp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Dashboard extends AppCompatActivity {
    private TextView dateTimeTextView;
    private Button settingsButton, addButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        dateTimeTextView = findViewById(R.id.dateTime);
        settingsButton = findViewById(R.id.settings);
        addButton = findViewById(R.id.add);
        backButton = findViewById(R.id.prev);

        updateDateTime();

        // Button click listeners
        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add functions to reminders
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back to login screen
                finish();
            }
        });
    }

    private void updateDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd\nhh:mm a", Locale.getDefault());
        String currentDateTime = sdf.format(new Date());
        dateTimeTextView.setText(currentDateTime);
    }
}