package com.example.user.android_dagger.di.module;

import com.example.user.android_dagger.User;
import com.example.user.android_dagger.di.scopes.UserScope;

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
    @UserScope
    User provideUser(){
        return user;
    }
}


