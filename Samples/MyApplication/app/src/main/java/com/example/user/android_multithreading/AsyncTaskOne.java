package com.example.user.android_multithreading;

import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by singh on 9/7/17.
 */

public class AsyncTaskOne extends AsyncTask<String, Integer, String> {


    private static final String TAG = "AsyncTaskOneTag";

    @Override
    protected String doInBackground(String... strings) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "doInBackground: " + strings[0]);
        return null;
    }
}
