package com.example.user.javacodingsamples.binary_tree_creation;

/**
 * Created by singh on 12/27/17.
 */

public class BinaryTree {

    public static Node root = null;

    public BinaryTree(int rootData) {
        root = new Node(rootData);
    }

    static class Orientation {
        public static final String LEFT = "left";
        public static final String RIGHT = "right";
    }

    //    create a method for adding the nodes
    public void add(Node parent, Node child, String orientation) {
        if (orientation.equals(Orientation.LEFT))
            parent.setLeft(child);
        else parent.setRight(child);

    }

    public static Node getRoot() {
        return root;
    }

    public static void setRoot(Node root) {
        BinaryTree.root = root;
    }

    public void print() {


    }


}
