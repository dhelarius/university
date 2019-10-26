package com.itla.university.data.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.itla.university.data.AddException;
import com.itla.university.data.DBConnection;
import com.itla.university.data.Database;
import com.itla.university.model.entity.CareerAsignature;

public class CareerAsignatureDao {

    private static final String TAG = CareerAsignatureDao.class.getSimpleName();

    private static final String TABLE = "carrera_materia";
    private static final String KEY_CAREER_ID = "carrera_id";
    private static final String KEY_ASIGNATURE_ID = "materia_id";

    private DBConnection dbConnection;

    public CareerAsignatureDao(Context context){ dbConnection = Database.getInstance(context); }

    public void create(CareerAsignature careerAsignature) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_CAREER_ID, careerAsignature.getCareer_id());
        cv.put(KEY_ASIGNATURE_ID, careerAsignature.getAsignature_id());

        SQLiteDatabase db = dbConnection.getWritableDatabase();

        long id = 0;

        try{
            id = db.insert(TABLE, null, cv);

            if(id <= 0)
                throw new AddException(id);
        }catch (AddException ae){
            Log.i(TAG, ae.getMessage());
        }finally {
            if(id > 0)
                Log.i(TAG, "La carrera se ha creado exitosamente: " + id);
        }
    }

}
