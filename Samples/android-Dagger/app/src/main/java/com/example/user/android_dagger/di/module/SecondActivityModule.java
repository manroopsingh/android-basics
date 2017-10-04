package com.example.user.android_dagger.di.module;

import com.example.user.android_dagger.SecondActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by singh on 28-Sep-17.
 */

@Module
public class SecondActivityModule {


    SecondActivity secondActivity;

    public SecondActivityModule(SecondActivity secondActivity) {
        this.secondActivity = secondActivity;
    }

    @Provides
    SecondActivity providesSecondActivity(){
        return secondActivity;
    }
}
