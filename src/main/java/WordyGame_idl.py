# Python stubs generated by omniidl from WordyGame.idl
# DO NOT EDIT THIS FILE!

import omniORB, _omnipy
from omniORB import CORBA, PortableServer
_0_CORBA = CORBA


_omnipy.checkVersion(4,2, __file__, 1)

try:
    property
except NameError:
    def property(*args):
        return None


#
# Start of module "WordyGame"
#
__name__ = "WordyGame"
_0_WordyGame = omniORB.openModule("WordyGame", r"WordyGame.idl")
_0_WordyGame__POA = omniORB.openModule("WordyGame__POA", r"WordyGame.idl")


# struct TopWord
_0_WordyGame.TopWord = omniORB.newEmptyClass()
class TopWord (omniORB.StructBase):
    _NP_RepositoryId = "IDL:WordyGame/TopWord:1.0"

    def __init__(self, username, word):
        self.username = username
        self.word = word

_0_WordyGame.TopWord = TopWord
_0_WordyGame._d_TopWord  = (omniORB.tcInternal.tv_struct, TopWord, TopWord._NP_RepositoryId, "TopWord", "username", (omniORB.tcInternal.tv_string,0), "word", (omniORB.tcInternal.tv_string,0))
_0_WordyGame._tc_TopWord = omniORB.tcInternal.createTypeCode(_0_WordyGame._d_TopWord)
omniORB.registerType(TopWord._NP_RepositoryId, _0_WordyGame._d_TopWord, _0_WordyGame._tc_TopWord)
del TopWord

# struct TopPlayer
_0_WordyGame.TopPlayer = omniORB.newEmptyClass()
class TopPlayer (omniORB.StructBase):
    _NP_RepositoryId = "IDL:WordyGame/TopPlayer:1.0"

    def __init__(self, rank, username, wins):
        self.rank = rank
        self.username = username
        self.wins = wins

_0_WordyGame.TopPlayer = TopPlayer
_0_WordyGame._d_TopPlayer  = (omniORB.tcInternal.tv_struct, TopPlayer, TopPlayer._NP_RepositoryId, "TopPlayer", "rank", omniORB.tcInternal.tv_long, "username", (omniORB.tcInternal.tv_string,0), "wins", omniORB.tcInternal.tv_long)
_0_WordyGame._tc_TopPlayer = omniORB.tcInternal.createTypeCode(_0_WordyGame._d_TopPlayer)
omniORB.registerType(TopPlayer._NP_RepositoryId, _0_WordyGame._d_TopPlayer, _0_WordyGame._tc_TopPlayer)
del TopPlayer

# typedef ... TopWords
class TopWords:
    _NP_RepositoryId = "IDL:WordyGame/TopWords:1.0"
    def __init__(self, *args, **kw):
        raise RuntimeError("Cannot construct objects of this type.")
_0_WordyGame.TopWords = TopWords
_0_WordyGame._d_TopWords  = (omniORB.tcInternal.tv_sequence, omniORB.typeMapping["IDL:WordyGame/TopWord:1.0"], 0)
_0_WordyGame._ad_TopWords = (omniORB.tcInternal.tv_alias, TopWords._NP_RepositoryId, "TopWords", (omniORB.tcInternal.tv_sequence, omniORB.typeMapping["IDL:WordyGame/TopWord:1.0"], 0))
_0_WordyGame._tc_TopWords = omniORB.tcInternal.createTypeCode(_0_WordyGame._ad_TopWords)
omniORB.registerType(TopWords._NP_RepositoryId, _0_WordyGame._ad_TopWords, _0_WordyGame._tc_TopWords)
del TopWords

# typedef ... TopPlayers
class TopPlayers:
    _NP_RepositoryId = "IDL:WordyGame/TopPlayers:1.0"
    def __init__(self, *args, **kw):
        raise RuntimeError("Cannot construct objects of this type.")
