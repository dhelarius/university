package com.itla.university.model.repository;

import com.itla.university.model.entity.Entity;

import java.util.List;

public interface repository<T extends Entity> {

    void create(T entity);

    void update(T entity);

    void delete(T entity);

    T find(int id);

    List<T> findAll();
}
