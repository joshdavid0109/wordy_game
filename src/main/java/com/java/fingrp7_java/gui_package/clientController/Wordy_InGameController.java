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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Wordy_InGameController implements Initializable {

    @FXML
    private Button logOut;

    @FXML
    private Text playerName;

    @FXML
    private Text playerName1;

    @FXML
    private Text playerStatus;

    @FXML
    private Text playerStatus1;

    @FXML
    private Text randomLettersText;

    @FXML
    private Button readyButton;

    @FXML
    private TextField wordsTF;

    @FXML
    private Text roundTimer;

    public static int userID;
    public static int gameID;
    public static int roundTime = 10;
    public static WordyGameServer wordyGameServer;
    char[] letters = new char[17];
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    static Wordy_MatchMakingController matchMakingController;

    @FXML
    void ready(ActionEvent event) {
        readyButton.setVisible(false);

        Runnable reqLetters = new Runnable() {
            @Override
            public void run() {
                letters = wordyGameServer.requestLetters(gameID);

                StringBuilder sb = new StringBuilder();

                if (letters != null) {
                    for (char c :
                        letters) {
                    sb.append(c);
                    if (c != letters[letters.length-1]) {
                        sb.append(" ");
                    }
                }
                    randomLettersText.setVisible(true);
                    randomLettersText.setText(sb.toString());

                if (letters != null) {
                    executorService.shutdown();
                }

                    scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
                        @Override
                        public void run() {
                            roundTimer.setText(String.valueOf(roundTime--));
                            if (roundTime < 0) {
                                System.out.println("checking winner");
                                System.out.println(wordyGameServer.checkWinner(gameID));
                                scheduledExecutorService.shutdown();

                            }
                        }
                    }, 0, 1, TimeUnit.SECONDS);

                }
            }
        };

        Runnable timer = new Runnable() {
            @Override
            public void run() {
                new JFXPanel().requestFocus();

                Platform.setImplicitExit(false);

                Wordy_MatchMakingController.timer = wordyGameServer.getTimer("r");
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        FXMLLoader fxmlLoader = new FXMLLoader();
                        fxmlLoader.setLocation(getClass().getResource("/com/java/fmxl/matchMaking.fxml"));

                        DialogPane dialogPane;
                        try {
                            dialogPane= fxmlLoader.load();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        matchMakingController = fxmlLoader.<Wordy_MatchMakingController>getController();


                        Dialog<ButtonType> dialog = new Dialog<>();
                        dialog.initStyle(StageStyle.UNDECORATED);
                        dialog.setDialogPane(dialogPane);
                        dialog.show();

                    }
                });
                if (matchMakingController != null) {
                    if (matchMakingController.timerCheck()) {
                        executorService.shutdown();
                        Platform.exit();
                    }
                }

            }
        };
        executorService.execute(reqLetters);
        executorService.execute(timer);
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
        wordsTF.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().equals(KeyCode.ENTER)) {
                    try {
                        wordyGameServer.checkWord(wordsTF.getText(), gameID, userID);
                    } catch (InvalidWord | WordLessThanFiveLetters | ExceededTimeLimit e) {
                        String reason;
                        if (e instanceof InvalidWord)
                            reason = ((InvalidWord) e).reason;
                        else if (e instanceof WordLessThanFiveLetters)
                            reason = ((WordLessThanFiveLetters) e).reason;
                        else
                            reason = ((ExceededTimeLimit) e).reason;

                        Notifications notificationBuilder = Notifications.create()
                                .title(e.getLocalizedMessage())
                                .text(reason)
                                .graphic(null)
                                .hideAfter(Duration.seconds(3))
                                .position(Pos.TOP_CENTER)
                                .onAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        System.out.println("Error caught");
                                    }
                                });
                        notificationBuilder.showConfirm();
                    }
                    wordsTF.clear();
                }
            }
        });
    }
}
