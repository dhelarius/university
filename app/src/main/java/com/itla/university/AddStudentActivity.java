package com.itla.university;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class AddStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        Button cancel = findViewById(R.id.cancel);
        ImageButton addCareer = findViewById(R.id.goToListCareer);

        addCareer.setOnClickListener(v -> {
            navigateToCollegeCareersActivity();
        });

        cancel.setOnClickListener(v -> {
            navigateToStudentActivity();
        });

    }

    private void navigateToCollegeCareersActivity() {
        Intent intent = new Intent(this, CollegeCareersActivity.class);
        startActivity(intent);
    }

    private void navigateToStudentActivity() {
        onNavigateUp();
    }
}
