package com.java.fingrp7_java.gui_package.clientController;

import WordyGame.WordyGameServer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Wordy_InGameController {

    @FXML
    private Button logOut;

    @FXML
    private Text playerName;

    @FXML
    private Text playerName1;

    @FXML
    private Text playerStatus;

    @FXML
    private Text playerStatus1;

    @FXML
    private Text randomLettersText;

    @FXML
    private Button readyButton;

    @FXML
    private TextField wordsTF;

    public static int userID;

    public static int gameID;

    public static WordyGameServer wordyGameServer;

    char[] letters;

    @FXML
    void ready(ActionEvent event) {
        System.out.println(gameID);
        letters = wordyGameServer.requestLetters(String.valueOf(gameID));

        StringBuilder sb = new StringBuilder();
        for (char c :
                letters) {
            sb.append(c);
            if (c != letters[letters.length-1]) {
                sb.append(" ");
            }
        }
        randomLettersText.setText(sb.toString());
    }

}
