package WordyGame;

/**
* WordyGame/TopPlayerHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Saturday, May 13, 2023 4:42:13 PM SGT
*/

public final class TopPlayerHolder implements org.omg.CORBA.portable.Streamable
{
  public WordyGame.TopPlayer value = null;

  public TopPlayerHolder ()
  {
  }

  public TopPlayerHolder (WordyGame.TopPlayer initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = WordyGame.TopPlayerHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    WordyGame.TopPlayerHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return WordyGame.TopPlayerHelper.type ();
  }

}
