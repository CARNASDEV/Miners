package com.colab.minerscli;

public class Card {

    private String name;
    private int id;
    private int pressure;

    private String type; // Added this line i onsdags


    public Card(){}

    public Card(String name, int pressure) {
    this.name = name;
    this.pressure = pressure;
    }


    //Override toString method to print out card object in a meaningful way
    @Override
    public String toString() {
        //return "Name: " + name + ", Pressure: " + pressure;
        //return String.format("%-20s | Pressure: %-2d", name, pressure);
        return String.format("%-20s | Pressure: %-2d", name, pressure);
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

    // Added getter and setter for `type`
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}


