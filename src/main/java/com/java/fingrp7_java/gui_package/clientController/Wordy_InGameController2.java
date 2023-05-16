package com.java.fingrp7_java.gui_package.clientController;
import WordyGame.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Stack;
import java.util.concurrent.*;

public class Wordy_InGameController2 implements Initializable{

    public Text roundNo;

    public static  int roundNumber = 1;

    Stack<String> stack = new Stack<String>();

    public Text playerWinCount;
    @FXML
    private Text roundTimer;
    @FXML
    public TextField letter1;
    @FXML
    public TextField letter2;
    @FXML
    public TextField letter3;
    @FXML
    public TextField letter4;
    @FXML
    public TextField letter5;
    @FXML
    public TextField letter6;
    @FXML
    public TextField letter7;
    @FXML
    public TextField letter8;
    @FXML
    public TextField letter9;
    @FXML
    public TextField letter10;
    @FXML
    public TextField letter11;
    @FXML
    public TextField letter12;
    @FXML
    public TextField letter13;
    @FXML
    public TextField letter14;
    @FXML
    public TextField letter15;
    @FXML
    public TextField letter16;
    @FXML
    public TextField letter17;
    @FXML
    public TextField wordsTF;
    @FXML
    private Button ready;
    @FXML
    private Button exitGame;
    @FXML
    private Text readyTimerCounter;

    public static int userID;
    public static int gameID;
    public static String readyStatus;
    public static int roundTime =10;
    public static int readyTimer;
    public static String winner;
    public static int winCount = 0;
    public static WordyGameServer wordyGameServer;
    char[] letters = new char[17];
    final boolean[] readyChecker = {false};
    ScheduledExecutorService scheduledExecutorService;
    ScheduledExecutorService scheduledExecutorServiceForRunnable;
    ExecutorService executorService;
    public static String[] longestWords;
    static String winnerID;
    static Wordy_MatchMakingController matchMakingController;

    ArrayList<TextField> textFields = new ArrayList<>();

