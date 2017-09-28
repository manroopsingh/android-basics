package com.example.user.android_dagger;

import android.app.Application;

import com.example.user.android_dagger.di.component.AppComponent;
import com.example.user.android_dagger.di.component.DaggerAppComponent;
import com.example.user.android_dagger.di.component.UserComponent;
import com.example.user.android_dagger.di.module.UserModule;

/**
 * Created by singh on 27-Sep-17.
 */

public class MyApplication extends Application {

    private AppComponent appComponent;
    private UserComponent userComponent;

    @Override
    public void onCreate() {
        super.onCreate();


        appComponent = DaggerAppComponent.builder()
                .build();

    }

    public UserComponent createUserComponent(User user) {
        userComponent = appComponent.plus(new UserModule(user));
        return userComponent;
    }


    public AppComponent getAppComponent() {
        return appComponent;
    }

    public UserComponent getUserComponent() {
        return userComponent;
    }
}
