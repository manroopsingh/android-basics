package com.example.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Author: singh on: 31-Jan-18.
 */

public class Clubbing_Anagrams {

    public static void main(String[] args) {


        List<String> stringList = new ArrayList<>();
        List<String> stringList1 = Arrays.asList("cat", "dog", "god", "coat", "taco");

        stringList.addAll(stringList1);

        printClubAnagrams(stringList);

    }

    public static HashMap<Character, Integer> countChar(String s) {

        HashMap<Character, Integer> charMap = new HashMap<>();

        Integer count;


        for (Character ch : s.toCharArray()) {
            count = charMap.get(ch);
            if (count != null) {
                charMap.put(ch, count++);
            } else charMap.put(ch, 1);
        }

        return charMap;

    }

    public static boolean isAnagram(String s1, String s2) {

        if (!(s1.length() == s2.length())) return false;

        HashMap<Character, Integer> charMap1 = countChar(s1);
        HashMap<Character, Integer> charMap2 = countChar(s2);

        return charMap1.equals(charMap2);
    }

    public static void printClubAnagrams(List<String> rawList) {

        HashSet<HashSet<String>> clubbedAnagrams = new HashSet<>();
        
        for (String s : rawList) {

            HashSet<String> anagramsSet = new HashSet<>();

            anagramsSet.add(s);
            for (String s1 : rawList) {

                if (isAnagram(s, s1)) {
                    anagramsSet.add(s1);
                }
            }
            clubbedAnagrams.add(anagramsSet);
        }

        System.out.println(clubbedAnagrams);

    }

}
