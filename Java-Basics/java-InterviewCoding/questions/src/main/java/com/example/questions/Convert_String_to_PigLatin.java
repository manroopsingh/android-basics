package com.example.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Author: singh on: 17-Apr-18.
 */

/*
PigLatin:

a made-up language formed from English by transferring the initial consonant or consonant
cluster of each word to the end of the word and adding a vocalic syllable (usually ˈpiɡ ˌlatn:
so chicken soup would be translated to ickenchay oupsay . Pig Latin is typically spoken
playfully, as if to convey secrecy.
*/

public class Convert_String_to_PigLatin {

    public static void main(String[] args) {

        String sentence = "When life gives you lemons make a lemonade";
        translateToLatin(sentence);
    }


    public static void translateToLatin(String sentence) {

        List<String> words = Arrays.asList(sentence.split("\\s+"));

        StringBuilder latinBuilder = new StringBuilder();
        for (String word : words) {
            translateWord(latinBuilder, word);

        }

        System.out.println(latinBuilder.toString());

    }

    private static void translateWord(StringBuilder latinBuilder, String word) {

        String vowels = "AEIOUaeiou";

        int index = 0;
        for (int i = 0; i < word.length(); i++) {
            index = vowels.indexOf(word.charAt(i));
            if (index > -1) {
                index = i;
                break;
            }
        }
        String newWord = word.substring(index, word.length()) + word.substring(0, index) + "ay";

        latinBuilder.append(newWord).append(" ");



    }

}
