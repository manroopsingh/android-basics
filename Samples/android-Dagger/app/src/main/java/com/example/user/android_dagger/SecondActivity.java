package com.example.user.android_dagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivityTag";
//    @Inject
//    Multiplication multiplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


//        CalcComponent component = DaggerCalcComponent.builder().build();
//        component.injectMultiplication2(this);
//        Log.d(TAG, "onCreate: " + multiplication.getSomeValue());


    }
}
