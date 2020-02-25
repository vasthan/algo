package com.datastruct.set;

import com.util.FileOperation;

import java.io.IOException;
import java.util.List;

/**
 * 对比基于BSTSet和LinkedListSet
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Set<String> set1 = new BSTSet<>();

        List<String> word1 = FileOperation.readFileToWords("src/main/resources/pride-and-prejudice.txt");
        System.out.println("pride-and-prejudice");
        System.out.println("total words: " + word1.size());
        for (String word : word1) {
            set1.add(word);
        }
        System.out.println("total different words: " + set1.getSize());

        System.out.println();

        Set<String> set2 = new LinkedListSet<>();

        List<String> word2 = FileOperation.readFileToWords("src/main/resources/pride-and-prejudice.txt");
        System.out.println("pride-and-prejudice");
        System.out.println("total words: " + word2.size());
        for (String word : word2) {
            set2.add(word);
        }
        System.out.println("total different words: " + set2.getSize());

    }


}
