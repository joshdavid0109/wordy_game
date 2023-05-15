package WordyGame;


/**
* WordyGame/WordyGamePlayer.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Saturday, May 13, 2023 4:42:13 PM SGT
*/

public final class WordyGamePlayer implements org.omg.CORBA.portable.IDLEntity
{
  public int id = (int)0;
  public int wins = (int)0;
  public int gameID = (int)0;
  public String status = null;

  public WordyGamePlayer ()
  {

  } // ctor


  public WordyGamePlayer (int _id, int _wins, int _gameID, String _status)
  {
    id = _id;
    wins = _wins;
    gameID = _gameID;
    status = _status;
  } // ctor

  public WordyGamePlayer(int id) {
    this.id = id;
    wins =0;
    gameID = 0;
    status = "";
  }


} // class WordyGamePlayer
