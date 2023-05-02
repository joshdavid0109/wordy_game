package com.java.fingrp7_java.Server;


import WordyGame.TopWord;

import java.sql.*;

public class DataAccessClass {
    static Connection connection;


    public DataAccessClass() {
        try {
            getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeToWord(String word, int gameID, int userID, int round) {
        String query = "INSERT INTO words (gameID, roundNum, userID, words) VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            preparedStatement.setString(1, String.valueOf(gameID));
            preparedStatement.setString(2, String.valueOf(round));
            preparedStatement.setString(3, String.valueOf(userID));
            preparedStatement.setString(4, word);

            preparedStatement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void writeToRound(String gameID, int roundNum, String roundWinner, String longestWord) {
        String query = "INSERT INTO round (gameID, roundNum, roundWin, longestWord) VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            preparedStatement.setString(1, gameID);
            preparedStatement.setString(2, String.valueOf(roundNum));
            preparedStatement.setString(3, roundWinner);//userID yung roundWinner
            preparedStatement.setString(4, longestWord);

            preparedStatement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void writeGameWinner(String gameID, int userID) {
        String query = "INSERT INTO game (gameID, userID) VALUES (?, ?)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            preparedStatement.setString(1, gameID);
            preparedStatement.setString(2, String.valueOf(userID));

            preparedStatement.executeQuery();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static TopWord[] getLongestWords() {
        int TOP_LIMIT = 5;
        String query = "SELECT top 5 words, userID FROM word";
        TopWord[] topWords = null;

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet rs  = preparedStatement.executeQuery();
            //rs to TopWord object
        }catch (SQLException e){
            e.printStackTrace();
        }

/*        topWords = new TopWord();*/
        return topWords;
    }

    public static void main(String[] args) {
        /*try {
            getConnection();
            getLongestWords();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
    }

    public static void getConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wordy", "root", "");
    }

    public static int checkCredentials(String username, String password) {
        String query = "SELECT * FROM USERS where username=? AND password=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                //query returned; log in OK:)
                return 2;
            } else
            {
                //no match sa db; login invalid
                return 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
