package com.example.user.android_dagger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.user.android_dagger.calculation.Multiplication;
import com.example.user.android_dagger.dagger.calculation.CalcComponent;
import com.example.user.android_dagger.dagger.calculation.DaggerCalcComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag";

    @Inject
    Multiplication multiplication;


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textview);


        //build the component interface with the object graph and use the methods
        CalcComponent calcComponent = DaggerCalcComponent.builder().build();


        //For using the multiplication class, pass this class reference to
        //map the dependency
        calcComponent.injectMultiplication(this);

        //using the Multiplication class
        Log.d(TAG, "onCreate: "+ multiplication.multiply(4,4));

        //Using the Calculation class with Addtion as dependency
        Log.d(TAG, "onCreate: " + calcComponent.getCalculation().add(2, 3));


        multiplication.setSomeValue("someValue");
        Log.d(TAG, "onCreate: Going to second activity to test scopes" );

        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
