package com.game.finalproject;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;

public class Node  extends Polygon{
    private String type;
    private boolean balls;
    public Node(){
        super(20,20,20,20,20);
        setLayoutX(357);
        setLayoutY(95);
        type="g";
        //setFill(Paint.valueOf("0"));


        //so maybe wont make it a polygon to have more options idk yet

        //figuring out rn, set default values for the polygonand then also take in like a coordinate or something to tie it to board class


    }
    public void onClick(){
        //check the stuff to make sure u can place and stuff
        //also if placed alr true can also unplace



    }

}
