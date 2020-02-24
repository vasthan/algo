package com.datastruct.bst;

public class TraverseBST {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();

        /////////////////
        //      5      //
        //    /   \    //
        //   3     7   //
        //  / \   / \  //
        // 2   4 6   8 //
        /////////////////

        int[] nums = {5, 3, 2, 7, 4, 6, 8};
        for (int num : nums) {
            bst.add(num);
        }

        // bst.preOrder();
        // System.out.println();
        // System.out.println(bst.preOrderNR());

        // bst.inOrder();
        // System.out.println();
        // System.out.println(bst.inOrderNR());

        // bst.postOrder();
        // System.out.println();
        // System.out.println(bst.postOrderNR());

        // bst.levelOrder();

        System.out.println(bst.getMin());
        System.out.println(bst.getMax());
    }
}
