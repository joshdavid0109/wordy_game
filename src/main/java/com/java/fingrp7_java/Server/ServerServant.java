package com.java.fingrp7_java.Server;


import WordyGame.WordyGameServerPOA;
import org.omg.PortableServer.Servant;

public class ServerServant extends WordyGameServerPOA {
    @Override
    public WordyGame.CredentialsResult login(String username, String password) {
            if (username.equals("testuser") && password.equals("testuser"))
                return WordyGame.CredentialsResult.SUCCESS;


        return WordyGame.CredentialsResult.INVALID_CREDENTIALS;
    }

    @Override
    public void logout(String username) {

    }

    @Override
    public String[] playGame(String username) throws WordyGame.NoPlayersAvailable {


        throw new WordyGame.NoPlayersAvailable("Walang tao");
    }

    @Override
    public boolean checkWord(String word) {
        return false;
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
