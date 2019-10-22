package com.itla.university;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.itla.university.model.entity.Career;
import com.itla.university.model.entity.Entity;
import com.itla.university.model.repository.FactoryRepository;
import com.itla.university.model.repository.Repository;
import com.itla.university.model.repository.type.RepositoryType;

public class AddCareerActivity extends AppCompatActivity {

    private Repository repository;

    private EditText editTextCareer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_career);

        repository = FactoryRepository.getRepository(this, RepositoryType.CAREER);

        editTextCareer = findViewById(R.id.editTextCareer);

        Button cancel = findViewById(R.id.cancel);
        Button saveCareer = findViewById(R.id.saveCareer);

        saveCareer.setOnClickListener(v -> {
            if(saveCareerIntoDatabase()){
                Snackbar.make( v, "Se ha guardado la carrera", Snackbar.LENGTH_SHORT).show();
            }
        });

        cancel.setOnClickListener(v -> {
            navigateToCollegeCareersActivity();
        });
    }

    private Boolean saveCareerIntoDatabase() {
        Career career = new Career();
        String careerName = editTextCareer.getText().toString();
        career.setName(careerName);
        repository.create(career);

        editTextCareer.setText("");

        return true;
    }

    private void navigateToCollegeCareersActivity() {
        onNavigateUp();
    }
}
