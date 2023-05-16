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
    private javafx.scene.text.Text topOneUserName;

    @FXML
    private javafx.scene.text.Text topTwoUserName;

    @FXML
    private javafx.scene.text.Text topThreeUserName;

    @FXML
    private javafx.scene.text.Text topFourUserName;

    @FXML
    private javafx.scene.text.Text topFiveUserName;

    @FXML
    private javafx.scene.text.Text topOneWord;

    @FXML
    private javafx.scene.text.Text topTwoWord;

    @FXML
    private javafx.scene.text.Text topThreeWord;

    @FXML
    private javafx.scene.text.Text topFourWord;

    @FXML
    private javafx.scene.text.Text topFiveWord;
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
