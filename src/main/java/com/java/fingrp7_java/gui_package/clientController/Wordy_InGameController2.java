package com.java.fingrp7_java.gui_package.clientController;
import WordyGame.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Wordy_InGameController2 {

    @FXML
    private Text roundTimer;
    @FXML
    private TextField letter1;
    @FXML
    private TextField letter2;
    @FXML
    private TextField letter3;
    @FXML
    private TextField letter4;
    @FXML
    private TextField letter5;
    @FXML
    private TextField letter6;
    @FXML
    private TextField letter7;
    @FXML
    private TextField letter8;
    @FXML
    private TextField letter9;
    @FXML
    private TextField letter10;
    @FXML
    private TextField letter11;
    @FXML
    private TextField letter12;
    @FXML
    private TextField letter13;
    @FXML
    private TextField letter14;
    @FXML
    private TextField letter15;
    @FXML
    private TextField letter16;
    @FXML
    private TextField letter17;
    @FXML
    private TextField wordsTF;
    @FXML
    private Button ready;
    @FXML
    private Button exitGame;

    public void ready(ActionEvent actionEvent) {
    }


    public void exitGame(ActionEvent actionEvent) {
    }
}
