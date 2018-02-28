package com.example.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by singh on 2/27/18.
 */

public class Recursive_Function_Add_IntegerList {

    public static void main(String[] args) {


        List<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(3);
        integers.add(4);
        System.out.println(recursiveSum(integers));

    }

    public static int recursiveSum(List<Integer> integers) {

        if (integers.size() == 0) {
            return 0;
        }
        
        List<Integer> newList = integers.subList(0, integers.size() - 1);
        return integers.get(integers.size()-1) + recursiveSum(newList);
    }


}
