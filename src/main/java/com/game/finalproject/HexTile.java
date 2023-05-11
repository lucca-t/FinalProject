package com.game.finalproject;



public class HexTile {
    private String type;

    private boolean edge;
    private boolean checked, counted, touched, selectedForPlacement,citchecked;
    private Player occupant;

    public HexTile(String t) {

        type = t;
        edge = false;
        occupant = null;
        checked = false;
        counted = false;
        touched = false;
        citchecked=false;
        selectedForPlacement = false;

    }
    public void setOccupancy(Player p) {
        occupant = p;
        selectedForPlacement = false;
    }
    public void setCitchecked(boolean temp){
        citchecked=temp;
    }
    public boolean getCitchecked(){
        return citchecked;
    }
    public void setSelected() {
        selectedForPlacement = true;
    }

    public boolean selected() {
        return selectedForPlacement;
    }

    public Player getOccupancy() {return occupant;}

    public String getType() {return type;}

    public void setEdge() {edge = true;}
    public void setCheck(boolean c) {
        checked = c;
    }
    public void setCounted(boolean c) {
        counted = c;
    }
    public void setTouched(boolean c) {
        counted = c;
    }

    public boolean getChecked() {
    return checked;
    }
    public boolean getCounted() {
        return counted;
    }
    public boolean getTouched() {
        return touched;
    }

    public String toString() {
        return type;
    }

}
