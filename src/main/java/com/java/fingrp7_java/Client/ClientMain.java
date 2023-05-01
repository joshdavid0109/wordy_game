package com.java.fingrp7_java.Client;

import WordyGame.WordyGameServerHelper;
import com.java.fingrp7_java.gui_package.client.Wordy_MatchMaking;
import com.java.fingrp7_java.gui_package.client.Wordy_Ready;
import com.java.fingrp7_java.gui_package.clientController.Wordy_MatchMakingController;
import com.java.fingrp7_java.gui_package.clientController.Wordy_ReadyController;
import javafx.application.Application;
import javafx.stage.Stage;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.io.IOException;

public class ClientMain extends Application{

    /**
     * The main entry point for all JavaFX applications.
     * The start method is called after the init method has returned,
     * and after the system is ready for the application to begin running.
     *
     * <p>
     * NOTE: This method is called on the JavaFX Application Thread.
     * </p>
     *
     * @param primaryStage the primary stage for this application, onto which
     *                     the application scene can be set. The primary stage will be embedded in
     *                     the browser if the application was launched as an applet.
     *                     Applications may create other stages, if needed, but they will not be
     *                     primary stages and will not be embedded in the browser.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
            Wordy_MatchMaking wordyMatchMaking= new Wordy_MatchMaking();
            wordyMatchMaking.start(primaryStage);
    }
}
