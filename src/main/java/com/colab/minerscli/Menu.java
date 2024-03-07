package com.colab.minerscli;

import java.util.Scanner;
public class Menu {
    private final static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        System.out.print("""

                 .----------------.  .----------------.  .-----------------. .----------------.  .----------------.  .----------------.\s
                | .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |
                | | ____    ____ | || |     _____    | || | ____  _____  | || |  _________   | || |  _______     | || |    _______   | |
                | ||_   \\  /   _|| || |    |_   _|   | || ||_   \\|_   _| | || | |_   ___  |  | || | |_   __ \\    | || |   /  ___  |  | |
                | |  |   \\/   |  | || |      | |     | || |  |   \\ | |   | || |   | |_  \\_|  | || |   | |__) |   | || |  |  (__ \\_|  | |
                | |  | |\\  /| |  | || |      | |     | || |  | |\\ \\| |   | || |   |  _|  _   | || |   |  __ /    | || |   '.___`-.   | |
                | | _| |_\\/_| |_ | || |     _| |_    | || | _| |_\\   |_  | || |  _| |___/ |  | || |  _| |  \\ \\_  | || |  |`\\____) |  | |
                | ||_____||_____|| || |    |_____|   | || ||_____|\\____| | || | |_________|  | || | |____| |___| | || |  |_______.'  | |
                | |              | || |              | || |              | || |              | || |              | || |              | |
                | '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |
                 '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'\s
                """
        );

        System.out.println("Press Enter to continue...");
        scanner.nextLine();

        boolean validChoice = false;

        while (!validChoice) {
            System.out.println("[1] - Start the game!");
            System.out.println("[2] - Exit the game");
// Adjusting to read an integer directly, as nextShort() can cause issues if not handled properly
            int choice = Integer.parseInt(scanner.nextLine()); // Adjusted to use nextLine() and parse to avoid Scanner issues

            switch (choice) {
                case 1:
                    System.out.println("Starting the game...");
                    choosePlayerNames();
                    validChoice = true; // Exits the while loop
                    break;
                case 2:
                    System.out.println("Exiting the game...");
                    System.exit(0); // Exits the program
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    // No need to modify validChoice here, as it remains false
                    break;
            }
        }
    }

    public static void choosePlayerNames() {
        // Choose player 1 name
        System.out.print("Enter the name of Player 1: ");
        String name1 = scanner.nextLine();
        Player player1 = new Player(name1);
        

        // Choose player 2 name
        System.out.print("Enter the name of Player 2: ");
        String name2 = scanner.nextLine();
        Player player2 = new Player(name2);
       

       
        // Create an instance of GameEngine
        GameEngine gameEngine = new GameEngine(player1, player2);
    }
}
