package com.example.user.android_broadcastreceiver.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.user.android_broadcastreceiver.utils.Constants;

public class MyStaticReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        //get the action to handle multiple intents
        String action = intent.getAction();


        switch (action) {

            case Constants.CUSTOM_ACTION_ONE:

                Toast.makeText(context, "Static: Custom Action one", Toast.LENGTH_SHORT).show();

                break;

            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                boolean isAirpaneModeAcive = intent.getBooleanExtra("state", false);

                if (isAirpaneModeAcive)
                    Toast.makeText(context, "Static: Airplane mode on", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(context, "Static: Airplane mode off", Toast.LENGTH_SHORT).show();
                break;

        }


    }
}
