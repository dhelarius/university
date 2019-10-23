package com.itla.university.data.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.itla.university.data.AddException;
import com.itla.university.data.DBConnection;
import com.itla.university.data.Database;
import com.itla.university.model.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDao implements Dao<Student> {

    private static final String TAG = Student.class.getSimpleName();

    private static final String TABLE = "estudiante";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "nombre";
    private static final String KEY_REGISTRATION = "matricula";
    private static final String KEY_CAREER_ID = "carrera_id";
    private static final String KEY_CAREER_NAME = "nombre_carrera";

    private DBConnection dbConnection;

    public StudentDao(Context context){ this.dbConnection = Database.getInstance(context);}

    @Override
    public void create(Student student) {
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME, student.getName());
        cv.put(KEY_REGISTRATION, student.getRegistration());
        cv.put(KEY_CAREER_ID, student.getCareerId());

        SQLiteDatabase db = dbConnection.getWritableDatabase();

        long id = 0;

        try{
            id = db.insert(TABLE, null, cv);

            throw new AddException(id);
        }catch (AddException ae){
            Log.i(TAG, ae.getMessage());
        }finally {
            if(id > 0)
                Log.i(TAG, "El estudiante se ha creado exitosamente: " + id);
        }
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
        List<Student> students = new ArrayList<>();

        /*Cursor cursor = dbConnection.getReadableDatabase()
                .rawQuery("SELECT * FROM " + TABLE, null);*/

        Cursor cursor = dbConnection.getReadableDatabase()
                .rawQuery("SELECT e.*, c.nombre AS nombre_carrera FROM estudiante e INNER JOIN carrera c\n" +
                        "ON e.carrera_id = c.id", null);

        while (cursor.moveToNext()){
            Student student = new Student();
            student.setId(cursor.getInt(cursor.getColumnIndex(KEY_ID)));
            student.setName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            student.setRegistration(cursor.getString(cursor.getColumnIndex(KEY_REGISTRATION)));
            student.setCareerId(cursor.getInt(cursor.getColumnIndex(KEY_CAREER_ID)));
            student.setCareerName(cursor.getString(cursor.getColumnIndex(KEY_CAREER_NAME)));
            students.add(student);
        }

        cursor.close();

        return students;
    }
}
