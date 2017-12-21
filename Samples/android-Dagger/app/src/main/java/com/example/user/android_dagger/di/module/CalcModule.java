package com.example.user.android_dagger.di.module;

import com.example.user.android_dagger.calculation.Addition;
import com.example.user.android_dagger.calculation.Calculation;
import com.example.user.android_dagger.calculation.Multiplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Author: singh on: 26-Sep-17.
 */

@Module
public class CalcModule {

    //member injection for calculation class, @Inject is required for
    //the Calculation class constructor
    @Provides
    @Singleton
    Calculation providesCalculation(Addition addition, Multiplication multiplication){
        return new Calculation(addition, multiplication);
    }

    //providing multiplication instance for Calculation constructor injection

//    @Provides
//    @Singleton
//    Multiplication provideMultiplication(){
//        return new Multiplication();
//
//    }
//
//
//    @Provides
//    @Singleton
//    Addition provideAddtion() {
//        return new Addition();
//
//    }




}
