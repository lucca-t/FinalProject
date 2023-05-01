package com.game.finalproject;

import java.util.ArrayList;

public class Player {
    private int points;
    private String settlementColor;
    private int settlements;
    private ArrayList<Action> actions;
    private ArrayList<Coord> occupiedTiles;
    private Card terrain;

    public Player(String col){
        points = 0;
        settlements = 40;
        settlementColor = col;
        actions = new ArrayList<Action>();
        terrain = null;
        occupiedTiles = new ArrayList<Coord>();
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
    public void addSettlementTile(Coord h) {
        occupiedTiles.add(h);
    }
    public ArrayList<Coord> getOccupiedTiles() {
        return occupiedTiles;
    }
}
