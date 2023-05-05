package WordyGame;


import com.java.fingrp7_java.Server.Word;
import com.java.fingrp7_java.gui_package.clientController.Wordy_InGameController;
import com.java.fingrp7_java.gui_package.clientController.Wordy_MatchMakingController;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Time;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
* WordyGame/Game.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Thursday, May 4, 2023 5:33:46 PM SGT
*/

public final class Game implements org.omg.CORBA.portable.IDLEntity
{
  public int gameID = (int)0;
  public String status = null;
  public int hostID = (int)0;
  public int winnerID = (int)0;
  public HashMap<Integer, char[]> lettersPerRound = new HashMap<Integer, char[]>();

  public ArrayList<Integer> players;
  public ArrayList<WordyGamePlayer> wgPlayers = new ArrayList<>();

  public ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);
  public String roundStatus;
  public int round;
  public int roundCounter = 10;
  public int timerCounter = 11;
  public static int readyCounter = 10;
  public ArrayList<Word> words;
  public ArrayList<String> strings = new ArrayList<>();

/*  DataAccessClass dataAccessClass = new DataAccessClass();*/

  public WordyGamePlayer host;
  public WordyGamePlayer winner;


  public static Stage stage;

  public Runnable tenSecondGameTimer = new Runnable() {
    @Override
    public void run() {
      System.out.println(timerCounter);
      timerCounter--;
      if (timerCounter == 0) {
        if (players.size() > 1) {
          System.out.println("Match Starting");
          round = 1;
          status = "Match Started";
//          playerReadyStatus = new boolean[players.size()];
          scheduler.shutdown();
        } else {
          System.out.println("No other players have joined123");
          gameID = 0;
          status = null;
          scheduler.shutdown();
        }
      }
    }
  };

  public Runnable tenSecondRoundTimer = new Runnable() {
    @Override
    public void run() {
      roundCounter--;
      if (roundCounter == 0) {
        for (Word w :
                words) {
            if (w.getGameID() == gameID) {
                if (w.getRoundNum() == round) {
                    strings.add(w.getWord()); // all valid words in current round
                }
            }
        }

        int max = 0; // max length
        int counter = 0; // number of repeating words
        for (int i = 0; i < strings.size(); i++) {
          int wordLength = strings.get(i).length();
          if (max == wordLength) {
            counter++;
          } else if (max < wordLength) { // change max length of the word
            max = wordLength;
            counter = 1;
          }
        }

        int j = 0;
        String [] winnerWords = new String[counter]; // all winning words
        for (int i = 0; i < strings.size(); i++) {
          int wordLength = strings.get(i).length();
          if (max == wordLength) {
            winnerWords[j] = strings.get(i);
            j++;
          }

        }
        System.out.println(Arrays.toString(winnerWords));
        if (winnerWords.length == 1) { // if there is only one winner
          for (Word w :
                  words) {
            if (w.getGameID() == gameID) {
              if (w.getRoundNum() == round) {
                if (winnerWords[0].equalsIgnoreCase(w.getWord())) {
                  for (WordyGamePlayer wgp:
                       wgPlayers) {
                    if (w.getUserID() == wgp.id) {
                      wgp.wins++; // increment win sa winner
                      System.out.println(wgp.id);
                    }
                  }
                }
              }
            }
          }
        } else // walang gagawin, since tie ang round

          scheduler.shutdown();
      }
    }
  };

  public Runnable readyChecker = new Runnable() {
    @Override
    public void run() {
      readyCounter--;
      System.out.println(readyCounter);
      if (readyCounter == 0) {
        for (WordyGamePlayer wp :
                wgPlayers) {
          System.out.println(wp.status);
          if (wp.status.equalsIgnoreCase("ready")) {
            if (wgPlayers.get(wgPlayers.size() - 1) == wp) {
              System.out.println("g na");
              roundStatus = "Start";
              scheduler.shutdown();
            }
          } else if (readyCounter == 0) {
            System.out.println("g naaa");
            roundStatus = "Start";
            scheduler.shutdown();
          }
        }
      }
    }
  };

  public Game ()
  {
    gameID = 0;
    status = "";
    winnerID = 0;
    hostID = 0;
  } // ctor

  public Game (int _gameID, String _status, int _hostID, int _winnerID)
  {
    gameID = _gameID;
    status = _status;
    hostID = _hostID;
    winnerID = _winnerID;
  } // ctor

  public Game (int gameID, int hostID) {
    players = new ArrayList<>();
    players.add(hostID);
    wgPlayers.add(new WordyGamePlayer(hostID));
    timerCounter = 11;
//    readyCounter = 15;
    this.gameID = gameID;
    this.hostID = hostID;
    status = "Waiting";
    winnerID = 0;
  }

  public boolean tenSecondGameTimer() {
    scheduler.scheduleAtFixedRate(tenSecondGameTimer, 0, 1, TimeUnit.SECONDS);
    Wordy_MatchMakingController.timer = timerCounter;

    while (!scheduler.isShutdown()) {
      if (scheduler.isShutdown()) {
        if (Wordy_MatchMakingController.timer == 0) {
          System.out.println("zero na");
        }
        return true;
      }
    }
    return false;
  }

  public void createSchedule(){
    if (scheduler.isShutdown() && roundCounter != 0) {
      scheduler = Executors.newScheduledThreadPool(10);
    }
  }

  public boolean playerChecker() {
//    if (scheduler.isShutdown()) {
      if (readyCounter == 0)
        scheduler.shutdown();
      else {
        scheduler = Executors.newScheduledThreadPool(10);
        Wordy_MatchMakingController.timer = readyCounter;
        scheduler.scheduleAtFixedRate(readyChecker, 0, 1, TimeUnit.SECONDS);
      }
//    }
    while (!scheduler.isShutdown()) {
      if (scheduler.isShutdown()) {
        return true;
      }
    }
    return false;
  }

  public void roundTimer() {
    if (roundCounter == 0) {
      scheduler.shutdown();
    }
    scheduler =Executors.newScheduledThreadPool(10);
    scheduler.scheduleAtFixedRate(tenSecondRoundTimer, 0, 1, TimeUnit.SECONDS);
    Wordy_InGameController.roundTime = readyCounter;
/*    while (!scheduler.isShutdown()) {
      if (scheduler.isShutdown())
        return true;
    }
    return false;*/
  }

} // class Game
