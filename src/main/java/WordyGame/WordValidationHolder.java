package WordyGame;

/**
* WordyGame/WordValidationHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Sunday, April 23, 2023 11:54:21 AM SGT
*/

public final class WordValidationHolder implements org.omg.CORBA.portable.Streamable
{
  public WordyGame.WordValidation value = null;

  public WordValidationHolder ()
  {
  }

  public WordValidationHolder (WordyGame.WordValidation initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = WordyGame.WordValidationHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    WordyGame.WordValidationHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return WordyGame.WordValidationHelper.type ();
  }

}
