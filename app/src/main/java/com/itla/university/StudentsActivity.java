package com.itla.university;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.itla.university.adapter.StudentsAdapter;
import com.itla.university.model.entity.Student;
import com.itla.university.model.repository.FactoryRepository;
import com.itla.university.model.repository.Repository;
import com.itla.university.model.repository.type.RepositoryType;

public class StudentsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private Repository<Student> studentRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);

        studentRepository = FactoryRepository.getRepository(this, RepositoryType.STUDENT);

        recyclerView = findViewById(R.id.listStudents);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new StudentsAdapter(studentRepository.findAll());

        recyclerView.setAdapter(adapter);

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
