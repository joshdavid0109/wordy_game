package WordyGame;


/**
* WordyGame/TopWordsHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Friday, April 28, 2023 8:59:44 PM SGT
*/

public final class TopWordsHolder implements org.omg.CORBA.portable.Streamable
{
  public WordyGame.TopWord value[] = null;

  public TopWordsHolder ()
  {
  }

  public TopWordsHolder (WordyGame.TopWord[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = WordyGame.TopWordsHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    WordyGame.TopWordsHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return WordyGame.TopWordsHelper.type ();
  }

}
