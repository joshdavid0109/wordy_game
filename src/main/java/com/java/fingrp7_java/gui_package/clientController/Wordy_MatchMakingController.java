package com.java.fingrp7_java.gui_package.clientController;

import WordyGame.WordyGameServer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.awt.event.ActionEvent;

public class Wordy_MatchMakingController {
    @FXML
    private Text playerID;

    @FXML
    private Button readyButton;

    public WordyGameServer wordyGameServer;

    @FXML
    void ready(ActionEvent event) {

    }
}
