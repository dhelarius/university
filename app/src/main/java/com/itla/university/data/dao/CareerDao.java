package com.itla.university.data.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.itla.university.data.AddException;
import com.itla.university.data.DBConnection;
import com.itla.university.model.entity.Career;

import java.util.ArrayList;
import java.util.List;

public class CareerDao implements Dao<Career>{

    private static final String TAG = CareerDao.class.getSimpleName();

    private static final String TABLE = "carrera";
    private static final String KEY_NAME = "nombre";

    private DBConnection dbConnection;

    public CareerDao(Context context){
        this.dbConnection = new DBConnection(context);
    }

    @Override
    public void create(Career career) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME, career.getName());

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

        List<Career> careers = new ArrayList<>();

        /*Cursor cursor = dbConnection.getReadableDatabase()
                .rawQuery("SELECT c.*, count(m.nombre) as materias, sum(m.creditos) as creditos FROM carrera c \n" +
                        "INNER JOIN carrera_materia cm ON c.id = cm.carrera_id\n" +
                        "INNER JOIN materia m ON cm.materia_id = m.id\n" +
                        "GROUP BY c.id", null);*/

        Cursor cursor = dbConnection.getReadableDatabase()
                .rawQuery("SELECT * FROM " + TABLE, null);

        while (cursor.moveToNext()){
            Career career = new Career();
            career.setId(cursor.getInt(cursor.getColumnIndex("id")));
            career.setName(cursor.getString(cursor.getColumnIndex("nombre")));
            //career.setAsignatures(cursor.getInt(cursor.getColumnIndex("materias")));
            //career.setCredits(cursor.getInt(cursor.getColumnIndex("creditos")));
            careers.add(career);
        }

        cursor.close();

        return careers;
    }
}
