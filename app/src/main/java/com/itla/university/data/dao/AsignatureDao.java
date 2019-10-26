package com.itla.university.data.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.itla.university.data.AddException;
import com.itla.university.data.DBConnection;
import com.itla.university.data.Database;
import com.itla.university.model.entity.Asignature;

import java.util.ArrayList;
import java.util.List;

public class AsignatureDao implements Dao<Asignature> {

    private static final String TAG = Asignature.class.getSimpleName();

    private static final String TABLE = "materia";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "nombre";
    private static final String KEY_CREDITS = "creditos";

    private DBConnection dbConnection;

    public AsignatureDao(Context context){ dbConnection = Database.getInstance(context); }

    @Override
    public void create(Asignature asignature) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME, asignature.getName());
        cv.put(KEY_CREDITS, asignature.getCredits());

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
                Log.i(TAG, "La materia se ha creado exitosamente: " + id);
        }
    }

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
        List<Asignature> asignatures = new ArrayList<>();

        Cursor cursor = dbConnection.getReadableDatabase()
                .rawQuery("SELECT * FROM " + TABLE, null);

        while(cursor.moveToNext()){
            Asignature asignature = new Asignature();
            asignature.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
            asignature.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            asignature.setCredits(cursor.getInt(cursor.getColumnIndex(KEY_CREDITS)));
            asignatures.add(asignature);
        }

        cursor.close();
        return asignatures;
    }
}
