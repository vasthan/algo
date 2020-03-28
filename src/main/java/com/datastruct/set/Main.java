package com.datastruct.set;

import com.util.FileUtils;

import java.util.List;

/**
 * 对比基于BSTSet和LinkedListSet
 */
public class Main {

    public static void main(String[] args) {
        long start = System.nanoTime();
        Set<String> set2 = new LinkedListSet<>();
        List<String> word2 = FileUtils.readFileToWords("src/main/resources/pride-and-prejudice.txt");
        System.out.println("pride-and-prejudice");
        System.out.println("total words: " + word2.size());
        for (String word : word2) {
            set2.add(word);
        }
        System.out.println("total different words: " + set2.getSize());
        System.out.println("LinkedListSet cost: " + (System.nanoTime() - start) / 1000000000.0 + "s");

        start = System.nanoTime();
        Set<String> set1 = new BSTSet<>();
        List<String> word1 = FileUtils.readFileToWords("src/main/resources/pride-and-prejudice.txt");
        System.out.println("pride-and-prejudice");
        System.out.println("total words: " + word1.size());
        for (String word : word1) {
            set1.add(word);
        }
        System.out.println("total different words: " + set1.getSize());
        System.out.println("BSTSet cost: " + (System.nanoTime() - start) / 1000000000.0 + "s");

        start = System.nanoTime();
        Set<String> set3 = new AVLSet<>();
        List<String> word3 = FileUtils.readFileToWords("src/main/resources/pride-and-prejudice.txt");
        System.out.println("pride-and-prejudice");
        System.out.println("total words: " + word3.size());
        for (String word : word3) {
            set3.add(word);
        }
        System.out.println("total different words: " + set3.getSize());
        System.out.println("AVLSet cost: " + (System.nanoTime() - start) / 1000000000.0 + "s");
    }


}
