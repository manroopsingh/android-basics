package com.example.user.android_multithreading;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.sql.Time;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    //parameters needed for creating your own thread pool executor
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = CPU_COUNT + 1;
    private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
    public static final int KEEP_TIME_ALIVE = 0;
    public static final  TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;
    private static final BlockingQueue<Runnable> sPoolWorkQueue =
            new LinkedBlockingQueue<Runnable>(128);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating a custom ThreadPoolExecutor
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAXIMUM_POOL_SIZE,
                KEEP_TIME_ALIVE,
                KEEP_ALIVE_TIME_UNIT,
                sPoolWorkQueue);


//        new AsyncTaskOne().executeOnExecutor(threadPoolExecutor, "Custom First");

        AsyncTaskOne taskOne = new AsyncTaskOne();
        AsyncTaskOne taskTwo = new AsyncTaskOne();
        taskOne.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "First");
        taskTwo.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "First");
        new AsyncTaskOne().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR ,"First");

        new AsyncTaskTwo().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "Second");

        StartAsyncTaskInParallel(new AsyncTaskOne(), "First");
        StartAsyncTaskInParallel(new AsyncTaskOne(), "Second");
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void StartAsyncTaskInParallel(AsyncTaskOne task, String params) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            Log.d("TAG", " GREATER THAN HONEYCOMB");
            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, params);
        }
        else {
            Log.d("TAG", " LESS THAN HONEYCOMB");
            task.execute();
        }
    }

}
