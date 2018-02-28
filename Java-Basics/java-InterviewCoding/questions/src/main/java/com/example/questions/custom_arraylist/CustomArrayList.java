package com.example.questions.custom_arraylist;

import java.util.Arrays;

/**
 * Created by singh on 2/27/18.
 */

public class CustomArrayList<T> {


    int counter=0;
    Object[] elements;

    public void add(T t) {

        if (elements == null) {
            elements = new Object[2];//creating the size to be default
        }

        if (counter == elements.length) {
            int newSize = elements.length * 2;
            elements = Arrays.copyOf(elements, newSize);
        }

        elements[counter] = t;
        counter++;


    }

    public int size() {
        return counter;
    }

    public int baseArraySize() {
        return elements.length;
    }
}
