package com.example.questions.convert_string_to_char_linkedlist;

/**
 * Created by singh on 2/21/18.
 */

public class LinkedList {

    Node head = null;
    Node tail = null;
    int length = 0;
    int counter = 0;
    public static final int ITERATE_UP = 1;
    public static final int ITERATE_DOWN = 0;

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

        }
        length++;

    }

    public void remove(int index) {

        int direction = 0;

        if(!(index<length)) {
            direction = ((length - index > length / 2) ? 0 : 1);
        }


        switch (direction) {

            case ITERATE_DOWN:
                break;

            case ITERATE_UP:
                break;

        }


    }

    public int size(){
        return length;
    }


}
