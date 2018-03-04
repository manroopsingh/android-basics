package com.example.questions.custom_arraylist;

import java.util.Arrays;

/**
 * Created by singh on 2/27/18.
 */

public class CustomArrayList<T> {


    T element;
    int counter=0;
    Object[] elements;

    public void add(T t) {

        //type safety
        element = t;
        
        //creating the size to be default
        if (elements == null) {
            elements = new Object[2];
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
