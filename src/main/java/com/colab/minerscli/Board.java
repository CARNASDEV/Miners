package com.colab.minerscli;

public class Board {

    //Carro: I added the player instances as class variables
    private Player player1;
    private Player player2;
    private String[][] boardTemplate; // Declare boardTemplate as a member variable

    public Board () {
        Diamond d1 = new Diamond();
        Diamond d2 = new Diamond();
        Diamond d3 = new Diamond();
        boardTemplate = new String[][]{ // Initialize boardTemplate
            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}, // array0
            {"-", "0", "0", "-", "0", "0", "-", "0", "0", "-"}, // array1
            {"-", "0", "0", "-", "0", "0", "-", "0", "0", "-"}, // array2
            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}, // array3
            {"-", "2", "1", "-", "2", "1", "-", "2", "1", "-"}, // array4 : diamonds
            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}, // array5
            {"-", "0", "0", "-", "0", "0", "-", "0", "0", "-"}, // array6
            {"-", "0", "0", "-", "0", "0", "-", "0", "0", "-"}, // array7
            {"-", "-", "-", "-", "-", "-", "-", "-", "-", "-"}, // array8
        };
    }


    // Printing methods
    public static void printLine(String[] array) {
        for (String element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void printBoard(String[][] arrays) {
        for (String[] array : arrays) {
            printLine(array);
            System.out.println(); 
        }
    }

    // Methods to access and modify values
    public void setElement(int row, int col, String value) {
        boardTemplate[row][col] = value;
    }

    public String getElement(int row, int col) {
        return boardTemplate[row][col];
    }



    //Carro Suggestions:
    //I suggest using setters to fetch the two player objects that are created when the user sets their names.
    //According to BP it is apparently better to use a setter rather than making the class constuctor expect
    //player objects.
    //Making a Player class that is tightly coupled with a GameBoard class (if we made Player class's
    // constructor requiring an instance of GameBoard) we could not test the player class without
    // also creating a Gameboard(?) and using the players in other future contexts (like in a shop)
    // would require the gameboard instance to come along unnecessarily aswell.

    public void setPlayers(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
}
