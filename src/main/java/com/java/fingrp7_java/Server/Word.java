package com.java.fingrp7_java.Server;

public class Word {
    private int userID;
    private String word;


    public Word(int userID, String word) {

        this.userID = userID;
        this.word = word;
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
