package com.colab.minerscli;

public class Card {

    private String name;
    private int id;
    private int pressure;

    public Card(){}

    public Card(String name, int pressure) {
    this.name = name;
    this.pressure = pressure;
    }


    //Override toString method to print out card object in a meaningful way
    @Override
    public String toString() {
        return "Name: " + name + ", Pressure: " + pressure;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getPressure() {
        return pressure;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPressure(int pressure) {
        this.pressure = pressure;
    }
}


