package com.itla.university;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.itla.university.adapter.CareersAdapter;
import com.itla.university.model.entity.Career;
import com.itla.university.model.repository.FactoryRepository;
import com.itla.university.model.repository.Repository;
import com.itla.university.model.repository.type.RepositoryType;

public class CollegeCareersActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private Repository<Career> careerRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_careers);

        careerRepository = FactoryRepository.getRepository(this, RepositoryType.CAREER);

        recyclerView = findViewById(R.id.listCareers);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new CareersAdapter(careerRepository.findAll());

        recyclerView.setAdapter(adapter);

        FloatingActionButton goToAddCareer = findViewById(R.id.goToAddCareer);

        goToAddCareer.setOnClickListener(v -> {
            navigateToAddCarrerActivity();
        });
    }

    private void navigateToAddCarrerActivity() {
        Intent intent = new Intent(this, AddCareerActivity.class);
        startActivity(intent);
    }
}
