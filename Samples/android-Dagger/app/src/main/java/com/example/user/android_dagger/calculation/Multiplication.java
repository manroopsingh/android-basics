package com.example.user.android_dagger.calculation;

/**
 * Created by singh on 26-Sep-17.
 */

public class Multiplication {

    String someValue;

    public int multiply(int a, int b){
        return a * b;
    }

    public String getSomeValue() {
        return someValue;
    }

    public void setSomeValue(String someValue) {
        this.someValue = someValue;
    }
}
