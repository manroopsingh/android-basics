package com.example.myapplication;


import android.support.annotation.NonNull;

import java.util.Comparator;


public class MyComparable<T extends Comparator<T>> implements Comparator<MyComparable<T>> {

    T objectType;


    @Override
    public int compare(MyComparable<T> o1, MyComparable<T> o2) {
        return 0;
    }

    @Override
    public Comparator<MyComparable<T>> reversed() {
        return null;
    }
}
