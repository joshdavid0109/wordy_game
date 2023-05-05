package com.java.fingrp7_java.Server;

public class Word {
    private int gameID;
    private int roundNum;
    private int userID;
    private String word;


    public Word(int gameID, int roundNum, int userID, String word) {
        this.gameID = gameID;
        this.roundNum = roundNum;
        this.userID = userID;
        this.word = word;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public int getRoundNum() {
        return roundNum;
    }

    public void setRoundNum(int roundNum) {
        this.roundNum = roundNum;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
