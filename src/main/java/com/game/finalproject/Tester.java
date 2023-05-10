package com.game.finalproject;

import java.util.ArrayList;
import java.util.HashMap;

public class Tester {
//    private KingdomBuilderMain game;
//    private Board b;
//    private HashMap<double[], HexTile> tiles;

    public static void main(String[] args) {
        //pulling HexTiles
        Board b = new Board(0, 1, 2, 3);
        String board = "";
        HashMap tiles = b.getTiles();
        //String tileString = b.getBoardTemp();
        double[] coord = new double[2];
        coord[0] = 0;
        coord[1] = 1;
//        System.out.println(tiles.get(coord));

        //printing the HashMap of tiles
        System.out.println(b.toString());
        System.out.println(tiles);
        Coord c = new Coord(0.0, 0.0);
        System.out.println(tiles.get((Coord)(c)));
        //printing out the HashMap of tiles and retreiving through the KingdomBuilderMain class
        KingdomBuilderMain game = new KingdomBuilderMain();
        System.out.println(game.getBoard().getTiles().toString());
        Coord j = new Coord(0.5, 1);
        System.out.println(game.getBoard().getTiles().get(j).toString());
        //random assignment of terrain
        ArrayList<Player> players = game.getPlayers();
        for (int t = 0; t < 4; t++) {
            System.out.println(t + " : " + players.get(t).getTerrain());
        }

        //boardAction
        System.out.println(game.getBoard().getBoardActions());

    }
}