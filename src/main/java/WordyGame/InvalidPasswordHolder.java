package WordyGame;

/**
* WordyGame/InvalidPasswordHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Tuesday, May 2, 2023 9:52:41 PM SGT
*/

public final class InvalidPasswordHolder implements org.omg.CORBA.portable.Streamable
{
  public WordyGame.InvalidPassword value = null;

  public InvalidPasswordHolder ()
  {
  }

  public InvalidPasswordHolder (WordyGame.InvalidPassword initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = WordyGame.InvalidPasswordHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    WordyGame.InvalidPasswordHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return WordyGame.InvalidPasswordHelper.type ();
  }

}