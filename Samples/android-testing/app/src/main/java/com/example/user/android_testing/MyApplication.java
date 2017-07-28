package com.example.user.android_testing;

import android.app.Activity;
import android.app.Application;
import android.util.Log;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by singh on 7/19/17.
 */

public class MyApplication extends Application{


    private static final String TAG = "MyApplicationTag";

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate: " + getApplicationContext());

        //ButterKnife.bind(MainActivity.this);



    }
}
