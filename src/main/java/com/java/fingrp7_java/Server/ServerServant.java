package com.java.fingrp7_java.Server;

import WordyGame.LoginResult;
import WordyGame.WordyGameServerPOA;

public class ServerServant extends WordyGameServerPOA {

    @Override
    public LoginResult login(String username, String password) {
        return null;
    }

    @Override
    public void logout(String username) {

    }

    @Override
    public void playGame(String username) {

    }

    @Override
    public String[] getLongestWords() {
        return new String[0];
    }

    @Override
    public String[] getTopPlayers() {
        return new String[0];
    }
}
