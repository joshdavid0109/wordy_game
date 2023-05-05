package com.java.fingrp7_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Tester {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("asdf");
        strings.add("asddcqweq");
        strings.add("qwerwqsad");
        
        int max = 0; // max length
        int counter = 0; // number of repeating words
        for (int i = 0; i < strings.size(); i++) {
            int wordLength = strings.get(i).length();
            if (max == wordLength) {
                counter++;
            } else if (max < wordLength) {
                max = wordLength;
                counter = 1;
            }
        }
        int j = 0;
        String [] winnerWords = new String[counter];
        for (int i = 0; i < strings.size(); i++) {
            int wordLength = strings.get(i).length();
            if (max == wordLength) {
                winnerWords[j] = strings.get(i);
                j++;
            }

        }
        System.out.println(Arrays.toString(winnerWords));
    }
}

