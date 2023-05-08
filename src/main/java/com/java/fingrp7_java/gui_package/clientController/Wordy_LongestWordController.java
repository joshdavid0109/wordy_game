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
    private TreeTableColumn<TopFiveLongestWord, String> userName;

    @FXML
    private TreeTableColumn<TopFiveLongestWord,String> longestWord;

    @FXML
    private TreeTableView<TopWord> treeTableView;
    
    private DataAccessClass dataAccessClass;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userName.setCellValueFactory(new TreeItemPropertyValueFactory<>("username"));
        longestWord.setCellValueFactory(new TreeItemPropertyValueFactory<>("words"));

        // create root item
        TreeItem<TopWord> rootItem = new TreeItem<>(null);
        treeTableView.setRoot(rootItem);

        // load data from database
        TopWord[] topWords = dataAccessClass.getLongestWords();

        // add data to table
        for (TopWord topWord : topWords) {
            TreeItem<TopWord> item = new TreeItem<>(topWord);
            rootItem.getChildren().add(item);
        }

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
