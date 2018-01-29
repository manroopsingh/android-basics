package com.example.singh.android_contentprovider;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.singh.android_contentprovider.model.People;
import com.example.singh.android_contentprovider.provider.LocalDataSource;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocalDataSource localDataSource = LocalDataSource.getInstance(this);

        //create database if does not exists
        if (!localDataSource.checkDataExists()) {
            localDataSource.createDatabase(LocalDataSource.DEFAULT_PEOPLE);
        }

        for (People p :
                localDataSource.retrieve(LocalDataSource.ALL_PEOPLE)) {

        }

    }
}
