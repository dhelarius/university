package com.itla.university;

import androidx.appcompat.app.AlertDialog;
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

    private StudentController controller;

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        ViewGroup viewGroup = findViewById(R.id.viewGroupAddStudentActivity);

        controller = new StudentController(this, new RepositoryStudentDbImpl(this), viewGroup);

        Button saveStudent = findViewById(R.id.saveStudent);
        Button cancel = findViewById(R.id.cancel);
        Spinner spinnerCareers = findViewById(R.id.spinnerCareers);
        ImageButton goToListCareers = findViewById(R.id.goToListCareers);

        controller.populateSpinnerWithCareerNames(spinnerCareers);
        spinnerCareers.setOnItemSelectedListener(this);

        saveStudent.setOnClickListener(v -> {
            view = v;
            if(controller.canSaveStudent()){
                showDialogToSaveStudent();
            }else{
                Snackbar.make(view, "No se ha podido crear el estudiante", Snackbar.LENGTH_SHORT).show();
            }
        });

        goToListCareers.setOnClickListener(v -> {
            navigateToCollegeCareersActivity();
        });

        cancel.setOnClickListener(v -> {
            navigateToStudentActivity();
        });
    }

    private void showDialogToSaveStudent(){
        AlertDialog alertDialog = createDialogToSaveStudent();
        alertDialog.show();
    }

    private AlertDialog createDialogToSaveStudent(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialogTheme);
        builder.setMessage("Guardar estudiante?");
        builder.setPositiveButton("ACEPTAR", (dialog, which) -> {
            if(saveStudentIntoDatabase()){
                controller.updateView(view);
            }
        });
        builder.setNegativeButton("CANCELAR", (dialog, which) -> {
            dialog.dismiss();
        });
        AlertDialog dialog = builder.create();
        dialog.setCancelable(false);
        return dialog;
    }

    private Boolean saveStudentIntoDatabase() {
        return controller.saveStudentIntoDatabase();
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
        controller.setCareerNameItem(careerNameItem);
        Log.i(TAG, careerNameItem);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
