package WordyGame;


/**
* WordyGame/_WordyGameServerStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Friday, May 12, 2023 8:08:15 AM CST
*/

public class _WordyGameServerStub extends org.omg.CORBA.portable.ObjectImpl implements WordyGame.WordyGameServer
{

  public void login (String username, String password) throws WordyGame.InvalidCredentials, WordyGame.UserAlreadyLoggedIn, WordyGame.InvalidPassword, WordyGame.ServerUnavailable
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("login", true);
                $out.write_string (username);
                $out.write_string (password);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:WordyGame/InvalidCredentials:1.0"))
                    throw WordyGame.InvalidCredentialsHelper.read ($in);
                else if (_id.equals ("IDL:WordyGame/UserAlreadyLoggedIn:1.0"))
                    throw WordyGame.UserAlreadyLoggedInHelper.read ($in);
                else if (_id.equals ("IDL:WordyGame/InvalidPassword:1.0"))
                    throw WordyGame.InvalidPasswordHelper.read ($in);
                else if (_id.equals ("IDL:WordyGame/ServerUnavailable:1.0"))
                    throw WordyGame.ServerUnavailableHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                login (username, password        );
            } finally {
                _releaseReply ($in);
            }
  } // login

  public void logout (int userID)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("logout", true);
                $out.write_long (userID);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                logout (userID        );
            } finally {
                _releaseReply ($in);
            }
  } // logout

  public int playGame (int userID) throws WordyGame.NoPlayersAvailable
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("playGame", true);
                $out.write_long (userID);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:WordyGame/NoPlayersAvailable:1.0"))
                    throw WordyGame.NoPlayersAvailableHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return playGame (userID        );
            } finally {
                _releaseReply ($in);
            }
  } // playGame

  public String ready (int userID, int gameID)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("ready", true);
                $out.write_long (userID);
                $out.write_long (gameID);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return ready (userID, gameID        );
            } finally {
                _releaseReply ($in);
            }
  } // ready

  public void checkWord (String word, int gameID, int userID) throws WordyGame.InvalidWord, WordyGame.WordLessThanFiveLetters, WordyGame.ExceededTimeLimit
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("checkWord", true);
                $out.write_string (word);
                $out.write_long (gameID);
                $out.write_long (userID);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                if (_id.equals ("IDL:WordyGame/InvalidWord:1.0"))
                    throw WordyGame.InvalidWordHelper.read ($in);
                else if (_id.equals ("IDL:WordyGame/WordLessThanFiveLetters:1.0"))
                    throw WordyGame.WordLessThanFiveLettersHelper.read ($in);
                else if (_id.equals ("IDL:WordyGame/ExceededTimeLimit:1.0"))
                    throw WordyGame.ExceededTimeLimitHelper.read ($in);
                else
                    throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                checkWord (word, gameID, userID        );
            } finally {
                _releaseReply ($in);
            }
  } // checkWord

  public int getRound (int gameID)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getRound", true);
                $out.write_long (gameID);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getRound (gameID        );
            } finally {
                _releaseReply ($in);
            }
  } // getRound

  public String checkMatchStatus (int gameID)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("checkMatchStatus", true);
                $out.write_long (gameID);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return checkMatchStatus (gameID        );
            } finally {
                _releaseReply ($in);
            }
  } // checkMatchStatus

  public char[] requestLetters (int gameID)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("requestLetters", true);
                $out.write_long (gameID);
                $in = _invoke ($out);
                char $result[] = WordyGame.lettersHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return requestLetters (gameID        );
            } finally {
                _releaseReply ($in);
            }
  } // requestLetters

  public String checkWinner (int gameID)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("checkWinner", true);
                $out.write_long (gameID);
                $in = _invoke ($out);
                String $result = $in.read_string ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return checkWinner (gameID        );
            } finally {
                _releaseReply ($in);
            }
  } // checkWinner

  public int getTimer (String of)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getTimer", true);
                $out.write_string (of);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getTimer (of        );
            } finally {
                _releaseReply ($in);
            }
  } // getTimer

  public WordyGame.TopWord[] getLongestWords ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getLongestWords", true);
                $in = _invoke ($out);
                WordyGame.TopWord $result[] = WordyGame.TopWordsHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getLongestWords (        );
            } finally {
                _releaseReply ($in);
            }
  } // getLongestWords

  public WordyGame.TopPlayer[] getTopPlayers ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getTopPlayers", true);
                $in = _invoke ($out);
                WordyGame.TopPlayer $result[] = WordyGame.TopPlayersHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getTopPlayers (        );
            } finally {
                _releaseReply ($in);
            }
  } // getTopPlayers

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:WordyGame/WordyGameServer:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _WordyGameServerStub
