package WordyGame;

/**
* WordyGame/TopWordHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Thursday, May 4, 2023 4:03:30 PM SGT
*/

public final class TopWordHolder implements org.omg.CORBA.portable.Streamable
{
  public WordyGame.TopWord value = null;

  public TopWordHolder ()
  {
  }

  public TopWordHolder (WordyGame.TopWord initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = WordyGame.TopWordHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    WordyGame.TopWordHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return WordyGame.TopWordHelper.type ();
  }

}
