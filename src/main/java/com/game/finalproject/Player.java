package com.game.finalproject;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Player {
    private int points;
    private String settlementColor;
    private int settlements;
    private ArrayList<Action> actions;
    private ArrayList<Coord> occupiedTiles;
    private Card terrain;
    private int turnSettlePlaced;
    private ArrayList<Coord> choiceHex;
    private boolean fPlayer;
    public Player(String col){
        points = 0;
        settlements = 40;
        settlementColor = col;
        actions = new ArrayList<Action>();
        terrain = null;
        occupiedTiles = new ArrayList<Coord>();
        turnSettlePlaced=3;
        choiceHex = new ArrayList<Coord>();
        fPlayer=false;

    }
    public void setScore(int pnt){
        points = pnt;
    }
    public void addPoints(int pnt) {
        points = points + pnt;
    }
    public int getScore(){
        return points;
    }
    public void addActions(Action x){
        actions.add(x);
    }
    public Action getAction(int i){
        return actions.get(i);
    }
    public ArrayList<Action> getActions() {
        return actions;
    }
    public void setColor(String col){
        settlementColor = col;
    }
    public String getColor(){
        return settlementColor;
    }
    public void setTerrain(Card ter){
        terrain = ter;
    }
    public Card getTerrain(){
        return terrain;
    }
    public int getNumSettlements() {
        return settlements;
    }
    public void decSettlements(int amount){
        settlements -= amount;
    }
    public void minusSettlements(){settlements=settlements-1;}
    public void addSettlementTile(Coord h) {
        occupiedTiles.add(h);
    }
    public ArrayList<Coord> getOccupiedTiles() {
        return occupiedTiles;
    }

    public void addChoiceHex(Coord c) {
        choiceHex.add(c);
    }

    public ArrayList<Coord> getChoiceHexes() {
        return choiceHex;
    }

    public void clearChoiceHexes() {
        choiceHex.clear();
    }

    Color getColorHex(){
        Color color= Color.BEIGE;

        if(settlementColor.equals("red"))
            color= Color.valueOf("#ff0000");
        else if(settlementColor.equals("purple"))
            color= Color.valueOf("#9d1cff");
        else if(settlementColor.equals("pink"))
            color= Color.valueOf("#ff6fd6");
        else if(settlementColor.equals("orange"))
            color= Color.valueOf("#ff6600");

        return color;
    }

    public boolean equals(Object o) {
        Player p = (Player)(o);
        if (p.getColor().equals(settlementColor)) {
            return true;
        }
        return false;
    }
    public int getTSPlaced(){
        return turnSettlePlaced;
    }
    public void decTSPlaced(){
        turnSettlePlaced--;
    }
    public void resTSPlaced(){turnSettlePlaced=3;}
    public void incTSPlaced(){
        turnSettlePlaced++;
    }
    public void setfPlayer(boolean balls){fPlayer=balls;}
    public boolean getfPlayer(){return fPlayer;}
    //red "#ff0000"
//purple "#9d1cff"
//pink "#ff6fd6"
//orange "#ff6600"

}
