package com.itla.university.controller;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.itla.university.R;
import com.itla.university.model.entity.Career;
import com.itla.university.model.repository.Repository;

public class CareerController implements Controller {

    private Repository<Career> repository;
    private ViewGroup viewGroup;

    public CareerController(Repository<Career> repository, ViewGroup viewGroup) {
        this.repository = repository;
        this.viewGroup = viewGroup;
    }

    public Boolean saveCareerIntoDatabase(){
        Career career = new Career();
        EditText editTextCareer = viewGroup.findViewById(R.id.editTextCareer);
        career.setName(editTextCareer.getText().toString());
        repository.create(career);

        editTextCareer.setText("");

        return true;
    }

    @Override
    public void updateView(View v) {
        Snackbar.make( v, "Se ha guardado la carrera", Snackbar.LENGTH_SHORT).show();
    }
}
