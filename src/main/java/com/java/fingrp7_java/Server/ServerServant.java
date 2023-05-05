package com.java.fingrp7_java.Server;


import WordyGame.*;
import WordyGame.Game;
import com.java.fingrp7_java.gui_package.clientController.Wordy_InGameController;
import com.java.fingrp7_java.gui_package.clientController.Wordy_MainPageController;
import com.java.fingrp7_java.gui_package.clientController.Wordy_MatchMakingController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ServerServant extends WordyGameServerPOA {
    static ArrayList<WordyGame.Game> games = new ArrayList<>();
    static private final int WORD_LIMIT = 5;

    static WordyGame.Game game;
    static char[] charArray = new char[17];
    ScheduledExecutorService scheduler;
    DataAccessClass dataAccessClass = new DataAccessClass();
    public ArrayList<Word> words;
    public ArrayList<String> strings = new ArrayList<>();


    @Override
    public void login(String username, String password) throws InvalidCredentials, UserAlreadyLoggedIn, InvalidPassword, ServerUnavailable {
        int loginStatus = dataAccessClass.checkCredentials(username, password);

        switch (loginStatus) {
            case 0:
                System.out.println("USER: " + username + " HAS SUCCESSFULLY LOGGED IN!");
                break;
            case 1:
                System.out.println("USER: " + username + " TRIED TO LOG IN WITH THE WRONG PASSWORD: " + password);
                throw new InvalidPassword("Invalid password! Try again.");
            case 2:
                System.out.println("LOG IN ATTEMPT BY " + username + " WITH THE PASSWORD " + password);
                throw new InvalidCredentials("Invalid credentials! Try again.");
        }
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
                Wordy_MatchMakingController.timer = game.timerCounter;

                if (game.tenSecondGameTimer()) {
                    System.out.println("tens");
                    if (game.gameID == 0) {
                        System.out.println("game will be removed from the list");
                        games.remove(game);
                        System.out.println(games.size());
                        throw new NoPlayersAvailable("No other players have joined the game.");
                    }
                    if (game.timerCounter == 0) {
                        game.scheduler.shutdown();
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
                            System.out.println("tens");
                            if (game.timerCounter == 0) {
                                scheduler.shutdown();
                                game.scheduler.shutdown();
                                if (game.gameID == 0) {
                                    System.out.println("game will be removed from the list");
                                    games.remove(game);
                                    System.out.println("size " +games.size());
                                    throw new NoPlayersAvailable("No other players have joined the game.");
                                }
                                games.get(games.size()-1).wgPlayers.add(wordyGamePlayer);
                                return game.gameID;
                            }
                        } else {
                            System.out.println("game will be removed from the list");
                            games.remove(game);
                            throw new NoPlayersAvailable("No other players have joined the game.");
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
                dataAccessClass.writeToWord(word, gameID, userID, g.round);

            }
        }

    }

    @Override
    public char[] requestLetters(int gameID) {
        StringBuilder sb = new StringBuilder();
        List<String> words = null;

        do {
            for (int i = 0; i < games.size(); i++) {
                Game g = games.get(i);
                if (g.gameID == gameID) {
                    game = g;
                    if (g.lettersPerRound.get(g.round) == null) {
                        LetterGenerator.getRandomLetters().getChars(0,17, charArray, 0);
                        g.lettersPerRound.put(g.round, charArray);
                        for (char c :
                                charArray) {
                            sb.append(c);
                        }
                    }else {
                        charArray = g.lettersPerRound.get(g.round);
                    }

//                    System.out.println("asd");
//                    System.out.println(Arrays.toString(charArray));


//                    System.out.println(sb);
                    words = LetterGenerator.getWords(sb.toString());
/*                    if (g.scheduler.isShutdown()) {
                        charArray
                    }*/

                    if (g.scheduler.isShutdown() && g.timerCounter == 0) {
                        if (g.playerChecker()) {
                            g.scheduler.shutdown();
                            if (g.winner == null) {
                                System.out.println("wala pang winner");
                                System.out.println("1"+words);
                                System.out.println(sb.toString());
                                if (g.roundTimer()) {
                                    g.scheduler.shutdown();
                                }
                                return charArray;
                            }
                        }
                    }
                }
            }


        }while (Game.readyCounter != 0);
//        System.out.println(sb.toString());
//        words = LetterGenerator.getWords(sb.toString());
        System.out.println(words);
        if (game.playerChecker()) {
            game.scheduler.shutdown();
        }

        return charArray;
    }

    @Override
    public String checkWinner(int gameID) {
        int round = 0;
        for (Game g :
                games) {
            if (g.gameID == gameID) {
                for (WordyGamePlayer wgp :
                        g.wgPlayers) {
                    if (wgp.wins>0) {
                        System.out.println(wgp.id);
                        try {
                            return dataAccessClass.getGameWinner(wgp.id);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
        return "";
    }

    @Override
    public int getTimer(String of) {
        if (game != null) {
            if (of.equalsIgnoreCase("g")) {
                return game.timerCounter;
            } else if (of.equalsIgnoreCase("r"))
                return Game.readyCounter;
        }
        return 0;
    }

    @Override
    public TopWord[] getLongestWords() {
        return new TopWord[0];
    }

    @Override
    public TopPlayer[] getTopPlayers() {
        return new TopPlayer[0];
    }

}
