package com.datastruct.redblacktree;

import com.datastruct.avltree.AVLTree;
import com.util.FileUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = FileUtils.readFileToWords("src/main/resources/pride-and-prejudice.txt");

        AVLTree<String, Integer> avl = new AVLTree<>();

        long start = System.nanoTime();
        for (String word : words) {
            if (avl.contains(word)) {
                avl.set(word, avl.get(word) + 1);
            } else {
                avl.add(word, 1);
            }
        }
        System.out.println("avl: " + (System.nanoTime() - start) / 1000000000.0 + "s");


        start = System.nanoTime();
        RBTree<String, Integer> rbt = new RBTree<>();
        for (String word : words) {
            if (rbt.contains(word)) {
                rbt.set(word, rbt.get(word) + 1);
            } else {
                rbt.add(word, 1);
            }
        }
        System.out.println("rbt: " + (System.nanoTime() - start) / 1000000000.0 + "s");
    }
}
