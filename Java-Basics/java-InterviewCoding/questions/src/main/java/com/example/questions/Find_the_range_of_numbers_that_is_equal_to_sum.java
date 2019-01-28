package com.example.questions;

public class Find_the_range_of_numbers_that_is_equal_to_sum {

    public static void main(String[] args) {

        findRange(125);

    }


    private static void findRange(int sum) {

        int currentSum;

        for (int i = 1 ;i <= sum/2; i++) {
            currentSum = i;
            for (int j = i+1; j <= sum; j++) {
                currentSum += j;
                if (currentSum == sum) {
                    currentSum = 0;
                    printRange(i, j);
                    break;
                }
            }
        }

    }

    private static void printRange(int i, int j) {

        for (int k = i; k <= j; k++) {
            System.out.print(k + " ");
        }
        System.out.println();
    }
}
