package com.example.questions;

public class Print_repetitive_chars {

    public static void main(String[] args) {

        char[] baseArr = new char[]{'a', 'b', 'c' ,'d'};
        print(8, baseArr);
    }

    public static void print(int n, char[] baseArr) {

//        index for the base array
        int index = 0;

//        outer loop for each row
        for (int i = n - 1; i >= 0; i--) {

//            inner loop for number of chars in each row
            for (int j = 0; j <= i; j++) {

//                reset index on base array end
                if (j % baseArr.length == 0) {
                    index = 0;
                }
//                print each char
                System.out.print(baseArr[index]);
                index++;
            }
//            go to next row
            System.out.print("\n");


        }
    }
}
