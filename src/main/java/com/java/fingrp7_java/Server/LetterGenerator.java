package com.java.fingrp7_java.Server;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LetterGenerator {
//    private List<Character> letters = new ArrayList<>();
    private static final Random random = new Random();
    private static final List<String> dictionary = getAllWords();
    private static List<String> possibleWords = null;

    private static List<String> getAllWords() {
        List<String> allWords = null;
        try {
            allWords = Files.readAllLines(new File("com/java/fingrp7_java/words.txt").toPath(),
                    Charset.defaultCharset());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allWords;
    }

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

    static void findOptions(String string, List<String> lowerCase) {
        int[] frequency = toFrequency(string);
        for (String l : lowerCase) {
            int[] freqIn = toFrequency(l);
            if (matches(frequency, freqIn)) {
                System.out.println(l); // comment this out, pangtest lang to
                possibleWords.add(l);
            }
        }
    }

    private static int[] toFrequency(String string) {
        int [] freq = new int[26];
        for (char c : string.toCharArray()) {
            if ((c - 'a') >= 0 && (c - 'a') < 26) {
                freq[c - 'a']++;
            }
        }
        return freq;
    }

    private static boolean matches(int[] freq, int[] freqIn) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0 && freqIn[i] > 0) {
                return false;
            } else if (freq[i] < freqIn[i]) {
                return false;
            }
        }
        return true;
    }

    // test only
    public static void main(String[] args) {
        String random = getRandomLetters();

        System.out.println("GENERATED LETTERS: " + random + "");

        List<String> lowercased = dictionary
                .stream()
                .map(s -> s.toLowerCase())
                .filter(s -> s.chars().allMatch(Character::isLetter))
                .collect(Collectors.toList());

        System.out.println("Read " + lowercased.size() + " words.");

        findOptions(random, lowercased);
    }
}
