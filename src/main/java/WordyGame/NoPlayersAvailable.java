package WordyGame;


/**
* WordyGame/NoPlayersAvailable.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Wednesday, May 10, 2023 11:56:33 AM SGT
*/

public final class NoPlayersAvailable extends org.omg.CORBA.UserException
{
  public String reason = null;

  public NoPlayersAvailable ()
  {
    super(NoPlayersAvailableHelper.id());
  } // ctor

  public NoPlayersAvailable (String _reason)
  {
    super(NoPlayersAvailableHelper.id());
    reason = _reason;
  } // ctor


  public NoPlayersAvailable (String $reason, String _reason)
  {
    super(NoPlayersAvailableHelper.id() + "  " + $reason);
    reason = _reason;
  } // ctor

} // class NoPlayersAvailable
