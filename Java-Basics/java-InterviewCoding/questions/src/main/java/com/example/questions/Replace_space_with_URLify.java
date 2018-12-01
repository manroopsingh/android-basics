package com.example.questions;

public class Replace_space_with_URLify {

    public static void main(String[] args) {


//        char array to be used
        char[] chars = new char[5000];

//        input string
        String rawString = "H   e   ll   o   worl d!";
        addInputToCharArray(chars, rawString);

        printResult(chars, rawString.length());

    }

    private static void addInputToCharArray(char[] chars, String rawString) {
        for (int i = 0; i < rawString.toCharArray().length; i++) {
            chars[i] = rawString.charAt(i);
        }
    }

    private static void printResult(char[] chars, int inputLength) {

        int newLength = replaceSpace(chars, inputLength);
        for (int i = 0; i < newLength; i++) {

            System.out.print(chars[i]);
        }

    }


    private static int replaceSpace(char[] chars, int inputLength) {

        //count spaces
        int spaceCount = 0;
        for (char aChar : chars) {
            if (aChar == ' ') spaceCount++;
        }

        //find the new length of the string
        int newLength = inputLength + (spaceCount * 2);
        //fill elements form the end of the array
        int newIndex = newLength - 1;

        //loop through the end of the input string
        for (int i = inputLength - 1; i >= 0; i--) {

            if (chars[i] == ' ') {
                newIndex = replaceChars(chars, newIndex);

            } else {
                chars[newIndex] = chars[i];
                newIndex--;
            }
        }
        return newLength;
    }

    private static int replaceChars(char[] chars, int newIndex) {
        chars[newIndex] = '0';
        chars[newIndex - 1] = '2';
        chars[newIndex - 2] = '%';
        newIndex = newIndex - 3;
        return newIndex;
    }


}
