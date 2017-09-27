package com.example.user.android_dagger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.user.android_dagger.calculation.Multiplication;
import com.example.user.android_dagger.dagger.calculation.CalcComponent;
import com.example.user.android_dagger.dagger.calculation.DaggerCalcComponent;

import javax.inject.Inject;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivityTag";
    @Inject
    Multiplication multiplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        CalcComponent component = DaggerCalcComponent.builder().build();
        component.injectMultiplication2(this);
        Log.d(TAG, "onCreate: " + multiplication.getSomeValue());


    }
}
