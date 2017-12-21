package com.example.user.android_dagger.datasource.remote;

import android.util.Log;

/**
 * Author: singh on: 20-Dec-17.
 */

public class RemoteDataSource {

    private static final String TAG = "RemoteDataSourceTag";
    String Base_URL;

    public RemoteDataSource(String base_URL) {
        Base_URL = base_URL;
    }


    public void getDataFromServer() {
        Log.d(TAG, "getDataFromServer: " + "retrieving data");
        Log.d(TAG, "getDataFromServer: " + "data received");
    }
}
