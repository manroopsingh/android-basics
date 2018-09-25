package com.example.questions.generic_comparator;

import java.util.Comparator;

public class GenericComparator<T extends Comparable<T>> implements Comparator<T> {

    @Override
    public int compare(T t, T t1) {
        return t.compareTo(t1);
    }

}
