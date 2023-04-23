package WordyGame;


/**
* WordyGame/WordyGameServerHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Sunday, April 23, 2023 11:54:21 AM SGT
*/

abstract public class WordyGameServerHelper
{
  private static String  _id = "IDL:WordyGame/WordyGameServer:1.0";

  public static void insert (org.omg.CORBA.Any a, WordyGame.WordyGameServer that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static WordyGame.WordyGameServer extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (WordyGame.WordyGameServerHelper.id (), "WordyGameServer");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static WordyGame.WordyGameServer read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_WordyGameServerStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, WordyGame.WordyGameServer value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static WordyGame.WordyGameServer narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof WordyGame.WordyGameServer)
      return (WordyGame.WordyGameServer)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      WordyGame._WordyGameServerStub stub = new WordyGame._WordyGameServerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static WordyGame.WordyGameServer unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof WordyGame.WordyGameServer)
      return (WordyGame.WordyGameServer)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      WordyGame._WordyGameServerStub stub = new WordyGame._WordyGameServerStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
