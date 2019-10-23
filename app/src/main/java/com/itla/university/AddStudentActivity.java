package com.itla.university;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import com.itla.university.controller.StudentController;
import com.itla.university.model.repository.RepositoryStudentDbImpl;

public class AddStudentActivity extends AppCompatActivity {

    private StudentController studentController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        studentController = new StudentController(this, new RepositoryStudentDbImpl(), null);

        Button cancel = findViewById(R.id.cancel);
        Spinner spinnerCareers = findViewById(R.id.spinnerCareers);
        ImageButton addCareer = findViewById(R.id.goToListCareer);

        studentController.populateSpinnerWithCareerNames(spinnerCareers);

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
