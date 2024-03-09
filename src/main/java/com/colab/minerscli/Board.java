package com.colab.minerscli;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    private List<List<String>> boardTemplate;
        public Diamond d1;
        public Diamond d2;
        public Diamond d3;

    public Board() {
        // Initialize boardTemplate as a nested ArrayList
        boardTemplate = new ArrayList<>();
        boardTemplate.add(new ArrayList<>(Collections.nCopies(10, "-"))); // array0
        boardTemplate.add(new ArrayList<>(List.of("-", "0", "0", "-", "2", "2", "-", "0", "0", "-"))); // array1
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