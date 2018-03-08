package com.example.questions;

public class Array_spiral_printing {
/*
    Given a 2D array, print it in spiral form. See the following examples.

    Input:
            1    2   3   4
            5    6   7   8
            9   10  11  12
            13  14  15  16
    Output:
            1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10


    Input:
            1   2   3   4  5   6
            7   8   9  10  11  12
            13  14  15 16  17  18
    Output:
            1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11

*/

    public static void main(String[] args) {

        int[][] sampleArray = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        printSpiral(sampleArray);
    }


    public static void print(int element) {
        System.out.print("\t" + element);
    }

    public static void printSpiral(int[][] arr) {
        int totalRows = arr.length;
        int totalColumns = arr[0].length;
        int currentRow = 0;
        int currentColumn = 0;
        System.out.println("Rows:" + totalRows);
        System.out.println("Columns:" + totalColumns);

        int i;

        //condition if the currentRow and currentCol are greater/less than total as we print
        while (currentRow < totalRows && currentColumn < totalColumns) {

            //iterate through starting row ( left to right )
            for (i = currentColumn; i < totalColumns; i++) {
                print(arr[currentRow][i]);
            }
            currentRow++;

            //iterate through remaining last column ( top to bottom)
            for (i = currentRow; i < totalRows; i++) {
                print(arr[i][totalColumns - 1]);
            }
            totalColumns--;


            //iterate through last row ( right to left )
            if (currentRow < totalRows) {

                for (i = totalColumns - 1; i >= currentColumn; i--) {
                    print(arr[totalRows - 1][i]);
                }
                totalRows--;

            }

            //iterate through first column ( bottom to top )
            if ((currentColumn < totalColumns)) {

                for (i = totalRows - 1; i >= currentRow; i--) {

                    print(arr[i][currentColumn]);
                }
                currentColumn++;
            }

        }

    }


}
