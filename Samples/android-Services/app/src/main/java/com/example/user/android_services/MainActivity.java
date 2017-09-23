package com.example.user.android_services;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.user.android_services.services.MyBoundService;
import com.example.user.android_services.services.MyForegroundService;
import com.example.user.android_services.services.MyIntentService;
import com.example.user.android_services.services.MyJobService;
import com.example.user.android_services.services.MyService;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTad";
    MyBoundService myBoundService;
    boolean isBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void startServices(View view) {

        Intent normalIntent = new Intent(this, MyService.class);
        Intent intIntent = new Intent(this, MyIntentService.class);
        Intent boundIntent = new Intent(this, MyBoundService.class);
        Intent foregroundIntent = new Intent(this, MyForegroundService.class);

        switch (view.getId()) {

            case R.id.btnScheduleService:

                scheduleJob();

                break;

            case R.id.btnNormalService:

                normalIntent.putExtra("data", "This is a normal service");
                startService(normalIntent);

                break;
            case R.id.btnStopNormalService:

                stopService(normalIntent);
                break;

            case R.id.btnStartForegroundService:

                startService(foregroundIntent);
                break;

            case R.id.btnStopForegroundService:





                break;

            case R.id.btnIntentService:

                intIntent.putExtra("data", "This is an intent service");
                startService(intIntent);

                break;

            case R.id.btnBoundService:

                boundIntent.putExtra("data", "This is a bound service");
                bindService(boundIntent, serviceConnection, Context.BIND_AUTO_CREATE);
                break;

            case R.id.btnUnboundService:

                if (isBound) {
                    unbindService(serviceConnection);
                    isBound = false;
                }
                break;
        }
        Toast.makeText(this, "Check your logs", Toast.LENGTH_SHORT).show();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void scheduleJob() {
        ComponentName serviceComponent = new ComponentName(this, MyJobService.class);
        JobInfo.Builder jobInfo = new JobInfo.Builder(0, serviceComponent);
        jobInfo.setMinimumLatency(1000);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            JobScheduler jobScheduler = getSystemService(JobScheduler.class);
            jobScheduler.schedule(jobInfo.build());
        }
    }

    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            MyBoundService.MyBinder myBinder = (MyBoundService.MyBinder) iBinder;
            myBoundService = myBinder.getService();
            Log.d(TAG, "onServiceConnected: " + myBoundService.getStringData());
            isBound = true;

        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

            isBound = false;
            Log.d(TAG, "onServiceDisconnected: ");

        }
    };


}