_0_WordyGame.TopPlayers = TopPlayers
_0_WordyGame._d_TopPlayers  = (omniORB.tcInternal.tv_sequence, omniORB.typeMapping["IDL:WordyGame/TopPlayer:1.0"], 0)
_0_WordyGame._ad_TopPlayers = (omniORB.tcInternal.tv_alias, TopPlayers._NP_RepositoryId, "TopPlayers", (omniORB.tcInternal.tv_sequence, omniORB.typeMapping["IDL:WordyGame/TopPlayer:1.0"], 0))
_0_WordyGame._tc_TopPlayers = omniORB.tcInternal.createTypeCode(_0_WordyGame._ad_TopPlayers)
omniORB.registerType(TopPlayers._NP_RepositoryId, _0_WordyGame._ad_TopPlayers, _0_WordyGame._tc_TopPlayers)
del TopPlayers

# typedef ... letters
class letters:
    _NP_RepositoryId = "IDL:WordyGame/letters:1.0"
    def __init__(self, *args, **kw):
        raise RuntimeError("Cannot construct objects of this type.")
_0_WordyGame.letters = letters
_0_WordyGame._d_letters  = (omniORB.tcInternal.tv_sequence, omniORB.tcInternal.tv_char, 0)
_0_WordyGame._ad_letters = (omniORB.tcInternal.tv_alias, letters._NP_RepositoryId, "letters", (omniORB.tcInternal.tv_sequence, omniORB.tcInternal.tv_char, 0))
_0_WordyGame._tc_letters = omniORB.tcInternal.createTypeCode(_0_WordyGame._ad_letters)
omniORB.registerType(letters._NP_RepositoryId, _0_WordyGame._ad_letters, _0_WordyGame._tc_letters)
del letters

# struct WordyGamePlayer
_0_WordyGame.WordyGamePlayer = omniORB.newEmptyClass()
class WordyGamePlayer (omniORB.StructBase):
    _NP_RepositoryId = "IDL:WordyGame/WordyGamePlayer:1.0"

    def __init__(self, id, wins, gameID, status):
        self.id = id
        self.wins = wins
        self.gameID = gameID
        self.status = status

_0_WordyGame.WordyGamePlayer = WordyGamePlayer
_0_WordyGame._d_WordyGamePlayer  = (omniORB.tcInternal.tv_struct, WordyGamePlayer, WordyGamePlayer._NP_RepositoryId, "WordyGamePlayer", "id", omniORB.tcInternal.tv_long, "wins", omniORB.tcInternal.tv_long, "gameID", omniORB.tcInternal.tv_long, "status", (omniORB.tcInternal.tv_string,0))
_0_WordyGame._tc_WordyGamePlayer = omniORB.tcInternal.createTypeCode(_0_WordyGame._d_WordyGamePlayer)
omniORB.registerType(WordyGamePlayer._NP_RepositoryId, _0_WordyGame._d_WordyGamePlayer, _0_WordyGame._tc_WordyGamePlayer)
del WordyGamePlayer

# struct Game
_0_WordyGame.Game = omniORB.newEmptyClass()
class Game (omniORB.StructBase):
    _NP_RepositoryId = "IDL:WordyGame/Game:1.0"

    def __init__(self, gameID, status, host, winner):
        self.gameID = gameID
        self.status = status
        self.host = host
        self.winner = winner

_0_WordyGame.Game = Game
_0_WordyGame._d_Game  = (omniORB.tcInternal.tv_struct, Game, Game._NP_RepositoryId, "Game", "gameID", omniORB.tcInternal.tv_long, "status", (omniORB.tcInternal.tv_string,0), "host", omniORB.typeMapping["IDL:WordyGame/WordyGamePlayer:1.0"], "winner", omniORB.typeMapping["IDL:WordyGame/WordyGamePlayer:1.0"])
_0_WordyGame._tc_Game = omniORB.tcInternal.createTypeCode(_0_WordyGame._d_Game)
omniORB.registerType(Game._NP_RepositoryId, _0_WordyGame._d_Game, _0_WordyGame._tc_Game)
del Game

# exception NoPlayersAvailable
_0_WordyGame.NoPlayersAvailable = omniORB.newEmptyClass()
class NoPlayersAvailable (CORBA.UserException):
    _NP_RepositoryId = "IDL:WordyGame/NoPlayersAvailable:1.0"

    def __init__(self, reason):
        CORBA.UserException.__init__(self, reason)
        self.reason = reason

