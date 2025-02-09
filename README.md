# Miners CLI Game

A two-player strategic board game where players compete to mine diamonds by carefully placing miners and managing pressure across different fields.

## Game Overview

In Miners CLI, players take turns placing pressure cards on a 9x10 board divided into six mining fields (three for each player). The goal is to match the pressure in your fields with diamond densities while maintaining lower overall pressure than your opponent.

## Game Board Layout

```
P2: [ ][ ][ ]  [ ][ ][ ]  [ ][ ][ ]  (Top Fields)
    [ ][ ][ ]  [ ][ ][ ]  [ ][ ][ ]

    [D1]       [D2]       [D3]       (Diamonds)

P1: [ ][ ][ ]  [ ][ ][ ]  [ ][ ][ ]  (Bottom Fields)
    [ ][ ][ ]  [ ][ ][ ]  [ ][ ][ ]
```

- The board is divided into 6 mining fields (2x2 grids)
- Three fields for each player (left, middle, right)
- Three diamonds (D1, D2, D3) with different density values
- Players place pressure values in their respective fields

## Gameplay Mechanics

### Turn Structure
1. Players draw cards containing pressure values
2. On their turn, a player:
   - Views their hand of cards
   - Selects a card to play
   - Chooses a field to place the pressure (left, middle, or right)
   - Picks a specific position within the 2x2 grid

### Diamond Mining Rules
- When a field's total pressure matches a diamond's density, the player wins that diamond
- If pressure exceeds density, the diamond is destroyed
- Players can redistribute miners if their pressure destroys a diamond

### Win Conditions
1. **Diamond Collection**: Player with more diamonds when all diamonds are claimed wins
2. **Pressure Tiebreaker**: If players have equal diamonds, the player with lower total pressure wins
3. **Perfect Tie**: If both diamonds and pressure are equal, the game ends in a tie

## Installation and Setup

1. Ensure you have Java installed on your system
2. Clone the repository
3. Compile the Java files
4. Run the main game file

## Classes Overview

### Core Components
- `GameEngine`: Manages game flow and turn structure
- `Board`: Handles board state and placement logic
- `Rules`: Enforces game rules and win conditions
- `Player`: Manages player state and actions

## Contributing

Feel free to submit issues and enhancement requests.

## License

[Specify your license here]
