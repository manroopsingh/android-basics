package com.example.user.android_dagger.di.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by singh on 27-Sep-17.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface UserScope {
}