_0_WordyGame.NoPlayersAvailable = NoPlayersAvailable
_0_WordyGame._d_NoPlayersAvailable  = (omniORB.tcInternal.tv_except, NoPlayersAvailable, NoPlayersAvailable._NP_RepositoryId, "NoPlayersAvailable", "reason", (omniORB.tcInternal.tv_string,0))
_0_WordyGame._tc_NoPlayersAvailable = omniORB.tcInternal.createTypeCode(_0_WordyGame._d_NoPlayersAvailable)
omniORB.registerType(NoPlayersAvailable._NP_RepositoryId, _0_WordyGame._d_NoPlayersAvailable, _0_WordyGame._tc_NoPlayersAvailable)
del NoPlayersAvailable

# exception UserAlreadyLoggedIn
_0_WordyGame.UserAlreadyLoggedIn = omniORB.newEmptyClass()
class UserAlreadyLoggedIn (CORBA.UserException):
    _NP_RepositoryId = "IDL:WordyGame/UserAlreadyLoggedIn:1.0"

    def __init__(self, reason):
        CORBA.UserException.__init__(self, reason)
        self.reason = reason

_0_WordyGame.UserAlreadyLoggedIn = UserAlreadyLoggedIn
_0_WordyGame._d_UserAlreadyLoggedIn  = (omniORB.tcInternal.tv_except, UserAlreadyLoggedIn, UserAlreadyLoggedIn._NP_RepositoryId, "UserAlreadyLoggedIn", "reason", (omniORB.tcInternal.tv_string,0))
_0_WordyGame._tc_UserAlreadyLoggedIn = omniORB.tcInternal.createTypeCode(_0_WordyGame._d_UserAlreadyLoggedIn)
omniORB.registerType(UserAlreadyLoggedIn._NP_RepositoryId, _0_WordyGame._d_UserAlreadyLoggedIn, _0_WordyGame._tc_UserAlreadyLoggedIn)
del UserAlreadyLoggedIn

# exception InvalidCredentials
_0_WordyGame.InvalidCredentials = omniORB.newEmptyClass()
class InvalidCredentials (CORBA.UserException):
    _NP_RepositoryId = "IDL:WordyGame/InvalidCredentials:1.0"

    def __init__(self, reason):
        CORBA.UserException.__init__(self, reason)
        self.reason = reason

_0_WordyGame.InvalidCredentials = InvalidCredentials
_0_WordyGame._d_InvalidCredentials  = (omniORB.tcInternal.tv_except, InvalidCredentials, InvalidCredentials._NP_RepositoryId, "InvalidCredentials", "reason", (omniORB.tcInternal.tv_string,0))
_0_WordyGame._tc_InvalidCredentials = omniORB.tcInternal.createTypeCode(_0_WordyGame._d_InvalidCredentials)
omniORB.registerType(InvalidCredentials._NP_RepositoryId, _0_WordyGame._d_InvalidCredentials, _0_WordyGame._tc_InvalidCredentials)
del InvalidCredentials

# exception InvalidPassword
_0_WordyGame.InvalidPassword = omniORB.newEmptyClass()
class InvalidPassword (CORBA.UserException):
    _NP_RepositoryId = "IDL:WordyGame/InvalidPassword:1.0"

    def __init__(self, reason):
        CORBA.UserException.__init__(self, reason)
        self.reason = reason

_0_WordyGame.InvalidPassword = InvalidPassword
_0_WordyGame._d_InvalidPassword  = (omniORB.tcInternal.tv_except, InvalidPassword, InvalidPassword._NP_RepositoryId, "InvalidPassword", "reason", (omniORB.tcInternal.tv_string,0))
_0_WordyGame._tc_InvalidPassword = omniORB.tcInternal.createTypeCode(_0_WordyGame._d_InvalidPassword)
omniORB.registerType(InvalidPassword._NP_RepositoryId, _0_WordyGame._d_InvalidPassword, _0_WordyGame._tc_InvalidPassword)
del InvalidPassword

