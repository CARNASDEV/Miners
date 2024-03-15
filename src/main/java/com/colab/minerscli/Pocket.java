
package com.colab.minerscli;

public class Pocket {
    int chosenAreaNumber;
    int pressure;
    int positionInGrid;

    public Pocket(){}
    public Pocket(int chosenAreaNumber, int pressure, int positionInGrid){
        this.chosenAreaNumber = chosenAreaNumber;
        this.pressure = pressure;
        this.positionInGrid = positionInGrid;

    }

    public int getChosenAreaNumber() {
        return chosenAreaNumber;
    }

    public void setChosenAreaNumber(int chosenAreaNumber) {
        this.chosenAreaNumber = chosenAreaNumber;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getPositionInGrid() {
        return positionInGrid;
    }

    public void setPositionInGrid(int positionInGrid) {
        this.positionInGrid = positionInGrid;
    }
    }
