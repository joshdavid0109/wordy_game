package WordyGame;

/**
* WordyGame/UserAlreadyLoggedInHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Tuesday, May 2, 2023 9:52:41 PM SGT
*/

public final class UserAlreadyLoggedInHolder implements org.omg.CORBA.portable.Streamable
{
  public WordyGame.UserAlreadyLoggedIn value = null;

  public UserAlreadyLoggedInHolder ()
  {
  }

  public UserAlreadyLoggedInHolder (WordyGame.UserAlreadyLoggedIn initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = WordyGame.UserAlreadyLoggedInHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    WordyGame.UserAlreadyLoggedInHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return WordyGame.UserAlreadyLoggedInHelper.type ();
  }

}