# exception ServerUnavailable
_0_WordyGame.ServerUnavailable = omniORB.newEmptyClass()
class ServerUnavailable (CORBA.UserException):
    _NP_RepositoryId = "IDL:WordyGame/ServerUnavailable:1.0"

    def __init__(self, reason):
        CORBA.UserException.__init__(self, reason)
        self.reason = reason

_0_WordyGame.ServerUnavailable = ServerUnavailable
_0_WordyGame._d_ServerUnavailable  = (omniORB.tcInternal.tv_except, ServerUnavailable, ServerUnavailable._NP_RepositoryId, "ServerUnavailable", "reason", (omniORB.tcInternal.tv_string,0))
_0_WordyGame._tc_ServerUnavailable = omniORB.tcInternal.createTypeCode(_0_WordyGame._d_ServerUnavailable)
omniORB.registerType(ServerUnavailable._NP_RepositoryId, _0_WordyGame._d_ServerUnavailable, _0_WordyGame._tc_ServerUnavailable)
del ServerUnavailable

# exception InvalidWord
_0_WordyGame.InvalidWord = omniORB.newEmptyClass()
class InvalidWord (CORBA.UserException):
    _NP_RepositoryId = "IDL:WordyGame/InvalidWord:1.0"

    def __init__(self, reason):
        CORBA.UserException.__init__(self, reason)
        self.reason = reason

_0_WordyGame.InvalidWord = InvalidWord
_0_WordyGame._d_InvalidWord  = (omniORB.tcInternal.tv_except, InvalidWord, InvalidWord._NP_RepositoryId, "InvalidWord", "reason", (omniORB.tcInternal.tv_string,0))
_0_WordyGame._tc_InvalidWord = omniORB.tcInternal.createTypeCode(_0_WordyGame._d_InvalidWord)
omniORB.registerType(InvalidWord._NP_RepositoryId, _0_WordyGame._d_InvalidWord, _0_WordyGame._tc_InvalidWord)
del InvalidWord

# exception WordLessThanFiveLetters
_0_WordyGame.WordLessThanFiveLetters = omniORB.newEmptyClass()
class WordLessThanFiveLetters (CORBA.UserException):
    _NP_RepositoryId = "IDL:WordyGame/WordLessThanFiveLetters:1.0"

    def __init__(self, reason):
        CORBA.UserException.__init__(self, reason)
        self.reason = reason

_0_WordyGame.WordLessThanFiveLetters = WordLessThanFiveLetters
_0_WordyGame._d_WordLessThanFiveLetters  = (omniORB.tcInternal.tv_except, WordLessThanFiveLetters, WordLessThanFiveLetters._NP_RepositoryId, "WordLessThanFiveLetters", "reason", (omniORB.tcInternal.tv_string,0))
_0_WordyGame._tc_WordLessThanFiveLetters = omniORB.tcInternal.createTypeCode(_0_WordyGame._d_WordLessThanFiveLetters)
omniORB.registerType(WordLessThanFiveLetters._NP_RepositoryId, _0_WordyGame._d_WordLessThanFiveLetters, _0_WordyGame._tc_WordLessThanFiveLetters)
del WordLessThanFiveLetters

# exception ExceededTimeLimit
_0_WordyGame.ExceededTimeLimit = omniORB.newEmptyClass()
class ExceededTimeLimit (CORBA.UserException):
    _NP_RepositoryId = "IDL:WordyGame/ExceededTimeLimit:1.0"

    def __init__(self, reason):
        CORBA.UserException.__init__(self, reason)
        self.reason = reason

_0_WordyGame.ExceededTimeLimit = ExceededTimeLimit
_0_WordyGame._d_ExceededTimeLimit  = (omniORB.tcInternal.tv_except, ExceededTimeLimit, ExceededTimeLimit._NP_RepositoryId, "ExceededTimeLimit", "reason", (omniORB.tcInternal.tv_string,0))
_0_WordyGame._tc_ExceededTimeLimit = omniORB.tcInternal.createTypeCode(_0_WordyGame._d_ExceededTimeLimit)
omniORB.registerType(ExceededTimeLimit._NP_RepositoryId, _0_WordyGame._d_ExceededTimeLimit, _0_WordyGame._tc_ExceededTimeLimit)
del ExceededTimeLimit

