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
    public Button closeButton;
    @FXML
    private Button playGame;

    @FXML
    private Text timerText;

    public static int timer;

    public static String[] args;
    public static WordyGameServer wordyGameServer;
    public static WordyGamePlayer wordyGamePlayer;
    public static int gameID;
    public ScheduledExecutorService scheduledExecutorService;

    @FXML
    public void closeWindow(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
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
        scheduledExecutorService = new ScheduledThreadPoolExecutor(10);
        scheduledExecutorService.scheduleAtFixedRate(Timer, 0, 1, TimeUnit.SECONDS);

    }

    Runnable Timer = new Runnable() {
        @Override
        public void run() {
            timer = wordyGameServer.getTimer(0, "g");

            timerText.setText(String.valueOf(timer));
            System.out.println(timer);
            if (timer < 1) {
                scheduledExecutorService.shutdown();
                Stage stage = (Stage) decline.getScene().getWindow();
                stage.close();
//                closeWindow(new ActionEvent());
//                decline.fire();
            }
        }
    };

    public boolean timerCheck()  {
        while (!scheduledExecutorService.isShutdown()) {
            if (scheduledExecutorService.isShutdown()) {
                if (Wordy_MatchMakingController.timer == 0) {
                    System.out.println("zero na");
                }
                return true;
            }
        }
        return false;
    }

}
