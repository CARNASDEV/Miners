package com.colab.minerscli;

public class Board {
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
}
