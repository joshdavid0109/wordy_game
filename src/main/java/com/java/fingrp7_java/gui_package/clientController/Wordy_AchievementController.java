package com.java.fingrp7_java.gui_package.clientController;

import WordyGame.TopPlayer;
import WordyGame.WordyGameServer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class Wordy_AchievementController implements Initializable {


    public Text top1UserName;
    public Text top2UserName;
    public Text top3UserName;
    public Text top4UserName;
    public Text top5UserName;
    public Text noOfWins1;
    public Text noOfWins2;
    public Text noOfWins3;
    public Text noOfWins4;
    public Text noOfWins5;
    public Button toMainPage;

    static WordyGameServer wordyGameServer;

    @FXML
    void toMainPage(ActionEvent event) throws IOException {
        toMainPage.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/com/java/fmxl/mainPage.fxml"));
        Parent root = loader.load();
        Wordy_MainPageController loginController = loader.getController();

        Scene scene = new Scene(root);
        Stage stage = (Stage) toMainPage.getScene().getWindow();
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

        TopPlayer[] topPlayers = wordyGameServer.getTopPlayers();

        List<Text> topUsernames = new ArrayList<>();
        List<javafx.scene.text.Text> wins = new ArrayList<>();
        System.out.println(Arrays.toString(topPlayers));

        topUsernames.add(top1UserName);
        topUsernames.add(top2UserName);
        topUsernames.add(top3UserName);
        topUsernames.add(top4UserName);
        topUsernames.add(top5UserName);

        wins.add(noOfWins1);
        wins.add(noOfWins2);
        wins.add(noOfWins3);
        wins.add(noOfWins4);
        wins.add(noOfWins5);

        for (int i = 0; i < topPlayers.length; i++) {
            topUsernames.get(i).setText(topPlayers[i].username);
            wins.get(i).setText(String.valueOf(topPlayers[i].wins));
        }

//        for (int i = 0; i < topFiveWords.size(); i++) {
//            javafx.scene.text.Text t = topFiveWords.get(i);
//            t.setText(topWords[i].getWord());
//
//            javafx.scene.text.Text t1 = topFivePlayers.get(i);
//            t1.setText(topWords[i].getUsername());
//        }
    }
}
