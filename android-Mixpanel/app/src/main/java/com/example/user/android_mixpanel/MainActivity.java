package com.example.user.android_mixpanel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.mixpanel.android.mpmetrics.MixpanelAPI;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    MixpanelAPI mixpanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String projectToken = "256071675a6dcb63c34c94a394c3c566";
        mixpanel = MixpanelAPI.getInstance(this, projectToken);
    }


    public void onShoot(View view) {

        try {
            JSONObject props = new JSONObject();
            props.put("Activity", "Shoot");
            props.put("Status", "Pending");
            mixpanel.track("MainActivity - onShoot called", props);
        } catch (JSONException e) {
            Log.e("MYAPP", "Unable to add properties to JSONObject", e);
        }
    }


    public void onJump(View view) {

        try {
            JSONObject props = new JSONObject();
            props.put("Activity", "Jump");
            props.put("Status", "Done");
            mixpanel.track("MainActivity - onJump called", props);
        } catch (JSONException e) {
            Log.e("MYAPP", "Unable to add properties to JSONObject", e);
        }

    }

    public void onSkydive(View view) {

        try {
            JSONObject props = new JSONObject();
            props.put("Activity", "Skydive");
            props.put("Status", "inProgress");
            mixpanel.track("MainActivity - onSkydive called", props);
        } catch (JSONException e) {
            Log.e("MYAPP", "Unable to add properties to JSONObject", e);
        }
    }

    public void onHike(View view) {

        try {
            JSONObject props = new JSONObject();
            props.put("Activity", "Hike");
            props.put("Status", "Never");
            mixpanel.track("MainActivity - onHike called", props);
        } catch (JSONException e) {
            Log.e("MYAPP", "Unable to add properties to JSONObject", e);
        }
    }


    @Override
    protected void onDestroy() {
        mixpanel.flush();
        super.onDestroy();

    }
}
