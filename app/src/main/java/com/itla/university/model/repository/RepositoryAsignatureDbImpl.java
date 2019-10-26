package com.itla.university.model.repository;

import android.content.Context;

import com.itla.university.data.dao.AsignatureDao;
import com.itla.university.data.dao.Dao;
import com.itla.university.model.entity.Asignature;

import java.util.List;


public class RepositoryAsignatureDbImpl implements Repository<Asignature> {

    private Dao<Asignature> asignatureDao;

    public RepositoryAsignatureDbImpl(Context context){ asignatureDao = new AsignatureDao(context); }

    @Override
    public void create(Asignature asignature) { asignatureDao.create(asignature);}

    @Override
    public void update(Asignature asignature) {

    }

    @Override
    public void delete(Asignature asignature) {

    }

    @Override
    public Asignature find(int id) {
        return null;
    }

    @Override
    public List<Asignature> findAll() {
        return asignatureDao.findAll();
    }
}
