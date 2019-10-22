package com.itla.university;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class AddCareerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_career);

        Button cancel = findViewById(R.id.cancel);

        cancel.setOnClickListener(v -> {
            navigateToCollegeCoreersActivity();
        });
    }

    private void navigateToCollegeCoreersActivity() {
        onNavigateUp();
    }
}
