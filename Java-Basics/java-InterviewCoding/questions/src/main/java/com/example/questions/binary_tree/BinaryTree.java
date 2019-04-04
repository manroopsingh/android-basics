package com.example.questions.binary_tree;


/**
 * Created by singh on 3/3/18.
 */

public class BinaryTree {

    private Node root;

    public static final int POST_ORDER = 3;
    public static final int PRE_ORDER = 2;
    public static final int IN_ORDER = 1;


    public void add(int value) {
        root = addNode(root, value);
    }

    private Node addNode(Node current, int data) {

        if (current == null) {
            current = new Node(data);
            return current;
        }

        if (data < current.data) current.left = addNode(current.left, data);
        else if (data > current.data) current.right = addNode(current.right, data);
        else return current;
        return current;
    }

    public void print(int ORDER) {

        switch (ORDER) {
            case PRE_ORDER:
                printPreOrder(root);
                break;

            case IN_ORDER:
                printInOrder(root);
                break;

            case POST_ORDER:
                printPostOrder(root);
                break;

        }

    }

    private void printPostOrder(Node root) {

        if (root == null) return;
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.println(root.data);

    }

    private void printInOrder(Node root) {

        if (root == null) return;
        printInOrder(root.left);
        System.out.println(root.data);
        printInOrder(root.right);
    }

    private void printPreOrder(Node root) {
        if (root == null) return;
        System.out.println(root.data);
        printPreOrder(root.left);
        printPreOrder(root.right);


    }

    private void balanceTree() {

    }

}
