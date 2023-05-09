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
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
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
    public static int roundTime =10;
    public static int readyTimer;
    public static WordyGameServer wordyGameServer;
    char[] letters = new char[17];
    ScheduledExecutorService scheduledExecutorService;
    ExecutorService executorService;
    static Wordy_MatchMakingController matchMakingController;

    ArrayList<TextField> textFields = new ArrayList<>();

    public void ready(ActionEvent actionEvent) {
//        ready.setVisible(false);
        executorService = Executors.newFixedThreadPool(10);
        scheduledExecutorService = Executors.newScheduledThreadPool(10);
        if (roundTime == 0) {
            roundTime = 10;
            roundTimer.setText(String.valueOf(roundTime));
        }

        wordyGameServer.ready(userID, gameID);

        Runnable result = new Runnable() {
            @Override
            public void run() {
                if (roundTime == 0) {
                    scheduledExecutorService.shutdown();
                }
                if (roundTime < 0) {
                    System.out.println("checking winner");
                    String winnerID = wordyGameServer.checkWinner(gameID);

                    System.out.println(winnerID + " " + userID);
                    GameWinnerController.name = winnerID;
                    if (Integer.parseInt(winnerID) == userID) {
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
                                dialog.show();

                            }
                        });
                    } else if (GameDrawController.longestWords.length > 1) {
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


                            }
                        });
                    }
                    scheduledExecutorService.shutdown();
                }
            }
        };

        Runnable roundCounter = new Runnable() {
            @Override
            public void run() {
                System.out.println("timer starting");
                roundTime = wordyGameServer.getTimer("round");
                System.out.println(roundTime);
                roundTimer.setText(String.valueOf(roundTime--));
                if (letters != null) {
                    if (roundTime < 0) {
                        scheduledExecutorService.shutdown();
                        scheduledExecutorService.scheduleAtFixedRate(result, 0, 1, TimeUnit.SECONDS );
                    }
                }
            }
        };

        Runnable reqLetters = new Runnable() {
            @Override
            public void run() {
                letters = wordyGameServer.requestLetters(gameID);
                if (letters!= null)
                    executorService.shutdown();

            }
        };


        Runnable timer = new Runnable() {
            @Override
            public void run() {
               readyTimer = wordyGameServer.getTimer("r");
                readyTimerCounter.setText(String.valueOf(readyTimer));
                if (readyTimer == 0) {
                    for (int i = 0; i < textFields.size(); i++) {
                        TextField tf = textFields.get(i);
                        tf.setText(String.valueOf(letters[i]));
                    }
                    scheduledExecutorService.shutdown();
                    scheduledExecutorService = new ScheduledThreadPoolExecutor(10);
                    scheduledExecutorService.scheduleAtFixedRate(roundCounter, 0 ,1, TimeUnit.SECONDS);
                }
/*
                if (matchMakingController != null) {
//                    if (matchMakingController.timerCheck())
                    if (Wordy_MatchMakingController.timer == 0) {
                        System.out.println("pasok");
                        executorService.shutdown();
                        new JFXPanel();
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                matchMakingController.closeWindow(actionEvent);
                                matchMakingController.closeWindow(new ActionEvent());
                                ready.getScene().getWindow().hide();

                            }
                        });
                        Platform.exit();
                    }
                }
*/

            }
        };

        executorService.execute(reqLetters);
        scheduledExecutorService.scheduleAtFixedRate(timer, 0,1,TimeUnit.SECONDS);

/*
        if (readyTimer == 0) {
            scheduledExecutorService.scheduleAtFixedRate(roundCounter, 0, 1, TimeUnit.SECONDS);
        }
*/

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
        textFields.add(letter17 );

        wordsTF.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                wordsTF.setStyle("-fx-display-caret: false;");
            }
        });


        wordsTF.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (!event.getCode().equals(KeyCode.BACK_SPACE)){
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
                    changeOpacityOfTF(stack.pop(), 1, 0.5);
                    backToOneOpacity(event);
                }

                if (event.getCode().equals(KeyCode.ENTER)) {
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
