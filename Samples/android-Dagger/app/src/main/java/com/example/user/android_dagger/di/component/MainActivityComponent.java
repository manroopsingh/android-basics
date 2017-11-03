package com.example.user.android_dagger.di.component;

import com.example.user.android_dagger.view.mainactivity.MainActivity;
import com.example.user.android_dagger.di.module.MainActivityModule;

import dagger.Subcomponent;

/**
 * Created by singh on 28-Sep-17.
 */

@Subcomponent(modules = MainActivityModule.class)
public interface MainActivityComponent {

    MainActivity inject(MainActivity mainActivity);

}
