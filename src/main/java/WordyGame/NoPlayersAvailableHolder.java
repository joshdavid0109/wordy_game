package WordyGame;

/**
* WordyGame/NoPlayersAvailableHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Sunday, April 23, 2023 11:54:21 AM SGT
*/

public final class NoPlayersAvailableHolder implements org.omg.CORBA.portable.Streamable
{
  public WordyGame.NoPlayersAvailable value = null;

  public NoPlayersAvailableHolder ()
  {
  }

  public NoPlayersAvailableHolder (WordyGame.NoPlayersAvailable initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = WordyGame.NoPlayersAvailableHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    WordyGame.NoPlayersAvailableHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return WordyGame.NoPlayersAvailableHelper.type ();
  }

}
