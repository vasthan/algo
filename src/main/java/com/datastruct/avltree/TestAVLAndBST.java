package com.datastruct.avltree;

import com.datastruct.map.BSTMap;
import com.util.FileUtils;

import java.util.Collections;
import java.util.List;

public class TestAVLAndBST {
    public static void main(String[] args) {

        List<String> words = FileUtils.readFileToWords("src/main/resources/pride-and-prejudice.txt");

        // 测试不平衡的时候BST和AVL的性能差异
        // 输入数据是有序的情况下，BST会退化成链表，而AVL仍然是平衡的二分搜索树
        Collections.sort(words);

        long start = System.nanoTime();
        testBST(words);
        long end = System.nanoTime();
        System.out.println("BST: " + (end - start) / 1000000000.0 + "s");

        start = System.nanoTime();
        testAVL(words);
        end = System.nanoTime();
        System.out.println("AVL: " + (end - start) / 1000000000.0 + "s");


    }

    private static void testBST(List<String> words) {
        BSTMap<String, Integer> bst = new BSTMap<>();
        for (String word : words) {
            if (bst.contains(word)) {
                bst.set(word, bst.get(word) + 1);
            } else {
                bst.add(word, 1);
            }
        }
        for (String word : words) {
            bst.contains(word);
        }
    }

    private static void testAVL(List<String> words) {
        AVLTree<String, Integer> avl = new AVLTree<>();
        for (String word : words) {
            if (avl.contains(word)) {
                avl.set(word, avl.get(word) + 1);
            } else {
                avl.add(word, 1);
            }
        }
        for (String word : words) {
            avl.contains(word);
        }
    }
}
