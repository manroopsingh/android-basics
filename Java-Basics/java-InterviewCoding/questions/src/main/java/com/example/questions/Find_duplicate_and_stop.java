package com.example.questions;


import java.util.HashMap;

/**
 * Created by singh on 3/8/18.
 */

public class Find_duplicate_and_stop {


    public static void main(String[] args) {

        String[] strings = new String[]{"1", "3", "4", "2", "6", "6", "1", "9", "10", "12"};

        printDuplicates(strings);

    }

    private static void printDuplicates(String[] strings) {

        HashMap<String, Integer> charMap = new HashMap<>();
        Integer count;

        for (String string : strings) {
            count = charMap.get(string);
            if (charMap.get(string) != null) charMap.put(string, count++);
            else charMap.put(string, 1);

            if (count != null) {
                if (count > 1) {
                    print(string);
                    break;
                }
            }
        }
    }

    private static void print(String outPut) {

        System.out.println(outPut);

    }
}
