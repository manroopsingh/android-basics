package com.example.questions;

import java.util.Arrays;

/**
 * Created by singh on 3/6/18.
 */

public class Binary_search {

    public static void main(String[] args) {

        int[] ints = new int[]{3, 5, 2, 6, 8, 9};

        Arrays.sort(ints);
        System.out.println(findInteger(ints, 0,ints.length-1, 3));
        //System.out.println(findInteger(randomInts(20), 6));

    }

    private static int findInteger(int[] integers, int start, int end, int findMe) {



        if (end >= start) {


            int midIndex = start + (end - 1)/ 2;


            if (integers[midIndex] == findMe) {
                return midIndex;
            }

            if (integers[midIndex] > findMe) {
                //pick up the lower half
                end = midIndex - 1;
                findInteger(integers, start, end,findMe);

            } else {
                //pick up the upper half
                start = midIndex + 1;
                findInteger(integers, start, end,findMe);
            }
        }


        return -1;

    }

    private static int[] randomInts(int size) {
        int[] a = new int[size];

        for (int i = 0; i < size; i++) {
            a[i] = (int) (Math.random() * 10);//note, this generates numbers from [0,9]

            for (int j = 0; j < i; j++) {
                if (a[i] == a[j]) {
                    i--; //if a[i] is a duplicate of a[j], then run the outer loop on i again
                    break;
                }
            }
        }
        Arrays.sort(a);
        return a;
    }

    private static int findIntegerWhile(int[] integers, int findMe) {

        int startIndex = 0;
        int endIndex = integers.length;

        int midIndex = integers.length / 2;


        return -1;

    }
}
