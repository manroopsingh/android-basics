package com.example.questions;

/**
 * Created by singh on 3/5/18.
 */

public class Reverse_string_of_numbers_exclude_zeros {

    /*
    Create a method that reverses a string of numbers
    “9876504321” and prepends any zeros -> output :”0123456789”
    */
    public static void main(String[] args) {
        String inputString = "9876504321";

        reverse_without_zeros(inputString);

    }

    private static void reverse_without_zeros(String inputStr) {

        int zeroCount = 0;
        String reverse = "";
        String zeroString = "0";

        for (int i = 0; i < inputStr.length()-1; i++) {
            if (inputStr.charAt(i) == '0') {
                zeroCount++;
            }else reverse += inputStr.charAt(i);


        }

        for (int i = 0; i < zeroCount; i++) {
            zeroString += zeroString;
        }

        System.out.println(zeroString.concat(reverse));

    }



}
