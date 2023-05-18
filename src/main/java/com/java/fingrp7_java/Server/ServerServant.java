package com.java.fingrp7_java.Server;


import WordyGame.*;
import WordyGame.Game;
import com.java.fingrp7_java.gui_package.clientController.Wordy_MainPageController;
import com.java.fingrp7_java.gui_package.clientController.Wordy_MatchMakingController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ServerServant extends WordyGameServerPOA {
    static ArrayList<WordyGame.Game> games = new ArrayList<>();
    static private final int WORD_LIMIT = 5;
    static int roundNumber;

    static WordyGame.Game game;
    static char[] charArray = new char[17];
    ScheduledExecutorService scheduler;
    DataAccessClass dataAccessClass = new DataAccessClass();
    public ArrayList<Word> words;
    public ArrayList<String> strings = new ArrayList<>();


    @Override
    public void login(String username, String password) throws InvalidCredentials, UserAlreadyLoggedIn, InvalidPassword, ServerUnavailable {
//        try {
        int loginStatus = dataAccessClass.checkCredentials(username, password);
/*
            switch (loginStatus) {
                default:
                    System.out.println("USER: " + username + " HAS SUCCESSFULLY LOGGED IN!");
                    break;
                case 1:
                    System.out.println("USER: " + username + " IS ATTEMPTING TO LOG IN TO AN ONLINE ACCOUNT!");
                    throw new UserAlreadyLoggedIn("Already logged in!");
                case 2:
                    System.out.println("USER: " + username + " TRIED TO LOG IN WITH THE WRONG PASSWORD: " + password);
                    throw new InvalidPassword("Invalid password! Try again.");
                case 3:
                    System.out.println("LOG IN ATTEMPT BY " + username + " WITH THE PASSWORD " + password);
                    throw new InvalidCredentials("Invalid credentials! Try again.");
            }
        } catch (UserAlreadyLoggedIn | InvalidPassword | InvalidCredentials e ) {
            if (e instanceof UserAlreadyLoggedIn) {
                throw new UserAlreadyLoggedIn("Already logged in!");
            } else if (e instanceof InvalidPassword) {
                throw new InvalidPassword("Invalid password! Try again.");
            } else {
                throw new InvalidCredentials("Invalid credentials! Try again.");
            }
        }*/
    }

    @Override
    public void logout(int userID) {
        dataAccessClass.setStatusOffline(userID);
        System.out.println("USER: " + userID + " HAS SUCCESSFULLY LOGGED OUT!");
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
        System.out.println("clicked");

        scheduler = Executors.newScheduledThreadPool(10);
//        scheduler.scheduleAtFixedRate(tenSecondGameTimer, 0,1, TimeUnit.SECONDS);;
        do {

            if (games.size() == 0) {
                System.out.println("First game of the day");
                try {
                    games.add(new Game(dataAccessClass.getGameID(), userID));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                game = games.get(0);
                System.out.println(game.gameID);
                game.wgPlayers.add(wordyGamePlayer);
                Wordy_MainPageController wordyMainPageController = new Wordy_MainPageController();
                wordyMainPageController.gameID = game.gameID;
                roundNumber = 1;
                if (game.tenSecondGameTimer()) {
                    if (game.gameID == 0) {
                        games.remove(game);
                        System.out.println(games.size());
                        throw new NoPlayersAvailable("No other players have joined the game.");
                    }
                    if (game.timerCounter == 0) {
                        game.scheduler.shutdown();
                        if (!game.players.contains(userID))
                            game.players.add(userID);

                        return game.gameID;
                    }
                }else if (game.gameID == 0) {
                    games.remove(game);
                    throw new NoPlayersAvailable("No other players have joined the game.");
                }
            } else if (game.timerCounter == 0) {
                try {
                    games.add(new Game(dataAccessClass.getGameID(), userID));
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                game = games.get(games.size()-1);
                System.out.println("G id" + game.gameID);
                game.wgPlayers.add(wordyGamePlayer);
                Wordy_MainPageController wordyMainPageController = new Wordy_MainPageController();
                wordyMainPageController.gameID = game.gameID;
                roundNumber =1;

                if (game.tenSecondGameTimer()) {
                    if (game.timerCounter == 0) {
                        scheduler.shutdown();
                        game.scheduler.shutdown();
                        if (game.gameID == 0) {
                            games.remove(game);
                            System.out.println("removing 12");
                            throw new NoPlayersAvailable("No other players have joined the game.");
                        }
                        games.get(games.size()-1).wgPlayers.add(wordyGamePlayer);
                        return game.gameID;
                    }
                }
            } else {
                for (Game g :
                        games) {
                    if (g.status.equals("Waiting") && !g.players.contains(userID)) {
                        g.players.add(userID);
                        g.wgPlayers.add(wordyGamePlayer);
                        game = g;

                        System.out.println(game.wgPlayers.size());

                        if (game.timerCounter == 0) {
                            scheduler.shutdown();
                            game.scheduler.shutdown();

                            return game.gameID;
                        }
                        break;
                    } else if (games.get(games.size() - 1) == g && !g.players.contains(userID)) {
                        try {
                            games.add(new Game(dataAccessClass.getGameID(), userID));
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                        game = games.get(games.size()-1);
                        System.out.println("Gz id" + game.gameID);
                        game.wgPlayers.add(wordyGamePlayer);
                        Wordy_MainPageController wordyMainPageController = new Wordy_MainPageController();
                        wordyMainPageController.gameID = game.gameID;
                        if (game.tenSecondGameTimer()) {
                            if (game.timerCounter == 0) {
                                scheduler.shutdown();
                                game.scheduler.shutdown();
                                if (game.gameID == 0) {
                                    System.out.println("removing 1");
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
                roundNumber =1;
            }
        } while (game.timerCounter != 0);
        if (game.gameID == 0) {
            games.remove(game);
        }
        System.out.println(game.gameID);
        return game.gameID;
    }

    @Override
    public String ready(int userID, int gameID) {
        for (Game g :
                games) {
            if (g.gameID == gameID) {
                for (WordyGamePlayer wgp :
                        g.wgPlayers) {
                    if (wgp.id == userID) {
                        wgp.status = "ready";
                        break;
                    }
                }
            }
        }

        return "ready";
    }

    @Override
    public void checkWord(String word, int gameID, int userID) throws InvalidWord, WordLessThanFiveLetters, ExceededTimeLimit {
        char [] letters;
        StringBuilder sb = new StringBuilder();
        for (Game g :
                games) {
            if (g.gameID == gameID) {

                try {
                    if (g.lettersPerRound.get(g.round) == null)
                        throw new ExceededTimeLimit("Exceeded Time Limit.");

                    letters = g.lettersPerRound.get(g.round);

                    for (char c :
                            letters) {
                        sb.append(c);
                    }

                    List<String> listOfValidWords = LetterGenerator.
                            getWords(sb.toString());

                    if (word.length() < WORD_LIMIT) {
                        throw new WordLessThanFiveLetters("Word should be 5 letters or more");
                    } else if (!listOfValidWords.contains(word)) {
                        throw new InvalidWord("Invalid word.");
                    }

                }catch (ExceededTimeLimit | InvalidWord | WordLessThanFiveLetters e) {
                    if (e instanceof ExceededTimeLimit)
                        throw new ExceededTimeLimit("Exceeded Time Limit.");
                    else if (e instanceof WordLessThanFiveLetters)
                        throw new WordLessThanFiveLetters("Word should be 5 letters or more");
                    else
                        throw new InvalidWord("Invalid word.");
                }

                System.out.println("valid word");
                dataAccessClass.writeToWord(g.gameID, g.round, userID, word);

            }
        }

    }

    @Override
    public int getRound(int gameID) {
        for (Game g :
                games) {
            if (gameID == g.gameID) {
                return g.round;
            }
        }
        return 0;
    }

    @Override
    public String checkMatchStatus(int gameID) {
        for (Game g :
                games) {
            if (g.gameID == gameID) {
                if (g.winner != null) {

                    return String.valueOf(g.winner.id);
                }
                for (WordyGamePlayer wgp :
                        g.wgPlayers) {
                    if (wgp.status.equalsIgnoreCase("ready")) {
                        return wgp.status;
                    }
                }
            }
        }
        return "";
    }

    @Override
    public char[] requestLetters(int gameID) {
        StringBuilder sb = new StringBuilder();
        List<String> words = null;

        for (int i = 0; i < games.size(); i++) {
            Game g = games.get(i);
            if (g.gameID == gameID) {
                game = g;
                if (g.roundStat)
                    break;
                if (g.lettersPerRound.get(g.round) == null) {
                    System.out.println("populating round " + g.round);
                    LetterGenerator.getRandomLetters().getChars(0,17, charArray, 0);
                    g.lettersPerRound.put(g.round, charArray);
                    for (char c :
                            charArray) {
                        sb.append(c);
                    }
                    charArray = g.lettersPerRound.get(g.round);
                }else {
                    charArray = g.lettersPerRound.get(g.round);
                }

                words = LetterGenerator.getWords(sb.toString());

                if (g.scheduler.isShutdown() && g.timerCounter == 0) {
                    if (g.playerChecker()) {
                        g.scheduler.shutdown();
                    }
                }
            }
        }

        System.out.println(words);
        return charArray;
    }

    @Override
    public int getPlayerID(String username) {
        System.out.println(username + " is requesting User ID: " + dataAccessClass.getUserID(username));
        return dataAccessClass.getUserID(username);
    }

    @Override
    public String checkWinner(int gameID) {
        boolean checking = false;

        for (Game g :
                games) {
            if (g.gameID == gameID) {
                game = g;
/*                    if (!checking) {
                        g.checkRoundWin();
                        checking = true;
                    }*/
                roundNumber =g.round;

                System.out.println(roundNumber + " asdas" +g.round);
                String userID = g.winnerPerRound.get(roundNumber);
                System.out.println(userID + " ito winner");
                if (g.winner== null){
                    for (WordyGamePlayer wgp :
                            g.wgPlayers) {
//                        System.out.println(wgp.id + " " + wgp.wins);
                        System.out.println(g.wgPlayers.size() + "sizee");
                        if (wgp.wins >= 3) {
                            g.winner = wgp;
                            try {
                                dataAccessClass.writeGameWinner(g.gameID, dataAccessClass.getGameWinner(wgp.id));
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        }
                        if (userID != null) {
                            if (wgp.id == Integer.parseInt(userID)) {
                                System.out.println(wgp.id + " " +wgp.wins);
                                userID = "";
                                // for tests lang
                                return String.valueOf(wgp.id);

                                // for registered users na ito
/*                                    try {
                                        return dataAccessClass.getGameWinner(wgp.id);
                                    } catch (SQLException e) {
                                        throw new RuntimeException(e);
                                    }*/
                            } else if (wgp == g.wgPlayers.get(g.wgPlayers.size() -1))
                                return "";
                        } else
                            return "draw";
                    }
                } else {
                    return "Game Over";
                }
            }
        }
        return "";
    }

    @Override
    public int getTimer(int gameID, String of) {
        if (game != null) {
            for (Game g:
                 games) {
                if (gameID == g.gameID) {
                    if (of.equalsIgnoreCase("g")) {
                        return g.timerCounter;
                    } else if (of.equalsIgnoreCase("r")) {// READY
                        return g.readyCounter;
                    } else if (of.equalsIgnoreCase("round")) {
                        return g.roundCounter;
                    }
                } else if (games.get(games.size() - 1) == g && gameID == 0) {

                    return game.timerCounter;
                }
            }
        }
        return 0;
    }

    @Override
    public TopWord[] getLongestWords() {
        return dataAccessClass.getLongestWords();
    }

    @Override
    public TopPlayer[] getTopPlayers() {
        System.out.println(Arrays.toString(dataAccessClass.getTopPlayers()));
        return dataAccessClass.getTopPlayers();
    }

}
