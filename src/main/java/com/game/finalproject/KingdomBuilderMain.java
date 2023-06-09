package com.game.finalproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class KingdomBuilderMain {
    private ArrayList<Player> players;
    private ArrayList<String> pointCards, discardedBiomes, pointCardsall;
    private ArrayList<Card> terrains;
    private int turn, num1, num2, num3, num4;
    private Board board;
    private HashMap tiles;
    public boolean end;
    private ArrayList<Coord> settlementCords;

    private HashMap<ArrayList<Action>, Integer> boardActions;
    //private String totalScoring;

    private ArrayList<Coord> printingThing;
    boolean settlementsDepleted;


    public KingdomBuilderMain(){
        settlementsDepleted = false;
        printingThing = null;
        pointCardsall = new ArrayList<String>();
        pointCards = new ArrayList<String>();
       // pointCardsall.add("Citizen");to avoid scoring error
//        pointCardsall.add("Discoverers");
//        pointCardsall.add("Farmers");
        pointCardsall.add("Fishermen");
       // pointCardsall.add("Hermits"); to avoid scoring error
//        pointCardsall.add("Knights");
//        pointCardsall.add("Lords");
        //pointCardsall.add("Merchants");to avoid scoring error
        pointCardsall.add("Miners");
        pointCardsall.add("Workers");

        //choosing boards
        ArrayList<Integer> choose = new ArrayList<Integer>();
        for (int a = 0; a < 4; a++) {choose.add(a);}
        Collections.shuffle(choose);
        board = new Board(choose.get(0), choose.get(1), choose.get(2), choose.get(3));
        boardActions = new HashMap<ArrayList<Action>, Integer>();

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
        players.get(0).setfPlayer(true);



        turn = 0;
        terrains = new ArrayList<Card>();
        resetTerrainDeck();

        discardedBiomes = new ArrayList<String>();
        end = false;

        Collections.shuffle(terrains);
        for (int j = 0; j < players.size(); j++) {
            players.get(j).setTerrain(terrains.get(0));
            players.get(j).getTerrain().setVisibility(false);
            terrains.remove(0);
        }
        players.get(turn).getTerrain().setVisibility(true);
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
        players.get(turn).setTerrain(terrains.get(0));
        terrains.remove(0);
        turn++;
        turn%=4;
        if (terrains.size() == 0) {
            resetTerrainDeck();
        }
//        int choiceTerrain = (int)(Math.random()*25);
//        players.get(turn).setTerrain(terrains.get(choiceTerrain));
//        terrains.remove(choiceTerrain);
        players.get(turn).getTerrain().setVisibility(true);

//        boolean settlementsDepleted = false;
        for (int p = 0; p < players.size(); p++) {
            if (players.get(p).getNumSettlements() == 0) {
                settlementsDepleted = true;
            }
        }

        if (turn == 0 && settlementsDepleted) {
            endGame();
        }
    }
    public boolean isEnd() {
        return end;
    }
    public void endGame(){
        end = true;
    }
    public ArrayList<Card> getTerrains() {
        return terrains;
    }
    public void scorePlayers(){
        //using the board object, pass in each player to score as an argument
        /*for (String pointCard : pointCards) {
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
        }*/
       /* for (int x=0;x<3;x++) {
            String pointCard=pointCards.get(x);
            switch (pointCard) {
//                case "Citizen":
                    //board.scoreCitizens(players);
                case "Discoverers":
                    board.scoreDiscoverers(players);
//                case "Farmers":
//                    board.scoreFarmers(players);
                case "Fishermen":
                    board.scoreFishermen(players);
//                case "Hermits":
//                    //board.scoreHermits(players);
//                case "Knights":
//                    board.scoreKnights(players);
//                case "Lords":
//                    board.scoreLords(players);
//                case "Merchants":
                   // board.scoreMerchants(players);
                case "Miners":
                    board.scoreMiners(players);
//                case "Workers":
//                    board.scoreWorkers(players);
            }


        }*/
       // board.scoreDiscoverers(players);
        board.scoreWorkers(players);
        board.scoreFishermen(players);
        board.scoreMiners(players);
        board.scoreCities(players);

    }
    public ArrayList<Player> getPlayers(){
        return players;
    }

    //tester methods
    public Board getBoard() {
        return board;
    }
    public int tavernHelperRight(Coord sC, Player p){
        if(board.getTiles().get(new Coord(sC.getX() + 1, sC.getY())).getOccupancy().equals(p)){
            return 1 + tavernHelperRight(new Coord(sC.getX() + 1, sC.getY()), p);
        }
        return 0;
    }

    public int tavernHelperLeft(Coord sC, Player p){
        if(board.getTiles().get(new Coord(sC.getX() - 1, sC.getY())).getOccupancy().equals(p)){
            return 1 + tavernHelperLeft(new Coord(sC.getX() - 1, sC.getY()), p);
        }
        return 0;
    }
    public int tavernHelperUpLeft(Coord sC, Player p){
        if(board.getTiles().get(new Coord(sC.getX() - 0.5, sC.getY() - 1)).getOccupancy().equals(p)){
            return 1 + tavernHelperUpLeft(new Coord(sC.getX() - 0.5, sC.getY() - 1), p);
        }
        return 0;
    }
    public int tavernHelperDownLeft(Coord sC, Player p){
        if(board.getTiles().get(new Coord(sC.getX() - 0.5, sC.getY() + 1)).getOccupancy().equals(p)){
            return 1 + tavernHelperDownLeft(new Coord(sC.getX() - 0.5, sC.getY() + 1), p);
        }
        return 0;
    }
    public int tavernHelperUpRight(Coord sC, Player p){
        if(board.getTiles().get(new Coord(sC.getX() + 0.5, sC.getY() - 1)).getOccupancy().equals(p)){
            return 1 + tavernHelperUpRight(new Coord(sC.getX() + 0.5, sC.getY() - 1), p);
        }
        return 0;
    }
    public int tavernHelperDownRight(Coord sC, Player p){
        if(board.getTiles().get(new Coord(sC.getX() + 0.5, sC.getY() + 1)).getOccupancy().equals(p)){
            return 1 + tavernHelperDownRight(new Coord(sC.getX() + 0.5, sC.getY() + 1), p);
        }
        return 0;
    }

    public void setPrint(ArrayList<Coord> a) {
        printingThing = a;
    }
    public ArrayList<Coord> getPrint() {
        return printingThing;
    }


    public boolean checkValidPlacement(Coord sC, Player p, String act){
        String terrainTypes = board.getTiles().get(sC).getType();
        if(board.getTiles().get(sC).getOccupancy() != null){
            return false;
        }
        else {
            if (terrainTypes.equals("m")) {
                return false;
            }
            if (terrainTypes.equals("w") && !act.equals("Harbor")) {
                return false;
            }
            if(act.equals("") || act.equals("Oracle")){
                boolean occ = false;
                if(!terrainTypes.equals(p.getTerrain().getType())) {
                    return false;
                }
                for(int i = 0; i < p.getOccupiedTiles().size(); i++){
                    if((!(p.getOccupiedTiles().get(i).getX() == (0.0))) && (!(p.getOccupiedTiles().get(i).getX() == (19.0))) && (!(p.getOccupiedTiles().get(i).getX() == (19.5))) && (!(p.getOccupiedTiles().get(i).getX() == (0.5)))){
                        if((!(p.getOccupiedTiles().get(i).getY() == (0.0))) && (!(p.getOccupiedTiles().get(i).getY() == (19.0)))){
                            for(int k = 0; k < findAdjacencies(p.getOccupiedTiles().get(i)).size(); k++){
                                if(board.getTiles().get(findAdjacencies(p.getOccupiedTiles().get(i)).get(k)).getOccupancy() == null && board.getTiles().get(findAdjacencies(p.getOccupiedTiles().get(i)).get(k)).getType().equals(terrainTypes)){
                                    occ = true;
                                }
                            }
                        }
                    }
                        for(int k = 0; k < findAdjacenciesEdge(p.getOccupiedTiles().get(i)).size(); k++){
                            if(board.getTiles().get(findAdjacenciesEdge(p.getOccupiedTiles().get(i)).get(k)).getOccupancy() == null && board.getTiles().get(findAdjacenciesEdge(p.getOccupiedTiles().get(i)).get(k)).getType().equals(terrainTypes)){
                                occ = true;
                            }
                        }
                }
                if(!occ){
                    return true;
                }
                if((!(sC.getX() == (0.0))) && (!(sC.getX() == (19.0))) && (!(sC.getX() == (19.5))) && (!(sC.getX() == (0.5)))){
                    if((!(sC.getY() == (0.0))) && (!(sC.getY() == (19.0)))){
                        for(int i = 0 ; i < findAdjacencies(sC).size(); i++){
                            if(board.getTiles().get(findAdjacencies(sC).get(i)).getOccupancy() != null){
                                if(board.getTiles().get(findAdjacencies(sC).get(i)).getOccupancy().equals(p)){
                                    return true;
                                }
                            }
                        }
                        return false;
                    }
                }
                    for(int i = 0 ; i < findAdjacenciesEdge(sC).size(); i++){
                        if(board.getTiles().get(findAdjacenciesEdge(sC).get(i)).getOccupancy() != null){
                            if(board.getTiles().get(findAdjacenciesEdge(sC).get(i)).getOccupancy().equals(p)){
                                return true;
                            }
                        }
                    }
                    return false;

            }
            else if(act.equals("Farm")){
                if(!terrainTypes.equals("g")){
                    return false;
                }
                boolean occ = false;
                for(int i = 0; i < p.getOccupiedTiles().size(); i++){
                        if((!(p.getOccupiedTiles().get(i).getX() == (0.0))) && (!(p.getOccupiedTiles().get(i).getX() == (19.0))) && (!(p.getOccupiedTiles().get(i).getX() == (19.5))) && (!(p.getOccupiedTiles().get(i).getX() == (0.5)))){
                            if((!(p.getOccupiedTiles().get(i).getY() == (0.0))) && (!(p.getOccupiedTiles().get(i).getY() == (19.0)))){
                                for(int k = 0; k < findAdjacencies(p.getOccupiedTiles().get(i)).size(); k++){
                                    if(board.getTiles().get(findAdjacencies(p.getOccupiedTiles().get(i)).get(k)).getOccupancy() == null && board.getTiles().get(findAdjacencies(p.getOccupiedTiles().get(i)).get(k)).getType().equals("g")){
                                        occ = true;
                                    }
                                }
                            }
                        }else{
                            for(int k = 0; k < findAdjacenciesEdge(sC).size(); k++){
                                if(board.getTiles().get(findAdjacenciesEdge(p.getOccupiedTiles().get(i)).get(k)).getOccupancy() == null && board.getTiles().get(findAdjacenciesEdge(p.getOccupiedTiles().get(i)).get(k)).getType().equals("g")){
                                    occ = true;
                                }
                            }
                        }


                }
                if(!occ){
                    return true;
                }
                if((!(sC.getX() == (0.0))) && (!(sC.getX() == (19.0))) && (!(sC.getX() == (19.5))) && (!(sC.getX() == (0.5)))){
                    if((!(sC.getY() == (0.0))) && (!(sC.getY() == (19.0)))){
                        for(int i = 0 ; i < findAdjacencies(sC).size(); i++){
                            if(board.getTiles().get(findAdjacenciesEdge(sC).get(i)).getOccupancy() != null) {
                                if (board.getTiles().get(findAdjacencies(sC).get(i)).getOccupancy().equals(p)) {
                                    return true;
                                }
                            }
                        }
                        return false;
                    }
                }
                    for(int i = 0 ; i < findAdjacenciesEdge(sC).size(); i++){
                        if(board.getTiles().get(findAdjacenciesEdge(sC).get(i)).getOccupancy() != null){
                            if(board.getTiles().get(findAdjacenciesEdge(sC).get(i)).getOccupancy().equals(p)){
                                return true;
                            }
                        }
                    }
                    return false;



            }
            else if(act.equals("Oasis")){
                if(!terrainTypes.equals("d")){
                    return false;
                }
                boolean occ = false;
                for(int i = 0; i < p.getOccupiedTiles().size(); i++){
                        if((!(p.getOccupiedTiles().get(i).getX() == (0.0))) && (!(p.getOccupiedTiles().get(i).getX() == (19.0))) &&(!(p.getOccupiedTiles().get(i).getX() == (19.5))) && (!(p.getOccupiedTiles().get(i).getX() == (0.5)))){
                            if((!(p.getOccupiedTiles().get(i).getY() == (0.0))) && (!(p.getOccupiedTiles().get(i).getY() == (19.0)))){
                                for(int k = 0; k < findAdjacencies(p.getOccupiedTiles().get(i)).size(); k++){
                                    if(board.getTiles().get(findAdjacencies(p.getOccupiedTiles().get(i)).get(k)).getOccupancy() == null && board.getTiles().get(findAdjacencies(p.getOccupiedTiles().get(i)).get(k)).getType().equals("s")){
                                        occ = true;
                                    }
                                }
                            }
                        }
                            for(int k = 0; k < findAdjacenciesEdge(p.getOccupiedTiles().get(i)).size(); k++){
                                if(board.getTiles().get(findAdjacenciesEdge(p.getOccupiedTiles().get(i)).get(k)).getOccupancy() == null && board.getTiles().get(findAdjacenciesEdge(p.getOccupiedTiles().get(i)).get(k)).getType().equals("s")){
                                    occ = true;
                                }
                            }
                    }
                if(!occ){
                    return true;
                }
                if((!(sC.getX() == (0.0))) && (!(sC.getX() == (19.0))) && (!(sC.getX() == (19.5))) &&(!(sC.getX() == (0.5)))){
                    if((!(sC.getY() == (0.0))) && (!(sC.getY() == (19.0)))){
                        for(int i = 0 ; i < findAdjacencies(sC).size(); i++){
                            if(board.getTiles().get(findAdjacencies(sC).get(i)).getOccupancy() != null){
                                if(board.getTiles().get(findAdjacencies(sC).get(i)).getOccupancy().equals(p)){
                                    return true;
                                }
                            }

                        }
                        return false;
                    }
                }
                    for(int i = 0 ; i < findAdjacenciesEdge(sC).size(); i++){
                        if(board.getTiles().get(findAdjacenciesEdge(sC).get(i)).getOccupancy() != null){
                            if(board.getTiles().get(findAdjacenciesEdge(sC).get(i)).getOccupancy().equals(p)){
                                return true;
                            }
                        }

                    }
                    return false;

            }
            else if(act.equals("Harbor")){
                if(!terrainTypes.equals("w")){
                    return false;
                }boolean occ = false;
                for(int i = 0; i < p.getOccupiedTiles().size(); i++){
                    if((!(p.getOccupiedTiles().get(i).getX() == (0.0))) && (!(p.getOccupiedTiles().get(i).getX() == (19.0))) &&(!(p.getOccupiedTiles().get(i).getX() == (19.5))) && (!(p.getOccupiedTiles().get(i).getX() == (0.5)))){
                        if((!(p.getOccupiedTiles().get(i).getY() == (0.0))) && (!(p.getOccupiedTiles().get(i).getY() == (19.0)))){
                            for(int k = 0; k < findAdjacencies(p.getOccupiedTiles().get(i)).size(); k++){
                                if(board.getTiles().get(findAdjacencies(p.getOccupiedTiles().get(i)).get(k)).getOccupancy() == null && board.getTiles().get(findAdjacencies(p.getOccupiedTiles().get(i)).get(k)).getType().equals("w")){
                                    occ = true;
                                }
                            }
                        }
                    }
                        for(int k = 0; k < findAdjacenciesEdge(p.getOccupiedTiles().get(i)).size(); k++){
                            if(board.getTiles().get(findAdjacenciesEdge(p.getOccupiedTiles().get(i)).get(k)).getOccupancy() == null && board.getTiles().get(findAdjacenciesEdge(p.getOccupiedTiles().get(i)).get(k)).getType().equals("w")){
                                occ = true;
                            }
                        }

                }
                if(!occ){
                    return true;
                }
                if((!(sC.getX() == (0.0))) && (!(sC.getX() == (19.0))) && (!(sC.getX() == (19.5))) &&(!(sC.getX() == (0.5)))){
                    if((!(sC.getY() == (0.0))) && (!(sC.getY() == (19.0)))){
                        for(int i = 0 ; i < findAdjacencies(sC).size(); i++){
                            if(board.getTiles().get(findAdjacencies(sC).get(i)).getOccupancy().equals(p)){
                                return true;
                            }
                        }
                        return false;
                    }
                }
                    for(int i = 0 ; i < findAdjacenciesEdge(sC).size(); i++){
                        if(board.getTiles().get(findAdjacenciesEdge(sC).get(i)).getOccupancy().equals(p)){
                            return true;
                        }
                    }
                    return false;



            }
        }



        return true;
    }
    public ArrayList<Coord> findAdjacenciesEdge(Coord c){
        ArrayList<Coord> adjacent = new ArrayList<>();
        if(c.getX() == 0.0){
            if(c.getY() == 0.0){
                adjacent.add(new Coord( c.getX() + 0.5,c.getY() + 1));
                adjacent.add(new Coord( c.getX() + 1,c.getY()));
            }
            else {
                adjacent.add(new Coord( c.getX() + 1,c.getY()));
                adjacent.add(new Coord( c.getX() + 0.5,c.getY() - 1));
                adjacent.add(new Coord( c.getX() + 0.5,c.getY() + 1));
            }
            return adjacent;
        }

        if(c.getX() == 0.5){
            if(c.getY() == 19.0){
                adjacent.add(new Coord( c.getX() - 0.5,c.getY() - 1));
                adjacent.add(new Coord( c.getX() + 0.5,c.getY() - 1));
                adjacent.add(new Coord( c.getX() + 1,c.getY()));
            }
            else {
                adjacent.add(new Coord( c.getX() - 0.5,c.getY() - 1));
                adjacent.add(new Coord( c.getX() + 0.5,c.getY() - 1));
                adjacent.add(new Coord( c.getX() + 1,c.getY()));
                adjacent.add(new Coord( c.getX() - 0.5,c.getY() + 1));
                adjacent.add(new Coord( c.getX() + 0.5,c.getY() + 1));
            }

            return adjacent;
        }
        if(c.getX() == 19.0){
            if(c.getY() == 0.0){
                adjacent.add(new Coord( c.getX() + 0.5,c.getY() + 1));
                adjacent.add(new Coord( c.getX() - 1,c.getY()));
                adjacent.add(new Coord( c.getX() - 0.5,c.getY() + 1));

            }
            else {
                adjacent.add(new Coord( c.getX() - 0.5,c.getY() - 1));
                adjacent.add(new Coord( c.getX() + 0.5,c.getY() - 1));
                adjacent.add(new Coord( c.getX() - 1,c.getY()));
                adjacent.add(new Coord( c.getX() - 0.5,c.getY() + 1));
                adjacent.add(new Coord( c.getX() + 0.5,c.getY() + 1));
            }
            return adjacent;
        }
        if(c.getX() == 19.5){
            if(c.getY() == 19.0){
                adjacent.add(new Coord( c.getX() - 0.5,c.getY() - 1));
                adjacent.add(new Coord( c.getX() - 1,c.getY()));

            }
            else {
                adjacent.add(new Coord( c.getX() - 0.5,c.getY() - 1));
                adjacent.add(new Coord( c.getX() - 1,c.getY()));
                adjacent.add(new Coord( c.getX() - 0.5,c.getY() + 1));
            }
            return adjacent;
        }

        if(c.getY()==0){
            adjacent.add(new Coord(c.getX()-1,c.getY()));
            adjacent.add(new Coord(c.getX()+1,c.getY()));
            adjacent.add(new Coord(c.getX()-.5,c.getY()+1));
            adjacent.add(new Coord(c.getX()+.5,c.getY()+1));
        }
        if(c.getY()==19){
            adjacent.add(new Coord(c.getX()-1,c.getY()));
            adjacent.add(new Coord(c.getX()+1,c.getY()));
            adjacent.add(new Coord(c.getX()-0.5,c.getY()-1));
            adjacent.add(new Coord(c.getX()+0.5,c.getY()-1));
        }
        return adjacent;

    }
    public ArrayList<Coord> findAdjacencies(Coord c){
        ArrayList<Coord> adjacent = new ArrayList<>();
        Coord right = new Coord(c.getX() + 1, c.getY());
        Coord tL = new Coord( c.getX() - 0.5,c.getY() + 1);
        Coord tR = new Coord( c.getX() + 0.5,c.getY() + 1);
        Coord bL = new Coord( c.getX()- 0.5,c.getY() - 1);
        Coord bR = new Coord( c.getX() + 0.5,c.getY() - 1);
        Coord left = new Coord( c.getX() - 1,c.getY());
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
    public boolean getEnd(){return end;}
}
