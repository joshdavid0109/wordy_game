package WordyGameServer;

/**
* WordyGameServer/NoPlayersAvailableHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Monday, April 17, 2023 4:44:05 PM SGT
*/

public final class NoPlayersAvailableHolder implements org.omg.CORBA.portable.Streamable
{
  public NoPlayersAvailable value = null;

  public NoPlayersAvailableHolder ()
  {
  }

  public NoPlayersAvailableHolder (NoPlayersAvailable initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = NoPlayersAvailableHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    NoPlayersAvailableHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return NoPlayersAvailableHelper.type ();
  }

}
