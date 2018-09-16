package com.example.questions;

import java.util.Stack;

public class ExpressionEvaluator {


    public static void main(String[] args) {

        // System.out.println(convert("3 5 +"));//3 + 5 = 8
        convert("3 5 + 7 *");//56

         System.out.println(calculate("3 5 + 7 *"));// (3 + 5) x 7 = 56
         System.out.println(calculate("3 5 - 7 8 / *"));
         System.out.println(calculate("3 5 6 + *"));
         System.out.println(calculate("3 5 + 6 *"));
    }

    public static float calculate(String postfixSum) {
        convert(postfixSum);
        return 0.0f;
    }


    public static void convert(String postFixSum) {


        int total = 0;
        int currentResult = 0;

        //convert the raw string
        String[] rawOp = postFixSum.split(" ");

        Stack<Integer> intStack = new Stack<>();

        for (String s : rawOp) {


            switch (s) {

                case "+":


                    int num1 = intStack.pop();
                    int num2 = intStack.pop();

                    currentResult = num1 + num2;

                    intStack.push(currentResult);


                    for (int i = 0; i <= intStack.size(); i++) {

                        currentResult = currentResult + intStack.pop();


                    }

                    System.out.print("+ : " + currentResult);


                    break;

                case "-":

                    for (int i = 0; i <= intStack.size(); i++) {

                        currentResult = currentResult - intStack.pop();

                    }
                    System.out.println("- : " + currentResult);
                    intStack.push(currentResult);
                    break;

                case "*":

                    for (int i = 0; i <= intStack.size(); i++) {

                        currentResult = currentResult * intStack.pop();


                    }
                    System.out.print("* : " + currentResult);

                    intStack.push(currentResult);

                    break;
                case "/":

                    int num = intStack.pop();
                    int den = intStack.pop();

                    currentResult = num / den;

                    System.out.print("/ : " + currentResult);
                    intStack.push(currentResult);


                    break;


                default:

                    intStack.push(Integer.parseInt(s));


            }
        }

        System.out.print(currentResult);

    }


}
