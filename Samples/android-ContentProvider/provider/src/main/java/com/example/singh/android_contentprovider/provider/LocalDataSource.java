package com.example.singh.android_contentprovider.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Author: singh on: 02-Jan-18.
 */

public class LocalDataSource extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "people.db";
    private static final int DATABASE_VERSION = 1;
    private static LocalDataSource instance = null;


    private LocalDataSource(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public static synchronized LocalDataSource getInstance(Context context) {
        if (instance == null) {
            return new LocalDataSource(context);
        } else {
            return instance;
        }
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
