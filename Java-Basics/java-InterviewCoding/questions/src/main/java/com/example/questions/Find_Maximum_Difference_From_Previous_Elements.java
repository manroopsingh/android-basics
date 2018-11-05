package com.example.questions;

public class Find_Maximum_Difference_From_Previous_Elements {


    public static void main(String[] args) {

        int[] a = new int[]{2, 3, 10, 3, 4, 8, 1};
        System.out.println(maxDifference(a));

    }


    private static int maxDifference(int[] a) {

        int size = a.length;
        int j = 1;
        int i = 0;
        int maxDifference = 0;
        int currentDifference = 0;

        while (j < size - 1) {


            if (a[j] > a[i])
                currentDifference = a[j] - a[i];


            if (currentDifference > maxDifference)
                maxDifference = currentDifference;

                i--;

            if (i < 0) {

                j++;
                i = j - 1;
            }


        }

        return maxDifference;


    }
}
