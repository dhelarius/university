package com.itla.university;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CollegeCareersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_careers);

        FloatingActionButton goToAddCareer = findViewById(R.id.goToAddCareer);

        goToAddCareer.setOnClickListener(v -> {
            navigateToAddCarrerActivity();
        });
    }

    private void navigateToAddCarrerActivity() {
        Intent intent = new Intent(this, AddCareerActivity.class);
        startActivity(intent);
    }
}
