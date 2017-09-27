package com.example.user.android_dagger.calculation;

import javax.inject.Inject;

/**
 * Created by singh on 26-Sep-17.
 */

public class Calculation {




    Addition addition;


    @Inject
    public Calculation(Addition addition) {
        this.addition = addition;
    }

    public int add(int a, int b) {
        return addition.add(a, b);
    }
}
