package com.java.fingrp7_java.gui_package.clientController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class GameDrawController implements Initializable {

    @FXML
    private Button nextButton;

    @FXML
    public Text roundLongestWord;

    @FXML
    private Text t;

    public static String[] longestWords;

    @FXML
    void proceedToNextRound(ActionEvent event) {
        Stage stage = (Stage) nextButton.getScene().getWindow();
        Wordy_InGameController2.roundNumber++;
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
        roundLongestWord.setText(Arrays.toString(longestWords));
    }
}
