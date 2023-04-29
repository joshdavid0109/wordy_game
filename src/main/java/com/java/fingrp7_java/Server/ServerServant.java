package com.java.fingrp7_java.Server;


import WordyGame.*;
import WordyGame.Game;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ServerServant extends WordyGameServerPOA {
    static ArrayList<WordyGame.Game> games = new ArrayList<>();
    static WordyGame.Game game;
    ScheduledExecutorService scheduler;


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

        scheduler = Executors.newScheduledThreadPool(10);
//        scheduler.scheduleAtFixedRate(tenSecondGameTimer, 0,1, TimeUnit.SECONDS);;
        do {
            if (games.size() == 0) {
                game = new Game();
                System.out.println("First game of the day");
                games.add(new Game(games.size() + 1, userID));
                game = games.get(0);

                scheduler.scheduleAtFixedRate(game.tenSecondGameTimer, 1, 1, TimeUnit.SECONDS);
                if (game.timerCounter == 0) {
                    scheduler.shutdown();
                    game.scheduler.shutdown();
                }
                if (scheduler.isShutdown()) {
                    return game.gameID;
                }
            } else {
                for (Game g :
                        games) {
                    if (g.status.equals("Waiting") && !g.players.contains(userID)) {
                        System.out.println("join lang");
                        g.players.add(userID);

                        scheduler.scheduleAtFixedRate(g.tenSecondGameTimer,0,1000, TimeUnit.SECONDS);
                        if (game.timerCounter == 0) {
                            scheduler.shutdown();
                            game.scheduler.shutdown();
                        }
                        if (scheduler.isShutdown()) {
                            return game.gameID;
                        }
                    } else if (games.get(games.size() - 1) == g && !g.players.contains(userID)) {
                        System.out.println("new game");
                        game = new Game();
                        games.add(new Game(games.size() + 1, userID));
                        game = games.get(games.size()-1);
                        scheduler.scheduleAtFixedRate(game.tenSecondGameTimer,0,1000, TimeUnit.SECONDS);
                        if (game.timerCounter == 0) {
                            scheduler.shutdown();
                            game.scheduler.shutdown();
                        }
                        if (scheduler.isShutdown()) {
                            return game.gameID;
                        }

                    }
                }
            }
        } while (game.timerCounter != 0);
        return game.gameID;
    }

    @Override
    public String ready(int userID, int gameID) {
        return null;
    }

    @Override
    public void checkWord(String word, int gameID, int userID) throws InvalidWord, WordLessThanFiveLetters, ExceededTimeLimit {

    }

    @Override
    public char[] requestLetters(String gameID) {
        return new char[0];
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
