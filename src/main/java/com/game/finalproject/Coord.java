package com.game.finalproject;

public class Coord {
    private double x;
    private double y;
    private int num;

    public Coord(double r, double c){
        x = c;
        y = r;
        num = (int)((x*y + x + y)*10);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object c) {
        Coord coord = (Coord)(c);
        if (this.x == coord.getX() && this.y == coord.getY()) {
            return true;
        }
        return false;
    }
    @Override
    public int hashCode(){
        return num;
    }
    public String toString() {
        String out = "(" + x + ", " + y + ")";
        return out;
    }
}
