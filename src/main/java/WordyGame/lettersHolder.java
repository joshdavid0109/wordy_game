package WordyGame;


/**
* WordyGame/lettersHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Thursday, May 4, 2023 5:33:46 PM SGT
*/

public final class lettersHolder implements org.omg.CORBA.portable.Streamable
{
  public char value[] = null;

  public lettersHolder ()
  {
  }

  public lettersHolder (char[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = WordyGame.lettersHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    WordyGame.lettersHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return WordyGame.lettersHelper.type ();
  }

}
