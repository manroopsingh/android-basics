package com.example.user.android_dagger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by singh on 23-Oct-17.
 */

public class Tet {

    //problem 2
    public static String duplicate(List<String> list) {
        Set<String> unique = new HashSet<String>();
        int frequency = 0;
        String string = "";
        for(int i = 0; i < list.size(); i++) {
            unique.add(list.get(i));
        }
        for(String key: unique) {
            frequency= Collections.frequency(list, key);
            while(frequency > 0) {
                string += key + " ";
                frequency--;
            }
        }
        return string;
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("jason");
        list.add("jason");
        list.add("jason");
        System.out.println(duplicate(list));
    }
}
