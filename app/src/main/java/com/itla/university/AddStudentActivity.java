package com.itla.university;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import com.google.android.material.snackbar.Snackbar;
import com.itla.university.controller.StudentController;
import com.itla.university.model.repository.RepositoryStudentDbImpl;

public class AddStudentActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = AddStudentActivity.class.getSimpleName();

    private StudentController studentController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        ViewGroup viewGroup = findViewById(R.id.viewGroupAddStudentActivity);

        studentController = new StudentController(this, new RepositoryStudentDbImpl(this), viewGroup);

        Button saveStudent = findViewById(R.id.saveStudent);
        Button cancel = findViewById(R.id.cancel);
        Spinner spinnerCareers = findViewById(R.id.spinnerCareers);
        ImageButton goToListCareers = findViewById(R.id.goToListCareers);

        studentController.populateSpinnerWithCareerNames(spinnerCareers);
        spinnerCareers.setOnItemSelectedListener(this);

        saveStudent.setOnClickListener(v -> {
            if(saveStudentIntoDatabase()){
                studentController.updateView(v);
            }else{
                Snackbar.make( v, "No se ha podido crear el estudiante", Snackbar.LENGTH_SHORT).show();
            }
        });

        goToListCareers.setOnClickListener(v -> {
            navigateToCollegeCareersActivity();
        });

        cancel.setOnClickListener(v -> {
            navigateToStudentActivity();
        });

    }

    private Boolean saveStudentIntoDatabase() {
        return studentController.saveStudentIntoDatabase();
    }

    private void navigateToCollegeCareersActivity() {
        Intent intent = new Intent(this, CollegeCareersActivity.class);
        startActivity(intent);
    }

    private void navigateToStudentActivity() {
        onNavigateUp();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String careerNameItem = parent.getSelectedItem().toString();
        studentController.setCareerNameItem(careerNameItem);
        Log.i(TAG, careerNameItem);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
