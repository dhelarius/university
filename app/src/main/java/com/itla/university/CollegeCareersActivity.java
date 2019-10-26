package com.itla.university;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.itla.university.adapter.CareersAdapter;
import com.itla.university.model.entity.Asignature;
import com.itla.university.model.entity.Career;
import com.itla.university.model.entity.CareerAsignature;
import com.itla.university.model.repository.FactoryRepository;
import com.itla.university.model.repository.Repository;
import com.itla.university.model.repository.RepositoryCareerAsignatureDb;
import com.itla.university.model.repository.type.RepositoryType;

public class CollegeCareersActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private Repository<Career> careerRepository;
    Repository<Asignature> asignatureRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_careers);

        asignatureRepository = FactoryRepository.getRepository(this, RepositoryType.ASIGNATURE);

        assert asignatureRepository != null;
        if(asignatureRepository.findAll().size() <= 0) {
            populateAsignaturesTableIntoDatabase();
        }

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

    private void populateAsignaturesTableIntoDatabase() {
        RepositoryCareerAsignatureDb careerAsignatureDb = new RepositoryCareerAsignatureDb(this);

        Asignature asig1 = new Asignature();
        asig1.setName("Historia del derecho");
        asig1.setCredits(4);
        asignatureRepository.create(asig1);
        CareerAsignature ca1 = new CareerAsignature(1, 1);
        careerAsignatureDb.create(ca1);

        Asignature asig2 = new Asignature();
        asig2.setName("Inglés");
        asig2.setCredits(4);
        asignatureRepository.create(asig2);
        CareerAsignature ca2 = new CareerAsignature(1, 2);
        careerAsignatureDb.create(ca2);
        CareerAsignature ca3 = new CareerAsignature(2, 2);
        careerAsignatureDb.create(ca3);
        CareerAsignature ca4 = new CareerAsignature(3, 2);
        careerAsignatureDb.create(ca4);
        CareerAsignature ca5 = new CareerAsignature(4, 2);
        careerAsignatureDb.create(ca5);

        Asignature asig3 = new Asignature();
        asig3.setName("Inglés técnico");
        asig3.setCredits(3);
        asignatureRepository.create(asig3);
        CareerAsignature ca6 = new CareerAsignature(3, 3);
        careerAsignatureDb.create(ca6);

        Asignature asig4 = new Asignature();
        asig4.setName("Marketing digital");
        asig4.setCredits(3);
        asignatureRepository.create(asig4);
        CareerAsignature ca7 = new CareerAsignature(2, 4);
        careerAsignatureDb.create(ca7);

        Asignature asig5 = new Asignature();
        asig5.setName("Introducción a la educación");
        asig5.setCredits(4);
        asignatureRepository.create(asig5);
        CareerAsignature ca8 = new CareerAsignature(4, 5);
        careerAsignatureDb.create(ca8);
    }

    private void navigateToAddCarrerActivity() {
        Intent intent = new Intent(this, AddCareerActivity.class);
        startActivity(intent);
    }
}
