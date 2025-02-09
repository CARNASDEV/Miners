# Miners CLI Game

A two-player strategic board game where players compete to mine diamonds by carefully placing miners and managing pressure across different fields.

> **Note:** This game is currently under active development and is available on the `dev` branch. Some features may be incomplete or subject to change.

## Game Overview

In Miners CLI, players take turns placing pressure cards on a 9x10 board divided into six mining fields (three for each player). The goal is to match the pressure in your fields with diamond densities while maintaining lower overall pressure than your opponent.

## Development Status

The game is currently in development, with several features still being implemented:
-Currently, the game includes a check for whether any 2x2 grid on the board reaches a total pressure of 21. However, this check is not being actively applied during gameplay as of this version.
To fix this, ensure the `checkFor21Pressure()` method is called after each card placement, and implement logic to handle the event (e.g., awarding a diamond) when the check returns `true`.
- Miner redistribution after diamond destruction
- Additional game balance adjustments
- UI improvements
- Bug fixes and optimization

For the latest playable version, please use the `dev` branch. The main branch will be updated once the game reaches a stable release state.

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

### Requirements
- JDK 17 or higher

### Installation Steps
1. Clone the project repository
2. Switch to the `dev` branch for the latest playable version
3. Run the main program from your IDE

That's it! No additional setup or configuration required.

## Classes Overview

### Core Components
- `GameEngine`: Manages game flow and turn structure
- `Board`: Handles board state and placement logic
- `Rules`: Enforces game rules and win conditions
- `Player`: Manages player state and actions

## Contributing

Feel free to submit issues and enhancement requests. As the game is still in development, feedback and contributions are welcome!

## License

[Specify your license here]
