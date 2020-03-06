package com.datastruct.map;

import com.util.FileUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Map<String, Integer> map1 = new LinkedListMap<>();
        List<String> words1 = FileUtils.readFileToWords("src/main/resources/pride-and-prejudice.txt");
        for (String word : words1) {
            if (map1.contains(word)) {
                map1.set(word, map1.get(word) + 1);
            } else {
                map1.add(word, 1);
            }
        }

        System.out.println("total different words: " + map1.getSize());
        System.out.println("pride frequence: " + map1.get("pride"));

        System.out.println();

        Map<String, Integer> map2 = new BSTMap<>();
        List<String> words2 = FileUtils.readFileToWords("src/main/resources/pride-and-prejudice.txt");
        for (String word : words2) {
            if (map2.contains(word)) {
                map2.set(word, map2.get(word) + 1);
            } else {
                map2.add(word, 1);
            }
        }

        System.out.println("total different words: " + map2.getSize());
        System.out.println("pride frequence: " + map2.get("pride"));
    }
}
