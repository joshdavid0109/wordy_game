package com.java.fingrp7_java.gui_package.clientController;

import WordyGame.Game;
import WordyGame.NoPlayersAvailable;
import WordyGame.WordyGameServer;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


public class Wordy_MainPageController implements Initializable {

    @FXML
    private Button logOutButton;

    @FXML
    private AnchorPane mainPane;

    @FXML
    private Button playGameButton;

    @FXML
    private Text playerName;

    @FXML
    private Text playerStatus;

    @FXML
    private Button topLongestWordsBtn;

    @FXML
    private Button topPlayers;

    public static int playerID;

    public int gameID;
    public static WordyGameServer wordyGameServer;
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

    @FXML
    void playGame(ActionEvent event) throws IOException {
        if (wordyGameServer != null) {
            if (playerID != 0) {

//                    matchMakingController.decline.fire();
                    FXMLLoader loader = new FXMLLoader();

                    Runnable timer = new Runnable() {
                        @Override
                        public void run() {
                            new JFXPanel().requestFocus();

                            Platform.setImplicitExit(false);

                            Wordy_MatchMakingController.timer = wordyGameServer.getTimer();
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    FXMLLoader fxmlLoader = new FXMLLoader();
                                    fxmlLoader.setLocation(getClass().getResource("/com/java/fmxl/matchMaking.fxml"));
                                    Parent parent = null;
                                    try {
                                        parent = fxmlLoader.load();
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                    Wordy_MatchMakingController matchMakingController = fxmlLoader.<Wordy_MatchMakingController>getController();


                                    Scene scene = new Scene(parent, 400, 200);
                                    Stage stage = new Stage();
                                    stage.initStyle(StageStyle.UNDECORATED);
                                    stage.setScene(scene);
//        stage.show();
                                    stage.show();


                                }
                            });

                        }
                    };

                    Runnable playGame = new Runnable() {
                        @Override
                        public void run() {
                            try {
                                gameID = wordyGameServer.playGame(playerID);
                            } catch (NoPlayersAvailable e) {
                                throw new RuntimeException(e.reason);
                            }
                        }
                    };
                executorService.execute(playGame);
                executorService.execute(timer);







                    if (gameID !=0) {
//                        System.out.println("game id check");
                        playGameButton.getScene().getWindow().hide();


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


            }
        } else {
            System.out.println("orb not read");
        }
    }

    @FXML
    void showTopLongestWords(ActionEvent event){
        FXMLLoader showLongestWord = new FXMLLoader();

        showLongestWord.setLocation(getClass().getResource("/com/java/fmxl/longestWord.fxml"));

        Parent root = null;
        try {
            root = showLongestWord.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene scene = new Scene(root);
        Stage stage = (Stage) topLongestWordsBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void showTopPlayers(ActionEvent event) {
        FXMLLoader showTopPlayers = new FXMLLoader();

        showTopPlayers.setLocation(getClass().getResource("/com/java/fmxl/achievement.fxml"));

        Parent root = null;
        try {
            root = showTopPlayers.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene scene = new Scene(root);
        Stage stage = (Stage) topPlayers.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void logOut(ActionEvent event) {
        FXMLLoader showLongestWord = new FXMLLoader();

        showLongestWord.setLocation(getClass().getResource("/com/java/fmxl/logInPage.fxml"));

        Parent root = null;
        try {
            root = showLongestWord.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene scene = new Scene(root);
        Stage stage = (Stage) topLongestWordsBtn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
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
