package com.example.user.android_dagger.di.module;

import android.app.Application;

import com.example.user.android_dagger.calculation.Addition;
import com.example.user.android_dagger.calculation.Multiplication;
import com.example.user.android_dagger.datasource.local.LocalDataSource;
import com.example.user.android_dagger.datasource.remote.RemoteDataSource;
import com.example.user.android_dagger.di.scopes.AppScope;

import dagger.Module;
import dagger.Provides;

/**
 * Author: singh on: 28-Sep-17.
 */
@Module
public class AppModule {

    private Application application;
    String BASE_URL;

    public AppModule(Application application, String BASE_URL) {
        this.application = application;
        this.BASE_URL = BASE_URL;
    }

    @AppScope
    @Provides
    Application providesApplication()
    {
        return application;
    }

    @AppScope
    @Provides
    RemoteDataSource providesRemoteDataSource() {
        return new RemoteDataSource(BASE_URL);
    }

    @AppScope
    @Provides
    LocalDataSource providesLocalDataSource() {
        return new LocalDataSource();
    }

    @Provides
    Addition provideAddtion() {
        return new Addition();

    }

    @Provides
    Multiplication provideMultiplication(){
        return new Multiplication();

    }
}
