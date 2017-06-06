[![Build Status](https://travis-ci.org/pelensky/SimplifiedTTT.svg?branch=master)](https://travis-ci.org/pelensky/SimplifiedTTT)
[![Coverage Status](https://coveralls.io/repos/github/pelensky/SimplifiedTTT/badge.svg?branch=master)](https://coveralls.io/github/pelensky/SimplifiedTTT?branch=master)

## Java Tic Tac Toe 

This is a simplified Tic Tac Toe game built in Java. My challenge is to create a Tic Tac Toe game with only the following:
* Board class
* Player interface
  * Human player
  * Computer player
* Game class
* CLI Game


There are two types of players, and a game can be played by any combination of them:
1. Human
2. Computer

#### Prerequisites 
1. Install [Java](http://www.oracle.com/technetwork/java/javase/downloads/index.html)

#### Running instructions
1. Clone the repository by clicking on the green "Clone or Download" button
2. Select Download Zip
3. Double click the zip file to unzip it
4. In terminal, CD into the repository
5. Build the app by running `$ ./gradlew build`
6. Run the tests by running `$ ./gradlew cleanTest test`
7. Play the game by running `$ ./gradlew --console plain run`

#### The Rules

The rules of tic-tac-toe are as follows:

* There are two players in the game (X and O)
* Players take turns until the game is over
* A player can claim a field if it is not already taken
* A turn ends when a player claims a field
* A player wins if they claim all the fields in a row, column or diagonal
* A game is over if a player wins
* A game is over when all fields are taken
