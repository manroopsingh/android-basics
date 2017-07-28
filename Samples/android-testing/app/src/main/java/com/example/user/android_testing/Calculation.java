package com.example.user.android_testing;

/**
 * Created by singh on 7/17/17.
 */

public class Calculation {



    Multiplication multiplication;
    Double val = 1.2;

    public Calculation(Multiplication multiplication) {
        this.multiplication = multiplication;
    }

    int val1 = 2;
    int val2 = 5;


    int multiply() {
        return val1 * val2;
    }


    int sum() {

        return val1 + val2;
    }

    double multipleDouble() {

        return multiplication.multiplyFloat(3.4, 5.4) + val;
    }


    void changeBack() {

        val1 = 2;
        val2 = 5;
    }

    public int getVal1() {
        return val1;
    }

    public void setVal1(int val1) {
        this.val1 = val1;
    }

    public int getVal2() {
        return val2;
    }

    public void setVal2(int val2) {
        this.val2 = val2;
    }
}
