package com.example.questions;

/**
 * Created by singh on 2/28/18.
 */

public class Matrix_multiplication_with_transpose {


    public static void main(String[] args) {


        System.out.println(transposeMatrixMultiply(1, 3,3));

    }

    public static int[][] transposeMatrixMultiply(int initialValue, int rows, int cols) {
        int[][] mainMatrix = initMatrix(initialValue, rows, cols);
        int[][] transposeMatrix = getTransposeMatrix(mainMatrix);

        return multiply(mainMatrix, transposeMatrix);

    }

    public static int[][] multiply(int[][] A, int[][] B) {
        int aRows = A.length;
        int aColumns = A[0].length;
        int bRows = B.length;
        int bColumns = B[0].length;

        //check if multiplication is possible
        if (aColumns != bRows) {
            throw new IllegalArgumentException("A:Rows: " + aColumns + " did not match B:Columns " + bRows + ".");
        }

        //initialize result matrix with 0 value
        int[][] C = new int[aRows][bColumns];
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bColumns; j++) {
                C[i][j] = 0;
            }
        }
        for (int i = 0; i < aRows; i++) { // aRow
            for (int j = 0; j < bColumns; j++) { // bColumn
                for (int k = 0; k < aColumns; k++) { // aColumn
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

    public static int[][] initMatrix(int initialValue, int rows, int cols) {

        int[][] matrix = new int[rows][cols];

        int value = initialValue;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = value;
                value++;
            }
        }
        return matrix;
    }


    public static int[][] getTransposeMatrix(int [][] m){
        int[][] temp = new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                temp[j][i] = m[i][j];
        return temp;
    }


}
