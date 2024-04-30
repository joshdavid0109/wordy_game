# Wordy Game (Java-Python)
The Wordy Game is a client-server program designed to facilitate multiplayer word games. This application allows client programs to connect and engage in a competitive word-forming challenge.

Features:

- User Authentication: Clients must log in using credentials stored in a database accessed by the server. Each account is allowed a single session, ensuring fair play.
- Game Initiation: Once connected, clients can initiate a game of Wordy. The game starts only if another player is available to join within 10 seconds.
- Real-time Gameplay: Each round of the game begins with the server sending 17 random letters, including 5 to 7 vowels, to all players. Players then have 10 seconds to form a valid word of at least five letters using the provided letters.
- Competition: Players can submit multiple words within the time limit, but only the longest valid word from each player is considered. If two or more players submit equally long words or no valid words are submitted, the round ends without a winner.
- Victory Conditions: The first player to win three rounds is declared the overall winner of the game.

Note: The server may send an exception if no other player is willing to join within 10 seconds, and invalid word submissions are handled by the server accordingly.

## Visuals
Depending on what you are making, it can be a good idea to include screenshots or even a video (you'll frequently see GIFs rather than actual videos). Tools like ttygif can help, but check out Asciinema for a more sophisticated method.

## Installation
Requirements:
* Java 8 SDK

  
## Authors and acknowledgment
Show your appreciation to those who have contributed to the project.

## License
For open source projects, say how it is licensed.

## Project status
If you have run out of energy or time for your project, put a note at the top of the README saying that development has slowed down or stopped completely. Someone may choose to fork your project or volunteer to step in as a maintainer or owner, allowing your project to keep going. You can also make an explicit request for maintainers.
