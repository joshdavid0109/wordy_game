package com.java.fingrp7_java.gui_package.clientController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.xml.soap.Text;
import java.io.IOException;

public class Wordy_AchievementController {

    @FXML
    private Button toMainPage;

    @FXML
    private javafx.scene.text.Text top1UserName;

    @FXML
    private javafx.scene.text.Text top2UserName;

    @FXML
    private javafx.scene.text.Text top3UserName;

    @FXML
    private javafx.scene.text.Text top4UserName;

    @FXML
    private javafx.scene.text.Text top5UserName;

    @FXML
    private javafx.scene.text.Text noOfWins1;

    @FXML
    private javafx.scene.text.Text noOfWins2;

    @FXML
    private javafx.scene.text.Text noOfWins3;

    @FXML
    private javafx.scene.text.Text noOfWins4;

    @FXML
    private javafx.scene.text.Text noOfWins5;
    @FXML
    void toMainPage(ActionEvent event) {
        FXMLLoader showLongestWord = new FXMLLoader();

        showLongestWord.setLocation(getClass().getResource("/com/java/fmxl/mainPage.fxml"));

        Parent root = null;
        try {
            root = showLongestWord.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Scene scene = new Scene(root);
        Stage stage = (Stage) toMainPage.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
