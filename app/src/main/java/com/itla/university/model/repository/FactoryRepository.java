package com.itla.university.model.repository;

import android.content.Context;

import com.itla.university.model.repository.type.RepositoryType;

public class FactoryRepository {

    public static Repository getRepository(Context context, RepositoryType type){

        switch (type){
            case CAREER: return new RepositoryCareerDbImpl(context);
            case ASIGNATURE: return new RepositoryAsignatureDbImpl();
            case STUDENT: return new RepositoryStudentDbImpl();
            default: return null;
        }
    }
}
