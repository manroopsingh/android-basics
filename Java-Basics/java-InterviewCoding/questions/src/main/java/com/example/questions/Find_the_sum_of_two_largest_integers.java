package com.example.questions;

public class Find_the_sum_of_two_largest_integers {

    public static void main(String[] args) {


        int[] arr = new int[]{3, 5, 1, 5, 7, 2, 3, 6};
        System.out.println(findSum(arr));

    }

    private static int findSum(int[] arr) {

        int max = 0, secondMax = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > max) {

                secondMax = max;
                max = arr[i];

            } else if (arr[i] > secondMax && arr[i] != max)
                secondMax = arr[i];


        }

        return max + secondMax;
    }
}
