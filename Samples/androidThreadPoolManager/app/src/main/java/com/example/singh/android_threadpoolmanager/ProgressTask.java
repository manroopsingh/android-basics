package com.example.singh.android_threadpoolmanager;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.widget.ProgressBar;

/**
 * Author: singh on: 27-Jan-18.
 */

public class ProgressTask implements Runnable {

    private int progressRate;
    private ProgressBar progressBar;
    private double downloadTime;
    private Handler handler = new Handler(Looper.myLooper());


    public ProgressTask(ProgressBar progressBar, double downloadTime) {
        this.progressBar = progressBar;
        this.downloadTime = downloadTime;
    }

    @Override
    public void run() {

        for (int i = 0; i < downloadTime; i++) {

//            calculate progress as per time
            double rate = (i + 1) / downloadTime;
            progressRate = (int) (rate * 100);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


//            use handler to post the results back in the UI thread
            handler.post(new Runnable() {
                @TargetApi(Build.VERSION_CODES.N)
                @Override
                public void run() {
                    progressBar.setProgress(progressRate, true);

                }
            });

        }

    }

}
