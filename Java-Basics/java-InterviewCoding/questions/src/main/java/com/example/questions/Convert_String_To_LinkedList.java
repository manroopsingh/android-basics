package com.example.questions;

/**
 * Created by singh on 2/15/18.
 */

public class Convert_String_To_LinkedList {

    /*
    Create a function to convert a string to
    a linked list of chars, do not use LinkedList
    from collections.

    */

    public static void main(String[] args) {


        String string = "Philadelphia";
        char[] strings = string.toCharArray();

        LinkedString linkedString = new LinkedString();
        for (char c : strings) {
            linkedString.add(new Node(c));
        }

        System.out.println(linkedString.size());

    }


    public static class Node{

        char data;
        Node next;

        public Node(char data) {
            this.data = data;
        }
    }

    //
    public static class LinkedString {

        Node head = null;
        Node tail = null;
        int length = 0;

        //adding a node to the linked list
        public void add(Node currentNode) {

            if (head == null && tail == null) {

                head = currentNode;
                tail = currentNode;

            } else {

                tail.next = currentNode;
                tail = tail.next;
                length++;

            }
        }
        public int size(){
            return length;
        }


    }


}


