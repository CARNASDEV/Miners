package com.colab.minerscli;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Board {
    private List<List<String>> boardTemplate;
        public Diamond d1;
        public Diamond d2;
        public Diamond d3;

    public Board() {
        // Initialize boardTemplate as a nested ArrayList
        boardTemplate = new ArrayList<>();
        boardTemplate.add(new ArrayList<>(Collections.nCopies(10, "-"))); // array0
        boardTemplate.add(new ArrayList<>(List.of("-", "0", "0", "-", "0", "0", "-", "0", "0", "-"))); // array1
        boardTemplate.add(new ArrayList<>(List.of("-", "0", "0", "-", "0", "0", "-", "0", "0", "-"))); // array2
        boardTemplate.add(new ArrayList<>(Collections.nCopies(10, "-"))); // array3
        boardTemplate.add(new ArrayList<>(List.of("-", "2", "1", "-", "2", "1", "-", "2", "1", "-"))); // array4 : diamonds
        boardTemplate.add(new ArrayList<>(Collections.nCopies(10, "-"))); // array5
        boardTemplate.add(new ArrayList<>(List.of("-", "0", "0", "-", "0", "0", "-", "0", "0", "-"))); // array6
        boardTemplate.add(new ArrayList<>(List.of("-", "0", "0", "-", "0", "0", "-", "0", "0", "-"))); // array7
        boardTemplate.add(new ArrayList<>(Collections.nCopies(10, "-"))); // array8

        Diamond d1 = new Diamond();
        Diamond d2 = new Diamond();
        Diamond d3 = new Diamond();
    }



    public void showBoard() {
        for (List<String> row : boardTemplate) {
            for (String element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    public void showBoardPlayer2Perspective() {
        Collections.reverse(boardTemplate);
        showBoard();
        Collections.reverse(boardTemplate);
    }



    // Methods to access and modify values
    public void setElement(int row, int col, String value) {
        boardTemplate.get(row).set(col, value);
    }

    public String getElement(int row, int col) {
        return boardTemplate.get(row).get(col);
    }

    ////////////////////////////////////////////////////////////////////////////
    // New method to ask for placement
    // Modified method to ask for specific placement within the 2x2 area
    public void askForPlacement(int pressure) {
        Scanner scanner = new Scanner(System.in); // Reuse existing scanner if you can pass it as a parameter
        System.out.println("Select a 2x2 grid-area where you would like to place your card:");
        System.out.println("1: Bottom Left, 2: Bottom Middle, 3: Bottom Right");
        int chosenAreaNumber = scanner.nextInt(); // Read user input for area

        // Validate chosen area
        while (chosenAreaNumber < 1 || chosenAreaNumber > 3) {
            System.out.println("Invalid area selected. Please select 1, 2, or 3.");
            chosenAreaNumber = scanner.nextInt(); // Read user input again if invalid
        }

        System.out.println("Select position within the 2x2 grid where you want to place the pressure:");
        System.out.println("1: Top-Left, 2: Top-Right, 3: Bottom-Left, 4: Bottom-Right");
        int positionInGrid = scanner.nextInt(); // Read user input for specific position

        // Validate chosen position
        while (positionInGrid < 1 || positionInGrid > 4) {
            System.out.println("Invalid position selected. Please select between 1 and 4.");
            positionInGrid = scanner.nextInt(); // Read user input again if invalid
        }

        placeCardInArea(chosenAreaNumber, pressure, positionInGrid); // Pass both choices to the placement method
    }

    // Updated to include specific position selection
    public void placeCardInArea(int chosenAreaNumber, int pressure, int positionInGrid) {
        String pressureAsString = String.valueOf(pressure); //Convert pressure to string
        // Assume chosenAreaNumber = 1 (Bottom Left), and positionInGrid = 4 (Bottom-Right within the 2x2 grid)
        int baseRow = 6; // Starting row for bottom grids
        int baseCol; // This will be set based on the chosen area

        switch (chosenAreaNumber) {
            case 1: baseCol = 1; break; // Bottom Left grid
            case 2: baseCol = 4; break; // Bottom Middle grid
            case 3: default: baseCol = 7; break; // Bottom Right grid
        }

// Adjust for position within the 2x2 grid
        if (positionInGrid == 2) baseCol++; // Top-Right: Increase column
        else if (positionInGrid == 3) baseRow++; // Bottom-Left: Increase row
        else if (positionInGrid == 4) { baseRow++; baseCol++; } // Bottom-Right: Increase both

// Now baseRow and baseCol point to the exact cell to update
        setElement(baseRow, baseCol, pressureAsString);
        showBoard(); // Show the updated board after placing the card.
    }


    ///////////////////////////////////////////////////////



    // Getters for sums of fields (to compare to diamonds)

    public int getFieldTopLeft() {
        return Integer.parseInt(boardTemplate.get(1).get(1)) +
               Integer.parseInt(boardTemplate.get(1).get(2)) +
               Integer.parseInt(boardTemplate.get(2).get(1)) +
               Integer.parseInt(boardTemplate.get(2).get(2));
    }

    public int getFieldTopMiddle() {
        return Integer.parseInt(boardTemplate.get(1).get(4)) +
               Integer.parseInt(boardTemplate.get(1).get(5)) +
               Integer.parseInt(boardTemplate.get(2).get(4)) +
               Integer.parseInt(boardTemplate.get(2).get(5));
    }

    public int getFieldTopRight() {
        return Integer.parseInt(boardTemplate.get(1).get(7)) +
               Integer.parseInt(boardTemplate.get(1).get(8)) +
               Integer.parseInt(boardTemplate.get(2).get(7)) +
               Integer.parseInt(boardTemplate.get(2).get(8));
    }

    public int getFieldBottomLeft() {
        return Integer.parseInt(boardTemplate.get(6).get(1)) +
               Integer.parseInt(boardTemplate.get(6).get(2)) +
               Integer.parseInt(boardTemplate.get(7).get(1)) +
               Integer.parseInt(boardTemplate.get(7).get(2));
    }

    public int getFieldBottomMiddle() {
        return Integer.parseInt(boardTemplate.get(6).get(4)) +
               Integer.parseInt(boardTemplate.get(6).get(5)) +
               Integer.parseInt(boardTemplate.get(7).get(4)) +
               Integer.parseInt(boardTemplate.get(7).get(5));
    }

    public int getFieldBottomRight() {
        return Integer.parseInt(boardTemplate.get(6).get(7)) +
               Integer.parseInt(boardTemplate.get(6).get(8)) +
               Integer.parseInt(boardTemplate.get(7).get(7)) +
               Integer.parseInt(boardTemplate.get(7).get(8));
    }

    // Specific field access methods

    public void setElement11(String value) {
        setElement(1, 1, value);
    }

    public void setElement12(String value) {
        setElement(1, 2, value);
    }

    public void setElement14(String value) {
        setElement(1, 4, value);
    }

    public void setElement15(String value) {
        setElement(1, 5, value);
    }

    public void setElement17(String value) {
        setElement(1, 7, value);
    }

    public void setElement18(String value) {
        setElement(1, 8, value);
    }

    public void setElement21(String value) {
        setElement(2, 1, value);
    }

    public void setElement22(String value) {
        setElement(2, 2, value);
    }

    public void setElement24(String value) {
        setElement(2, 4, value);
    }

    public void setElement25(String value) {
        setElement(2, 5, value);
    }

    public void setElement27(String value) {
        setElement(2, 7, value);
    }

    public void setElement28(String value) {
        setElement(2, 8, value);
    }

    public void setElement61(String value) {
        setElement(6, 1, value);
    }

    public void setElement62(String value) {
        setElement(6, 2, value);
    }

    public void setElement64(String value) {
        setElement(6, 4, value);
    }

    public void setElement65(String value) {
        setElement(6, 5, value);
    }

    public void setElement67(String value) {
        setElement(6, 7, value);
    }

    public void setElement68(String value) {
        setElement(6, 8, value);
    }

    public void setElement71(String value) {
        setElement(7, 1, value);
    }

    public void setElement72(String value) {
        setElement(7, 2, value);
    }

    public void setElement74(String value) {
        setElement(7, 4, value);
    }

    public void setElement75(String value) {
        setElement(7, 5, value);
    }

    public void setElement76(String value) {
        setElement(7, 6, value);
    }

    public void setElement77(String value) {
        setElement(7, 7, value);
    }

    public void setElement78(String value) {
        setElement(7, 8, value);
    }
    
}