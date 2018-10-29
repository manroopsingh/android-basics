package com.example.questions;

public class Convert_String_to_Binary {

    public static void main(String[] args) {

        String someWord = "Something";
        System.out.println("Original string: " + someWord);
        System.out.println("After converting to Binary");
        System.out.println(convertToBinary(someWord));

        something something = new something();

    }

    public static String convertToBinary(String str) {

        byte[] stringBytes = str.getBytes();

        StringBuilder stringBinary = new StringBuilder();

        for (byte stringByte : stringBytes) {

            int val = stringByte;
            for (int i = 0; i < 8; i++) {

                stringBinary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
            stringBinary.append(" ");
        }

        return stringBinary.toString();
    }

    public static class something{

    }


}
