package com.java.fingrp7_java.Server;


import WordyGame.*;
import WordyGame.Game;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ServerServant extends WordyGameServerPOA {
    static ArrayList<WordyGame.Game> games = new ArrayList<>();
    static WordyGame.Game game;
    private Timer timer;


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
    public String playGame(int userID) throws NoPlayersAvailable {

        timer = new Timer();
        if (games.size() == 0) {
            game = new Game();
            System.out.println("asd");
            games.add(new Game(String.valueOf(games.size() +1), userID));

            timer.schedule(new TimerTask() {
                @Override
                public void run() {

                    if (games.get(0).status.equalsIgnoreCase("match started")) {
                        System.out.println("Match Starting");
                        game = games.get(0);
                    } else if (games.get(0).status.equalsIgnoreCase("")){
                        try {
                            System.out.println("no players");
                            games.remove(game);
                            throw new NoPlayersAvailable("No other players have joined");
                        } catch (NoPlayersAvailable e) {
                            throw new RuntimeException(e.reason);
                        }
                    }
                }
            }, 10 * 1000);
        } else {
            for (Game g :
                    games) {
                if (g.status.equals("Waiting") && !g.players.contains(userID)) {
                            System.out.println("join lang");
                    g.players.add(userID);
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            if (!g.status.equals("Waiting")) {
                                game = g;
//                                player.setGame(game);
                            }
                        }
                    }, 10 * 1000);
                    break;
                } else if (games.get(games.size() - 1) == g && !g.players.contains(userID)) {
                    System.out.println("new game");
                    game = new Game();
                    games.add(new Game(String.valueOf(games.size()+1), userID));
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            if (games.get(games.size() - 1).players.size() > 1) {
                                System.out.println("Match starting");
                                games.get(games.size() - 1).status = "Match Started";
                                games.get(games.size() - 1).gameID = String.valueOf(games.size());
                                game = games.get(games.size() - 1);
                            } else {
                                games.get(games.size() - 1).status = "";
                                games.remove(game);
                                try {
                                    throw new NoPlayersAvailable();
                                } catch (NoPlayersAvailable e) {
                                    throw new RuntimeException(e);
                                }
                            }

                        }
                    }, 10 * 1000);
                    break;
                }
            }
        }
        return game.gameID;
    }

    @Override
    public void checkWord(String word, String gameID, int userID) throws InvalidWord, WordLessThanFiveLetters, ExceededTimeLimit {

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
    public void checkWord(String word, String gameID, String username) throws InvalidWord, WordLessThanFiveLetters {

    }
}
