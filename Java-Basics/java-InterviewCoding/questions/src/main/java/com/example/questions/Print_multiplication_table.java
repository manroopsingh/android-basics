package com.example.questions;

/**
 * Created by singh on 3/1/18.
 */

public class Print_multiplication_table {

    public static void main(String[] args) {

        printMatrix();
    }

    public static void printMatrix() {

        int rows = 12, cols = 12;
        int value;

        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= cols; j++) {
                value = i * j;
                printValue(value, j);
            }
        }

    }

    public static void printValue(int value, int col) {

        System.out.printf("%4d",value );

        if(col==12) System.out.println("\n");

    }

}
