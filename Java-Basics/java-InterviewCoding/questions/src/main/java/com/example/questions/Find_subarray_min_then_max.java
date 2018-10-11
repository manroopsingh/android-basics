package com.example.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Find_subarray_min_then_max {

    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();

        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(1);
        integers.add(2);
        System.out.println(findMaximumOfSubArrayMin(2, integers));

    }

    private static int findMaximumOfSubArrayMin(int x, List<Integer> integers) {

        List<List<Integer>> subArrayList = new ArrayList<>();

        if (x < 1 || x > Math.pow(10, 5)) {
            return -1;
        }

        for (int i = 0; i <= integers.size() - x; i++) {

            List<Integer> subArray = new ArrayList<>();
            for (int j = i; j < i + x; j++) {

                subArray.add(integers.get(j));
            }
            subArrayList.add(subArray);
        }

        List<Integer> minSubArray = new ArrayList<>();
        for (List<Integer> integerList : subArrayList) {
            minSubArray.add(Collections.min(integerList));
        }

        return Collections.max(minSubArray);

    }

}
