package WordyGame;


/**
* WordyGame/ExceededTimeLimit.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Tuesday, May 2, 2023 9:52:41 PM SGT
*/

public final class ExceededTimeLimit extends org.omg.CORBA.UserException
{
  public String reason = null;

  public ExceededTimeLimit ()
  {
    super(ExceededTimeLimitHelper.id());
  } // ctor

  public ExceededTimeLimit (String _reason)
  {
    super(ExceededTimeLimitHelper.id());
    reason = _reason;
  } // ctor


  public ExceededTimeLimit (String $reason, String _reason)
  {
    super(ExceededTimeLimitHelper.id() + "  " + $reason);
    reason = _reason;
  } // ctor

} // class ExceededTimeLimit
