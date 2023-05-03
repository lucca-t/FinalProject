package com.game.finalproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class KingdomBuilderMain {
    private ArrayList<Player> players;
    private ArrayList<String> pointCards, discardedBiomes, pointCardsall;
    private ArrayList<Card> terrains;
    private int turn, num1, num2, num3, num4;
    private Board board;
    private HashMap tiles;
    public boolean end;
    private ArrayList<Coord> settlementCords;

    public KingdomBuilderMain(){
        pointCardsall = new ArrayList<String>();
        pointCards = new ArrayList<String>();
        pointCardsall.add("Citizen");
        pointCardsall.add("Discoverers");
        pointCardsall.add("Farmers");
        pointCardsall.add("Fishermen");
        pointCardsall.add("Hermits");
        pointCardsall.add("Knights");
        pointCardsall.add("Lords");
        pointCardsall.add("Merchants");
        pointCardsall.add("Miners");
        pointCardsall.add("Workers");

        //choosing boards
        ArrayList<Integer> choose = new ArrayList<Integer>();
        for (int a = 0; a < 4; a++) {choose.add(a);}
        Collections.shuffle(choose);
        board = new Board(choose.get(0), choose.get(1), choose.get(2), choose.get(3));

        //players
        players = new ArrayList<Player>();
        players.add(new Player("red"));
        players.add(new Player("purple"));
        players.add(new Player("pink"));
        players.add(new Player("orange"));
        for(int i = 0; i < 3; i++){
            int x = (int)(Math.random() * pointCardsall.size());
            pointCards.add(pointCardsall.get(x));
            pointCardsall.remove(x);
        }
        turn = 0;
        terrains = new ArrayList<Card>();
        resetTerrainDeck();
//        terrains.add("s");
//        terrains.add("g");
//        terrains.add("d");
//        terrains.add("c");
//        terrains.add("m");
//        terrains.add("w");
//        terrains.add("f");
        discardedBiomes = new ArrayList<String>();
        end = false;

        Collections.shuffle(terrains);
//        for (int j = 0; j < players.size(); j++) {
////            int choiceTerrain = (int)(Math.random()*25);
//            players.get(j).setTerrain(terrains.get(choiceTerrain));
//            terrains.remove(choiceTerrain);
//        }
        settlementCords = new ArrayList<Coord>();
    }
    public ArrayList getPointsCards(){
        return pointCards;
    }

    public void resetTerrainDeck() {
        terrains.clear();
        for (int i = 0; i < 5; i++) {
            terrains.add(0, new Card("s"));
            terrains.get(0).setVisibility(false);
        }
        for (int i = 0; i < 5; i++) {
            terrains.add(0, new Card("g"));
            terrains.get(0).setVisibility(false);
        }
        for (int i = 0; i < 5; i++) {
            terrains.add(0, new Card("d"));
            terrains.get(0).setVisibility(false);
        }
        for (int i = 0; i < 5; i++) {
            terrains.add(0, new Card("c"));
            terrains.get(0).setVisibility(false);
        }
        for (int i = 0; i < 5; i++) {
            terrains.add(0, new Card("f"));
            terrains.get(0).setVisibility(false);
        }
        Collections.shuffle(terrains);
    }
    public Player getTurnPlayer() {
        return players.get(turn);
    }

    /*public void setSettlementCord(Coord sC) {
        if (checkValidPlacement(sC, players.get(0))) {
//            settlementCords = sC;
        }
    }*/

//    public void runGame() {
//        while (!end) {
//            for (int j = 0; j < players.size(); j++) {
//                int choiceTerrain = (int)(Math.random()*25);
//                players.get(j).setTerrain(terrains.get(choiceTerrain));
//                players.get(j).getTerrain().setVisibility(false);
//                terrains.remove(choiceTerrain);
//            }
//            players.get(turn).getTerrain().setVisibility(true);
//            playTurn();
//
//            if (turn == 3) {
//                for (int i = 0; i < players.size(); i++) {
//                    if (players.get(i).getNumSettlements() == 0) {
//                        //might have issues?
//                        endGame();
//                        break;
//                    }
//                }
//            }
//            nextTurn();
//        }
//    }

    public void newRound() {
        for (int j = 0; j < players.size(); j++) {
                int choiceTerrain = (int)(Math.random()*25);
                players.get(j).setTerrain(terrains.get(choiceTerrain));
                players.get(j).getTerrain().setVisibility(false);
                terrains.remove(choiceTerrain);
            }

    }

    public void playTurn(){
        players.get(turn).getTerrain().setVisibility(true);
        for (int i = 0; i < settlementCords.size(); i++) {
            board.getTiles().get(settlementCords.get(i)).setOccupancy(players.get(turn));
        }
    }

    public void nextTurn(){
        ArrayList<Action> temp = players.get(turn).getActions();
        for (int i = 0; i < temp.size(); i++) {
            temp.get(i).setUsed(false);
        }
        players.get(turn).setTerrain(null);
        turn++;
        if (terrains.size() == 0) {
            resetTerrainDeck();
        }
        int choiceTerrain = (int)(Math.random()*25);
        players.get(turn).setTerrain(terrains.get(choiceTerrain));
        terrains.remove(choiceTerrain);
        players.get(turn).getTerrain().setVisibility(true);
        turn = turn%4;
    }
    public void endGame(){
        end = true;
    }
    public ArrayList<Card> getTerrains() {
        return terrains;
    }
    public void scorePlayers(){
        //using the board object, pass in each player to score as an argument
        for (String pointCard : pointCards) {
            switch (pointCardsall.indexOf(pointCard)) {
                case 0:
                    board.scoreCitizens(players);
                case 1:
                    board.scoreDiscoverers(players);
                case 2:
                    board.scoreFarmers(players);
                case 3:
                    board.scoreFishermen(players);
                case 4:
                    board.scoreHermits(players);
                case 5:
                    board.scoreKnights(players);
                case 6:
                    board.scoreLords(players);
                case 7:
                    board.scoreMerchants(players);
                case 8:
                    board.scoreMiners(players);
                case 9:
                    board.scoreWorkers(players);
            }
        }
//        for (int i = 0; i < 4; i++) {
//            board.score(players.get(i));
//        }
    }
    public ArrayList<Player> getPlayers(){
        return players;
    }

    //tester methods
    public Board getBoard() {
        return board;
    }


    public boolean checkValidPlacement(Coord sC, Player p, String act){
        String terrainTypes = board.getTiles().get(sC).getType();
        if(!board.getTiles().get(sC).getOccupancy().equals(null)){
            return false;
        }
        if (terrainTypes.equals("m")) {
            return false;
        }
        if (terrainTypes.equals("w") && !act.equals("Harbor")) {
            return false;
        }
        if(act.equals("")){
            boolean occ = false;
            if(!terrainTypes.equals(players.get(turn).getTerrain())) {
                return false;
            }
            for(int i = 0; i < p.getOccupiedTiles().size(); i++){
                if(board.getTiles().get(p.getOccupiedTiles().get(i)).getType().equals(terrainTypes)){
                    occ = true;
                }
            }
            if(!occ){
                return true;
            }
            if((!(sC.getX() == (0.0))) || (!(sC.getX() == (19.0))) || (!(sC.getX() == (19.5))) || (!(sC.getX() == (0.5)))){
                for(int i = 0 ; i < findAdjacencies(sC).size(); i++){
                    if(board.getTiles().get(findAdjacencies(sC).get(i)).getOccupancy().equals(p)){
                        return true;
                    }
                    return false;
                }
            }
        }
        if(act.equals("Farm")){
            if(!terrainTypes.equals("g")){
                return false;
            }
            boolean occ = false;
            for(int i = 0; i < p.getOccupiedTiles().size(); i++){
                if(board.getTiles().get(p.getOccupiedTiles().get(i)).getType().equals("g")){
                    occ = true;
                }
            }
            if(!occ){
                return true;
            }
            for(int i = 0 ; i < findAdjacencies(sC).size(); i++){
                if(board.getTiles().get(findAdjacencies(sC).get(i)).getOccupancy().equals(p)){
                    return true;
                }
            }
            return false;

        }
        if(act.equals("Oasis")){
            if(!terrainTypes.equals("s")){
                return false;
            }
            boolean occ = false;
            for(int i = 0; i < p.getOccupiedTiles().size(); i++){
                if(board.getTiles().get(p.getOccupiedTiles().get(i)).getType().equals("s")){
                    occ = true;
                }
            }
            if(!occ){
                return true;
            }
            for(int i = 0 ; i < findAdjacencies(sC).size(); i++){
                if(board.getTiles().get(findAdjacencies(sC).get(i)).getOccupancy().equals(p)){
                    return true;
                }
            }
            return false;
        }
        if(act.equals("Tower")){
            if((!(sC.getX() == (0.0))) || (!(sC.getX() == (19.0))) || (!(sC.getX() == (19.5))) || (!(sC.getX() == (0.5)))){
                if((!(sC.getY() == (0.0))) || (!(sC.getY() == (19.0)))){
                    return false;
                }
            }
            boolean occ = false;
            ArrayList<Coord> available = new ArrayList<>();
            for(int i = 0; i < p.getOccupiedTiles().size(); i++){
                if((!(p.getOccupiedTiles().get(i).getX() == (0.0))) || (!(p.getOccupiedTiles().get(i).getX() == (19.0))) || (!(p.getOccupiedTiles().get(i).getX() == (19.5))) || (!(sC.getX() == (0.5)))){
                    if((!(p.getOccupiedTiles().get(i).getY() == (0.0))) || (!(p.getOccupiedTiles().get(i).getY() == (19.0)))){
                        for(int k = 0; k < findAdjacencies(p.getOccupiedTiles().get(i)).size(); k++){
                            if(findAdjacencies(p.getOccupiedTiles().get(i)).get(k).getX() == (0.0) || findAdjacencies(p.getOccupiedTiles().get(i)).get(k).getX() == (19.0) || findAdjacencies(p.getOccupiedTiles().get(i)).get(k).getX() == (19.5) || findAdjacencies(p.getOccupiedTiles().get(i)).get(k).getX() == (0.5)){
                                if(findAdjacencies(p.getOccupiedTiles().get(i)).get(k).getY() == (0.0) || findAdjacencies(p.getOccupiedTiles().get(i)).get(k).getY() == (19.0)){
                                    occ = true;
                                    if(board.getTiles().get(findAdjacencies(p.getOccupiedTiles().get(i)).get(k)).getOccupancy() == null){
                                        available.add(findAdjacenciesEdge(p.getOccupiedTiles().get(i)).get(k));
                                    }
                                }
                            }
                        }
                    }
                }
                else{
                    for(int k = 0; k < findAdjacenciesEdge(p.getOccupiedTiles().get(i)).size(); k++){
                        if(findAdjacenciesEdge(p.getOccupiedTiles().get(i)).get(k).getX() == (0.0) || findAdjacenciesEdge(p.getOccupiedTiles().get(i)).get(k).getX() == (19.0) || findAdjacenciesEdge(p.getOccupiedTiles().get(i)).get(k).getX() == (19.5)|| findAdjacenciesEdge(p.getOccupiedTiles().get(i)).get(k).getX() == (0.5)){
                            if(findAdjacenciesEdge(p.getOccupiedTiles().get(i)).get(k).getY() == (0.0) || findAdjacenciesEdge(p.getOccupiedTiles().get(i)).get(k).getY() == (19.0)){
                                occ = true;
                                if(board.getTiles().get(findAdjacenciesEdge(p.getOccupiedTiles().get(i)).get(k)).getOccupancy() == null){
                                    available.add(findAdjacenciesEdge(p.getOccupiedTiles().get(i)).get(k));
                                }
                            }
                        }
                    }
                }
            }

            if(!occ) {
                return true;
            }
            for(int i = 0; i < available.size(); i++){
                if(available.get(i).equals(sC)){
                    return true;
                }
            }
            return false;

        }


        return true;
    }
    public ArrayList<Coord> findAdjacenciesEdge(Coord c){
        ArrayList<Coord> adjacent = new ArrayList<>();
        if(c.getX() == 0.0){
            if(c.getY() == 0.0){
                adjacent.add(new Coord(c.getY() + 1, c.getX() + 0.5));
                adjacent.add(new Coord(c.getY(), c.getX() + 1));
            }
            adjacent.add(new Coord(c.getY(), c.getX() + 1));
            adjacent.add(new Coord(c.getY() - 1, c.getX() + 0.5));
            adjacent.add(new Coord(c.getY() + 1, c.getX() + 0.5));
            return adjacent;
        }
        if(c.getX() == 0.5){
            if(c.getY() == 19.0){
                adjacent.add(new Coord(c.getY() - 1, c.getX() - 0.5));
                adjacent.add(new Coord(c.getY() - 1, c.getX() + 0.5));
                adjacent.add(new Coord(c.getY(), c.getX() + 1));
            }
            adjacent.add(new Coord(c.getY() - 1, c.getX() - 0.5));
            adjacent.add(new Coord(c.getY() - 1, c.getX() + 0.5));
            adjacent.add(new Coord(c.getY(), c.getX() + 1));
            adjacent.add(new Coord(c.getY() + 1, c.getX() - 0.5));
            adjacent.add(new Coord(c.getY() + 1, c.getX() + 0.5));
            return adjacent;
        }
        if(c.getX() == 19.0){
            if(c.getY() == 0.0){
                adjacent.add(new Coord(c.getY() + 1, c.getX() + 0.5));
                adjacent.add(new Coord(c.getY(), c.getX() + 1));
                adjacent.add(new Coord(c.getY() - 1, c.getX() - 0.5));

            }
            adjacent.add(new Coord(c.getY() - 1, c.getX() - 0.5));
            adjacent.add(new Coord(c.getY() - 1, c.getX() + 0.5));
            adjacent.add(new Coord(c.getY(), c.getX() - 1));
            adjacent.add(new Coord(c.getY() + 1, c.getX() - 0.5));
            adjacent.add(new Coord(c.getY() + 1, c.getX() + 0.5));
            return adjacent;
        }
        if(c.getX() == 19.5){
            if(c.getY() == 19.0){
                adjacent.add(new Coord(c.getY() - 1, c.getX() - 0.5));
                adjacent.add(new Coord(c.getY(), c.getX() - 1));

            }
            adjacent.add(new Coord(c.getY() - 1, c.getX() - 0.5));
            adjacent.add(new Coord(c.getY(), c.getX() - 1));
            adjacent.add(new Coord(c.getY() + 1, c.getX() - 0.5));
            return adjacent;
        }
        return adjacent;

    }
    public ArrayList<Coord> findAdjacencies(Coord c){
        ArrayList<Coord> adjacent = new ArrayList<>();
        Coord right = new Coord(c.getY(), c.getX() + 1);
        Coord tL = new Coord(c.getY() + 1, c.getX() - 0.5);
        Coord tR = new Coord(c.getY() + 1, c.getX() + 0.5);
        Coord bL = new Coord(c.getY() - 1, c.getX()- 0.5);
        Coord bR = new Coord(c.getY() - 1, c.getX() + 0.5);
        Coord left = new Coord(c.getY(), c.getX() - 1);
        adjacent.add(left);
        adjacent.add(right);
        adjacent.add(tL);
        adjacent.add(tR);
        adjacent.add(bL);
        adjacent.add(bR);
        return adjacent;
    }
    public int getTurnNum(){
        return turn;
    }
    //need it to test buttons
    public void testNextTurnNum(){
        turn++;
        turn%=4;
    }
    public void testPrevTurnNum(){
        turn+=3;
        turn%=4;

    }
}
