package com.java.fingrp7_java.Server;

import java.io.Serializable;

public class TopFiveLongestWord implements Serializable {

    private String userName;
    private String words;


    public TopFiveLongestWord() {
        this.userName = userName;
        this.words = words;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }
}
