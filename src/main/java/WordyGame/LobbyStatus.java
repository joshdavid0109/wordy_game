package WordyGame;


/**
* WordyGame/LobbyStatus.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Sunday, April 23, 2023 11:50:14 AM SGT
*/

public class LobbyStatus implements org.omg.CORBA.portable.IDLEntity
{
  private        int __value;
  private static int __size = 2;
  private static LobbyStatus[] __array = new LobbyStatus [__size];

  public static final int _JOINED_A_GAME = 0;
  public static final LobbyStatus JOINED_A_GAME = new LobbyStatus(_JOINED_A_GAME);
  public static final int _NEW_GAME = 1;
  public static final LobbyStatus NEW_GAME = new LobbyStatus(_NEW_GAME);

  public int value ()
  {
    return __value;
  }

  public static LobbyStatus from_int (int value)
  {
    if (value >= 0 && value < __size)
      return __array[value];
    else
      throw new org.omg.CORBA.BAD_PARAM ();
  }

  protected LobbyStatus (int value)
  {
    __value = value;
    __array[__value] = this;
  }
} // class LobbyStatus
