package com.example.user.android_broadcastreceiver.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.user.android_broadcastreceiver.utils.Constants;

/**
 * Created by singh on 8/15/17.
 */

public class MyDynamicReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        //get the action to handle multiple intents
        String action = intent.getAction();


        switch (action) {

            case Constants.CUSTOM_ACTION_SECOND:

                Toast.makeText(context, "Dynamic: Custom Action two", Toast.LENGTH_SHORT).show();

                break;

            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                boolean isAirpaneModeAcive = intent.getBooleanExtra("state", false);

                if (isAirpaneModeAcive)
                    Toast.makeText(context, "Dynamic: Airplane mode on", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(context, "Dynamic: Airplane mode off", Toast.LENGTH_SHORT).show();
                break;

            case Constants.CUSTOM_ACTION_WITH_PERMISSION:

                Toast.makeText(context, "Dynamic: With custom permission", Toast.LENGTH_SHORT).show();
                break;

        }


    }
}
