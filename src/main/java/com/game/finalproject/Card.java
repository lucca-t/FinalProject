package com.game.finalproject;

public class Card {
    private String type;
    private boolean visible;

    public Card(String t) {type = t;}

    public void setVisibility(boolean v) {visible = v;}

    public boolean getVisibility() {return visible;}

    public String toString() {
        return type;
    }

//    public int scoreMerchants() {
//    }
}
