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

        if (areSame(root1, root2)) {
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        } else return false;

    }

    public static boolean areSame(TNode node1, TNode node2) {


        return false;
    }


}
