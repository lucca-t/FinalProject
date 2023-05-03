package com.game.finalproject;

public class Action {
    private int location;
    private String type;
    private boolean used;
    private int usages;

    public Action(int loc, String ty, boolean u){
        location = loc;
        type = ty;
        used = u;
        usages = 0;
    }
    public String getType(){
        return type;
    }
    public void setType(String ty){
        type = ty;
    }
    public int getLoc(){
        return location;
    }
    public void setLoc(int loc){
        location = loc;
    }
    public void setUsed(boolean u){
        used = u;
    }
    public boolean getUsed(){
        return used;
    }
    @Override
    public boolean equals(Object c) {
        String a = (String)(c);
        if (a.equals(this.type)) {
            return true;
        }
        return false;
    }
}
