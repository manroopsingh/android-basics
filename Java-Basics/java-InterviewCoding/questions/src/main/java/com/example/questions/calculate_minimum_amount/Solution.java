package com.example.questions.calculate_minimum_amount;

import java.util.Arrays;
import java.util.List;

public class Solution {


    public static void main(String[] args) {

        List<Integer> prices = Arrays.asList(4,9,2,3);
        System.out.println(calculateAmount(prices));
    }


    public static int calculateAmount(List<Integer> prices){

        int currentMin = prices.get(0);
        int currentPrice = 0;
        int totalCost = prices.get(0);

        for (int i = 1; i < prices.size(); i++) {

            if (prices.get(i) > currentMin) {
                currentPrice = prices.get(i) - currentMin;
                totalCost += currentPrice;
            }

            currentMin = getCurrentMin(currentMin, prices.get(i));

        }
        return totalCost;

    }

    public static int getCurrentMin(int currentPrice, int newPrice) {

        if(currentPrice>=newPrice) return newPrice;
        else return currentPrice;
    }


}
