package com.example.questions.linked_list_implementation_with_sorting;

public class LinkedList<T> {

    public static final int SORT_ASC = 1;
    private static final int SORT_DESC = 2;


    private Node<T> head = null;
    private Node<T> tail = null;

    private int currentSize;

    LinkedList() {
        currentSize = 0;
    }

    public void add(T currentData) {

        Node<T> currentNode = new Node<>(currentData);

//        for first element
        if (head == null && tail == null) {
            head = currentNode;
            tail = currentNode;
        }
//        for remaining elements
        else {
            tail.next = currentNode;
            tail = tail.next;

        }

//        increment the size
        currentSize++;


    }

    public void print() {

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" > ");
            }
            temp = temp.next;
        }

    }

    public void sort(int sortOrder) {

        switch (sortOrder) {
            case SORT_ASC:

                sortAscending();
                break;
            case SORT_DESC:
                sortDescending();
                break;
        }
    }

    private void sortDescending() {

    }

    private void sortAscending() {

        //bubble sort for exchanging the data when required
        if (currentSize > 1) {
            System.out.println("\n<<Sorting list>>");
            for (int i = 0; i < currentSize; i++) {
                Node<T> currentNode = head;
                Node<T> nextNode = head.next;
                for (int j = 0; j < currentSize - 1; j++) {
                    if (currentNode.data instanceof Integer) {
                        Integer currentData = (Integer) currentNode.data;
                        Integer nextData = (Integer) nextNode.data;
                        if (currentData > nextData) {
                            Integer temp = (Integer) currentNode.data;
                            currentNode.data = nextNode.data;
                            nextNode.data = (T) temp;
                        }
                        currentNode = nextNode;
                        nextNode = nextNode.next;
                    }
                }
            }
        }
    }
}
