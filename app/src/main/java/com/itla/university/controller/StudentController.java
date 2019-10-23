package com.itla.university.controller;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.itla.university.R;
import com.itla.university.model.entity.Career;
import com.itla.university.model.entity.Student;
import com.itla.university.model.repository.FactoryRepository;
import com.itla.university.model.repository.Repository;
import com.itla.university.model.repository.type.RepositoryType;

import java.util.ArrayList;
import java.util.List;

public class StudentController implements Controller {

    private Context context;

    private Repository<Student> studentRepository;
    private Repository<Career> careerRepository;

    private ViewGroup viewGroup;

    public StudentController(Context context, Repository<Student> studentRepository, ViewGroup viewGroup){
        this.context = context;
        this.studentRepository = studentRepository;
        careerRepository = FactoryRepository.getRepository(context, RepositoryType.CAREER);
    }

    public void populateSpinnerWithCareerNames(Spinner spinner){
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(context, R.layout.support_simple_spinner_dropdown_item, getCareerNames());
        spinner.setAdapter(adapter);
    }

    private List<String> getCareerNames(){
        List<String> careerNames = new ArrayList<>();
        List<Career> careers = careerRepository.findAll();

        for(Career career : careers){
            String careerName = career.getName();
            careerNames.add(careerName);
        }

        return careerNames;

    }

    @Override
    public void updateView(View v) {

    }
}
