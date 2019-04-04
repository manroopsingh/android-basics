package com.example.questions;

public class CompressString {

    public static void main(String[] args) {


        System.out.println(compressString("aaabbccccd"));

        System.out.println(compressString("aaabbccccd".toCharArray()));
    }

    private static String compressString(String input) {

        int charCount = 0;
        char ch = input.charAt(0);
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {

            if (input.charAt(i) == ch) {
                charCount++;

            } else {
                output.append(ch);
                output.append(charCount);

                ch = input.charAt(i);
                charCount = 1;
            }

        }
        return output.append(ch).append(charCount).toString();
    }

    private static char[] compressString(char[] chars) {

        char ch = chars[0];
        int charCount = 0;
        int index = 0;
        int outputIndex = 0;

        while (index < chars.length) {

            if (chars[index] != ch) {

                chars[outputIndex] = ch;
                chars[outputIndex + 1] = (char) (charCount + '0');
                outputIndex += 2;
                ch = chars[index];
                charCount = 1;
            } else {
                charCount++;
            }
            index++;

        }

        chars[outputIndex] = ch;
        chars[outputIndex + 1] = (char) (charCount + '0');
        outputIndex += 2;

        while (outputIndex < index) {
            chars[outputIndex] = ' ';
            outputIndex++;
        }

        return chars;

    }
}
