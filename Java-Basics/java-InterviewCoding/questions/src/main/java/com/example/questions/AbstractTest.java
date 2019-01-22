package com.example.questions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public  class AbstractTest {

    public static void main(String[] args) {


        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("a");
        stack.push("a");

        LinkedList<String> linkedList = new LinkedList<>();

        HashSet<Integer> hashSet = new HashSet<>();


    }


    public class MyAbsractChild extends MyAbstractClass {


    }

    public abstract class MyAbstractClass{
        public void something(){
            System.out.println("do something");
        }
    }

}
