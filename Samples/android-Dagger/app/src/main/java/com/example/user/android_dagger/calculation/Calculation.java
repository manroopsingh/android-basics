package com.example.user.android_dagger.calculation;

import javax.inject.Inject;

/**
 * Created by singh on 26-Sep-17.
 */

public class Calculation {




    private Addition addition;
    private Multiplication multiplication;



    @Inject
    public Calculation(Addition addition, Multiplication multiplication) {
        this.addition = addition;
        this.multiplication = multiplication;
    }

    public int add(int a, int b) {
        return addition.add(a, b);
    }


    public int multiply(int a, int b){
        return multiplication.multiply(a, b);
    }




}
