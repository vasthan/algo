package com.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileOperation {

    public static List<String> readFileToWords(String fileName) {
        BufferedReader br = null;
        List<String> words = new ArrayList<>();
        try {
            br = new BufferedReader(new FileReader(fileName));
            String content;
            while((content = br.readLine()) != null) {
                for (String word : content.split(" ")) {
                    words.add(word);
                }
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return words;
    }
}
