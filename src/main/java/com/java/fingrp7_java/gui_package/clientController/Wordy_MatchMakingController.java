package com.java.fingrp7_java.gui_package.clientController;

import WordyGame.NoPlayersAvailable;
import WordyGame.WordyGamePlayer;
import WordyGame.WordyGameServer;
import WordyGame.WordyGameServerHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Wordy_MatchMakingController implements Initializable {
    @FXML
    private Button playGame;

    @FXML
    private TextField playerID;


    public static String[] args;
    public static WordyGameServer wordyGameServer;
    public static WordyGamePlayer wordyGamePlayer;
    public int gameID;

    @FXML
    void play(ActionEvent event) {
        if (wordyGameServer != null) {
            if (playerID != null) {
                try {
                    gameID = wordyGameServer.playGame(Integer.parseInt(playerID.getText()));

                    if (gameID !=0) {
                        System.out.println("game id check");
                        playGame.getScene().getWindow().hide();
                        FXMLLoader loader = new FXMLLoader();

                        loader.setLocation(getClass().getResource("/com/java/fmxl/inGame.fxml"));


                        Wordy_InGameController.wordyGameServer = wordyGameServer;
                        Wordy_InGameController.gameID = gameID;
                        Wordy_InGameController.userID = Integer.parseInt(playerID.getText());

                        Parent root = loader.load();
                        Scene scene = new Scene(root);
                        Stage stage = (Stage) playGame.getScene().getWindow();
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

            Wordy_MatchMakingController.wordyGameServer = WordyGameServerHelper.narrow(namingContextExt.resolve_str(stub));

        } catch (NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName e) {
            throw new RuntimeException(e);
        } catch (org.omg.CORBA.ORBPackage.InvalidName e) {
            throw new RuntimeException(e);
        }
    }
}
