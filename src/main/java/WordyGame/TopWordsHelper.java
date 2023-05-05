package WordyGame;


/**
* WordyGame/TopWordsHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Thursday, May 4, 2023 5:33:46 PM SGT
*/

abstract public class TopWordsHelper
{
  private static String  _id = "IDL:WordyGame/TopWords:1.0";

  public static void insert (org.omg.CORBA.Any a, WordyGame.TopWord[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static WordyGame.TopWord[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = WordyGame.TopWordHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (WordyGame.TopWordsHelper.id (), "TopWords", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static WordyGame.TopWord[] read (org.omg.CORBA.portable.InputStream istream)
  {
    WordyGame.TopWord value[] = null;
    int _len0 = istream.read_long ();
    value = new WordyGame.TopWord[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = WordyGame.TopWordHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, WordyGame.TopWord[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      WordyGame.TopWordHelper.write (ostream, value[_i0]);
  }

}
