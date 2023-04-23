package com.java.fingrp7_java.Server;


import WordyGame.*;
import org.omg.PortableServer.Servant;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ServerServant extends WordyGameServerPOA {
    static ArrayList<Game> games = new ArrayList<>();
    @Override
    public CredentialsResult login(String username, String password) {
        return null;
    }

    @Override
    public void logout(String username) {

    }

    @Override
    public LobbyStatus playGame(WordyGamePlayer player) {
        if (games.size() == 0) {
            games.add(new Game(player));
            return LobbyStatus.NEW_GAME;
        } else {

            for (Game game :
                    games) {
                if (game.getStatus().equals("Waiting")) {
                    game.getClients().add(player);
                    return LobbyStatus.JOINED_A_GAME;
                } else if (games.get(games.size()-1) == game) {
                    games.add(new Game(player));
                    return LobbyStatus.NEW_GAME;
                }
            } }
        games.add(new Game(player));
        return LobbyStatus.NEW_GAME;
//        throw new RuntimeException();
    }

    @Override
    public WordValidation checkWord(String word) {
        FileReader file = null;
        try {
            file = new FileReader("com/java/fingrp7_java/words.txt");

            BufferedReader bufferedReader = new BufferedReader(file);
            String string;
            if (word.length() < 5) {
                return WordValidation.WORD_LESS_THAN_FIVE_LETTERS;
            }

            while ((string = bufferedReader.readLine())!= null) {
                if (word.equals(string)) {
                    return WordValidation.VALID_WORD;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return WordValidation.INVALID_WORD;
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
