package com.example.questions.convert_string_to_char_linkedlist;

/**
 * Created by singh on 2/15/18.
 */

public class Main {

    /*
    Create a function to convert a string to
    a linked list of chars, do not use LinkedList
    from collections.

    */

    public static void main(String[] args) {



        String string = "Philadelphia";
        char[] strings = string.toCharArray();

        LinkedList linkedString = new LinkedList();
        for (char c : strings) {
            linkedString.add(new Node(c));
        }

        System.out.println(linkedString.size());

    }






}


