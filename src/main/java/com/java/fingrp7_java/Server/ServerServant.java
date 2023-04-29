package com.java.fingrp7_java.Server;


import WordyGame.*;
import WordyGame.Game;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ServerServant extends WordyGameServerPOA {
    static ArrayList<WordyGame.Game> games = new ArrayList<>();

    static WordyGame.Game game;
    ScheduledExecutorService scheduler;
    public LetterGenerator letterGenerator = new LetterGenerator();


    @Override
    public void login(String username, String password) throws InvalidCredentials, UserAlreadyLoggedIn, InvalidPassword, ServerUnavailable {

    }

    @Override
    public void logout(int userID) {

    }

    /**
     *
     * @param userID
     * @return gameID
     * @throws NoPlayersAvailable
     */
    @Override
    public int playGame(int userID) throws NoPlayersAvailable {

        WordyGamePlayer wordyGamePlayer = new WordyGamePlayer(userID);

        scheduler = Executors.newScheduledThreadPool(10);
//        scheduler.scheduleAtFixedRate(tenSecondGameTimer, 0,1, TimeUnit.SECONDS);;
        do {
            if (games.size() == 0) {
                game = new Game();
                System.out.println("First game of the day");
                games.add(new Game(games.size() + 1, userID));
                game = games.get(0);

                if (game.tenSecondGameTimer()) {
                    if (game.timerCounter == 0) {
                        game.scheduler.shutdown();
                        if (game.gameID == 0) {
                            games.remove(game);
                            throw new NoPlayersAvailable("No other players have joined the game.");
                        }
                        games.get(0).wgPlayers.add(wordyGamePlayer);
                        return game.gameID;
                    }
                }
            } else {
                for (Game g :
                        games) {
                    if (g.status.equals("Waiting") && !g.players.contains(userID)) {
                        System.out.println("join lang");
                        g.players.add(userID);
                        g.wgPlayers.add(wordyGamePlayer);

                        if (game.timerCounter == 0) {
                            scheduler.shutdown();
                            game.scheduler.shutdown();
                            return game.gameID;
                        }
                        break;
                    } else if (games.get(games.size() - 1) == g && !g.players.contains(userID)) {
                        System.out.println("new game");
                        game = new Game();
                        games.add(new Game(games.size() + 1, userID));
                        game = games.get(games.size()-1);
                        if (game.tenSecondGameTimer()) {
                            if (game.timerCounter == 0) {
                                scheduler.shutdown();
                                game.scheduler.shutdown();
                                if (game.gameID == 0) {
                                    games.remove(game);
                                    throw new NoPlayersAvailable("No other players have joined the game.");
                                }
                                games.get(games.size()-1).wgPlayers.add(wordyGamePlayer);
                                return game.gameID;
                            }
                        }
                        break;
                    }
                }
            }
        } while (game.timerCounter != 0);
        return game.gameID;
    }

    @Override
    public String ready(int userID, int gameID) {
        boolean checker = false;
        do {
            for (Game g :
                    games) {
                if (g.gameID == gameID) {
                    if (g.playerChecker()) {
                        checker = true;
                        break;
                    }
                }
            }


        }while (game.readyCounter!= 0 || checker);
        return "ready";
    }

    @Override
    public void checkWord(String word, int gameID, int userID) throws InvalidWord, WordLessThanFiveLetters, ExceededTimeLimit {

    }

    @Override
    public char[] requestLetters(String gameID) {
        char[] charArray = new char[17];
        LetterGenerator.getRandomLetters().getChars(0,17, charArray, 0);
        return charArray;
    }

    @Override
    public String checkWinner(String gameID) {
        return null;
    }

    @Override
    public boolean roundStatus(String gameID) {
        return false;
    }

    @Override
    public TopWord[] getLongestWords() {
        return new TopWord[0];
    }

    @Override
    public TopPlayer[] getTopPlayers() {
        return new TopPlayer[0];
    }






    @Override
    public void checkWord(String word, String gameID, int userID) throws InvalidWord, WordLessThanFiveLetters, ExceededTimeLimit {
    }
}
