package com.itla.university;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class StudentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);

        FloatingActionButton addStudent = findViewById(R.id.addStudent);

        addStudent.setOnClickListener(v -> {
            navigateToAddStudentActivity();
        });
    }

    private void navigateToAddStudentActivity() {
        Intent intent = new Intent(this,  AddStudentActivity.class);
        startActivity(intent);
    }
}
