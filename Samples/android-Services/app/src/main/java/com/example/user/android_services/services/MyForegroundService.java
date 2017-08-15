package com.example.user.android_services.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

import com.example.user.android_services.MainActivity;
import com.example.user.android_services.R;

public class MyForegroundService extends Service {
    private static final String TAG = "MyForeServiceTag";

    public MyForegroundService() {
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        switch (intent.getAction()) {

            case Constants.ACTION_FOREGROUND_START:

                Intent intent1 = new Intent(this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent1, 0);

                Notification notification = new Notification.Builder(this)
                        .setContentTitle("Title")
                        .setContentText("Message")
                        .setSmallIcon(android.R.drawable.ic_notification_overlay)
                        .setContentIntent(pendingIntent)
                        .setTicker("ticker")
                        .build();

                startForeground(101, notification);
                break;

            case Constants.ACTION_FOREGROUND_STOP:

                stopForeground(true);
                break;
        }

        return START_STICKY;
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
