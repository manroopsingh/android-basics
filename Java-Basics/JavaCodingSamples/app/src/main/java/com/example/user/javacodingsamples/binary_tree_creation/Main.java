package com.example.user.javacodingsamples.binary_tree_creation;

/**
 * Created by singh on 12/27/17.
 */

public class Main {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(3);
        Node root = BinaryTree.root;
        Node n1 = new Node(4);
        Node n2 = new Node(7);
        Node n3 = new Node(4);
        Node n4 = new Node(8);
        Node n5 = new Node(4);
        Node n6 = new Node(8);

        binaryTree.add(root, n1, BinaryTree.Orientation.LEFT);
        binaryTree.add(root, n2, BinaryTree.Orientation.RIGHT);
        binaryTree.add(n1, n3, BinaryTree.Orientation.LEFT);
        binaryTree.add(n1, n4, BinaryTree.Orientation.RIGHT);
        binaryTree.add(n2, n5, BinaryTree.Orientation.LEFT);
        binaryTree.add(n2, n6, BinaryTree.Orientation.RIGHT);

        System.out.println(binaryTree.toString());

    }
}
