/*
package com.java.fingrp7_java;

import WordyGame.WordyGamePlayer;
import com.java.fingrp7_java.Server.LetterGenerator;
import com.java.fingrp7_java.Server.Word;

import java.util.*;

public class Tester {
    public static void main(String[] args) {
        int gameID = 1;
        int round = 1;
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(1, 1, 2323, "hello"));
        words.add(new Word(1,1, 4444, "hello"));
        for (Word w :
                words) {
            if (w.getGameID() == gameID) {
                if (w.getRoundNum() == round) {

                    for (String winnerWord : winnerWords) {
                        if (w.getWord().equals(winnerWord)) {

                            for (WordyGamePlayer wgp :
                                    wgPlayers) {
                                wgp.status = "";
                                if (w.getUserID() == wgp.id) {
                                    winnerPerRound.put(round, String.valueOf(wgp.id));
                                    dataAccessClass.writeToRound(gameID, round, wgp.id, winnerWord);

                                    break;
                                }
                            }

                        }
                    }
                }
            }
        }
        System.out.println(strings);
    }
}

*/
