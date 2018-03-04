package com.example.questions.cracking_the_coding_interview.arrays_and_strings;

/**
 * Created by singh on 3/4/18.
 */

public class Is_Unique {

    public static void main(String[] args) {

        String inputString = "Manroop";

        System.out.println(isUnique(inputString));
        System.out.println(isUniqueOptimized(inputString));

    }

    /*This function have a complexity of O(n^2)
    */
    private static boolean isUnique(String inputString) {


        int size = inputString.length();
        char[] charArray = inputString.toCharArray();
        int[] charCount = new int[size];


        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j < charArray.length; j++) {

                if(charArray[i]==charArray[j]) charCount[i]++;
            }
            if(charCount[i]>1) return false;
        }

        return true;

    }

    /*This function have a complexity of O(n)
    */
    private static boolean isUniqueOptimized(String inputString) {

        int stringSize = inputString.length();

        boolean[] char_set = new boolean[128];

        for (int i = 0; i < stringSize; i++) {

            int value = inputString.charAt(i);
            if (char_set[value]) {
                return false;
            }
            char_set[value] = true;
        }
        return true;

    }


}
