package com.java.fingrp7_java.gui_package.clientController;

import WordyGame.WordyGameServer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.text.Text;

public class Wordy_MatchMakingController {
    @FXML
    private Text playerID;

    @FXML
    private Button readyButton;

    public int gameID;

    public WordyGameServer wordyGameServer;


    public void ready(ActionEvent actionEvent) {
        wordyGameServer.requestLetters(String.valueOf(gameID));
    }

    public Text getPlayerID() {
        return playerID;
    }

    public void setPlayerID(Text playerID) {
        this.playerID = playerID;
    }

    public void setPlayerID(String text) {
        playerID.setText(text);
    }
}