# interface WordyGameServer
_0_WordyGame._d_WordyGameServer = (omniORB.tcInternal.tv_objref, "IDL:WordyGame/WordyGameServer:1.0", "WordyGameServer")
omniORB.typeMapping["IDL:WordyGame/WordyGameServer:1.0"] = _0_WordyGame._d_WordyGameServer
_0_WordyGame.WordyGameServer = omniORB.newEmptyClass()
class WordyGameServer :
    _NP_RepositoryId = _0_WordyGame._d_WordyGameServer[1]

    def __init__(self, *args, **kw):
        raise RuntimeError("Cannot construct objects of this type.")

    _nil = CORBA.Object._nil


_0_WordyGame.WordyGameServer = WordyGameServer
_0_WordyGame._tc_WordyGameServer = omniORB.tcInternal.createTypeCode(_0_WordyGame._d_WordyGameServer)
omniORB.registerType(WordyGameServer._NP_RepositoryId, _0_WordyGame._d_WordyGameServer, _0_WordyGame._tc_WordyGameServer)

# WordyGameServer operations and attributes
WordyGameServer._d_login = (((omniORB.tcInternal.tv_string,0), (omniORB.tcInternal.tv_string,0)), (), {_0_WordyGame.InvalidCredentials._NP_RepositoryId: _0_WordyGame._d_InvalidCredentials, _0_WordyGame.UserAlreadyLoggedIn._NP_RepositoryId: _0_WordyGame._d_UserAlreadyLoggedIn, _0_WordyGame.InvalidPassword._NP_RepositoryId: _0_WordyGame._d_InvalidPassword, _0_WordyGame.ServerUnavailable._NP_RepositoryId: _0_WordyGame._d_ServerUnavailable})
WordyGameServer._d_logout = ((omniORB.tcInternal.tv_long, ), (), None)
WordyGameServer._d_playGame = ((omniORB.tcInternal.tv_long, ), (omniORB.tcInternal.tv_long, ), {_0_WordyGame.NoPlayersAvailable._NP_RepositoryId: _0_WordyGame._d_NoPlayersAvailable})
WordyGameServer._d_ready = ((omniORB.tcInternal.tv_long, omniORB.tcInternal.tv_long), ((omniORB.tcInternal.tv_string,0), ), None)
WordyGameServer._d_checkWord = (((omniORB.tcInternal.tv_string,0), omniORB.tcInternal.tv_long, omniORB.tcInternal.tv_long), (), {_0_WordyGame.InvalidWord._NP_RepositoryId: _0_WordyGame._d_InvalidWord, _0_WordyGame.WordLessThanFiveLetters._NP_RepositoryId: _0_WordyGame._d_WordLessThanFiveLetters, _0_WordyGame.ExceededTimeLimit._NP_RepositoryId: _0_WordyGame._d_ExceededTimeLimit})
WordyGameServer._d_getRound = ((omniORB.tcInternal.tv_long, ), (omniORB.tcInternal.tv_long, ), None)
WordyGameServer._d_checkMatchStatus = ((omniORB.tcInternal.tv_long, ), ((omniORB.tcInternal.tv_string,0), ), None)
WordyGameServer._d_requestLetters = ((omniORB.tcInternal.tv_long, ), (omniORB.typeMapping["IDL:WordyGame/letters:1.0"], ), None)
WordyGameServer._d_getPlayerID = (((omniORB.tcInternal.tv_string,0), ), (omniORB.tcInternal.tv_long, ), None)
WordyGameServer._d_checkWinner = ((omniORB.tcInternal.tv_long, ), ((omniORB.tcInternal.tv_string,0), ), None)
WordyGameServer._d_getTimer = ((omniORB.tcInternal.tv_long, (omniORB.tcInternal.tv_string,0)), (omniORB.tcInternal.tv_long, ), None)
WordyGameServer._d_getLongestWords = ((), (omniORB.typeMapping["IDL:WordyGame/TopWords:1.0"], ), None)
WordyGameServer._d_getTopPlayers = ((), (omniORB.typeMapping["IDL:WordyGame/TopPlayers:1.0"], ), None)

