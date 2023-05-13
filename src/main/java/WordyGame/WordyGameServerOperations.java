package WordyGame;


/**
* WordyGame/WordyGameServerOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from WordyGame.idl
* Saturday, May 13, 2023 4:42:13 PM SGT
*/

public interface WordyGameServerOperations 
{
  void login (String username, String password) throws WordyGame.InvalidCredentials, WordyGame.UserAlreadyLoggedIn, WordyGame.InvalidPassword, WordyGame.ServerUnavailable;
  void logout (int userID);
  int playGame (int userID) throws WordyGame.NoPlayersAvailable;
  String ready (int userID, int gameID);
  void checkWord (String word, int gameID, int userID) throws WordyGame.InvalidWord, WordyGame.WordLessThanFiveLetters, WordyGame.ExceededTimeLimit;
  int getRound (int gameID);
  String checkMatchStatus (int gameID);
  char[] requestLetters (int gameID);
  int getPlayerID (String username);
  String checkWinner (int gameID);
  int getTimer (String of);
  WordyGame.TopWord[] getLongestWords ();
  WordyGame.TopPlayer[] getTopPlayers ();
} // interface WordyGameServerOperations
