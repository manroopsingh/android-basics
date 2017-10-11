package com.example.singh.oopsconcepts_and_designpatterns.java_problems.custom_parser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by singh on 10-Oct-17.
 */

public class ParserTest {

    public static void main(String[] args) {

        String response = "USA|Canada|Mexico*WashingtonD.C$Ottawa$MexicoCity";
        List<Country> countryList = new ArrayList<>();


        List<String> countryStringList = new ArrayList<>();

        List<String> capitalStringList = new ArrayList<>();

        char[] chars = response.toCharArray();

        int fromIndex = 0;
        int toIndex = 0;

        for (int i = 0; i < response.length(); i++) {


            if (chars[i] == '|' || chars[i] == '*') {
                toIndex = i;
                countryStringList.add(response.substring(fromIndex, toIndex));
                fromIndex = i + 1;
            }
            if (chars[i] == '$') {
                toIndex = i;
                capitalStringList.add(response.substring(fromIndex, toIndex));
                fromIndex = i + 1;
            }
            if (i == response.length() - 1) {

                capitalStringList.add(response.substring(fromIndex));
            }


        }

        for (int i = 0; i < countryStringList.size(); i++) {

            Country country = new Country(
                    countryStringList.get(i),
                    capitalStringList.get(i));

            countryList.add(country);

        }



    }


}
