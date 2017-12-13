package com.example.user.android_dagger.di.module;

import android.app.Application;

import dagger.Module;
import dagger.Provides;

/**
 * Author: singh on: 28-Sep-17.
 */
@Module
public class AppModule {

    private Application application;

    public AppModule(Application application)
    {
        this.application = application;
    }

    @Provides
    Application providesApplication()
    {
        return application;
    }
}
