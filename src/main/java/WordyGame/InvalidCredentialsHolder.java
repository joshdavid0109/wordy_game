package WordyGame;

/**
* WordyGame/InvalidCredentialsHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Tuesday, May 16, 2023 6:27:20 PM SGT
*/

public final class InvalidCredentialsHolder implements org.omg.CORBA.portable.Streamable
{
  public WordyGame.InvalidCredentials value = null;

  public InvalidCredentialsHolder ()
  {
  }

  public InvalidCredentialsHolder (WordyGame.InvalidCredentials initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = WordyGame.InvalidCredentialsHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    WordyGame.InvalidCredentialsHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return WordyGame.InvalidCredentialsHelper.type ();
  }

}
