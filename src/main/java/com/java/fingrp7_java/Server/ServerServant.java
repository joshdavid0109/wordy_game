package com.java.fingrp7_java.Server;


import WordyGame.*;
import WordyGame.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ServerServant extends WordyGameServerPOA {
    static ArrayList<WordyGame.Game> games = new ArrayList<>();
    static private final int WORD_LIMIT = 5;

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

        return "ready";
    }

    @Override
    public void checkWord(String word, int gameID, int userID) throws InvalidWord, WordLessThanFiveLetters, ExceededTimeLimit {
        List<String> yungValidWordsDito = LetterGenerator.
                getWords("loop games para makuha game, tas check yung word sa round");//paano kunin yung list ng valid words
        if(word.length()<WORD_LIMIT){
            throw new WordLessThanFiveLetters("Word should be 5 letters or more");
        }
        if(yungValidWordsDito.contains(word)){
            throw new InvalidWord("word is invalid.");
        }
        int score = word.length();
        //assign score sa userid, query sa database or sum
    }

    @Override
    public char[] requestLetters(String gameID) {
        char[] charArray = new char[17];
        LetterGenerator.getRandomLetters().getChars(0,17, charArray, 0);

        do {
            for (Game g :
                    games) {
                if (g.gameID == Integer.parseInt(gameID)) {
                    g.lettersPerRound.put(1, charArray);
                    for (WordyGamePlayer wgp:
                         g.wgPlayers) {
                        if (!wgp.status.equalsIgnoreCase("ready")) {
                            break;
                        }
                    }
                    if (g.playerChecker()) {
                        if (g.winnerID == 0) {
                            return g.lettersPerRound.get(g.round);
                        }
                    }
                }
            }


        }while (game.readyCounter!= 0);
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
