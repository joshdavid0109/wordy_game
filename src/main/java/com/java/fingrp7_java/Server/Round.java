package com.java.fingrp7_java.Server;

import WordyGame.WordyGamePlayer;

import java.util.ArrayList;
import java.util.List;

import com.java.fingrp7_java.Server.*;

public class Round {
    ArrayList<String> arrayListOfPlayers = new ArrayList<>();
    WordyGamePlayer roundWinner = null;
    private List<String> possibleWords;
    private String letters;
    private int Round;

    public Round() {
        this.letters = LetterGenerator.getRandomLetters();
        this.possibleWords = LetterGenerator.getWords(letters);
        //this.Round = 0;
    }

    public List<String> getPossibleWords() {
        return possibleWords;
    }

    public String getLetters() {
        return letters;
    }

    public void setRoundWinner(WordyGamePlayer roundWinner) {
        this.roundWinner = roundWinner;
    }

}
