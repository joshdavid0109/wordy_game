package com.java.fingrp7_java.gui_package.client;

import com.java.fingrp7_java.gui_package.clientController.Wordy_MatchMakingController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Wordy_MatchMaking extends Application {
    public static String[] args;
    @Override
    public void start(Stage primaryStage) throws IOException {
        Image image = new Image("SLU_LOGO-removebg-preview.png");

        FXMLLoader fxmlLoader =
                new FXMLLoader(LogIn.class.getResource("/com/java/fmxl/matchMaking.fxml"));
        Wordy_MatchMakingController wordy_matchMakingController = fxmlLoader.getController();
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("MATCH MAKING");
        primaryStage.getIcons().add(image);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Wordy_MatchMaking.args = args;
        launch(args);

    }
}
