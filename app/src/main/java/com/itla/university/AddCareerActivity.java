package com.itla.university;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;
import com.itla.university.controller.CareerController;
import com.itla.university.model.repository.RepositoryCareerDbImpl;

public class AddCareerActivity extends AppCompatActivity {

    private CareerController controller;

    private View view;

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
            view = v;
            if(controller.canSaveCareer()){
                showDialogToSaveCareer();
            }else{
                Snackbar.make(view, "No se ha podido crear la carrera", Snackbar.LENGTH_SHORT).show();
            }
        });

        cancel.setOnClickListener(v -> {
            navigateToCollegeCareersActivity();
        });
    }

    private void showDialogToSaveCareer(){
        AlertDialog alertDialog = createDialogToSaveCareer();
        alertDialog.show();
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(getResources().getColor(R.color.colorPrimary));
        alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(getResources().getColor(R.color.colorPrimary));
    }

    private AlertDialog createDialogToSaveCareer(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Guardar carrera?");
        builder.setPositiveButton("ACEPTAR", (dialog, which) -> {
            if(saveCareerIntoDatabase()){
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

    private Boolean saveCareerIntoDatabase() {
        return controller.saveCareerIntoDatabase();
    }

    private void navigateToCollegeCareersActivity() {
        onNavigateUp();
    }
}
