package com.itla.university.model.repository;

import android.content.Context;

import com.itla.university.data.dao.CareerDao;
import com.itla.university.model.entity.Career;

import java.util.List;

public class RepositoryCareerDbImpl implements Repository<Career> {

    private CareerDao careerDao;

    public RepositoryCareerDbImpl(Context context){
        careerDao = new CareerDao(context);
    }

    @Override
    public void create(Career career) {
        careerDao.create(career);
    }

    @Override
    public void update(Career career) {

    }

    @Override
    public void delete(Career career) {

    }

    @Override
    public Career find(int id) {
        return null;
    }

    @Override
    public List<Career> findAll() {
        return careerDao.findAll();
    }
}
