package WordyGame;

/**
* WordyGame/WordyGameServerHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Sunday, April 23, 2023 11:54:21 AM SGT
*/

public final class WordyGameServerHolder implements org.omg.CORBA.portable.Streamable
{
  public WordyGame.WordyGameServer value = null;

  public WordyGameServerHolder ()
  {
  }

  public WordyGameServerHolder (WordyGame.WordyGameServer initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = WordyGame.WordyGameServerHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    WordyGame.WordyGameServerHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return WordyGame.WordyGameServerHelper.type ();
  }

}
