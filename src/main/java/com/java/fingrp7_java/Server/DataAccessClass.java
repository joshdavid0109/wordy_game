package com.java.fingrp7_java.Server;


import WordyGame.ServerUnavailable;
import WordyGame.TopPlayer;
import WordyGame.TopWord;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;


public class DataAccessClass {
    static Connection connection;


    public DataAccessClass() {
        try {
            getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeToWord(int gameID, int roundID,int userID, String word) {
        String query = "INSERT INTO word (gameID, roundNo, userID, words) VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            preparedStatement.setInt(1, gameID);
            preparedStatement.setInt(2, roundID);
            preparedStatement.setInt(3, userID);
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

    public void writeGameWinner(int gameID, String gameWinner) {
        String query = "UPDATE game set gameWinner = ? WHERE gameID =?";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            preparedStatement.setString(1, gameWinner);
            preparedStatement.setInt(2, gameID);

            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void writeGame(int gameID) {
        String query = "INSERT INTO game (gameID) VALUES (?)";

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            preparedStatement.setInt(1, gameID);

            preparedStatement.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public TopWord[] getLongestWords() {
//        int TOP_LIMIT = 5;
//
///*        String query = "SELECT top 5 words, userID FROM word";*/
//
//        // SELECT userID, words FROM word
//        // WHERE LENGTH(words) =
//        // (SELECT MIN(LENGTH(words)) FROM word)
//        // ORDER BY words;
//        String query = "SELECT userId, words FROM word WHERE LENGTH(words) = " +
//                "(SELECT MIN(LENGTH(words) FROM word) ORDER BY words;";
//        TopWord[] topWords = null;
//
//        PreparedStatement preparedStatement = null;
//        try {
//            preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
//
//            ResultSet rs  = preparedStatement.executeQuery();
//            //rs to TopWord object
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//
//
////        topWords = new TopWord();

        String query = "SELECT username, words FROM users NATURAL JOIN word ORDER BY LENGTH(words) DESC LIMIT 5;";

        TopWord[] topWords = new TopWord[5];

        PreparedStatement ps;

        try {
            ps = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery();
//            int i = 0;

//            while (rs.next()) {
//                topWords[i] = new TopWord(rs.getString(1), rs.getString(2));
//                i++;
////                System.out.println(rs.getString("username") + " " + rs.getString("words"));
//            }

            for (int i = 0; i < topWords.length; i++) {
                if (rs.next()) {
                    topWords[i] = new TopWord(rs.getString("username"), rs.getString("words"));
                    System.out.println(rs.getString(1) + " " + rs.getString(2));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return topWords;
    }

    public static void main(String[] args) {
        DataAccessClass dataAccessClass = new DataAccessClass();
        dataAccessClass.run();
    }

    public void run(){

//        writeToRound(123, 1, 2234423, "longestto");

        System.out.println(Arrays.toString(getTopPlayers()));
    }

    public void getConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wordy_schema", "root", "");
    }

    void setStatusOffline(int uid) {
        String query = "UPDATE users SET isOnline = 0 WHERE userID = ?";
        PreparedStatement ps;

        try {
            ps = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setInt(1, uid);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    int checkCredentials(String username, String password) {
        String query = "SELECT * FROM USERS WHERE username = ?";
        String query2 = "SELECT * FROM USERS WHERE password = ?";
        String query3 = "SELECT * FROM USERS WHERE username = ? AND password = ? AND isOnline = 0";
        String query4 = "UPDATE users SET isOnline = 1 WHERE username = ? AND password = ?";
        PreparedStatement ps;
        try {
            ps = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ps = connection.prepareStatement(query2, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ps.setString(1, password);

                ResultSet rs1 = ps.executeQuery();

                if (rs1.next()) {
                    ps = connection.prepareStatement(query3, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                    ps.setString(1, username);
                    ps.setString(2, password);

                    ResultSet rs2 = ps.executeQuery();

                    if (rs2.next()) {
                        // set status to 1 - which means user is now online
                        ps = connection.prepareStatement(query4, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        ps.setString(1, username);
                        ps.setString(2, password);
                        ps.executeUpdate();

                        // successful login
                        return 0;
                    } else {
                        // throw UserAlreadyLoggedIn exception
                        return 1;
                    }
                } else {
                    // throw InvalidPassword exception
                    return 2;
                }
            } else {
                // throw InvalidCredentials exception
                return 3;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    int getUserID(String username) {
        String query = "SELECT * FROM USERS WHERE username = ?";
        PreparedStatement ps;

        try {
            ps = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("userID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
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

    public int getGameID() throws SQLException{
        String q  = "Select * from game";
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE  );
        ResultSet resultSet = statement.executeQuery(q);
        int count = 0;

        while (resultSet.next()) {
            count++;
        }

        return count+1;
    }

    public void insertGameObject(int gameID) throws SQLException{
        String q = "insert into game(gameID, gameWinner) values (?, NULL)";

        PreparedStatement preparedStatement = connection.prepareStatement(q, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        preparedStatement.setInt(1, gameID);
        preparedStatement.execute();
    }

    public TopPlayer[] getTopPlayers() {
        String query = "select ROW_NUMBER() over (ORDER BY gwc.wins desc) as 'Rank', gameWinner, wins from " +
                "(select gameWinner, count(gameWinner) as 'wins' from game group by gameWinner) as gWc order by gwc.wins desc limit 5";
        String q = "select ROW_NUMBER() over (ORDER BY gwc.wins desc) as 'Rank', gameWinner, wins from " +
                "(select gameWinner, count(gameWinner) as 'wins' from game group by gameWinner) as gWc order by gwc.wins desc limit 5";

        PreparedStatement ps;
        TopPlayer[] topPlayers = new TopPlayer[0];

        try {
            ps = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = ps.executeQuery();
            ps = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet res = ps.executeQuery();
            int c = 0;
            while (res.next()) {
                c++;
            }

            topPlayers = new TopPlayer[c];

            for (int i = 0; i < topPlayers.length; i++) {
                if (rs.next()) {
                    topPlayers[i] = new TopPlayer(rs.getInt(1), rs.getString(2), rs.getInt(3));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return topPlayers;
    }
}

