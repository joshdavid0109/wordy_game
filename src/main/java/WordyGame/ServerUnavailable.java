package WordyGame;


/**
* WordyGame/ServerUnavailable.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Tuesday, May 2, 2023 9:49:55 PM SGT
*/

public final class ServerUnavailable extends org.omg.CORBA.UserException
{
  public String reason = null;

  public ServerUnavailable ()
  {
    super(ServerUnavailableHelper.id());
  } // ctor

  public ServerUnavailable (String _reason)
  {
    super(ServerUnavailableHelper.id());
    reason = _reason;
  } // ctor


  public ServerUnavailable (String $reason, String _reason)
  {
    super(ServerUnavailableHelper.id() + "  " + $reason);
    reason = _reason;
  } // ctor

} // class ServerUnavailable
