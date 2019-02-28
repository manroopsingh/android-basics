package com.example.questions.calculate_minimum_amount;

import java.util.Arrays;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        List<Integer> prices = Arrays.asList(4,9,2,3);
        System.out.println(calculateAmount(prices));
    }


    public static long calculateAmount(List<Integer> prices){

        long currentMin = prices.get(0);
        long currentPrice = 0;
        long totalCost = prices.get(0);

        for (int i = 1; i < prices.size(); i++) {

            if (prices.get(i) >= currentMin) {
                currentPrice = prices.get(i) - currentMin;
                totalCost += currentPrice;
            }

            currentMin = getCurrentMin(currentMin, prices.get(i));

        }
        return totalCost;

    }

    public static long getCurrentMin(long currentPrice, long newPrice) {

        if(currentPrice>=newPrice) return newPrice;
        else return currentPrice;
    }


}
