package com.example.questions.convert_string_to_char_linkedlist;

/**
 * Created by singh on 2/21/18.
 */

public class LinkedList {

    Node head = null;
    Node tail = null;
    int length = 0;
    int counter;

    //adding a node to the linked list
    public void add(Node currentNode) {

        //for the first element
        if (head == null && tail == null) {
            head = currentNode;
            tail = currentNode;

        }
        //for other elements
        else {
            tail.next = currentNode;
            tail = tail.next;
            length++;
        }
    }

    public void remote(int index) {



    }

    public int size(){
        return length;
    }


}
