package WordyGame;

/**
* WordyGame/WordyGamePlayerHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Tuesday, May 16, 2023 6:27:20 PM SGT
*/

public final class WordyGamePlayerHolder implements org.omg.CORBA.portable.Streamable
{
  public WordyGame.WordyGamePlayer value = null;

  public WordyGamePlayerHolder ()
  {
  }

  public WordyGamePlayerHolder (WordyGame.WordyGamePlayer initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = WordyGame.WordyGamePlayerHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    WordyGame.WordyGamePlayerHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return WordyGame.WordyGamePlayerHelper.type ();
  }

}
