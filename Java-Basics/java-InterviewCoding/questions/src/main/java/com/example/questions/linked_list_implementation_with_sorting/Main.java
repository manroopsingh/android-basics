package com.example.questions.linked_list_implementation_with_sorting;

public class Main {

    public static void main(String[] args) {


//        create linked list
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        integerLinkedList.add(5);
        integerLinkedList.add(6);
        integerLinkedList.add(3);
        integerLinkedList.add(2);

        integerLinkedList.print();
        integerLinkedList.sort(LinkedList.SORT_ASC);
        integerLinkedList.print();

    }


}
