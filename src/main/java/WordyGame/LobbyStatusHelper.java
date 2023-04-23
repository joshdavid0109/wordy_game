package WordyGame;


/**
* WordyGame/LobbyStatusHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Sunday, April 23, 2023 11:54:21 AM SGT
*/

abstract public class LobbyStatusHelper
{
  private static String  _id = "IDL:WordyGame/LobbyStatus:1.0";

  public static void insert (org.omg.CORBA.Any a, WordyGame.LobbyStatus that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static WordyGame.LobbyStatus extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_enum_tc (WordyGame.LobbyStatusHelper.id (), "LobbyStatus", new String[] { "JOINED_A_GAME", "NEW_GAME"} );
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static WordyGame.LobbyStatus read (org.omg.CORBA.portable.InputStream istream)
  {
    return WordyGame.LobbyStatus.from_int (istream.read_long ());
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, WordyGame.LobbyStatus value)
  {
    ostream.write_long (value.value ());
  }

}
