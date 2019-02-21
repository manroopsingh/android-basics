package com.example.questions.string_encoder;


/**
 * The type String encoder.
 */
public class String_encoder {

    /**
     * Encode string.
     *
     * @param plainText the plain text
     * @return the string returns the cipher text
     */
    private static String encode(String plainText){

//        Convert plaintext to lowercase
        plainText = plainText.toLowerCase();
//        create a new string builder to save cipher strings
        StringBuilder cipherText = new StringBuilder();

        String plainSub = "";
//        Loop through the characters to identify and encrypt
        for (char c : plainText.toCharArray()) {

//            Convert the plainSub string used for integers to reverse
            if (!identifySubstring(c).equals("integer")) {
                cipherText.append(reverse(plainSub));
                plainSub = "";
            }
            switch (identifySubstring(c)){
                case "vowel":
                    cipherText.append(getCipherVowel(c));
                    break;

                case "consonant":
                    cipherText.append(getCipherConsonant(c));
                    break;

                case "y":
                    cipherText.append(" ");
                    break;
                case "space":
                    cipherText.append("y");

                    break;
                case "integer":
                    plainSub += String.valueOf(c);
                    break;
                case "default":
                    cipherText.append(c);
            }
        }
        cipherText.append(reverse(plainSub));
        return cipherText.toString();
    }

    /**
     * Reverse string.
     *
     * @param input the input is the un-reversed string
     * @return the string returns the reversed string
     */
    private static String reverse(String input) {
        int length = input.length();
        String reverse = "";
        for (int i = length-1; i >= 0; i--) {
            reverse += input.charAt(i);
        }
        return reverse;

    }

    private static String getCipherConsonant(char c) {

        char cipherChar = (char) (c - 1);
        return String.valueOf(cipherChar);
    }

    /**
     * Identify substring string.
     *
     * @param sub the sub is the sub char of the input string
     * @return the string returns the type of character being identified
     */
    public static String identifySubstring(char sub){

//        if the value is consonant or vowel
        if(sub>=97 && sub<=122){
//            if the char is 'y'
            if(sub==121) return "y";
//            if the char is a vowel
            if (sub == 97 || sub == 101 || sub == 105 || sub == 111 || sub == 117) {
                return "vowel";
//                if the char is a consonant
            } else return "consonant";
        }
//        if the char is an integer
        if(sub>=48 && sub<=57) return "integer";
//        if the char is a space
        if(sub==32) return "space";
        return "default";
    }


    /**
     * Get cipher vowel string.
     *
     * @param ch the char from input string
     * @return the string after converting the vowel's equivalent int value
     */
    private static String getCipherVowel(char ch){

        String cipher = "";
        switch (ch) {
            case 'a':
                cipher = String.valueOf(1);
                break;
            case 'e':
                cipher = String.valueOf(2);
                break;
            case 'i':
                cipher = String.valueOf(3);
                break;
            case 'o':
                cipher = String.valueOf(4);
                break;
            case 'u':
                cipher = String.valueOf(5);
                break;
        }

        return cipher;
    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        System.out.println(encode("Hello World!aaa 21"));
    }

}
