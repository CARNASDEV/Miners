package com.colab.minerscli;

import java.util.Scanner;

public class Menu {
    private final static Scanner scanner = new Scanner(System.in);

    public static void showMenu() {
        System.out.print("\n" +
                " .----------------.  .----------------.  .-----------------. .----------------.  .----------------.  .----------------. \n" +
                "| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |\n" +
                "| | ____    ____ | || |     _____    | || | ____  _____  | || |  _________   | || |  _______     | || |    _______   | |\n" +
                "| ||_   \\  /   _|| || |    |_   _|   | || ||_   \\|_   _| | || | |_   ___  |  | || | |_   __ \\    | || |   /  ___  |  | |\n" +
                "| |  |   \\/   |  | || |      | |     | || |  |   \\ | |   | || |   | |_  \\_|  | || |   | |__) |   | || |  |  (__ \\_|  | |\n" +
                "| |  | |\\  /| |  | || |      | |     | || |  | |\\ \\| |   | || |   |  _|  _   | || |   |  __ /    | || |   '.___`-.   | |\n" +
                "| | _| |_\\/_| |_ | || |     _| |_    | || | _| |_\\   |_  | || |  _| |___/ |  | || |  _| |  \\ \\_  | || |  |`\\____) |  | |\n" +
                "| ||_____||_____|| || |    |_____|   | || ||_____|\\____| | || | |_________|  | || | |____| |___| | || |  |_______.'  | |\n" +
                "| |              | || |              | || |              | || |              | || |              | || |              | |\n" +
                "| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |\n" +
                " '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------' \n"
        );

        System.out.println("Press Enter to continue...");
        scanner.nextLine();

        int choice;
        boolean validChoice = false;

        while (!validChoice) {
            System.out.println("[1] - Start the game!");
            System.out.println("[2] - Exit the game");

            choice = getInput();
            if (choice == 1) {
                System.out.println("Starting the game...");
                choosePlayerNames();
                validChoice = true;
            } else if (choice == 2) {
                System.out.println("Exiting the game...");
                System.exit(0);
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    public static void choosePlayerNames() {
        // Choose player 1 name
        System.out.print("Enter the name of Player 1: ");
        String name1 = scanner.nextLine();
        Player player1 = new Player();
        player1.setName(name1);

        // Choose player 2 name
        System.out.print("Enter the name of Player 2: ");
        String name2 = scanner.nextLine();
        Player player2 = new Player();
        player2.setName(name2);

        System.out.println(player1.getName() + " and " + player2.getName() + ", you are now entering into the deep dark mines to decide who is the best miner. Setting up the battlefield...");
    }

    public static int getInput() {
        int choice = -1;
        boolean validInput = false;

        while (!validInput) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        return choice;
    }
}
