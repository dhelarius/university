package com.itla.university.model.repository;

import android.content.Context;

import com.itla.university.data.dao.Dao;
import com.itla.university.data.dao.StudentDao;
import com.itla.university.model.entity.Student;

import java.util.List;

public class RepositoryStudentDbImpl implements Repository<Student> {

    private Dao<Student> studentDao;

    public RepositoryStudentDbImpl(Context context){ this.studentDao = new StudentDao(context);}

    @Override
    public void create(Student student) {
        studentDao.create(student);
    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(Student student) {

    }

    @Override
    public Student find(int id) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }
}
