package com.example.singh.android_rxjava2.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by singh on 23-Sep-17.
 */

public class DataSource {


    public static void main(String[] args) {
        for (String s: getStringList(5)){

            System.out.println(s);
        }
    }

    public static List<Integer> getIntList(int length){

        List<Integer> integers= new ArrayList<>();
        for (int i = 0; i < length; i++) {
            integers.add(i+1);
        }
        return integers;

    }


    public static List<String> getStringList(int numberOfWords)
    {
        List<String> randomStrings = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < numberOfWords; i++)
        {
            char[] word = new char[random.nextInt(8)+3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            for(int j = 0; j < word.length; j++)
            {
                word[j] = (char)('a' + random.nextInt(26));
            }
            randomStrings.add(new String(word));
        }
        return randomStrings;
    }
}
