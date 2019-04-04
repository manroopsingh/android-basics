package com.example.questions.binary_tree;

import java.io.Console;

/**
 * Created by singh on 2/13/18.
 */

public class Main {

    public static void main(String[] args) {


        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(30);

        binaryTree.add(5);
        binaryTree.add(10);
        binaryTree.add(15);
        binaryTree.add(20);
        binaryTree.add(25);
        binaryTree.add(30);
        binaryTree.add(40);
        binaryTree.add(45);
        binaryTree.add(50);

        binaryTree.print(BinaryTree.POST_ORDER);

    }





}
