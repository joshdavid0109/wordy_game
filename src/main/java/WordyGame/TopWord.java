package WordyGame;


/**
* WordyGame/TopWord.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Tuesday, May 2, 2023 9:52:41 PM SGT
*/

public final class TopWord implements org.omg.CORBA.portable.IDLEntity
{
  public String username = null;
  public String word = null;

  public TopWord ()
  {
  } // ctor

  public TopWord (String _username, String _word)
  {
    username = _username;
    word = _word;
  } // ctor

} // class TopWord