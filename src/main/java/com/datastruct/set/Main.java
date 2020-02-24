package com.datastruct.set;


import com.datastruct.linkedlist.LinkedList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Set<String> set1 = new BSTSet<>();

        List<String> word1 = new ArrayList<>();
        readFile("src/main/resources/pride-and-prejudice.txt", word1);
        System.out.println("pride-and-prejudice");
        System.out.println("total words: " + word1.size());
        for (String word : word1) {
            set1.add(word);
        }
        System.out.println("total different words: " + set1.getSize());

        System.out.println();

        Set<String> set2 = new LinkedListSet<>();

        List<String> word2 = new ArrayList<>();
        readFile("src/main/resources/pride-and-prejudice.txt", word2);
        System.out.println("pride-and-prejudice");
        System.out.println("total words: " + word2.size());
        for (String word : word2) {
            set2.add(word);
        }
        System.out.println("total different words: " + set2.getSize());

    }

    private static void readFile(String fileName, List<String> word1) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String content;
        while ((content = br.readLine()) != null) {
            String[] words = content.split(" ");
            for (String word : words) {
                word1.add(word);
            }
        }
        br.close();
    }
}
