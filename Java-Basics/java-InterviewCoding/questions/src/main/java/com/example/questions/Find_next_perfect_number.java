package com.example.questions;

public class Find_next_perfect_number {

    public static void main(String[] args) {

        System.out.println(findPerfectNumber(7));

    }

    private static boolean isPerfectNumber(int number) {
        int temp = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) temp += i;

        }
        return temp == number;
    }

    private static int findPerfectNumber(int seedNumber) {
        int currentNumber = seedNumber;
        int perfectNumber = 0;
        boolean keepFinding = true;


        while (keepFinding) {

            if (isPerfectNumber(currentNumber)) {
                perfectNumber = currentNumber;
                keepFinding = false;
            } else
                currentNumber++;
        }

        return perfectNumber;
    }

}
