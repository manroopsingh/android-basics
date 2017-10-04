package com.example.user.android_dagger.di.component;

import com.example.user.android_dagger.SecondActivity;
import com.example.user.android_dagger.di.module.SecondActivityModule;

import dagger.Subcomponent;

/**
 * Created by singh on 28-Sep-17.
 */

@Subcomponent(modules = SecondActivityModule.class)
public interface SecondActivityComponent {

    SecondActivity inject(SecondActivity secondActivity);
}
