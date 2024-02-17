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

    //Getters for sums of fields (to compare to diamonds)

        public int getFieldTopLeft() {
            return Integer.parseInt(boardTemplate[1][1]) +
                    Integer.parseInt(boardTemplate[1][2]) +
                    Integer.parseInt(boardTemplate[2][1]) +
                    Integer.parseInt(boardTemplate[2][2]);
        }


        public int getFieldTopMiddle() {
        return Integer.parseInt(boardTemplate[1][4]) +
               Integer.parseInt(boardTemplate[1][5]) +
               Integer.parseInt(boardTemplate[2][4]) +
               Integer.parseInt(boardTemplate[2][5]);
    }

    public int getFieldTopRight() {
        return Integer.parseInt(boardTemplate[1][7]) +
               Integer.parseInt(boardTemplate[1][8]) +
               Integer.parseInt(boardTemplate[2][7]) +
               Integer.parseInt(boardTemplate[2][8]);
    }

    public int getFieldBottomLeft() {
        return Integer.parseInt(boardTemplate[6][1]) +
               Integer.parseInt(boardTemplate[6][2]) +
               Integer.parseInt(boardTemplate[7][1]) +
               Integer.parseInt(boardTemplate[7][2]);
    }

    public int getFieldBottomMiddle() {
        return Integer.parseInt(boardTemplate[6][4]) +
               Integer.parseInt(boardTemplate[6][5]) +
               Integer.parseInt(boardTemplate[7][4]) +
               Integer.parseInt(boardTemplate[7][5]);
    }

    public int getFieldBottomRight() {
        return Integer.parseInt(boardTemplate[6][7]) +
               Integer.parseInt(boardTemplate[6][8]) +
               Integer.parseInt(boardTemplate[7][7]) +
               Integer.parseInt(boardTemplate[7][8]);
    }

    //Specific field access methods
    
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
    