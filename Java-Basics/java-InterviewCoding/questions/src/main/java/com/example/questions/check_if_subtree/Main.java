package com.example.questions.check_if_subtree;

/**
 * Created by singh on 2/28/18.
 */

/*

Check if a given tree is a subtree of the main tree
return 0 if true
return -1 if not


*/

public class Main {


    public static void main(String[] args) {


    }

    public static boolean isSubTree(TNode root1, TNode root2) {

        if (root1 == null) {
            return false;
        }

        if (root2 == null) {
            return true;
        }

        if (areSame(root1, root2))
            return true;

        return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);

    }

    public static boolean areSame(TNode node1, TNode node2) {


        if (node1 == null && node2 == null) return true;
        if (node1 == null || node2 == null) return false;

        return (node1.data == node2.data ||
                areSame(node1.left, node2.left) ||
                areSame(node1.left, node2.left));
    }


}
