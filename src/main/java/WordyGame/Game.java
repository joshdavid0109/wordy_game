package WordyGame;


import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
* WordyGame/Game.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Friday, April 28, 2023 9:04:46 PM SGT
*/

public final class Game implements org.omg.CORBA.portable.IDLEntity
{
  public String gameID = null;
  public String status = null;
  public int hostID = (int)0;
  public int winnerID = (int)0;
  public ArrayList<Integer> players;
  ScheduledExecutorService scheduler;

  Runnable tenSecondGameTimer = new Runnable() {
    @Override
    public void run() {
      System.out.println(players.size());
      if (players.size() > 1) {
        System.out.println("Match Starting");
        status = "Match Started";
      } else {
        status = null;
      }
    }
  };

  Runnable tenSecondRoundTimer = new Runnable() {
    @Override
    public void run() {

    }
  };

  public Game ()
  {
    gameID = "";
    status = "";
    winnerID = 0;
    hostID = 0;
  } // ctor

  public Game (String _gameID, String _status, int _hostID, int _winnerID)
  {
    gameID = _gameID;
    status = _status;
    hostID = _hostID;
    winnerID = _winnerID;
  } // ctor

  public Game (String gameID, int hostID) {
    players = new ArrayList<>();
    players.add(hostID);
    this.gameID = gameID;
    this.hostID = hostID;
    status = "Waiting";
    winnerID = 0;

    scheduler = Executors.newScheduledThreadPool(10);
    scheduler.schedule(tenSecondGameTimer, 10, TimeUnit.SECONDS);
  }

} // class Game
