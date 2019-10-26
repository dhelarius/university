package com.itla.university.model.repository;

import android.content.Context;
import com.itla.university.data.dao.CareerAsignatureDao;
import com.itla.university.model.entity.CareerAsignature;

public class RepositoryCareerAsignatureDb {

    private CareerAsignatureDao careerAsignatureDao;

    public RepositoryCareerAsignatureDb(Context context){careerAsignatureDao = new CareerAsignatureDao(context); }

    public void create(CareerAsignature careerAsignature){ careerAsignatureDao.create(careerAsignature);}
}
