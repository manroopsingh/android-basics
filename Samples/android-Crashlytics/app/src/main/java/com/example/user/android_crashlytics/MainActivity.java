package com.example.user.android_crashlytics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Initialize the crashlytics lib from fabric
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
    }


    //This button click is forcing the app to crash.
    //Check your email or crashlytics console for more details about the crash.
    public void forceCrash(View view) {
        throw new RuntimeException("This is a crash");
    }


}
