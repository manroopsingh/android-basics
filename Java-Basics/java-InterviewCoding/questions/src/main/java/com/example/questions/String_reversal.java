package com.example.questions;

public class String_reversal {

    public static void main(String[] args) {

        System.out.println(reverse("Hello"));
    }


    static String reverse(String input){

        char[] strArr = input.toCharArray();

        for (int i = 0; i < strArr.length/2; i++) {

            char temp = strArr[i];
            strArr[i] = strArr[strArr.length-i-1];
            strArr[strArr.length-i-1] = temp;
        }

        return String.copyValueOf(strArr);

    }
}
