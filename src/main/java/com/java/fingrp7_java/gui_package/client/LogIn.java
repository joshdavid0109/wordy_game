package com.java.fingrp7_java.gui_package.client;

import com.java.fingrp7_java.gui_package.clientController.LogInController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LogIn extends Application {
    public static String[] args;
    @Override
    public void start(Stage primaryStage) throws IOException {
/*        Image image = new Image("SLU_LOGO.jpg");*/

        FXMLLoader fxmlLoader =
                new FXMLLoader(LogIn.class.getResource("/com/java/fmxl/logInPage.fxml"));
        LogInController logInController = fxmlLoader.getController();
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Player");
/*        primaryStage.getIcons().add(image);*/
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        LogIn.args =args;
        launch(args);
    }
}
