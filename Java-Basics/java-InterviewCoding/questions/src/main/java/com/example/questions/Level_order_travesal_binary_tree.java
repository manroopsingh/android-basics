package com.example.questions;

public class Level_order_travesal_binary_tree {

    // Recursive Java program for level order traversal of Binary Tree

    /* Class containing left and right child of current
    node and key value*/
    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static class BinaryTree {
        // Root of the Binary Tree
        Node root;
        private int height;
        private int width;

        public BinaryTree() {
            root = null;
        }

        /* function to print level order traversal of tree*/
        void printLevelOrder() {
            int h = height(root);

            int height, width = 0;


            int i;
            for (i = 1; i <= h; i++) {

                System.out.println("height:" + i);
                printGivenLevel(root, i);
                System.out.println("width:" + i);
                width = 0;
            }

        }

        /* Compute the "height" of a tree -- the number of
        nodes along the longest path from the root node
        down to the farthest leaf node.*/
        int height(Node root) {
            if (root == null)
                return 0;
            else {
                /* compute height of each subtree */
                int lheight = height(root.left);
                int rheight = height(root.right);

                /* use the larger one */
                if (lheight > rheight)
                    return (lheight + 1);
                else return (rheight + 1);
            }
        }


        /* Print nodes at the given level */
        void printGivenLevel(Node root, int level) {


            if (root == null)
                return;
            if (level == 1) {
//                draw circle
                System.out.print(root.data + " ");
                width++;

            } else if (level > 1) {
                printGivenLevel(root.left, level - 1);
                printGivenLevel(root.right, level - 1);
            }
        }

        /* Driver program to test above functions */
        public static void main(String args[]) {
            BinaryTree tree = new BinaryTree();
            tree.root = new Node(1);
            tree.root.left = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left = new Node(4);
            tree.root.left.right = new Node(5);
            tree.root.right.left = new Node(7);
            tree.root.right.right = new Node(8);

            System.out.println("Level order traversal of binary tree is ");
            tree.printLevelOrder();
        }
    }

}
