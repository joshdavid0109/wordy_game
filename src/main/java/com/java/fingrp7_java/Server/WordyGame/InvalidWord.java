package com.java.fingrp7_java.Server.WordyGame;


/**
* com.java.fingrp7_java.Server.WordyGame/InvalidWord.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from com.java.fingrp7_java.Server.WordyGame.idl
* Tuesday, April 18, 2023 11:22:51 AM CST
*/

public final class InvalidWord extends org.omg.CORBA.UserException
{
  public String reason = null;

  public InvalidWord ()
  {
    super(InvalidWordHelper.id());
  } // ctor

  public InvalidWord (String _reason)
  {
    super(InvalidWordHelper.id());
    reason = _reason;
  } // ctor


  public InvalidWord (String $reason, String _reason)
  {
    super(InvalidWordHelper.id() + "  " + $reason);
    reason = _reason;
  } // ctor

} // class InvalidWord
