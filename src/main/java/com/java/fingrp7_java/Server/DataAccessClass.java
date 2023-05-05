package com.java.fingrp7_java.Server;


import WordyGame.InvalidCredentials;
import WordyGame.TopWord;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ResultTreeType;

import java.sql.*;
import java.util.ArrayList;

/*
public class DataAccessClass {
    static Connection connection;


    public DataAccessClass() {
        try {
            getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeToWord(String word, int gameID, int userID, int round) {
        String query = "INSERT INTO word (gameID, roundNum, userID, words) VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            preparedStatement.setString(1, String.valueOf(gameID));
            preparedStatement.setString(2, String.valueOf(round));
            preparedStatement.setString(3, String.valueOf(userID));
            preparedStatement.setString(4, word);

            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void writeToRound(int gameID, int roundNum, int roundWinner, String longestWord) {
        String query = "INSERT INTO round (gameID, roundNum, roundWin, longestWord) VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            preparedStatement.setInt(1, gameID);
            preparedStatement.setInt(2, roundNum);
            preparedStatement.setInt(3, roundWinner);//userID yung roundWinner
            preparedStatement.setString(4, longestWord);

            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void writeGameWinner(int gameID, int userID) {
        String query = "INSERT INTO game (gameID, userID) VALUES (?, ?)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            preparedStatement.setInt(1, gameID);
            preparedStatement.setString(2, String.valueOf(userID));

            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public TopWord[] getLongestWords() {
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

*/
/*        topWords = new TopWord();*//*

        return topWords;
    }

    public static void main(String[] args) {
        DataAccessClass dataAccessClass = new DataAccessClass();
        dataAccessClass.run();
    }

    public void run(){

        writeToRound(123, 1, 2234423, "longestto");

    }

    public void getConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wordy_schema", "root", "");
    }

    int checkCredentials(String username, String password) {
        String query = "SELECT * FROM USERS WHERE username = ?";
        String query2 = "SELECT * FROM USERS WHERE password = ?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ps = connection.prepareStatement(query2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setString(1, password);

                ResultSet rs1 = ps.executeQuery();

                if (rs1.next()) {
                    return 0;
                } else {
                    // throw InvalidPassword exception
                    return 1;
                }
            } else {
                // throw InvalidCredentials exception
                return 2;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Word> getWords() throws SQLException {
        ArrayList<Word> words = new ArrayList<>();
        String query = "SELECT * FROM word";
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE  );
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            words.add(new Word(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3),
                    resultSet.getString(4)));
        }
        resultSet.close();
        return words;
    }

    public String getGameWinner (int id) throws SQLException{
        String query = "SELECT username from users where userID=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getString(1);
        }

        return "";
    }
}
*/
