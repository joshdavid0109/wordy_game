package com.java.fingrp7_java.Client.WordyGameClient;

/**
* WordyGameClient/NoPlayersAvailableHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Monday, April 17, 2023 4:33:03 PM SGT
*/

public final class NoPlayersAvailableHolder implements org.omg.CORBA.portable.Streamable
{
  public com.java.fingrp7_java.Client.WordyGameClient.NoPlayersAvailable value = null;

  public NoPlayersAvailableHolder ()
  {
  }

  public NoPlayersAvailableHolder (com.java.fingrp7_java.Client.WordyGameClient.NoPlayersAvailable initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = com.java.fingrp7_java.Client.WordyGameClient.NoPlayersAvailableHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    com.java.fingrp7_java.Client.WordyGameClient.NoPlayersAvailableHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return com.java.fingrp7_java.Client.WordyGameClient.NoPlayersAvailableHelper.type ();
  }

}
