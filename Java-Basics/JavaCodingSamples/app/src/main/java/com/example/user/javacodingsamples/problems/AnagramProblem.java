package com.example.user.javacodingsamples.problems;

import java.util.HashMap;

/**
 * Created by singh on 12/26/17.
 */

public class AnagramProblem {

    private static int count;

    public static void main(String[] args) {

        String firstStr = "geeksforgeeks";
        String secondStr = "forgeeksgeeks";
        count = 0;
        HashMap<Character, Integer> firstMap = convertHashMap(firstStr);
        HashMap<Character, Integer> secondMap = convertHashMap(secondStr);

//        compare the HashMaps
        System.out.println(firstMap.equals(secondMap));

    }

    private static HashMap convertHashMap(String str) {

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {

            Character currentCharacter = str.charAt(i);
            if (!hashMap.containsKey(currentCharacter)) {
                hashMap.put(str.charAt(i), 1);
            } else {
                count = hashMap.get(currentCharacter);
                hashMap.put(currentCharacter, count + 1);
            }

        }
        return hashMap;
    }


}
