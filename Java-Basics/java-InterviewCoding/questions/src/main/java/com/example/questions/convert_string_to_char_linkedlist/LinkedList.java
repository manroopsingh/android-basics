package com.example.questions.convert_string_to_char_linkedlist;

/**
 * Created by singh on 2/21/18.
 */

public class LinkedList {

    Node head = null;
    Node tail = null;
    int length = 0;
    int counter = 0;
    public static final int ITERATE_UP = 0;
    public static final int ITERATE_DOWN = 1;

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

    public int remove(int index) {

        int direction = 0;
        if (index > length) return 0;


//        used for doubly linked list
//        if((index>length/2)) {
//            direction = 1;
//        }

        //get the head in temp
        Node temp = head;

        //change head
        if (index == 0) {
            head = temp.next;
        }


        switch (direction) {

            //you can iterate down for a double linked list
            case ITERATE_DOWN:
                counter = length - 1;
                while (counter > index) {

                }

                break;

            case ITERATE_UP:
                while (counter < index - 1) {
                    temp = temp.next;
                    counter++;
                }
                Node next = temp.next.next;
                temp.next = next;
                break;

        }

        length--;
        return 1;
    }

    public String print() {
        String result = null;
        Node temp = head;
        while (temp != null) {
            result += temp.data + " ,";
            temp = temp.next;
        }
        return result;
    }

    public int size() {
        return length;
    }


}
