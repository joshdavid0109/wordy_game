package com.java.fingrp7_java.gui_package.clientController;

import WordyGame.NoPlayersAvailable;
import WordyGame.WordyGamePlayer;
import WordyGame.WordyGameServer;
import WordyGame.WordyGameServerHelper;
import com.java.fingrp7_java.gui_package.client.Wordy_Ready;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Wordy_ReadyController implements Initializable {

    @FXML
    private Button readyButton;

    @FXML
    private TextField playerID;

    public static String[] args;

    public static WordyGameServer wordyGameServer;
    public static WordyGamePlayer wordyGamePlayer;
    public int gameID;
    public static Scanner scanner;

    @FXML
    void logIn(ActionEvent event) {
        if (wordyGameServer != null) {
            if (playerID != null) {
                try {
                    gameID = wordyGameServer.playGame(Integer.parseInt(playerID.getText()));

                    if (gameID !=0) {
                        FXMLLoader loader = new FXMLLoader();

                        loader.setLocation(getClass().getResource("/com/java/fmxl/matchMaking.fxml"));
                        Wordy_MatchMakingController wordy_matchMakingController = new Wordy_MatchMakingController();
                        wordy_matchMakingController.wordyGameServer = wordyGameServer;

                        Parent root = loader.load();
                        Scene scene = new Scene(root);
                        Stage stage = (Stage) readyButton.getScene().getWindow();
                        stage.setScene(scene);
                        stage.show();

                    }
                } catch (NoPlayersAvailable e) {
                    Alert dialog = new Alert(Alert.AlertType.ERROR, e.reason);
                    dialog.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
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

            Wordy_ReadyController.wordyGameServer = WordyGameServerHelper.narrow(namingContextExt.resolve_str(stub));

        } catch (NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName e) {
            throw new RuntimeException(e);
        } catch (org.omg.CORBA.ORBPackage.InvalidName e) {
            throw new RuntimeException(e);
        }
    }
}
