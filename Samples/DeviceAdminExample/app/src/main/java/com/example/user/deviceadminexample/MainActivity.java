package com.example.user.deviceadminexample;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    DevicePolicyManager devicePolicyManager;
    ComponentName componentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        componentName = new ComponentName(this, DeviceRecieverSample.class);
        devicePolicyManager = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);


    }


    //this is the button click
    public void lockme(View view) {

        Log.d(TAG, "lockme: ");
        Log.d(TAG, "lockme: " + devicePolicyManager.isAdminActive(componentName));


        if (devicePolicyManager.isAdminActive(componentName)) {
            devicePolicyManager.lockNow();
        }
        else{

            Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
            intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN,componentName);
            intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "Locking the device");
            startActivity(intent);

        }


    }
}
