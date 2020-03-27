package com.datastruct.avltree;

import com.util.FileUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AVLTree<String, Integer> avl = new AVLTree<>();
        List<String> words = FileUtils.readFileToWords("src/main/resources/pride-and-prejudice.txt");
        for (String word : words) {
            if (avl.contains(word)) {
                avl.set(word, avl.get(word) + 1);
            } else {
                avl.add(word, 1);
            }
        }
        System.out.println("total different words: " + avl.getSize());
        System.out.println("pride frequence: " + avl.get("pride"));
        System.out.println("is BST: " + avl.isBST());
        System.out.println("is balanced: " + avl.isBalanced());

        for (String word : words) {
            avl.remove(word);
            if (!avl.isBST() || !avl.isBalanced()) {
                throw new RuntimeException("Error");
            }
        }

    }
}
