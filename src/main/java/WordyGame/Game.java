package WordyGame;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * WordyGame/Game.java .
 * Generated by the IDL-to-Java compiler (portable), version "3.2"
 * from WordyGame.idl
 * Saturday, April 29, 2023 11:47:14 AM SGT
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
  public int timerCounter = 10;
  public int readyCounter = 15;

  public Runnable tenSecondGameTimer = new Runnable() {
    private volatile boolean exit = false;
    @Override
    public void run() {
      timerCounter--;
      System.out.println(timerCounter);
      if (timerCounter == 0) {
        System.out.println();
        if (players.size() > 1) {
          System.out.println("Match Starting");
          round = 1;
          status = "Match Started";
          scheduler.shutdown();
        } else {
          System.out.println("No other players have joined");
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

    }
  };

  public Runnable readyChecker = new Runnable() {
    @Override
    public void run() {
      readyCounter--;
      if (readyCounter == 0) {
        for (WordyGamePlayer wp :
                wgPlayers) {
          System.out.println(wp.status);
          if (wp.status.equalsIgnoreCase("ready")) {
            if (wgPlayers.get(wgPlayers.size() - 1) == wp) {
              roundStatus = "Start";
              scheduler.shutdown();
            }
          } else if (readyCounter == 0) {
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
    this.gameID = gameID;
    this.hostID = hostID;
    status = "Waiting";
    winnerID = 0;
  }

  public boolean tenSecondGameTimer() {
    scheduler.scheduleAtFixedRate(tenSecondGameTimer, 0, 1, TimeUnit.SECONDS);
    while (!scheduler.isShutdown()) {
      if (scheduler.isShutdown()) {
        return true;
      }
    }
    return false;
  }

  public boolean playerChecker() {
    scheduler = Executors.newScheduledThreadPool(10);
    scheduler.scheduleAtFixedRate(readyChecker, 0,1,TimeUnit.SECONDS);
    while (!scheduler.isShutdown()) {
      if (scheduler.isShutdown()) {
        return true;
      }
    }
    return false;
  }

} // class Game
