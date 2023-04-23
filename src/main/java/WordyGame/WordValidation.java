package WordyGame;


/**
* WordyGame/WordValidation.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Sunday, April 23, 2023 11:54:21 AM SGT
*/

public class WordValidation implements org.omg.CORBA.portable.IDLEntity
{
  private        int __value;
  private static int __size = 3;
  private static WordyGame.WordValidation[] __array = new WordyGame.WordValidation [__size];

  public static final int _WORD_LESS_THAN_FIVE_LETTERS = 0;
  public static final WordyGame.WordValidation WORD_LESS_THAN_FIVE_LETTERS = new WordyGame.WordValidation(_WORD_LESS_THAN_FIVE_LETTERS);
  public static final int _INVALID_WORD = 1;
  public static final WordyGame.WordValidation INVALID_WORD = new WordyGame.WordValidation(_INVALID_WORD);
  public static final int _VALID_WORD = 2;
  public static final WordyGame.WordValidation VALID_WORD = new WordyGame.WordValidation(_VALID_WORD);

  public int value ()
  {
    return __value;
  }

  public static WordyGame.WordValidation from_int (int value)
  {
    if (value >= 0 && value < __size)
      return __array[value];
    else
      throw new org.omg.CORBA.BAD_PARAM ();
  }

  protected WordValidation (int value)
  {
    __value = value;
    __array[__value] = this;
  }
} // class WordValidation
