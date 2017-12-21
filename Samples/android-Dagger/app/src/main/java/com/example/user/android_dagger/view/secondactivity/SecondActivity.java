package com.example.user.android_dagger.view.secondactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.user.android_dagger.MyApplication;
import com.example.user.android_dagger.R;
import com.example.user.android_dagger.User;
import com.example.user.android_dagger.datasource.remote.RemoteDataSource;
import com.example.user.android_dagger.di.module.SecondActivityModule;

import javax.inject.Inject;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivityTag";


    @Inject
    User user;

    @Inject
    RemoteDataSource remoteDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getDaggerUserComponent();

        Log.d(TAG, "onCreate: Testing  user object");
        Log.d(TAG, "onCreate: " + user.getEmail());

        Log.d(TAG, "onCreate: Testing remote data source");
        remoteDataSource.getDataFromServer();




    }

    private void getDaggerUserComponent() {
        MyApplication.get(this)
                .getUserComponent()
                .plus(new SecondActivityModule(this))
                .inject(this);
    }
}
