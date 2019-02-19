package com.example.user.kotlin_classespropertiesandinterfaces;

import java.util.Arrays;
import java.util.List;

public class Coding {


    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(7, 2, 3, 10,2,4,8,1);
        maxDifference(integers);


    }

    public static int maxDifference(List<Integer> integers) {


        int currentDifference = 0;
        int maxDifference = 0;


        for (Integer integer : integers) {
            for (Integer integer1 : integers) {

                if(integer<integer1){
                    currentDifference = integer1 - integer;
                    System.out.println(currentDifference);
                    if(currentDifference>maxDifference) maxDifference = currentDifference;
                }
            }
        }
        System.out.println(maxDifference);
        return -1;
    }
}
