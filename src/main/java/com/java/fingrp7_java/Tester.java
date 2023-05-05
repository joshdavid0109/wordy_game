package com.java.fingrp7_java;

import com.java.fingrp7_java.Server.LetterGenerator;

import java.util.*;

public class Tester {
    public static void main(String[] args) {
        char[] letters = {'f', 'a', 'p', 'n', 't', 'k', 'i', 'u', 'e','h', 'k','d','r', 'j','p','z','i'};

        System.out.println(letters.length);

    StringBuilder sb  = new StringBuilder();


        for (char c :
                letters) {
            sb.append(c);
        }

        List<String> listOfValidWords = LetterGenerator.
                getWords(sb.toString());
        System.out.println(listOfValidWords);
        System.out.println(LetterGenerator.
                getWords(sb.toString()));
        System.out.println(listOfValidWords);


    }
}