    public void ready(ActionEvent actionEvent) {
//        ready.setVisible(false);
        executorService = Executors.newFixedThreadPool(10);
        scheduledExecutorService = Executors.newScheduledThreadPool(10);
        readyChecker[0] = true;
        if (roundTime == 0) {
            roundTime = 11;
            roundTimer.setText(String.valueOf(roundTime));
        }

        wordyGameServer.ready(userID, gameID);

        Runnable result = new Runnable() {
            @Override
            public void run() {
//                if (gameID != 0) {
                System.out.println("checking winner");

                if (roundTime < 0) {
                    winnerID = wordyGameServer.checkWinner(gameID);

                    System.out.println(winnerID + " " + userID);

                    if (Integer.parseInt(winnerID) == userID) {
                        System.out.println("panalo to");
                        try {
                            GameWinnerController.name = winnerID;
                            GameWinnerController.label = "Round Winner";
                            GameWinnerController.longestWords = longestWords;
                            new JFXPanel().requestFocus();

                            Platform.setImplicitExit(false);

                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    FXMLLoader fxmlLoader = new FXMLLoader();
                                    fxmlLoader.setLocation(getClass().getResource("/com/java/fmxl/gameWinner.fxml"));

                                    DialogPane dialogPane;
                                    try {
                                        dialogPane = fxmlLoader.load();
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                    GameWinnerController gameWinnerController = fxmlLoader.getController();

                                    Dialog<ButtonType> dialog = new Dialog<>();
                                    dialog.initStyle(StageStyle.UNDECORATED);
                                    dialog.setDialogPane(dialogPane);
                                    wordsTF.clear();

                                    new JFXPanel();
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            if (letters != null) {
                                                for (char letter : letters) {
                                                    for (TextField tf :
                                                            textFields) {
                                                        if ((tf.getText().equals(String.valueOf(letter).toLowerCase()) || tf.getText().equals(String.valueOf(letter).toUpperCase()))
                                                                && tf.getOpacity() == 0.5) {
                                                            tf.setOpacity(1);
                                                            break;
                                                        }
                                                    }

                                                }
                                            }
                                        }
                                    });


                                    winCount++;
                                    playerWinCount.setText(String.valueOf(winCount));
                                    longestWords = new String[0];
                                    dialog.show();
                                    winnerID = "";
                                    scheduledExecutorService.shutdown();
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (longestWords.length > 1) {
                        new JFXPanel().requestFocus();

                        Platform.setImplicitExit(false);

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                FXMLLoader fxmlLoader = new FXMLLoader();
                                fxmlLoader.setLocation(getClass().getResource("/com/java/fmxl/gameDraw.fxml"));

                                DialogPane dialogPane;
                                try {

                                    dialogPane = fxmlLoader.load();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                GameDrawController gameDrawController = fxmlLoader.getController();



                                Dialog<ButtonType> dialog = new Dialog<>();
                                dialog.initStyle(StageStyle.UNDECORATED);
                                dialog.setDialogPane(dialogPane);
                                dialog.show();

                                wordsTF.clear();
                                for (char letter : letters) {
                                    for (TextField tf :
                                            textFields) {
                                        if ((tf.getText().equals(String.valueOf(letter).toLowerCase()) || tf.getText().equals(String.valueOf(letter).toUpperCase()))
                                                && tf.getOpacity() == 0.5) {
                                            tf.setOpacity(1);
                                            break;
                                        }
                                    }
                                }

                                longestWords = new String[0];
                                winnerID = "";
                                scheduledExecutorService.shutdown();
                            }
                        });
                    } else if (Integer.parseInt(winnerID) != userID) {
                        System.out.println("talo ka");
                        scheduledExecutorService.shutdown();
                    }
                    winnerID = "";


                }
            }
//            }
        };

        Runnable roundCounter = new Runnable() {
            @Override
            public void run() {
                System.out.println("timer starting");
                roundTime = wordyGameServer.getTimer(gameID, "round");
                System.out.println(roundTime);
                roundTimer.setText(String.valueOf(roundTime--));
                if (letters != null) {
                    if (roundTime < 0) {
                        scheduledExecutorService.shutdown();
                        scheduledExecutorService.shutdown();
                        System.out.println("shutdown round timer");
                        for (int i = 0; i < textFields.size(); i++) {
                            TextField tf = textFields.get(i);
                            tf.setText(String.valueOf(i+1));
                            tf.setOpacity(1);
                        }
                        letters = null;
                        roundNumber++;
                        roundNo.setText(String.valueOf(roundNumber));
                        scheduledExecutorService = new ScheduledThreadPoolExecutor(10);
                        scheduledExecutorService.schedule(result, 1, TimeUnit.SECONDS);
                    } else if (roundTime == 10) {
                        scheduledExecutorService = new ScheduledThreadPoolExecutor(10);
                        scheduledExecutorService.schedule(result, 1, TimeUnit.SECONDS);
                    }
                } else {
                    if (roundTime < 0) {
                        scheduledExecutorService.shutdown();
                        System.out.println("shutdown round timer");
                        for (int i = 0; i < textFields.size(); i++) {
                            TextField tf = textFields.get(i);
                            tf.setText(String.valueOf(i+1));
                        }
                        letters = null;
                        roundNumber++;
                        roundNo.setText(String.valueOf(roundNumber));
                        scheduledExecutorService = new ScheduledThreadPoolExecutor(10);
                        scheduledExecutorService.schedule(result, 1, TimeUnit.SECONDS);
                    } else if (roundTime == 10) {
                        scheduledExecutorService = new ScheduledThreadPoolExecutor(10);
                        scheduledExecutorService.schedule(result, 1, TimeUnit.SECONDS);
                    }
                }
            }
        };

        Runnable reqLetters = new Runnable() {
            @Override
            public void run() {
                letters = wordyGameServer.requestLetters(gameID);
            }
        };


        Runnable timer = new Runnable() {
            @Override
            public void run() {
                readyTimer = wordyGameServer.getTimer(gameID, "r");
                readyTimerCounter.setText(String.valueOf(readyTimer));
                if (readyTimer == 0) {
//                    winnerID = wordyGameServer.checkWinner(gameID);
//                    if (!winnerID.equalsIgnoreCase("")) {
//                        letters = null;
//                        roundNumber++;
//                        roundNo.setText(String.valueOf(roundNumber));
//                        scheduledExecutorService.shutdown();
//                        scheduledExecutorService = new ScheduledThreadPoolExecutor(10);
//                        scheduledExecutorService.schedule(result, 1, TimeUnit.SECONDS);
//
//                    }

                    System.out.println("else");

                    for (int i = 0; i < textFields.size(); i++) {
                        TextField tf = textFields.get(i);
                        if (tf.getText().equals(String.valueOf(letters[i])))
                            break;
                        tf.setText(String.valueOf(letters[i]));

                    }

                    scheduledExecutorService.shutdown();
                    scheduledExecutorService = new ScheduledThreadPoolExecutor(10);
                    scheduledExecutorService.scheduleAtFixedRate(roundCounter, 0, 1, TimeUnit.SECONDS);
//                    }
                }
            }
        };

        executorService.execute(reqLetters);
        scheduledExecutorService.scheduleAtFixedRate(timer, 0,1,TimeUnit.SECONDS);

    }


    public void exitGame(ActionEvent actionEvent) {
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

        roundNo.setText(String.valueOf(roundNumber));

        textFields.add(letter1);
        textFields.add(letter2);
        textFields.add(letter3);
        textFields.add(letter4);
        textFields.add(letter5);
        textFields.add(letter6);
        textFields.add(letter7);
        textFields.add(letter8);
        textFields.add(letter9);
        textFields.add(letter10);
        textFields.add(letter11);
        textFields.add(letter12);
        textFields.add(letter13);
        textFields.add(letter14);
        textFields.add(letter15);
        textFields.add(letter16);
        textFields.add(letter17);

        scheduledExecutorServiceForRunnable = Executors.newScheduledThreadPool(10);
        scheduledExecutorServiceForRunnable.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (gameID!=0) {

                    roundNumber = wordyGameServer.getRound(gameID);
                    if (roundNumber != Integer.parseInt(roundNo.getText()) && letters == null && readyTimer > 0)
                        readyChecker[0] = false;
                    roundNo.setText(String.valueOf(roundNumber));

                    readyStatus = wordyGameServer.checkMatchStatus(gameID);
                    if (readyStatus.equalsIgnoreCase("ready")) {
                        if (!readyChecker[0]){
                            new JFXPanel();
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    Notifications notificationBuilder = Notifications.create()
                                            .title("Round " + roundNumber + " is about to start")
                                            .text("Other players are already ready.")
                                            .graphic(null)
                                            .hideAfter(Duration.seconds(5))
                                            .position(Pos.TOP_CENTER)
                                            .onAction(new EventHandler<ActionEvent>() {
                                                @Override
                                                public void handle(ActionEvent event) {
                                                    System.out.println("Error caught");
                                                }
                                            });
                                    if (roundNumber == Integer.parseInt(roundNo.getText()))
                                        notificationBuilder.showInformation();
                                    readyChecker[0] = true;
                                }
                            });
                        }

                    } else if (readyStatus.equalsIgnoreCase("")) {
                    }else {
                        GameWinnerController.name = String.valueOf(readyStatus);
                        new JFXPanel();
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                FXMLLoader fxmlLoader = new FXMLLoader();
                                fxmlLoader.setLocation(getClass().getResource("/com/java/fmxl/gameWinner.fxml"));

                                DialogPane dialogPane;
                                try {
                                    dialogPane = fxmlLoader.load();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                GameWinnerController gameWinnerController = fxmlLoader.getController();

                                GameWinnerController.label = "Game Winner";

                                Dialog<ButtonType> dialog = new Dialog<>();
                                dialog.initStyle(StageStyle.UNDECORATED);
                                dialog.setDialogPane(dialogPane);
                                wordsTF.clear();
                                if (letters != null) {
                                    for (char letter : letters) {
                                        for (TextField tf :
                                                textFields) {
                                            if ((tf.getText().equals(String.valueOf(letter).toLowerCase()) || tf.getText().equals(String.valueOf(letter).toUpperCase()))
                                                    && tf.getOpacity() == 0.5) {
                                                tf.setOpacity(1);
                                                break;
                                            }
                                        }

                                    }
                                }
                                scheduledExecutorServiceForRunnable.shutdown();
                                dialog.showAndWait();
                                winnerID = "";
                                winCount = 0;
                                gameID = 0;
                                FXMLLoader loader = new FXMLLoader();
                                loader.setLocation(getClass().getResource("/com/java/fmxl/mainPage.fxml"));
                                Wordy_MainPageController wordyMainPageController = new Wordy_MainPageController();
                                Wordy_MainPageController.wordyGameServer = wordyGameServer;
//                    Wordy_MainPageController.playerID = wordyGameServer.getPlayerID(username);
                                Wordy_MainPageController.playerID = userID;
                                Parent root = null;
                                try {
                                    root = loader.load();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                                Scene scene = new Scene(root);
                                Stage stage = (Stage) ready.getScene().getWindow();
                                stage.setScene(scene);
                                stage.show();

                                stage.setOnCloseRequest(windowEvent ->
                                        wordyMainPageController.onShutDown());

                            }
                        });

                    }

                }
            }
        },0,1,TimeUnit.SECONDS);

        wordsTF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                wordsTF.setStyle("-fx-display-caret: false;");
            }
        });


        wordsTF.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (!event.getCode().equals(KeyCode.BACK_SPACE) && letters != null){
                    if (event.getCode().equals(KeyCode.A)) {
                        changeOpacityOfTF("A", 0.5, 1);
                        stack.push("A");
                    }
                    if (event.getCode().equals(KeyCode.B)) {
                        changeOpacityOfTF("B", 0.5, 1);
                        stack.push("B");
                    }
                    if (event.getCode().equals(KeyCode.C)) {
                        changeOpacityOfTF("C", 0.5, 1);
                        stack.push("C");
                    }
                    if (event.getCode().equals(KeyCode.D)) {
                        changeOpacityOfTF("D", 0.5, 1);
                        stack.push("D");
                    }
                    if (event.getCode().equals(KeyCode.E)) {
                        changeOpacityOfTF("E", 0.5, 1);
                        stack.push("E");
                    }
                    if (event.getCode().equals(KeyCode.F)) {
                        changeOpacityOfTF("F", 0.5, 1);
                        stack.push("F");
                    }
                    if (event.getCode().equals(KeyCode.G)) {
                        changeOpacityOfTF("G", 0.5, 1);
                        stack.push("G");
                    }
                    if (event.getCode().equals(KeyCode.H)) {
                        changeOpacityOfTF("H", 0.5, 1);
                        stack.push("H");
                    }
                    if (event.getCode().equals(KeyCode.I)) {
                        changeOpacityOfTF("I", 0.5, 1);
                        stack.push("I");
                    }
                    if (event.getCode().equals(KeyCode.J)) {
                        changeOpacityOfTF("J", 0.5, 1);
                        stack.push("J");
                    }
                    if (event.getCode().equals(KeyCode.K)) {
                        changeOpacityOfTF("K", 0.5, 1);
                        stack.push("K");
                    }
                    if (event.getCode().equals(KeyCode.L)) {
                        changeOpacityOfTF("L", 0.5, 1);
                        stack.push("L");
                    }
                    if (event.getCode().equals(KeyCode.M)) {
                        changeOpacityOfTF("M", 0.5, 1);
                        stack.push("M");
                    }
                    if (event.getCode().equals(KeyCode.N)) {
                        changeOpacityOfTF("N", 0.5, 1);
                        stack.push("N");
                    }
                    if (event.getCode().equals(KeyCode.O)) {
                        changeOpacityOfTF("O", 0.5, 1);
                        stack.push("O");
                    }
                    if (event.getCode().equals(KeyCode.P)) {
                        changeOpacityOfTF("P", 0.5, 1);
                        stack.push("P");
                    }
                    if (event.getCode().equals(KeyCode.Q)) {
                        changeOpacityOfTF("Q", 0.5, 1);
                        stack.push("Q");
                    }
                    if (event.getCode().equals(KeyCode.R)) {
                        changeOpacityOfTF("R", 0.5, 1);
                        stack.push("R");
                    }
                    if (event.getCode().equals(KeyCode.S)) {
                        changeOpacityOfTF("S", 0.5, 1);
                        stack.push("S");
                    }
                    if (event.getCode().equals(KeyCode.T)) {
                        changeOpacityOfTF("T", 0.5, 1);
                        stack.push("T");
                    }
                    if (event.getCode().equals(KeyCode.U)) {
                        changeOpacityOfTF("U", 0.5, 1);
                        stack.push("U");
                    }
                    if (event.getCode().equals(KeyCode.V)) {
                        changeOpacityOfTF("V", 0.5, 1);
                        stack.push("V");
                    }
                    if (event.getCode().equals(KeyCode.W)) {
                        changeOpacityOfTF("W", 0.5, 1);
                        stack.push("W");
                    }
                    if (event.getCode().equals(KeyCode.X)) {
                        changeOpacityOfTF("X", 0.5, 1);
                        stack.push("X");
                    }
                    if (event.getCode().equals(KeyCode.Y)) {
                        changeOpacityOfTF("Y", 0.5, 1);
                        stack.push("Y");
                    }
                    if (event.getCode().equals(KeyCode.Z)) {
                        changeOpacityOfTF("Z", 0.5, 1);
                        stack.push("Z");
                    }
                }else {
                    // change opacity to 1 if nagback space
                    if (letters!= null) {
                        changeOpacityOfTF(stack.pop(), 1, 0.5);
                        backToOneOpacity(event);
                    }
                }

                if (event.getCode().equals(KeyCode.ENTER) && letters != null) {
                    try {
                        wordyGameServer.checkWord(wordsTF.getText(), gameID, userID);
                    } catch (InvalidWord | WordLessThanFiveLetters | ExceededTimeLimit e) {
                        String reason;
                        if (e instanceof InvalidWord)
                            reason = ((InvalidWord) e).reason;
                        else if (e instanceof WordLessThanFiveLetters)
                            reason = ((WordLessThanFiveLetters) e).reason;
                        else
                            reason = ((ExceededTimeLimit) e).reason;

                        Notifications notificationBuilder = Notifications.create()
                                .title(e.getLocalizedMessage())
                                .text(reason)
                                .graphic(null)
                                .hideAfter(Duration.seconds(3))
                                .position(Pos.TOP_CENTER)
                                .onAction(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent event) {
                                        System.out.println("Error caught");
                                    }
                                });
                        notificationBuilder.showConfirm();
                    }
                    wordsTF.clear();
                    for (char letter : letters) {
                        for (TextField tf :
                                textFields) {
                            if ((tf.getText().equals(String.valueOf(letter).toLowerCase()) || tf.getText().equals(String.valueOf(letter).toUpperCase()))
                                    && tf.getOpacity() == 0.5) {
                                tf.setOpacity(1);
                                break;
                            }
                        }

                    }
                }
            }
        });
    }

    private void backToOneOpacity(KeyEvent event) {
        if (event.getCode().equals(KeyCode.A)) {
            changeOpacityOfTF("A", 1, 0.5 );
        }
        if (event.getCode().equals(KeyCode.B)) {
            changeOpacityOfTF("B", 1, 0.5 );
        }
        if (event.getCode().equals(KeyCode.C)) {
            changeOpacityOfTF("C", 1, 0.5 );
        }
        if (event.getCode().equals(KeyCode.D)) {
            changeOpacityOfTF("D", 1, 0.5 );
        }
        if (event.getCode().equals(KeyCode.E)) {
            changeOpacityOfTF("E", 1, 0.5 );
        }
        if (event.getCode().equals(KeyCode.F)) {
            changeOpacityOfTF("F", 1, 0.5 );
        }
        if (event.getCode().equals(KeyCode.G)) {
            changeOpacityOfTF("G", 1, 0.5 );
        }
        if (event.getCode().equals(KeyCode.H)) {
            changeOpacityOfTF("H", 1, 0.5 );
        }
        if (event.getCode().equals(KeyCode.I)) {
            changeOpacityOfTF("I", 1, 0.5 );
        }
        if (event.getCode().equals(KeyCode.J)) {
            changeOpacityOfTF("J", 1, 0.5 );
        }
        if (event.getCode().equals(KeyCode.K)) {
            changeOpacityOfTF("K", 1, 0.5 );
        }
        if (event.getCode().equals(KeyCode.L)) {
            changeOpacityOfTF("L", 1, 0.5 );
        }
        if (event.getCode().equals(KeyCode.M)) {
            changeOpacityOfTF("M", 1, 0.5 );
        }
        if (event.getCode().equals(KeyCode.N)) {
            changeOpacityOfTF("N", 1, 0.5 );
        }
        if (event.getCode().equals(KeyCode.O)) {
            changeOpacityOfTF("O", 1, 0.5 );
        }
        if (event.getCode().equals(KeyCode.P)) {
            changeOpacityOfTF("P", 1, 0.5 );
        }
        if (event.getCode().equals(KeyCode.Q)) {
            changeOpacityOfTF("Q", 1, 0.5 );
        }
        if (event.getCode().equals(KeyCode.R)) {
            changeOpacityOfTF("R", 1, 0.5 );
        }
        if (event.getCode().equals(KeyCode.S)) {
            changeOpacityOfTF("S", 1, 0.5 );
        }
        if (event.getCode().equals(KeyCode.T)) {
            changeOpacityOfTF("T", 1, 0.5 );
        }
        if (event.getCode().equals(KeyCode.U)) {
            changeOpacityOfTF("U", 1, 0.5 );
        }
        if (event.getCode().equals(KeyCode.V)) {
            changeOpacityOfTF("V", 1, 0.5 );
        }
        if (event.getCode().equals(KeyCode.W)) {
            changeOpacityOfTF("W", 1, 0.5 );
        }
        if (event.getCode().equals(KeyCode.X)) {
            changeOpacityOfTF("X", 1, 0.5 );
        }
        if (event.getCode().equals(KeyCode.Y)) {
            changeOpacityOfTF("Y", 1, 0.5 );
        }
        if (event.getCode().equals(KeyCode.Z)) {
            changeOpacityOfTF("Z", 1, 0.5 );
        }
    }

    public void changeOpacityOfTF(String s, double opacity, double initialOpacity) {
        for (char letter : letters) {
            if (letter == s.toLowerCase().charAt(0) || letter == s.toUpperCase().charAt(0)) {
                for (TextField tf :
                        textFields) {
                    if ((tf.getText().equals(s.toLowerCase()) || tf.getText().equals(s.toUpperCase())) && tf.getOpacity() == initialOpacity) {
//                        tf.setStyle("-fx-background-color: #6F7378");
                        tf.setOpacity(opacity);
                        break;
                    }
                }
                break;
            }
        }
    }


}
