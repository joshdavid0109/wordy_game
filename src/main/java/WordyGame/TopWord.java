package WordyGame;


/**
* WordyGame/TopWord.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Saturday, May 13, 2023 4:42:13 PM SGT
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

  public String toString() {
    return username + " " + word;
  }
} // class TopWord
