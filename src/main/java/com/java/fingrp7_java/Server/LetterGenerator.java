package com.java.fingrp7_java.Server;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LetterGenerator {
    private List<Character> letters = new ArrayList<>();
    private static final Random random = new Random();

    public static String getRandomLetters() {
        String vowels = "aeiou";
        StringBuilder sb = new StringBuilder();
        int vowelCount = 0;
        int letterCount = 0;

        while (letterCount < 17) {
            char c = (char) (random.nextInt(26) + 'a');
            sb.append(c);
            letterCount++;

            if (vowels.indexOf(c) != -1) {
                vowelCount++;
            }

            if ((vowelCount >=5 && vowelCount <= 7) && letterCount == 17) {
                break;
            } else if (letterCount == 17) {
                sb.delete(0, sb.length());
                letterCount = 0;
                vowelCount = 0;
            }
        }
        System.out.println(vowelCount + " " + letterCount);
        return sb.toString();
    }
}
