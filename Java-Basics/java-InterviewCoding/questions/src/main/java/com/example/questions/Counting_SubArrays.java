package com.example.questions;

import java.util.Arrays;


public class Counting_SubArrays {


    public static void main(String[] args) {

        int[] integerSample1 = new int[]{3, 4, 5, 6};
        int sample1_MAX = 16;
        int[] integerSample2 = new int[]{5, 6, 37, 42, 89};
        int sample2_MAX = 1000;
        int[] integerSample3 = new int[]{11, 4, 13, 20, 32, 44, 59, 61, 71, 75, 86, 83};
        int sample3_MAX = 56060;

        printResults(integerSample1, sample1_MAX);
        printResults(integerSample2, sample2_MAX);
        printResults(integerSample3, sample3_MAX);

    }

    static void printResults(int[] sample, int size) {
        System.out.println("Sample array: " + sample.toString());
        System.out.println("SubArray products less than " + size + " : " + calculateProducts(sample, size));
        System.out.println("\n");

    }

    static long calculateProducts(int[] integers, int size) {


//        constraint on the total size
        if (size > Math.pow(10, 6)) return -1;

//        constraint on each array element
        for (int l = 0; l < integers.length; l++) {
            if (integers[l] > 100) {
                return -1;
            }
        }

        int arraySize = 1;
        int i = 0;
        int countSub = 0;
        int k = integers.length;
        long product;

        while (arraySize <= k) {

            product = calculateProduct(Arrays.copyOfRange(integers, i, i + arraySize));

            if (product < size) {
                countSub++;
            }

            i++;

            if ((i + arraySize) == k + 1) {
                arraySize++;
                i = 0;
            }
        }

        return countSub;

    }

    static long calculateProduct(int[] integers) {
        long product = 1;

        for (int i = 0; i < integers.length; i++) {
            product = product * integers[i];
        }
        return product;
    }


}
