package com.example.singh.oopsconcepts_and_designpatterns.java_problems;

import java.util.Stack;

/**
 * Created by singh on 10-Oct-17.
 */

public class BalancingParenthesis {


    public static void main(String[] args) {


        String inputString = "{([])}[]";

        Stack<Character> stack = new Stack<>();

        System.out.println(validate(inputString, stack));

    }

    private static boolean validate(String inputString, Stack<Character> stack) {
        char[] chars = inputString.toCharArray();

        for (int i = 0; i < inputString.length(); i++) {

            switch (chars[i]) {
                case '[':case '{':case '(':
                    stack.push(chars[i]);
                    break;

                case ']':case '}':case ')':
                    if (stack.isEmpty() || !(stack.pop() == getInvert(chars[i])) )
                        return false;
                    break;
            }

        }
        return stack.isEmpty();
    }

    private static char getInvert(Character character) {

        if(character==']') return'[';
        if(character=='}') return'{';
        if(character==')') return'(';

        return 0;
    }


}
