package com.example.questions.custom_arraylist;

import java.util.Arrays;

/**
 * Created by singh on 2/27/18.
 */

public class CustomArrayList<T> {


    private static final int DEFAULT_SIZE = 4;
    private T element;
    private int size = 0;
    private Object[] elements;


    public void add(T t) {
        //type safety
        this.element = t;
        initializeArray();
        elements[size] = t;
        size++;
    }

    public int remove(int index) {

        if (index > size - 1 || index < 0) {
            return -1;
        }

        int direction = (index < size / 2) ? 0 : 1;


        return 0;


    }

    public boolean remove(T t) {
        //type safety
        this.element = t;


        return true;
    }

    private void initializeArray() {
        //creating the size to be default
        if (elements == null) {
            elements = new Object[DEFAULT_SIZE];
        }

        if (size == elements.length) {
            int newSize = elements.length * 2;
            elements = Arrays.copyOf(elements, newSize);
        }
    }

    public int size() {
        return size;
    }

    public int baseArraySize() {
        return elements.length;
    }
}
