package com.example.user.android_dagger.dagger.calculation;

import com.example.user.android_dagger.SecondActivity;
import com.example.user.android_dagger.calculation.Calculation;
import com.example.user.android_dagger.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by singh on 26-Sep-17.
 */

@Singleton
@Component(modules = CalcModule.class)
public interface CalcComponent {

    //Using the @Inject in the MainActivity for Multiplication class instance
    void injectMultiplication(MainActivity mainActivity);

    //returns the Calculation class instance using the @Inject in its constructor
    //and injecting the Addition class as a dependency in Calculation class
    Calculation getCalculation();

    void injectMultiplication2(SecondActivity secondActivity);
}
