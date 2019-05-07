package com.example.questions;

public class FizzBuzz {
    public static void main(String[] args) {

        String result = "";
        for (int i = 0; i < 20; i++) {

            if (i % 3 == 0) result += "Fizz";
            if (i % 5 == 0) result += "Buzz";
            if (result.isEmpty()) result += String.valueOf(i);
            System.out.println(result);
            result = "";
        }

    }
}
