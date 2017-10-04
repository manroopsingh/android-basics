package com.example.user.android_dagger.di.module;

import com.example.user.android_dagger.calculation.Addition;
import com.example.user.android_dagger.calculation.Multiplication;

/**
 * Created by singh on 26-Sep-17.
 */

//@Module
public class CalcModule {

    //providing simple dependency, which will be used directly in MainActivity
//    @Provides
//    @Singleton
    Multiplication getMultiplication(){
        return new Multiplication();
    }

    //member injection for calculation class, @Inject is required for
    //the Calculation class constructor
//    @Provides
    Addition getAddtion() {
        return new Addition();

    }




}
