package com.java.fingrp7_java.gui_package.clientController;

import WordyGame.TopWord;
import com.java.fingrp7_java.Server.DataAccessClass;
import com.java.fingrp7_java.Server.TopFiveLongestWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.stage.Stage;

import javax.xml.soap.Text;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Wordy_LongestWordController implements Initializable {

    @FXML
    private Button toMainPage;

    @FXML
    private Text top1UserName;

    @FXML
    private Text top2UserName;

    @FXML
    private Text top3UserName;

    @FXML
    private Text top4UserName;

    @FXML
    private Text top5UserName;

    @FXML
    private Text top1Word;

    @FXML
    private Text top2Word;

    @FXML
    private Text top3Word;

    @FXML
    private Text top4Word;

    @FXML
    private Text top5Word;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

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
