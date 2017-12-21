package com.example.user.android_dagger.di.component;

import com.example.user.android_dagger.di.module.AppModule;
import com.example.user.android_dagger.di.module.CalcModule;
import com.example.user.android_dagger.di.module.UserModule;
import com.example.user.android_dagger.di.scopes.AppScope;

import dagger.Component;

/**
 * Created by singh on 27-Sep-17.
 */

@AppScope
@Component(modules = AppModule.class)
public interface AppComponent {

    UserComponent plus(UserModule userModule);
    CalcComponent plus(CalcModule calcModule);
}
