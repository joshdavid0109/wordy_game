package WordyGame;

/**
* WordyGame/LoginFailedHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Sunday, April 23, 2023 11:54:21 AM SGT
*/

public final class LoginFailedHolder implements org.omg.CORBA.portable.Streamable
{
  public WordyGame.LoginFailed value = null;

  public LoginFailedHolder ()
  {
  }

  public LoginFailedHolder (WordyGame.LoginFailed initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = WordyGame.LoginFailedHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    WordyGame.LoginFailedHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return WordyGame.LoginFailedHelper.type ();
  }

}