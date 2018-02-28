package com.example.questions;

/**
 * Created by singh on 2/13/18.
 */

public class BubbleSort {

    public static void main(String[] args) {


        int[] integers = new int[]{4, 6, 2, 5, 1};

        sort(integers);
        for (int integer : integers) {
            System.out.println(integer);
        }
    }

    public static void sort(int[] integers) {


        for (int i = 0; i < integers.length - 1; i++) {

            for (int j = 0; j < integers.length - i - 1; j++) {

                if (integers[j] > integers[j + 1]) {
                    int temp = integers[j];
                    integers[j] = integers[j + 1];
                    integers[j + 1] = temp;

                }
            }
        }

    }
}
