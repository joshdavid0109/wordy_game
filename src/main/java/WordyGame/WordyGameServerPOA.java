package WordyGame;


/**
* WordyGame/WordyGameServerPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Sunday, April 23, 2023 11:50:14 AM SGT
*/

public abstract class WordyGameServerPOA extends org.omg.PortableServer.Servant
 implements WordyGameServerOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("login", new Integer (0));
    _methods.put ("logout", new Integer (1));
    _methods.put ("playGame", new Integer (2));
    _methods.put ("checkWord", new Integer (3));
    _methods.put ("getLongestWords", new Integer (4));
    _methods.put ("getTopPlayers", new Integer (5));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    Integer __method = (Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // WordyGame/WordyGameServer/login
       {
         String username = in.read_string ();
         String password = in.read_string ();
         CredentialsResult $result = null;
         $result = this.login (username, password);
         out = $rh.createReply();
         CredentialsResultHelper.write (out, $result);
         break;
       }


  // Connect
       case 1:  // WordyGame/WordyGameServer/logout
       {
         String username = in.read_string ();
         this.logout (username);
         out = $rh.createReply();
         break;
       }

       case 2:  // WordyGame/WordyGameServer/playGame
       {
         WordyGamePlayer username = WordyGamePlayerHelper.read (in);
         LobbyStatus $result = null;
         $result = this.playGame (username);
         out = $rh.createReply();
         LobbyStatusHelper.write (out, $result);
         break;
       }

       case 3:  // WordyGame/WordyGameServer/checkWord
       {
         String word = in.read_string ();
         boolean $result = false;
         $result = this.checkWord (word);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 4:  // WordyGame/WordyGameServer/getLongestWords
       {
         String $result[] = null;
         $result = this.getLongestWords ();
         out = $rh.createReply();
         StringSeqHelper.write (out, $result);
         break;
       }

       case 5:  // WordyGame/WordyGameServer/getTopPlayers
       {
         String $result[] = null;
         $result = this.getTopPlayers ();
         out = $rh.createReply();
         StringSeqHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:WordyGame/WordyGameServer:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public WordyGameServer _this() 
  {
    return WordyGameServerHelper.narrow(
    super._this_object());
  }

  public WordyGameServer _this(org.omg.CORBA.ORB orb) 
  {
    return WordyGameServerHelper.narrow(
    super._this_object(orb));
  }


} // class WordyGameServerPOA
