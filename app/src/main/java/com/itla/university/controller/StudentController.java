package com.itla.university.controller;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.snackbar.Snackbar;
import com.itla.university.R;
import com.itla.university.model.entity.Career;
import com.itla.university.model.entity.Student;
import com.itla.university.model.repository.FactoryRepository;
import com.itla.university.model.repository.Repository;
import com.itla.university.model.repository.type.RepositoryType;
import java.util.ArrayList;
import java.util.List;

public class StudentController implements Controller {

    private static final String TAG = StudentController.class.getSimpleName();

    private Context context;
    private Repository<Student> studentRepository;
    private Repository<Career> careerRepository;
    private String careerNameItem;

    private EditText studentName;
    private EditText studentRegistration;

    public StudentController(Context context, Repository<Student> studentRepository, ViewGroup viewGroup){
        this.context = context;
        this.studentRepository = studentRepository;
        studentName = viewGroup.findViewById(R.id.studentName);
        studentRegistration = viewGroup.findViewById(R.id.studentRegistration);
        careerRepository = FactoryRepository.getRepository(context, RepositoryType.CAREER);
    }

    public void setCareerNameItem(String careerNameItem) {
        this.careerNameItem = careerNameItem;
    }

    public Boolean canSaveStudent(){
        return !studentName.getText().toString().isEmpty() && !studentRegistration.getText().toString().isEmpty();
    }

    public Boolean saveStudentIntoDatabase(){
        if(!canSaveStudent())
            return false;

        String name = studentName.getText().toString();
        String registration = studentRegistration.getText().toString();
        int careerId = getCareerId();

        Student student = new Student();
        student.setName(name);
        student.setRegistration(registration);
        student.setCareerId(careerId);

        studentRepository.create(student);

        return true;
    }

    private int getCareerId(){
        int careerId = 0;
        List<Career> careers = careerRepository.findAll();
        for(Career career : careers){
            if(career.getName().equals(careerNameItem)){
                careerId = career.getId();
            }
        }
        return careerId;
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
        Snackbar.make( v, "Se ha guardado el estudiante", Snackbar.LENGTH_SHORT).show();
    }
}
