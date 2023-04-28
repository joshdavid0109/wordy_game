package com.java.fingrp7_java.Server;


import WordyGame.*;
import WordyGame.Game;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ServerServant extends WordyGameServerPOA {
    static ArrayList<WordyGame.Game> games = new ArrayList<>();
    static WordyGame.Game game;
    private Timer timer = new Timer();

    @Override
    public CredentialsResult login(String username, String password) {
        DataAccessClass.checkCredentials(username, password);
        return null;
    }

    @Override
    public void logout(String username) {

    }

    @Override
    public WordyGame.Game playGame(WordyGamePlayer player) {
        game = new WordyGame.Game();

        while (player.getGame() == null || player.getGame().status.equalsIgnoreCase("waiting")) {
            if (games.size() == 0) {

                System.out.println("asd");
                games.add(new WordyGame.Game(player));
                ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
                scheduler.schedule(()-> {
                    System.out.println("test scheduler");
                }, 10, TimeUnit.SECONDS);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {

                        if (games.get(0).players.size() >1) {
                            System.out.println("Match Starting");
                            games.get(0).status = "Match Started";
                            games.get(0).gameID =String.valueOf(games.size());
                            game = games.get(0);
                            player.setGame(game);
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
            } else {
                for (WordyGame.Game g :
                        games) {
                    if (g.status.equals("Waiting") && !g.players.contains(player)) {
//                            System.out.println("join lang");
                        g.players.add(player);


                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                if (!g.status.equals("Waiting")) {
                                    game = g;
                                    player.setGame(game);
                                }
                            }
                        }, 10 * 1000);
                        break;
                    } else if (games.get(games.size() - 1) == g && !g.players.contains(player)) {
                        System.out.println("new game");
                        games.add(new Game(player));
                        timer.schedule(new TimerTask() {
                            @Override
                            public void run() {
                                if (games.get(games.size() - 1).players.size() > 1) {
                                    System.out.println("Match starting");
                                    games.get(games.size() - 1).status = "Match Started";
                                    games.get(games.size() - 1).gameID = String.valueOf(games.size());
                                    game = games.get(games.size() - 1);
                                    player.setGame(game);
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
        }

        if (game.players.size() == 0) {
            try {
                games.get(0).status = "";
                throw new NoPlayersAvailable("No other players have joined the game");
            } catch (NoPlayersAvailable e) {
                throw new RuntimeException(e);
            }
        }else
            return game;
//        throw new RuntimeException();
    }

    @Override
    public WordValidation checkWord(String word) {
        FileReader file = null;
        /*try {
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
        }*/

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
