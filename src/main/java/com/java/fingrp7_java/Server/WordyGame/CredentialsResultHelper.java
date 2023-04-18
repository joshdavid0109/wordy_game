package com.java.fingrp7_java.Server.WordyGame;


/**
* com.java.fingrp7_java.Server.WordyGame/CredentialsResultHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from com.java.fingrp7_java.Server.WordyGame.idl
* Tuesday, April 18, 2023 11:22:51 AM CST
*/

abstract public class CredentialsResultHelper
{
  private static String  _id = "IDL:com.java.fingrp7_java.Server.WordyGame/CredentialsResult:1.0";

  public static void insert (org.omg.CORBA.Any a, com.java.fingrp7_java.Server.WordyGame.CredentialsResult that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static com.java.fingrp7_java.Server.WordyGame.CredentialsResult extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_enum_tc (com.java.fingrp7_java.Server.WordyGame.CredentialsResultHelper.id (), "CredentialsResult", new String[] { "SUCCESS", "INVALID_CREDENTIALS", "ACCOUNT_ALREADY_LOGGED_IN", "USERNAME_TAKEN", "SERVER_UNAVAILABLE"} );
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static com.java.fingrp7_java.Server.WordyGame.CredentialsResult read (org.omg.CORBA.portable.InputStream istream)
  {
    return com.java.fingrp7_java.Server.WordyGame.CredentialsResult.from_int (istream.read_long ());
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, com.java.fingrp7_java.Server.WordyGame.CredentialsResult value)
  {
    ostream.write_long (value.value ());
  }

}