# WordyGameServer object reference
class _objref_WordyGameServer (CORBA.Object):
    _NP_RepositoryId = WordyGameServer._NP_RepositoryId

    def __init__(self, obj):
        CORBA.Object.__init__(self, obj)

    def login(self, *args):
        return self._obj.invoke("login", _0_WordyGame.WordyGameServer._d_login, args)

    def logout(self, *args):
        return self._obj.invoke("logout", _0_WordyGame.WordyGameServer._d_logout, args)

    def playGame(self, *args):
        return self._obj.invoke("playGame", _0_WordyGame.WordyGameServer._d_playGame, args)

    def ready(self, *args):
        return self._obj.invoke("ready", _0_WordyGame.WordyGameServer._d_ready, args)

    def checkWord(self, *args):
        return self._obj.invoke("checkWord", _0_WordyGame.WordyGameServer._d_checkWord, args)

    def getRound(self, *args):
        return self._obj.invoke("getRound", _0_WordyGame.WordyGameServer._d_getRound, args)

    def checkMatchStatus(self, *args):
        return self._obj.invoke("checkMatchStatus", _0_WordyGame.WordyGameServer._d_checkMatchStatus, args)

    def requestLetters(self, *args):
        return self._obj.invoke("requestLetters", _0_WordyGame.WordyGameServer._d_requestLetters, args)

    def getPlayerID(self, *args):
        return self._obj.invoke("getPlayerID", _0_WordyGame.WordyGameServer._d_getPlayerID, args)

    def checkWinner(self, *args):
        return self._obj.invoke("checkWinner", _0_WordyGame.WordyGameServer._d_checkWinner, args)

    def getTimer(self, *args):
        return self._obj.invoke("getTimer", _0_WordyGame.WordyGameServer._d_getTimer, args)

    def getLongestWords(self, *args):
        return self._obj.invoke("getLongestWords", _0_WordyGame.WordyGameServer._d_getLongestWords, args)

    def getTopPlayers(self, *args):
        return self._obj.invoke("getTopPlayers", _0_WordyGame.WordyGameServer._d_getTopPlayers, args)

omniORB.registerObjref(WordyGameServer._NP_RepositoryId, _objref_WordyGameServer)
_0_WordyGame._objref_WordyGameServer = _objref_WordyGameServer
del WordyGameServer, _objref_WordyGameServer

# WordyGameServer skeleton
__name__ = "WordyGame__POA"
class WordyGameServer (PortableServer.Servant):
    _NP_RepositoryId = _0_WordyGame.WordyGameServer._NP_RepositoryId


    _omni_op_d = {"login": _0_WordyGame.WordyGameServer._d_login, "logout": _0_WordyGame.WordyGameServer._d_logout, "playGame": _0_WordyGame.WordyGameServer._d_playGame, "ready": _0_WordyGame.WordyGameServer._d_ready, "checkWord": _0_WordyGame.WordyGameServer._d_checkWord, "getRound": _0_WordyGame.WordyGameServer._d_getRound, "checkMatchStatus": _0_WordyGame.WordyGameServer._d_checkMatchStatus, "requestLetters": _0_WordyGame.WordyGameServer._d_requestLetters, "getPlayerID": _0_WordyGame.WordyGameServer._d_getPlayerID, "checkWinner": _0_WordyGame.WordyGameServer._d_checkWinner, "getTimer": _0_WordyGame.WordyGameServer._d_getTimer, "getLongestWords": _0_WordyGame.WordyGameServer._d_getLongestWords, "getTopPlayers": _0_WordyGame.WordyGameServer._d_getTopPlayers}

WordyGameServer._omni_skeleton = WordyGameServer
_0_WordyGame__POA.WordyGameServer = WordyGameServer
omniORB.registerSkeleton(WordyGameServer._NP_RepositoryId, WordyGameServer)
del WordyGameServer
__name__ = "WordyGame"

#
# End of module "WordyGame"
#
__name__ = "WordyGame_idl"

_exported_modules = ( "WordyGame", )

# The end.