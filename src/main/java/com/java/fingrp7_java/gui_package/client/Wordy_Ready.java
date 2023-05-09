package com.java.fingrp7_java.gui_package.client;

import WordyGame.WordyGameServerHelper;
import com.java.fingrp7_java.gui_package.clientController.Wordy_MatchMakingController;
import com.java.fingrp7_java.gui_package.clientController.Wordy_ReadyController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.io.IOException;

public class Wordy_Ready extends Application{
    public String[] args;
    public static Wordy_Ready wordyReady;
    @Override
    public void start(Stage primaryStage) throws IOException {
        Image image = new Image("SLU_LOGO-removebg-preview.png");

        FXMLLoader fxmlLoader =
                new FXMLLoader(LogIn.class.getResource("/com/java/fmxl/ready.fxml"));
        wordyReady = fxmlLoader.getController();
        Wordy_ReadyController.args = args;

        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("READY");
        primaryStage.getIcons().add(image);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        args = args;
        launch(args);

    }

}
