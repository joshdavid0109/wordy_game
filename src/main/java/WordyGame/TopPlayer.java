package WordyGame;


/**
* WordyGame/TopPlayer.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Tuesday, May 2, 2023 9:52:41 PM SGT
*/

public final class TopPlayer implements org.omg.CORBA.portable.IDLEntity
{
  public int rank = (int)0;
  public String username = null;
  public int wins = (int)0;

  public TopPlayer ()
  {
  } // ctor

  public TopPlayer (int _rank, String _username, int _wins)
  {
    rank = _rank;
    username = _username;
    wins = _wins;
  } // ctor

} // class TopPlayer
