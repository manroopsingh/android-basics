package com.example.questions.cracking_the_coding_interview.arrays_and_strings;

import java.util.Arrays;

/**
 * Created by singh on 3/4/18.
 */

public class Check_Permutation {


    public static void main(String[] args) {

        String string1 = "california";
        String string2 = "caliniafor";

        System.out.println("With permutation: ");
        System.out.println(check_permutation_with_sorting(string1, string2));
        System.out.println("Without permutation: ");
        System.out.println(check_permutation_without_sorting(string1, string2));

    }
    
    /*
    Solution1 using sorting
    */
    private static boolean check_permutation_with_sorting(String a, String b) {

        if(a.length()!=b.length()) return false;
        return sort(a).equals(sort(b));

    }

    private static String sort(String inputString) {
        char[] content = inputString.toCharArray();
        Arrays.sort(content);
        return String.valueOf(content);
    }


    /*
    Solution 2 with sorting functions
    */
    private static boolean check_permutation_without_sorting(String a, String b) {

        //return if length is not equal
        if(a.length()!=b.length()) return false;

        int[] letters = new int[128];//assuming the letters are ASCII

        //count the character in the string
        for (int i = 0; i < a.length(); i++) {
            letters[a.charAt(i)]++;
        }

        for (int i = 0; i < b.length(); i++) {
            int count = letters[b.charAt(i)];
            letters[b.charAt(i)]--;
            if (count < 0) {
                return false;
            }
        }
        return true;
        
    }
}
