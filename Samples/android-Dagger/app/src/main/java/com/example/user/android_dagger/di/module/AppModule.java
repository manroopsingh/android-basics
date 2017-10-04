package com.example.user.android_dagger.di.module;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * Created by singh on 28-Sep-17.
 */
@Module
public class AppModule {

    Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    Application provicesApplication(){
        return application;
    }
}
