package WordyGame;


/**
* WordyGame/UserAlreadyLoggedIn.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Wednesday, May 10, 2023 11:56:33 AM SGT
*/

public final class UserAlreadyLoggedIn extends org.omg.CORBA.UserException
{
  public String reason = null;

  public UserAlreadyLoggedIn ()
  {
    super(UserAlreadyLoggedInHelper.id());
  } // ctor

  public UserAlreadyLoggedIn (String _reason)
  {
    super(UserAlreadyLoggedInHelper.id());
    reason = _reason;
  } // ctor


  public UserAlreadyLoggedIn (String $reason, String _reason)
  {
    super(UserAlreadyLoggedInHelper.id() + "  " + $reason);
    reason = _reason;
  } // ctor

} // class UserAlreadyLoggedIn
