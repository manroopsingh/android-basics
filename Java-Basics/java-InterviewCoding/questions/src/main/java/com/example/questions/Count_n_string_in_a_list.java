package com.example.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Count_n_string_in_a_list {



    public static void main(String[] args) {


        List<String> strings = new ArrayList<>();
        strings.add("Foo");
        strings.add("Foo");
        strings.add("Bar");
        strings.add("Something");
        strings.add("Bar");
        strings.add("Bar");

        System.out.println(matchString(strings, 2));

    }


    public static List<String> matchString(List<String> strings, int n) {


        List<String> matchingString = new ArrayList<>();
        HashMap<String, Integer> countMap = new HashMap<>();

        Integer currentCount;
        for (String current : strings) {
            if (countMap.containsKey(current)) {
                currentCount = countMap.get(current);
                currentCount++;
                countMap.put(current, currentCount);
            } else {
                countMap.put(current, -1);
            }

        }

        for (Map.Entry entry : countMap.entrySet()) {

            int count = (int) entry.getValue();

            if (count == n) {

                matchingString.add((String) entry.getKey());
            }

        }

        return matchingString;

    }


}
