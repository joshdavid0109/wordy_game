package com.java.fingrp7_java.gui_package.clientController;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.awt.*;

public class Wordy_MainPageController {

    @FXML
    protected Text playerName;
    @FXML
    protected Text playerStatus;
    @FXML
    protected Button playGame;
    @FXML
    protected Button topPlayers;
    @FXML
    protected Button topLongestWords;
    @FXML
    protected Button logout;

    @FXML
    void playGame(MouseEvent event) {
        System.out.println("hi");
    }

    @FXML
    void showTopPlayers(MouseEvent event) {

    }

    @FXML
    void showTopLongestWords(MouseEvent event) {

    }

    @FXML
    void logout(MouseEvent event) {

    }
}
