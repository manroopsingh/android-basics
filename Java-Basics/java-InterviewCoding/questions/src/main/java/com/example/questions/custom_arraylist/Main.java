package com.example.questions.custom_arraylist;

/**
 * Created by singh on 2/27/18.
 */

public class Main {

    public static void main(String[] args) {

        CustomArrayList<Integer> customArrayList = new CustomArrayList<>();
        customArrayList.add(4);
        customArrayList.add(3);
        customArrayList.add(5);
        customArrayList.add(1);

        //print array size
        System.out.println(customArrayList.size());

        //debug underlying array size
        System.out.println(customArrayList.baseArraySize());

    }
}
