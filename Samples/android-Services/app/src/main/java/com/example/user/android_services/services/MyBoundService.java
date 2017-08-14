package com.example.user.android_services.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

public class MyBoundService extends Service {


    private static final String TAG = "MyBoundService";
    IBinder iBinder = new MyBinder();

    public MyBoundService() {
    }

    public class MyBinder extends Binder {

        MyBoundService getService() {
            return MyBoundService.this;
        }

    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: ");
        return iBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {

        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    public String getStringData() {

        Random randomGenerator = new Random();
        String random = String.valueOf(randomGenerator.nextInt(100));
        return "Data from the bound service: " + random;
    }
}
