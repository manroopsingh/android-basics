package com.example.questions;

public class Find_count_of_pattern_In_an_array {

    public static void main(String[] args) {


        int[] arr = new int[]{1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1};
        int[] pattern = new int[]{1, 0, 1};

        int[] arr2 = new int[]{1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1,0, 1};
        int[] pattern2 = new int[]{1, 1, 0};

//        System.out.println(findPattern(arr, pattern));

        System.out.println(findPattern(arr2, pattern2));

    }


    private static int findPattern(int[] arr, int[] pattern) {

        int count = 0;

        int j = pattern.length;
        int patternIndex = 0;

        int k = 0;

        while (k < arr.length) {

            if (arr[k] == pattern[patternIndex]) {

                if (patternIndex == j - 1) {
                    count++;
                    patternIndex = 0;

                } else {

                    patternIndex++;
                    k++;
                }

            } else {

                if (patternIndex == 0) {

                    k++;
                }

//                if (patternIndex > 1) {
//                    if (k > 0) {
//
//                        k = k - patternIndex;
//                    }
//                }


                patternIndex = 0;
            }
        }
        return count;


    }

}
