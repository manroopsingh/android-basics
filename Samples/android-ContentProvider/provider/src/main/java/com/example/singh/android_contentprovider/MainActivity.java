package com.example.singh.android_contentprovider;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.singh.android_contentprovider.provider.LocalDataSource;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LocalDataSource localDataSource = LocalDataSource.getInstance(this);
        localDataSource.createDatabase(LocalDataSource.DEFAULT_PEOPLE);

    }
}
