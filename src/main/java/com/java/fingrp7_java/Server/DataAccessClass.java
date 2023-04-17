package com.java.fingrp7_java.Server;

import javax.xml.crypto.Data;
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
    public void getConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/comprog", "root", "");
    }


    public static int checkCredentials(String username, String password) {
        String query = "SELECT * FROM USERS where username=? AND password=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return 0 ;
    }
}
