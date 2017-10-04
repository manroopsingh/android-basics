package com.example.user.android_dagger.di.module;

import com.example.user.android_dagger.User;

import dagger.Module;
import dagger.Provides;

/**
 * Created by singh on 27-Sep-17.
 */

@Module
public class UserModule {

    User user;

    public UserModule(User user) {
        this.user = user;
    }

    @Provides
    User provideUser(){
        return user;
    }
}


