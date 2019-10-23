package com.itla.university;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;
import com.itla.university.controller.CareerController;
import com.itla.university.model.repository.RepositoryCareerDbImpl;

public class AddCareerActivity extends AppCompatActivity {

    private CareerController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_career);

        ViewGroup constraintslayout = findViewById(R.id.constraintlayout);

        controller = new CareerController(new RepositoryCareerDbImpl(this), constraintslayout);

        controller.printAllCareers();

        Button cancel = findViewById(R.id.cancel);
        Button saveCareer = findViewById(R.id.saveCareer);

        saveCareer.setOnClickListener(v -> {
            if(saveCareerIntoDatabase()){
                controller.updateView(v);
            }else{
                Snackbar.make( v, "No se ha podido crear la carrera", Snackbar.LENGTH_SHORT).show();
            }
        });

        cancel.setOnClickListener(v -> {
            navigateToCollegeCareersActivity();
        });
    }

    private Boolean saveCareerIntoDatabase() {
        return controller.saveCareerIntoDatabase();
    }

    private void navigateToCollegeCareersActivity() {
        onNavigateUp();
    }
}
