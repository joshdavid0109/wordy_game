package WordyGame;


/**
* WordyGame/InvalidWord.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Tuesday, May 2, 2023 9:52:41 PM SGT
*/

public final class InvalidWord extends org.omg.CORBA.UserException
{
  public String reason = null;

  public InvalidWord ()
  {
    super(InvalidWordHelper.id());
  } // ctor

  public InvalidWord (String _reason)
  {
    super(InvalidWordHelper.id());
    reason = _reason;
  } // ctor


  public InvalidWord (String $reason, String _reason)
  {
    super(InvalidWordHelper.id() + "  " + $reason);
    reason = _reason;
  } // ctor

} // class InvalidWord
