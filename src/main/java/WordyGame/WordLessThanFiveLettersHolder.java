package WordyGame;

/**
* WordyGame/WordLessThanFiveLettersHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Tuesday, May 2, 2023 9:52:41 PM SGT
*/

public final class WordLessThanFiveLettersHolder implements org.omg.CORBA.portable.Streamable
{
  public WordyGame.WordLessThanFiveLetters value = null;

  public WordLessThanFiveLettersHolder ()
  {
  }

  public WordLessThanFiveLettersHolder (WordyGame.WordLessThanFiveLetters initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = WordyGame.WordLessThanFiveLettersHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    WordyGame.WordLessThanFiveLettersHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return WordyGame.WordLessThanFiveLettersHelper.type ();
  }

}
