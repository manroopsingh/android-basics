package com.example.user.android_dagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.user.android_dagger.di.module.SecondActivityModule;

import javax.inject.Inject;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivityTag";
//    @Inject
//    Multiplication multiplication;


    @Inject
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        MyApplication.get(this)
                .getUserComponent()
                .plus(new SecondActivityModule(this))
                .inject(this);


        Log.d(TAG, "onCreate: " + user.getEmail());

//        CalcComponent component = DaggerCalcComponent.builder().build();
//        component.injectMultiplication2(this);
//        Log.d(TAG, "onCreate: " + multiplication.getSomeValue());


    }
}
