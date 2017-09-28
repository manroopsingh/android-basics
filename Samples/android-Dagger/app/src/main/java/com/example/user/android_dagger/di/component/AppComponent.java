package com.example.user.android_dagger.di.component;

import com.example.user.android_dagger.di.module.UserModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by singh on 27-Sep-17.
 */

@Singleton
@Component
public interface AppComponent {

    UserComponent plus(UserModule userModule);

}
