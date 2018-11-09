package com.example.questions.sorting_algotithms;

public class Find_max_sum_consecutive_values {

    public static void main(String[] args) {


        int[] values = new int[]{8, 6, 2, 7, 30};

        System.out.println("Max: Nested loops: " + maxConsecutiveSum(values, 3));

        System.out.println("Max: One loop: " + maxConsecutiveSumOptimal(values, 3));


    }


    //    using nested loops
    public static int maxConsecutiveSum(int[] values, int windowSize) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= values.length - windowSize; i++) {

            for (int j = 0; j < windowSize; j++) {
                currentSum += values[i + j];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                currentSum = 0;
            }
        }
        return maxSum;

    }

    public static int maxConsecutiveSumOptimal(int[] values, int windowSize) {

        int currentSum = 0;
        int maxSum = 0;
        int mainCounter = 0;
        int windowCounter = 0;
        int size = values.length;


        while (mainCounter <= size - windowSize) {

            if (windowCounter < windowSize) {
                currentSum += values[mainCounter + windowCounter];
                windowCounter++;
            }

            if (windowCounter == windowSize) {

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    currentSum = 0;
                }

                windowCounter = 0;
                mainCounter++;
            }

        }
        return maxSum;


    }
}