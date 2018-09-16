package com.example.questions;

public class Count_ways_from_topleft_bottomright {

    public static void main(String[] args) {

        System.out.println(numberOfPaths(3,3));
    }

    static int  numberOfPaths(int m, int n)
    {
        System.out.println("m:"+m+"n:"+n);
        // If either given row number is first or
        // given column number is first
        if (m == 1 || n == 1)
            return 1;

        // If diagonal movements are allowed then
        // the last addition is required.
        int total = numberOfPaths(m-1, n) + numberOfPaths(m, n-1);
        return  total;
        // + numberOfPaths(m-1,n-1);
    }

}
