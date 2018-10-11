package com.example.questions;

import java.util.ArrayList;
import java.util.List;

public class Reverse_string_array {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("Hello1");
        strings.add("Hello2");

        System.out.println(reverseStringList(strings));
    }


    private static List<String> reverseStringList(List<String> stringList) {

        if (stringList.size() <= 1) {
            return stringList;
        }

        int end = stringList.size()-1;

        List<String> reverseString = new ArrayList<>();
        for (int i = end; i >= 0; i--) {

            reverseString.add(stringList.get(i));
        }

        stringList.clear();
        return reverseString;

    }
}
