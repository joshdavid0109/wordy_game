package com.java.fingrp7_java.gui_package.client;

import com.java.fingrp7_java.gui_package.clientController.Wordy_AchievementController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Wordy_InGame extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Image image = new Image("SLU_LOGO-removebg-preview.png");

        FXMLLoader fxmlLoader =
                new FXMLLoader(LogIn.class.getResource("/com/java/fmxl/inGame.fxml"));
        Wordy_AchievementController wordy_achievementController = fxmlLoader.getController();
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("IN GAME");
        primaryStage.getIcons().add(image);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
