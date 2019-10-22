package com.itla.university.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBConnection extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DB_NAME = "univesity.db";

    public DBConnection(@Nullable Context context) { super(context, DB_NAME, null, VERSION); }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(getStringCreateTableCareer());
        db.execSQL(getStringCreateTableAsignature());
        db.execSQL(getStringCreateTableStudent());
        db.execSQL(getStringCreateTableCareerAsignature());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private String getStringCreateTableCareer(){
        return "CREATE TABLE \"carrera\" (\"id\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"nombre\"\tTEXT NOT NULL\n" +
                ");";
    }

    private String getStringCreateTableAsignature(){
        return "CREATE TABLE \"materia\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"nombre\"\tTEXT NOT NULL,\n" +
                "\t\"creditos\"\tINTEGER NOT NULL\n" +
                ");";
    }

    private String getStringCreateTableStudent(){
        return "CREATE TABLE \"estudiante\" (\n" +
                "\t\"id\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                "\t\"nombre\"\tTEXT NOT NULL,\n" +
                "\t\"matricula\"\tTEXT NOT NULL,\n" +
                "\t\"carrera_id\"\tINTEGER NOT NULL\n" +
                ");";
    }

    private String getStringCreateTableCareerAsignature(){
        return "CREATE TABLE \"carrera_materia\" (\n" +
                "\t\"carrera_id\"\tINTEGER NOT NULL,\n" +
                "\t\"materia_id\"\tINTEGER NOT NULL\n" +
                ");";
    }
}
