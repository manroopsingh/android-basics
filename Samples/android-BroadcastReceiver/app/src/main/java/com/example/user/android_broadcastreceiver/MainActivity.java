package com.example.user.android_broadcastreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.user.android_broadcastreceiver.receivers.MyDynamicReceiver;
import com.example.user.android_broadcastreceiver.utils.Constants;

public class MainActivity extends AppCompatActivity {


    MyDynamicReceiver dynamicReceiver = new MyDynamicReceiver();
    IntentFilter intentFilter = new IntentFilter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onStart() {
        super.onStart();
        intentFilter.addAction(Constants.CUSTOM_ACTION_SECOND);
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intentFilter.addAction(Constants.CUSTOM_ACTION_WITH_PERMISSION);
        registerReceiver(dynamicReceiver, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(dynamicReceiver);
    }

    public void sendingBroadcasts(View view) {

        switch (view.getId()) {

            case R.id.btnStaticSendActionOne:
                Intent staticActionOneIntent = new Intent(Constants.CUSTOM_ACTION_ONE);
                sendBroadcast(staticActionOneIntent);
                break;

            case R.id.btnDynamicSendActionTwo:
                Intent dynamicActionTwoIntent = new Intent(Constants.CUSTOM_ACTION_SECOND);
                sendBroadcast(dynamicActionTwoIntent);
                break;

            case R.id.btnDynamicSendActionPermission:
                Intent dynamicActionPermissionIntent = new Intent(Constants.CUSTOM_ACTION_WITH_PERMISSION);
                sendBroadcast(dynamicActionPermissionIntent, Constants.CUSTOM_PERMISSION);
                break;

        }


    }
}
