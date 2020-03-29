package com.datastruct.hashtable;

import com.datastruct.redblacktree.RBTree;
import com.util.FileUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> words = FileUtils.readFileToWords("src/main/resources/pride-and-prejudice.txt");

        RBTree<String, Integer> rbt = new RBTree<>();
        long start = System.nanoTime();
        for (String word : words) {
            if (rbt.contains(word)) {
                rbt.set(word, rbt.get(word) + 1);
            } else {
                rbt.add(word, 1);
            }
        }
        System.out.println("RedBlackTree: " + (System.nanoTime() - start) / 1000000000.0 + "s");

        HashTable<String, Integer> ht = new HashTable<>();
        start = System.nanoTime();
        for (String word : words) {
            if (ht.contains(word)) {
                ht.put(word, ht.get(word) + 1);
            } else {
                ht.put(word, 1);
            }
        }
        System.out.println("HashTable: " + (System.nanoTime() - start) / 1000000000.0 + "s");

    }
}
