package com.java.fingrp7_java.gui_package.clientController;

import WordyGame.ExceededTimeLimit;
import WordyGame.InvalidWord;
import WordyGame.WordLessThanFiveLetters;
import WordyGame.WordyGameServer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

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

    public static int userID;

    public static int gameID;

    public static WordyGameServer wordyGameServer;

    char[] letters;

    @FXML
    void ready(ActionEvent event) {
        System.out.println(gameID);
        letters = wordyGameServer.requestLetters(String.valueOf(gameID));

        StringBuilder sb = new StringBuilder();
        for (char c :
                letters) {
            sb.append(c);
            if (c != letters[letters.length-1]) {
                sb.append(" ");
            }
        }
        randomLettersText.setText(sb.toString());
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
                        Alert dialog = new Alert(Alert.AlertType.INFORMATION, e.toString());
                        dialog.show();
                    }
                }
            }
        });
    }
}
