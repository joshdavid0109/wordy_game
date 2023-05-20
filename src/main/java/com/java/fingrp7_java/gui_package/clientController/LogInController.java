package com.java.fingrp7_java.gui_package.clientController;

import WordyGame.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import jdk.nashorn.internal.ir.EmptyNode;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;


import java.awt.*;
import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.ResourceBundle;

public class LogInController implements Initializable {
    public TextField usernameTF;
    public TextField passwordTF;
    public PasswordField passwordHide;


    @FXML
    private Button enterButton;

    @FXML
    private CheckBox showPasswordCB;


    public static String[] args;
    public static WordyGameServer wordyGameServer;

    @FXML
    void logIn(ActionEvent event) {
        try {
            String username = usernameTF.getText();
            String password = (passwordTF.getText() == null ? passwordTF.getText() : passwordHide.getText());
            boolean loginStatus = true;

            if (!usernameTF.getText().equals("")) {

                try {
                    wordyGameServer.login(username, password);
                } catch (UserAlreadyLoggedIn | InvalidCredentials | InvalidPassword e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
                    alert.show();

                    usernameTF.clear();
                    passwordHide.clear();
                    loginStatus = false;
                }

                if (loginStatus) {
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/com/java/fmxl/mainPage.fxml"));
                    Wordy_MainPageController wordyMainPageController = new Wordy_MainPageController();
                    Wordy_MainPageController.wordyGameServer = wordyGameServer;
                    Wordy_MatchMakingController.wordyGameServer = wordyGameServer;
                    Wordy_MainPageController.playerID = wordyGameServer.getPlayerID(username);
//                    Wordy_MainPageController.playerID = Integer.parseInt(usernameTF.getText());
                    Parent root = null;
                    try {
                        root = loader.load();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) enterButton.getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();

                    stage.setOnCloseRequest(windowEvent ->
                            wordyMainPageController.onShutDown());

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Server currently unavailable!");
            alert.showAndWait();
        }
    }

    @FXML
    void showPassword(ActionEvent event) {
        if(showPasswordCB.isSelected()) {
            passwordTF.setText(passwordHide.getText());
            passwordTF.setVisible(true);
            passwordHide.setVisible(false);
        } else {
            passwordHide.setText(passwordTF.getText());
            passwordHide.setVisible(true);
            passwordTF.setVisible(false);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

            /**
             * Default codes for
             */
            // create and initialize ORB
            ORB orb = ORB.init(args, null);

            // get the root naming context
            org.omg.CORBA.Object objectRef = orb.resolve_initial_references("NameService");

            // Use NamingContextExt which is part of the Interoperable Naming Service (INS) specs
            NamingContextExt namingContextExt = NamingContextExtHelper.narrow(objectRef);

            // bind the Object reference in Namin
            String stub = "Hello";

            LogInController.wordyGameServer = WordyGameServerHelper.narrow(namingContextExt.resolve_str(stub));

            usernameTF.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    if (event.getCode().equals(KeyCode.ENTER))
                        logIn(new ActionEvent());
                }
            });

            passwordTF.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    if (event.getCode().equals(KeyCode.ENTER))
                        logIn(new ActionEvent());
                }
            });

            passwordHide.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent event) {
                    if (event.getCode().equals(KeyCode.ENTER))
                        logIn(new ActionEvent());
                }
            });

        } catch (NotFound | CannotProceed | InvalidName | org.omg.CORBA.ORBPackage.InvalidName e) {
            throw new RuntimeException(e);
        }
    }
}
