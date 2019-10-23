package com.itla.university.data;

import android.content.Context;

public class Database {

    private Context context;

    private static DBConnection INSTANCE;

    public static DBConnection getInstance(Context context){
        DBConnection instance = INSTANCE;

        if(instance == null){
            instance = new DBConnection(context);
            INSTANCE = instance;
        }

        return INSTANCE;
    }
}
