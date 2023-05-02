package com.java.fingrp7_java.gui_package.clientController;

import WordyGame.NoPlayersAvailable;
import WordyGame.WordyGameServer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Wordy_MainPageController implements Initializable {

    @FXML
    private Button logOutButton;

    @FXML
    private Button playGameButton;

    @FXML
    private Text playerName;

    @FXML
    private Text playerStatus;

    @FXML
    private Button topLongestWords;

    @FXML
    private Button topPlayers;

    public static int playerID;
    public int gameID;
    public static WordyGameServer wordyGameServer;

    @FXML
    void logOut(ActionEvent event) {

    }

    @FXML
    void playGame(ActionEvent event) {
        if (wordyGameServer != null) {
            if (playerID != 0) {
                try {



//                    matchMakingController.decline.fire();

                    gameID = wordyGameServer.playGame(playerID);

                    if (gameID !=0) {
                        System.out.println("game id check");
                        playGameButton.getScene().getWindow().hide();

                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("/com/java/fmxl/inGame.fxml"));

                        Wordy_InGameController.wordyGameServer = wordyGameServer;
                        Wordy_InGameController.gameID = gameID;
//                        Wordy_InGameController.userID = Integer.parseInt(playerID.getText());

                        Parent root = loader.load();
                        Scene scene = new Scene(root);
                        Stage stage = (Stage) playGameButton.getScene().getWindow();
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
        } else {
            System.out.println("orb not read");
        }
    }

    @FXML
    void showTopLongestWords(ActionEvent event) {

    }

    @FXML
    void showTopPlayers(ActionEvent event) {

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

        playerName.setText(String.valueOf(playerID));
    }
}
