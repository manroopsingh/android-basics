package com.example.singh.android_threadpoolmanager;

import android.widget.ProgressBar;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Author: singh on: 27-Jan-18.
 */

public class ProgressThreadManager {


    public static ProgressThreadManager instance;

    static {
        instance = new ProgressThreadManager();
    }

    //    Creating a blocking queue for the tasks
    private  final BlockingDeque<Runnable> blockingDeque ;

    //    Creating a thread pool
    private ThreadPoolExecutor threadPoolExecutor;

//    make the constructor private for making the class singleton
    private ProgressThreadManager() {

        blockingDeque = new LinkedBlockingDeque<>();

//        initialize parameter for creating a thread pool
        final int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
        final int KEEP_ALIVE_TIME = 1;
        final TimeUnit KEEP_LIVE_TIME_UNIT = TimeUnit.SECONDS;

        threadPoolExecutor = new ThreadPoolExecutor(
                NUMBER_OF_CORES,
                NUMBER_OF_CORES,
                KEEP_ALIVE_TIME,
                KEEP_LIVE_TIME_UNIT,
                blockingDeque);
    }

    public void startDownload(ProgressBar progressBar, int downloadSize) {

//        clear previous progress
        progressBar.setProgress(0);
        threadPoolExecutor.execute(new ProgressTask(progressBar, downloadSize));

    }
}
