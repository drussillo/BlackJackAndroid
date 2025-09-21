package com.example.blackjackandroid;

public class Card {
    private int value;
    private int value2;
    private String foreground;
    private String background;
    public Card(int value, int value2, String foreground, String background) {
        this.value = value;
        this.value2 = value2;
        this.foreground = foreground;
        this.background = background;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }

    public void setForeground(String foreground) {
        this.foreground = foreground;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public int getValue() {
        return value;
    }

    public int getValue2() {
        return value2;
    }

    public String getForeground() {
        return foreground;
    }

    public String getBackground() {
        return background;
    }



}