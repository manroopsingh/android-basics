package com.example.questions;

/**
 * Created by singh on 2/13/18.
 */

public class Printing_Binary_Tree {

    public static void main(String[] args) {


    }


    public class Node {

        Node left;
        Node right;
        int data;

        public Node(int data) {

            this.data = data;
        }

    }

    public class BinaryTree {

        Node root;
        public static final String POST_ORDER = "post";
        public static final String PRE_ORDER = "pre";
        public static final String IN_ORDER = "in";
        String order;

        public BinaryTree(int rootData, String order) {
            this.root = new Node(rootData);
            this.order = order;
        }

        public void addNode(Node node) {

            switch (order) {
                case POST_ORDER:


                    break;

                case PRE_ORDER:


                    break;

                case IN_ORDER:


                    break;

            }

        }


    }
}
