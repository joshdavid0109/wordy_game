package WordyGame;


/**
* WordyGame/WordLessThanFiveLetters.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Thursday, May 4, 2023 4:03:30 PM SGT
*/

public final class WordLessThanFiveLetters extends org.omg.CORBA.UserException
{
  public String reason = null;

  public WordLessThanFiveLetters ()
  {
    super(WordLessThanFiveLettersHelper.id());
  } // ctor

  public WordLessThanFiveLetters (String _reason)
  {
    super(WordLessThanFiveLettersHelper.id());
    reason = _reason;
  } // ctor


  public WordLessThanFiveLetters (String $reason, String _reason)
  {
    super(WordLessThanFiveLettersHelper.id() + "  " + $reason);
    reason = _reason;
  } // ctor

} // class WordLessThanFiveLetters
