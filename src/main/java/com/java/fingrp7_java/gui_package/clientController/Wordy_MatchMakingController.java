package com.java.fingrp7_java.gui_package.clientController;

import WordyGame.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Wordy_MatchMakingController implements Initializable {
    public Button decline;
    @FXML
    private Button playGame;

    @FXML
    public AnchorPane mmDialog;

    @FXML
    private Text timerText;

    public static int timer;

    public static String[] args;
    public static WordyGameServer wordyGameServer;
    public static WordyGamePlayer wordyGamePlayer;
    public int gameID;
    ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(10);


    @FXML
    void play(ActionEvent event) {

    }


    @FXML
    void closeWindow(ActionEvent event) {
        Stage stage = (Stage) decline.getScene().getWindow();
        stage.close();
    }

    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     *                  the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        scheduledExecutorService.scheduleAtFixedRate(Timer, 0, 1, TimeUnit.SECONDS);
    }

    Runnable Timer = new Runnable() {
        @Override
        public void run() {
            timerText.setText(String.valueOf(timer--));
            if (timer < 1) {
                scheduledExecutorService.shutdown();
                mmDialog.getScene().getWindow().hide();
                mmDialog.setVisible(false);
//                closeWindow(new ActionEvent());
//                decline.fire();
            }
        }
    };
}
