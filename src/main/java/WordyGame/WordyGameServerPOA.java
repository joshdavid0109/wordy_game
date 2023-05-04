package WordyGame;


/**
* WordyGame/WordyGameServerPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Thursday, May 4, 2023 4:03:30 PM SGT
*/

public abstract class WordyGameServerPOA extends org.omg.PortableServer.Servant
 implements WordyGame.WordyGameServerOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("login", new java.lang.Integer (0));
    _methods.put ("logout", new java.lang.Integer (1));
    _methods.put ("playGame", new java.lang.Integer (2));
    _methods.put ("ready", new java.lang.Integer (3));
    _methods.put ("checkWord", new java.lang.Integer (4));
    _methods.put ("requestLetters", new java.lang.Integer (5));
    _methods.put ("checkWinner", new java.lang.Integer (6));
    _methods.put ("getTimer", new java.lang.Integer (7));
    _methods.put ("roundStatus", new java.lang.Integer (8));
    _methods.put ("getLongestWords", new java.lang.Integer (9));
    _methods.put ("getTopPlayers", new java.lang.Integer (10));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // WordyGame/WordyGameServer/login
       {
         try {
           String username = in.read_string ();
           String password = in.read_string ();
           this.login (username, password);
           out = $rh.createReply();
         } catch (WordyGame.InvalidCredentials $ex) {
           out = $rh.createExceptionReply ();
           WordyGame.InvalidCredentialsHelper.write (out, $ex);
         } catch (WordyGame.UserAlreadyLoggedIn $ex) {
           out = $rh.createExceptionReply ();
           WordyGame.UserAlreadyLoggedInHelper.write (out, $ex);
         } catch (WordyGame.InvalidPassword $ex) {
           out = $rh.createExceptionReply ();
           WordyGame.InvalidPasswordHelper.write (out, $ex);
         } catch (WordyGame.ServerUnavailable $ex) {
           out = $rh.createExceptionReply ();
           WordyGame.ServerUnavailableHelper.write (out, $ex);
         }
         break;
       }

       case 1:  // WordyGame/WordyGameServer/logout
       {
         int userID = in.read_long ();
         this.logout (userID);
         out = $rh.createReply();
         break;
       }

       case 2:  // WordyGame/WordyGameServer/playGame
       {
         try {
           int userID = in.read_long ();
           int $result = (int)0;
           $result = this.playGame (userID);
           out = $rh.createReply();
           out.write_long ($result);
         } catch (WordyGame.NoPlayersAvailable $ex) {
           out = $rh.createExceptionReply ();
           WordyGame.NoPlayersAvailableHelper.write (out, $ex);
         }
         break;
       }

       case 3:  // WordyGame/WordyGameServer/ready
       {
         int userID = in.read_long ();
         int gameID = in.read_long ();
         String $result = null;
         $result = this.ready (userID, gameID);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 4:  // WordyGame/WordyGameServer/checkWord
       {
         try {
           String word = in.read_string ();
           int gameID = in.read_long ();
           int userID = in.read_long ();
           this.checkWord (word, gameID, userID);
           out = $rh.createReply();
         } catch (WordyGame.InvalidWord $ex) {
           out = $rh.createExceptionReply ();
           WordyGame.InvalidWordHelper.write (out, $ex);
         } catch (WordyGame.WordLessThanFiveLetters $ex) {
           out = $rh.createExceptionReply ();
           WordyGame.WordLessThanFiveLettersHelper.write (out, $ex);
         } catch (WordyGame.ExceededTimeLimit $ex) {
           out = $rh.createExceptionReply ();
           WordyGame.ExceededTimeLimitHelper.write (out, $ex);
         }
         break;
       }

       case 5:  // WordyGame/WordyGameServer/requestLetters
       {
         String gameID = in.read_string ();
         char $result[] = null;
         $result = this.requestLetters (gameID);
         out = $rh.createReply();
         WordyGame.lettersHelper.write (out, $result);
         break;
       }

       case 6:  // WordyGame/WordyGameServer/checkWinner
       {
         String gameID = in.read_string ();
         String $result = null;
         $result = this.checkWinner (gameID);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 7:  // WordyGame/WordyGameServer/getTimer
       {
         String of = in.read_string ();
         int $result = (int)0;
         $result = this.getTimer (of);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 8:  // WordyGame/WordyGameServer/roundStatus
       {
         String gameID = in.read_string ();
         boolean $result = false;
         $result = this.roundStatus (gameID);
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 9:  // WordyGame/WordyGameServer/getLongestWords
       {
         WordyGame.TopWord $result[] = null;
         $result = this.getLongestWords ();
         out = $rh.createReply();
         WordyGame.TopWordsHelper.write (out, $result);
         break;
       }

       case 10:  // WordyGame/WordyGameServer/getTopPlayers
       {
         WordyGame.TopPlayer $result[] = null;
         $result = this.getTopPlayers ();
         out = $rh.createReply();
         WordyGame.TopPlayersHelper.write (out, $result);
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
