package com.example.questions.print_binary_tree;

/**
 * Created by singh on 2/13/18.
 */

public class Printing_Binary_Tree {

    public static void main(String[] args) {


        BinaryTree binaryTree = new BinaryTree("sdf");
        binaryTree.add(4);
        binaryTree.add(5);
        binaryTree.add(7);
        binaryTree.add(2);
        binaryTree.add(6);

        System.out.println(binaryTree);
    }


}
