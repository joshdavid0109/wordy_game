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
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.ResourceBundle;

public class LogInController implements Initializable {
    public TextField usernameTF;
    public PasswordField passwordTF;
    /**
     * Called to initialize a controller after its root element has been
     * completely processed.
     *
     * @param location  The location used to resolve relative paths for the root object, or
     * <tt>null</tt> if the location is not known.
     * @param resources The resources used to localize the root object, or <tt>null</tt> if
     * the root object was not localized.
     */


    @FXML
    private Button enterButton;


    @FXML
    private CheckBox showPasswordCB;


    public static String[] args;
    public static WordyGameServer wordyGameServer;

    @FXML
    void logIn(ActionEvent event) {
        if (!usernameTF.getText().equals("")) {
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource("/com/java/fmxl/mainPage.fxml"));
            Wordy_MainPageController wordyMainPageController = new Wordy_MainPageController();

/*
            String username = usernameTF.getText();
            String password = passwordTF.getText();

            int UID;

            try {
                wordyGameServer.login(username, password);
            } catch (UserAlreadyLoggedIn e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, e.reason);
                alert.showAndWait();
            } catch (InvalidPassword e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, e.reason);
                alert.showAndWait();
            } catch (InvalidCredentials e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, e.reason);
                alert.showAndWait();
            } catch (ServerUnavailable e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, e.reason);
                alert.showAndWait();
            }
*/




            Wordy_MainPageController.wordyGameServer = wordyGameServer;

            // TODO: how do i get uid, help
            // use username: 456 and password: 55555 for now to continue to the main page
            Wordy_MainPageController.playerID = Integer.parseInt(usernameTF.getText());

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

/*            stage.setOnCloseRequest(windowEvent ->
            {
                wordyMainPageController.onShutDown();
            });*/

        }
    }

    @FXML
    void showPassword(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

            System.out.println(Arrays.toString(args) + "args");
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

        } catch (NotFound | CannotProceed | InvalidName | org.omg.CORBA.ORBPackage.InvalidName e) {
            throw new RuntimeException(e);
        }
    }
}
