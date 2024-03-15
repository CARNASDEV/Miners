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
        boardTemplate.add(new ArrayList<>(List.of("-", "0", "0", "-", "0", "0", "-", "0", "0", "-", "Player 2"))); // array1
        boardTemplate.add(new ArrayList<>(List.of("-", "0", "0", "-", "0", "0", "-", "0", "0", "-"))); // array2
        boardTemplate.add(new ArrayList<>(Collections.nCopies(10, "-"))); // array3
        boardTemplate.add(new ArrayList<>(List.of("-", "2", "1", "-", "2", "1", "-", "2", "1", "-"))); // array4 : diamonds
        boardTemplate.add(new ArrayList<>(Collections.nCopies(10, "-"))); // array5
        boardTemplate.add(new ArrayList<>(List.of("-", "0", "0", "-", "0", "0", "-", "0", "0", "-"))); // array6
        boardTemplate.add(new ArrayList<>(List.of("-", "0", "0", "-", "0", "0", "-", "0", "0", "-", "Player 1"))); // array7
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
    public Pocket askForPlacement(int pressure, Player currentplayer) {
        Scanner scanner = new Scanner(System.in); // Reuse existing scanner if you can pass it as a parameter
        System.out.println("Select a 2x2 grid-area where you would like to place your card:");

        System.out.println(currentplayer.getId());
        if (currentplayer.getId() == 1) {System.out.println("1: Bottom Left, 2: Bottom Middle, 3: Bottom Right");
        } else {System.out.println("1: Top Left, 2: Top Middle, 3: Top Right");}

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
        return new Pocket(chosenAreaNumber, pressure, positionInGrid); // Pass both choices to the placement method
    }

    // Updated to include specific position selection
    public void placeCardInArea(Player cp) {
        String pressureAsString = String.valueOf(cp.getPocket().getPressure()); //Convert pressure to string
        // Assume chosenAreaNumber = 1 (Bottom Left), and positionInGrid = 4 (Bottom-Right within the 2x2 grid)
        // Starting row for bottom grids
        int baseRow;
        if (cp.getId() == 1) {baseRow = 6;}
                        else {baseRow = 1;}

            int baseCol; // This will be set based on the chosen area

            switch (cp.getPocket().getChosenAreaNumber()) {
                case 1:
                    baseCol = 1;
                    break; // Bottom Left grid
                case 2:
                    baseCol = 4;
                    break; // Bottom Middle grid
                case 3:
                default:
                    baseCol = 7;
                    break; // Bottom Right grid
            }

// Adjust for position within the 2x2 grid
            if (cp.getPocket().getPositionInGrid() == 2) baseCol++; // Top-Right: Increase column
            else if (cp.getPocket().getPositionInGrid() == 3) baseRow++; // Bottom-Left: Increase row
            else if (cp.getPocket().getPositionInGrid() == 4) {
                baseRow++;
                baseCol++;
            } // Bottom-Right: Increase both

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
}