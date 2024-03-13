package com.colab.minerscli;

import java.sql.SQLOutput;

public class Rules {
    //Check win conditions (if a player has 21 points within one field on their side, they get the diamond responding to that field,
    //if they have more than 21, the diamond gets destroyed and they can change the placement of miners working on that field to another field). [Based on the comparison of the Diamonds density and the sum of fields (methods in Board)
    //if they have an equal amount of diamonds or none at all (which still is equal) the one with the least pressure on the field wins.
    //Game either ends or continues

    public static void checkIfPlayerGetsADiamond(Board board, Player p1, Player p2) {


        if (board.d1.density == board.getFieldBottomLeft()) {
            board.d1.density = 0;
            p1.setDiamondsRewarded(p1.getDiamondsRewarded() + 1);
        }
        if (board.d2.density == board.getFieldBottomMiddle()) {
            board.d2.density = 0;
            p1.setDiamondsRewarded(p1.getDiamondsRewarded() + 1);
        }
        if (board.d3.density == board.getFieldBottomRight()) {
            board.d3.density = 0;
            p1.setDiamondsRewarded(p1.getDiamondsRewarded() + 1);
        }
        if (board.d1.density == board.getFieldTopLeft()) {
            board.d1.density = 0;
            p2.setDiamondsRewarded(p2.getDiamondsRewarded() + 1);
        }
        if (board.d2.density == board.getFieldTopMiddle()) {
            board.d2.density = 0;
            p2.setDiamondsRewarded(p2.getDiamondsRewarded() + 1);
        }
        if (board.d3.density == board.getFieldTopRight()) {
            board.d3.density = 0;
            p2.setDiamondsRewarded(p2.getDiamondsRewarded() + 1);
        }
    }

    public static void checkIfDiamondIsDestroyed(Board board, Player p1, Player p2) {
        //       p2      p1
        //d1 = topleft bottomleft
        //d2 = topmid bottommid
        //d3 = topright bottomright

        if (board.d1.density < board.getFieldBottomLeft()) {
            board.d1.density = 0;
        }
        if (board.d2.density < board.getFieldBottomMiddle()) {
            board.d2.density = 0;
        }
        if (board.d3.density < board.getFieldBottomRight()) {
            board.d3.density = 0;
        }
        if (board.d1.density < board.getFieldTopLeft()) {
            board.d1.density = 0;
        }
        if (board.d2.density < board.getFieldTopMiddle()) {
            board.d2.density = 0;
        }
        if (board.d3.density < board.getFieldTopRight()) {
            board.d3.density = 0;
        }

        // TODO: Add functionality to move troops to other fields.

    }
    //       p2      p1
    //d1 = topleft bottomleft
    //d2 = topmid bottommid
    //d3 = topright bottomright
    public static void allowPlayerToMoveMinersIfTheDiamondIsDestroyed(Board board, Player p1, Player p2){
        if (board.d1.density == 0){
            if (board.getFieldTopLeft()>21){

            }
        }
    }

    public static void checkWinConditionsIfAllDiamondsAreGone(Board board, Player p1, Player p2) {
        //       p2      p1
        //d1 = topleft bottomleft
        //d2 = topmid bottommid
        //d3 = topright bottomright

        //If there are no diamonds and players dont have an equal amount of diamonds, we check who won.

        if ((board.d1.density == 0) && (board.d2.density == 0) && (board.d3.density == 0)
                && (p1.getDiamondsRewarded() != p2.getDiamondsRewarded())) {
            if (p1.getDiamondsRewarded() < p2.getDiamondsRewarded()) {
                System.out.println(p2.getName() + " WON!");
            } else if (p2.getDiamondsRewarded() < p1.getDiamondsRewarded()) {
                System.out.println(p1.getName() + " WON!");
            }
        }

        //If there are no diamonds but players have an equal amount of diamonds we check their pressure, the one with the lower pressure wins.

        else if ((board.d1.density == 0) && (board.d2.density == 0) && (board.d3.density == 0)
                && (p1.getDiamondsRewarded() == p2.getDiamondsRewarded())) {
            int p1Pressure = (board.getFieldBottomLeft() + board.getFieldBottomMiddle() + board.getFieldBottomRight());
            int p2Pressure = (board.getFieldTopLeft()) + board.getFieldTopMiddle() + board.getFieldTopRight();
            if (p1Pressure < p2Pressure) {
                System.out.println(p1.getName() + " WON!");
            } else if (p2Pressure < p1Pressure) {
                System.out.println(p2.getName() + " WON!");
            } else {
                System.out.println("It's a tie!");
            }
        }
    }
}



