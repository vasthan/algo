package com.datastruct.redblacktree;

import com.datastruct.avltree.AVLTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main2 {
    public static void main(String[] args) {
        Random rand = new Random();
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 20000000; i++) {
            nums.add(rand.nextInt(Integer.MAX_VALUE));
        }

        AVLTree<Integer, Integer> avl = new AVLTree<>();
        long start = System.nanoTime();
        for (Integer num : nums) {
            avl.add(num, null);
        }
        System.out.println("avl: " + (System.nanoTime() - start) / 1000000000.0 + "s");


        RBTree<Integer, Integer> rbt = new RBTree<>();
        start = System.nanoTime();
        for (Integer num : nums) {
            rbt.add(num, null);
        }
        System.out.println("rbt: " + (System.nanoTime() - start) / 1000000000.0 + "s");
    }
}
