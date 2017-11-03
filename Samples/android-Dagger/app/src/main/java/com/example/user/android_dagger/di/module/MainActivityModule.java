package com.example.user.android_dagger.di.module;

import com.example.user.android_dagger.view.mainactivity.MainActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by singh on 28-Sep-17.
 */

@Module
public class MainActivityModule {

    MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;

    }


    @Provides
    MainActivity providesMainActivity(){
        return mainActivity;
    }
}
