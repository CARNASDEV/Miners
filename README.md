# Miners CLI Game

A two-player strategy board game where players place pressure cards on a grid to control fields and diamonds. The game involves tactical placements and strategic decisions, with the ultimate goal of accumulating diamonds or preventing the opponent from doing so.

## Table of Contents

1. [Introduction](#introduction)
2. [Game Setup](#game-setup)
3. [How to Play](#how-to-play)
4. [Game Flow](#game-flow)
5. [Rules](#rules)
6. [Technologies Used](#technologies-used)
7. [Contributing](#contributing)
8. [License](#license)

## Introduction

The Miners CLI Game is a console-based strategy game where two players compete to accumulate pressure points by placing cards on a 2x2 grid within a 10x10 board. Players can control the placement of pressure cards and attempt to score diamonds while preventing their opponent from doing the same.

## Game Setup

To start the game, you’ll need to create two `Player` objects and initialize the game with these players. The game automatically starts with Player 1 taking the first turn.

### Requirements
- Java 8 or above
- A suitable IDE (Eclipse, IntelliJ, etc.)
- Basic understanding of the game's rules and mechanics

### Starting the Game

To run the game, initialize the `GameEngine` with two players:

```java
Player player1 = new Player("Player 1");
Player player2 = new Player("Player 2");
GameEngine gameEngine = new GameEngine(player1, player2);
