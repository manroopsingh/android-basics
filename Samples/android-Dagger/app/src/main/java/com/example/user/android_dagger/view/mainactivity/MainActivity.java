package com.example.user.android_dagger.view.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.user.android_dagger.MyApplication;
import com.example.user.android_dagger.R;
import com.example.user.android_dagger.User;
import com.example.user.android_dagger.calculation.Calculation;
import com.example.user.android_dagger.datasource.local.LocalDataSource;
import com.example.user.android_dagger.datasource.remote.RemoteDataSource;
import com.example.user.android_dagger.di.module.MainActivityModule;
import com.example.user.android_dagger.view.secondactivity.SecondActivity;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivityTag";

    TextView textView;

    //    inject dependencies from app component
    @Inject
    RemoteDataSource remoteDataSource;
    @Inject
    LocalDataSource localDataSource;

    //    inject dependency from calculation component
    @Inject
    Calculation calculation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);

        setupDaggerUserComponent();

//        test injected dependencies from app component
        remoteDataSource.getDataFromServer();
        localDataSource.queryData("Select * from Table name");


        setupDaggerCalcComponent();

//        test calculation class
        Log.d(TAG, "onCreate: " + calculation.multiply(3, 5));
        Log.d(TAG, "onCreate: "+ calculation.add(5, 6));


//        test @User scope
        Log.d(TAG, "onCreate: Going to second activity to test scopes");
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    private void setupDaggerCalcComponent() {
        MyApplication.get(this).createCalcComponent().inject(this);
    }

    private void setupDaggerUserComponent() {
        MyApplication.get(this)
                .createUserComponent(new User("Manroop", 23, "singh@manroop.com"))
                .plus(new MainActivityModule(this))
                .inject(this);
    }


}
