package WordyGame;


import com.java.fingrp7_java.Server.DataAccessClass;
import com.java.fingrp7_java.Server.Word;
import com.java.fingrp7_java.gui_package.clientController.*;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
* WordyGame/Game.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Friday, May 12, 2023 8:08:15 AM CST
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
  public static  int roundCounter = 11;
  public int timerCounter = 10;
  public static int readyCounter = 10;
  public ArrayList<String> strings;
  public boolean roundStat = false;

  DataAccessClass dataAccessClass = new DataAccessClass();
  public ArrayList<Word> words ;
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
      System.out.println(roundCounter);
      roundCounter--;
      if (roundCounter <0) {
        //otherwise, walang gagawin, since tie ang round
        checkRoundWin();
        scheduler.shutdown();
      }
    }
  };

  //TODO TIMER NAGIGING NEGATIVE IF ISA LANG NAGREADY
  public Runnable readyChecker = new Runnable() {
    @Override
    public void run() {
      System.out.println(readyCounter);
      readyCounter--;
      if (readyCounter == 0 && roundStat) {
            System.out.println("g naaa");
            scheduler.shutdown();
            roundTimer();
      } else if (readyCounter == 0){
            System.out.println("Kung sino lang nakaready");

            // TODO check if two players lang nasa game, pag oo, tas hindi nakaready isa matic win yung nakaready
            scheduler.shutdown();
            roundTimer();
      }else if (!roundStat) {
        for (WordyGamePlayer wp :
                wgPlayers) {
          if (wp.status.equals("")) {
            break;
          }else if (wgPlayers.get(wgPlayers.size()-1) == wp){
            System.out.println("g na");
            readyCounter = 3;
            roundStat = true;
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
        readyCounter = 10;
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
    if (roundCounter == 0)
      scheduler.shutdown();
    else {
      scheduler = Executors.newScheduledThreadPool(10);
      scheduler.scheduleAtFixedRate(tenSecondRoundTimer, 0, 1, TimeUnit.SECONDS);
      Wordy_InGameController2.roundTime = roundCounter;
    }
  }

  public void checkRoundWin() {
    System.out.println("round check");
      try {
        words = dataAccessClass.getWords();
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    strings = new ArrayList<>();

/*      for (Word w :
              words) {
        if (w.getGameID() == gameID) {
          if (w.getRoundNum() == round) {
            System.out.println(w.getWord());
            if (!strings.contains(w.getWord())) {
              strings.add(w.getWord()); // all valid words in current game and round
            }else {
              for (Word w1 :
                      words) {
                if (w.getWord().equals(w1.getWord())){
                  if (w1.getUserID())
                }
              }
            }
          }
        }
      }*/

    for (int i = 0; i < words.size(); i++) {
      Word w = words.get(i);
      if (w.getGameID() == gameID) {
        if (w.getRoundNum() == round) {
          if (!strings.contains(w.getWord())) {
            strings.add(w.getWord()); // all valid words in current game and round
          }else {
            for (int j = 0; j < words.size(); j++) {
              Word w1 = words.get(j);
              if (strings.contains(w1.getWord())) {
                if (w.getUserID() == w1.getUserID()) {
                  break;
                }else {
                  strings.add(w1.getWord()); // all valid words in current game and round

                }
              }
            }
          }
        }
      }
    }


      int max = 0; // max length of the word
      int counter = 0; // number of repeating words with same length
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
      String[] winnerWords = new String[counter]; // all winning words
      for (int i = 0; i < strings.size(); i++) {
        int wordLength = strings.get(i).length();
        if (max == wordLength) {
          winnerWords[j] = strings.get(i);
          j++;
        }

      }
      System.out.println("Winner words");
      System.out.println(Arrays.toString(winnerWords));

      if (winnerWords.length == 1) { // if there is only one winner
        GameWinnerController gameWinnerController;
        gameWinnerController = new GameWinnerController();
        gameWinnerController.longestWords = winnerWords;
        for (Word w :
                words) {
          if (w.getGameID() == gameID) {
            if (w.getRoundNum() == round) {
              if (w.getWord().equals(winnerWords[0])) {
                for (WordyGamePlayer wgp :
                        wgPlayers) {
                  wgp.status = "";
                  if (w.getUserID() == wgp.id) {
                      wgp.wins++; // increment win sa winner
                  }
                }
              }
            }
          }
        }
      } else {
        GameDrawController.longestWords = winnerWords;
      }

    System.out.println("setting all status to empty");
    for (WordyGamePlayer wgp :
            wgPlayers) {
      wgp.status = "";
    }
      roundStat =false;
      roundCounter = 10;
      readyCounter = 10;
      round++;

  }

} // class Game
