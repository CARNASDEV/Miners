package com.colab.minerscli;

public class Card {

    private String name;
    private int id;
    private int pressure;


    public Card(){}

    public Card(String name, int id, int pressure) {
    this.name = name;
    this.id = id;
    this.pressure = pressure;

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


