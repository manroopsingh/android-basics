package com.example.user.android_dagger.di.component;

import com.example.user.android_dagger.SecondActivity;
import com.example.user.android_dagger.di.module.UserModule;
import com.example.user.android_dagger.di.scopes.UserScope;

import dagger.Subcomponent;

/**
 * Created by singh on 27-Sep-17.
 */

@UserScope
@Subcomponent(modules = UserModule.class)
public interface UserComponent {

   // void inject(MainActivity mainActivity);
    void inject(SecondActivity secondActivity);


}
