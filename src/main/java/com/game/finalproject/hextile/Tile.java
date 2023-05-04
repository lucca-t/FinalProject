
package com.game.finalproject.hextile;

import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class Tile extends Polygon {

    private final static double r = 20; // the inner radius from hexagon center to outer corner
    private final static double n = Math.sqrt(r * r * 0.75); // the inner radius from hexagon center to middle of the axis
    private final static double TILE_HEIGHT = 2 * r;
    private final static double TILE_WIDTH = 2 * n;
    Tile(double x, double y) {
        // creates the polygon using the corner coordinates
        getPoints().addAll(
                x, y,
                x, y + r,
                x + n, y + r * 1.5,
                x + TILE_WIDTH, y + r,
                x + TILE_WIDTH, y,
                x + n, y - r * 0.5
        );

        // set up the visuals and a click listener for the tile
        setFill(Color.ANTIQUEWHITE);
        setStrokeWidth(1);
        setStroke(Color.BLACK);
        setOnMouseClicked(e -> System.out.println("Clicked: " + this));
    }
}

