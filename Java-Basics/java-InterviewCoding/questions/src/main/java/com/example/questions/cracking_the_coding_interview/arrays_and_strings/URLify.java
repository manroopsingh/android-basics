package com.example.questions.cracking_the_coding_interview.arrays_and_strings;

/**
 * Created by singh on 3/4/18.
 */

public class URLify {

    /*
    Create a function that will add "%20" where there is space in
    a string
    Input  "John Doe  "
    Output "John%20Doe"

    The length of the string will remain the same since the input string
    will have a buffer to add the new characters
    */
    public static void main(String[] args) {

        String inputString = "John Doe  ";
        int trueLength = 8;

        System.out.println(urlifyString(inputString, trueLength));


    }

    private static String urlifyString(String inputString, int trueLength) {


        int spaceCount = 0;

        //scan for number of spaces to be added
        for (int i = 0; i < trueLength; i++) {

            if (inputString.charAt(i) == ' ') {
                spaceCount++;
            }

        }

        //calculate the new string size
        int originalLength = trueLength + spaceCount * 2;
        int newIndex = originalLength;
        char[] newString = new char[originalLength];

        //replace the new string with required characters
        for (int i = trueLength - 1; i >= 0; i--) {
            if (inputString.charAt(i) == ' ') {
                newString[newIndex - 1] = '0';
                newString[newIndex - 2] = '2';
                newString[newIndex - 3] = '%';
                newIndex -= 3;
            } else {
                newString[newIndex - 1] = inputString.charAt(i);
                newIndex--;
            }
        }

        return String.valueOf(newString);
    }
}
