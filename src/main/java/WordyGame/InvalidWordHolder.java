package WordyGame;

/**
* WordyGame/InvalidWordHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Sunday, April 23, 2023 11:54:21 AM SGT
*/

public final class InvalidWordHolder implements org.omg.CORBA.portable.Streamable
{
  public WordyGame.InvalidWord value = null;

  public InvalidWordHolder ()
  {
  }

  public InvalidWordHolder (WordyGame.InvalidWord initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = WordyGame.InvalidWordHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    WordyGame.InvalidWordHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return WordyGame.InvalidWordHelper.type ();
  }

}
