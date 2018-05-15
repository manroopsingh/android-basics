package com.example.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Credit_card_validation {


    public static final String IS_VALID = "isValid";
    public static final String IS_ALLOWED = "isAllowed";
    public static final String CARD = "card";
    public static void main(String[] args) {
        String[] cards = new String[]{"6724843711060148"};
        String[] banned = new String[]{"675"};


        System.out.println(validateCreditCards(banned,cards));
    }

    static List<Map<String, Object>> validateCreditCards(String[] bannedPrefixes, String[] cardsToValidate) {

        List<Map<String, Object>> cardValidations = new ArrayList<>();

        for (String card : cardsToValidate) {
            cardValidations.add(validateCard(bannedPrefixes,card));
        }
        return cardValidations;
    }

    private static Map<String, Object> validateCard(String[] bannedPrefixes, String card) {

        Map<String, Object> validationMap = new HashMap<>();

        validationMap.put(CARD, card);
        validationMap.put(IS_VALID, isCardValid(card));
        validationMap.put(IS_ALLOWED, isCardAllowed(bannedPrefixes, card));


        return validationMap;
    }

    private static boolean isCardAllowed(String[] bannedPrefixes, String card) {

        for (String bannedPrefix : bannedPrefixes) {
            if (bannedPrefix.equals(card.substring(0, bannedPrefix.length()))) {
                return false;
            }
        }

        return true;
    }

    private static boolean isCardValid(String card) {

        int luhnCheck = 0;

        String subCard = card.substring(0, card.length()-1);
        for (int i = 0; i < subCard.length(); i++) {
            luhnCheck = luhnCheck + 2*Integer.parseInt(String.valueOf(subCard.charAt(i)));
        }

        luhnCheck = luhnCheck % 10;
        if (luhnCheck != Integer.parseInt(card.substring(card.length() - 1))) {
            return false;

        }

        return true;
    }
}
