package com.java.fingrp7_java.gui_package.clientController;

import WordyGame.WordyGameServer;
import WordyGame.WordyGameServerHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jdk.nashorn.internal.ir.EmptyNode;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;


import java.awt.*;
import java.io.IOException;
import java.net.URL;
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



            Wordy_MainPageController.wordyGameServer = wordyGameServer;
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

        }
    }

    @FXML
    void showPassword(ActionEvent event) {

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

        } catch (NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName e) {
            throw new RuntimeException(e);
        } catch (org.omg.CORBA.ORBPackage.InvalidName e) {
            throw new RuntimeException(e);
        }
    }
}
