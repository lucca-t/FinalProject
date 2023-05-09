package com.game.finalproject;

import java.util.ArrayList;
import java.util.HashMap;

public class Board {

    //desert: d, canyon: c, water: w, forest: s, flowers: f, grass: g, mountains: m, castle: castle
    private int location;
    private ArrayList<Action> actions;
    private HashMap<Coord, HexTile> tiles;

    String[] board1 = {"d", "d", "c", "w", "w", "s", "s", "s", "g", "g", "d", "castle", "c", "w", "s", "s", "s", "Barn", "g", "g", "c", "c", "c", "f", "f", "f", "s", "c", "f", "f", "c", "c", "f", "f", "w", "d", "d", "c", "c", "f", "c", "g", "g", "w", "f", "f", "d", "d", "c", "c", "g", "g", "Barn", "f", "w", "f", "w", "d", "d", "c", "g", "g", "g", "s", "f", "f", "w", "w", "d", "d", "g", "g", "s", "s", "m", "w", "w", "w", "d", "w", "g", "m", "s", "s", "w", "w", "w", "w", "w", "w", "s", "s", "s", "w", "w", "w", "w", "w", "w", "w"};
    String[] board2 = {"d", "d", "c", "w", "w", "s", "s", "g", "g", "g", "d", "c", "w", "f", "f", "s", "s", "s", "g", "g", "d", "d", "w", "f", "f", "s", "s", "Oasis", "f", "g", "w", "w", "w", "f", "g", "s", "f", "f", "f", "f", "w", "w", "w", "w", "g", "g", "g", "g", "f", "f", "w", "s", "s", "w", "g", "g", "c", "c", "d", "c", "w", "s", "c", "s", "w", "g", "c", "c", "d", "c", "w", "castle", "c", "f", "w", "Oasis", "d", "d", "c", "w", "w", "w", "c", "f", "w", "w", "w", "d", "d", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w"};
    String[] board3 = {"g", "g", "s", "s", "s", "w", "g", "s", "s", "f", "g", "f", "s", "s", "w", "g", "s", "s", "f", "f", "g", "f", "f", "s", "w", "g", "g", "f", "f", "f", "f", "f", "s", "s", "w", "g", "m", "f", "d", "d", "c", "f", "castle", "s", "w", "g", "d", "d", "d", "d", "c", "c", "s", "w", "g", "g", "m", "m", "d", "d", "c", "c", "w", "w", "w", "g", "d", "d", "d", "c", "w", "w", "g", "g", "w", "w", "Harbor", "c", "m", "c", "w", "d", "castle", "g", "w", "m", "w", "c", "c", "c", "w", "d", "d", "w", "w", "w", "w", "c", "c", "c"};
    //board3 not built correctly
    String[] board4 = {"g", "g", "g", "s", "s", "w", "g", "s", "s", "s", "g", "g", "g", "castle", "s", "w", "g", "s", "s", "s", "g", "f", "f", "g", "s", "s", "w", "g", "g", "s", "f", "f", "c", "g", "s", "w", "f", "Oracle", "s", "s", "f", "f", "f", "c", "c", "w", "f", "f", "w", "w", "m", "m", "c", "g", "g", "w", "w", "w", "d", "d", "c", "c", "c", "m", "g", "f", "f", "f", "d", "d", "c", "c", "castle", "d", "m", "d", "f", "f", "c", "c", "w", "w", "w", "d", "d", "d", "d", "m", "c", "c", "w", "w", "w", "w", "d", "d", "d", "d", "d", "c"};
    String[][] boards = {board1, board2, board3, board4};
    public Board(int b1, int b2, int b3, int b4) {
        actions = new ArrayList<Action>();
        actions.add(new Action(1, "Barn", false));
        actions.add(new Action(1, "Barn", false));
        actions.add(new Action(2, "Oasis", false));
        actions.add(new Action(2, "Oasis", false));
        actions.add(new Action(2, "Harbor", false));
        actions.add(new Action(2, "Oracle", false));
        tiles = new HashMap<Coord, HexTile>();
        int i = 0;
        int y = 0;
        int x = 0;
        Coord c;
        for (y = 0; y < 10; y++) {
            for (x = 10; x < 20; x++) {
                if (y%2 == 0) {
                    c = new Coord(x, y);
                }
                else {
                    c = new Coord(x + 0.5, y);
                }
//                if (boards[b1][i])
                tiles.put(c, new HexTile((boards[b1][i])));
                i++;
            }
        }
        i = 0;
        for (y = 0; y < 10; y++) {
            for (x = 0; x < 10; x++) {
                if (y%2 == 0) {
                    c = new Coord(x, y);
//                    coord[0] = y;
//                    coord[1] = x;
                }
                else {
                    c = new Coord(x + 0.5, y);
//                    coord[0] = y;
//                    coord[1] = x + 0.5;
                }
                tiles.put(c, new HexTile((boards[b2][i])));
                i++;
            }
        }
        i = 0;
        for (y = 10; y < 20; y++) {
            for (x = 0; x < 10; x++) {
                double[] coord = new double[2];
                if (y%2 == 0) {
                    c = new Coord(x, y);
                    coord[0] = y;
                    coord[1] = x;
                }
                else {
                    c = new Coord(x + 0.5, y);
                    coord[0] = y;
                    coord[1] = x + 0.5;
                }
                tiles.put(c, new HexTile((boards[b3][i])));
                i++;
            }
        }
        i = 0;
        for (y = 10; y < 20; y++) {
            for (x = 10; x < 20; x++) {
                double[] coord = new double[2];
                if (y%2 == 0) {
                    c = new Coord(x, y);
                    coord[0] = y;
                    coord[1] = x;
                }
                else {
                    c = new Coord(x + 0.5, y);
                    coord[0] = y;
                    coord[1] = x + 0.5;
                }
                tiles.put(c, new HexTile((boards[b4][i])));
                i++;
            }
        }
    }
    public ArrayList<Coord> findAdjacencies(Coord c){
        ArrayList<Coord> adjacent = new ArrayList<Coord>();
        Coord left = new Coord(c.getY(), c.getX() - 1);
//        double[] left = {coord[0] - 1, coord[1]};
        Coord right = new Coord(c.getY(), c.getX() + 1);
//        double[] right = {coord[0] + 1, coord[1]};
        Coord tL = new Coord(c.getY() + 1, c.getX() - 0.5);
//        double[] tL = {coord[0] - 0.5, coord[1] + 1};
        Coord tR = new Coord(c.getY() + 1, c.getX() + 0.5);
//        double[] tR = {coord[0] + 0.5, coord[1] + 1};
        Coord bL = new Coord(c.getY() - 1, c.getX()- 0.5);
//        double[] bL = {coord[0] - 0.5, coord[1] - 1};
        Coord bR = new Coord(c.getY() - 1, c.getX() + 0.5);
//        double[] bR = {coord[0] + 0.5, coord[1] - 1};
        adjacent.add(left);
        adjacent.add(right);
        adjacent.add(tL);
        adjacent.add(tR);
        adjacent.add(bL);
        adjacent.add(bR);
        return adjacent;
    }
    public boolean contains(ArrayList<Double> x, double y){
        for(int i = 0; i < x.size(); i++){
            if(x.get(i) == y){
                return true;
            }
        }
        return false;
    }
    public void setCheckedFalse(Coord crd){
        tiles.get(crd).setCheck(false);
    }
    public void scoreFishermen(ArrayList<Player> players) {
        for(int p = 0; p < players.size(); p++) {
            int cnt = 0;
            for(int i = 0; i < players.get(p).getOccupiedTiles().size(); i++){
                ArrayList<Coord> temp = findAdjacencies(players.get(p).getOccupiedTiles().get(i));
                for(int k = 0; k < temp.size(); k++){
                    cnt+=scoreFishermen(temp.get(k));
                }
            }
            for(int i = 0; i < players.get(p).getOccupiedTiles().size(); i++){
                ArrayList<Coord> temp = findAdjacencies(players.get(p).getOccupiedTiles().get(i));
                for(int k = 0; k < temp.size(); k++){
                    setCheckedFalse(temp.get(k));
                }
            }
            players.get(p).addPoints(cnt);
        }

    }
    public int scoreFishermen(Coord crd){
        if(tiles.get(crd).getType().equals("w") && !tiles.get(crd).getChecked()){
            tiles.get(crd).setCheck(true);
            return 1;
        }
        else{
            return 0;
        }
    }
    public void scoreMiners(ArrayList<Player> players) {
        for (Player player : players) {
            int cnt = 0;
            for (int i = 0; i < player.getOccupiedTiles().size(); i++) {
                ArrayList<Coord> temp = findAdjacencies(player.getOccupiedTiles().get(i));
                for (Coord coord : temp) {
                    cnt += scoreMiners(coord);
                }
            }
            for (int i = 0; i < player.getOccupiedTiles().size(); i++) {
                ArrayList<Coord> temp = findAdjacencies(player.getOccupiedTiles().get(i));
                for (Coord coord : temp) {
                    setCheckedFalse(coord);
                }
            }
            player.addPoints(cnt);
        }

    }
    public int scoreMiners(Coord crd){
        if(tiles.get(crd).getType().equals("m") && !tiles.get(crd).getChecked()){
            tiles.get(crd).setCheck(true);
            return 1;
        }
        else{
            return 0;
        }
    }
    public void scoreWorkers(ArrayList<Player> players) {
        for (Player player : players) {
            int cnt = 0;
            for (int i = 0; i < player.getOccupiedTiles().size(); i++) {
                ArrayList<Coord> temp = findAdjacencies(player.getOccupiedTiles().get(i));
                for (Coord coord : temp) {
                    cnt += scoreWorkers(coord);
                }
            }
            for (int i = 0; i < player.getOccupiedTiles().size(); i++) {
                ArrayList<Coord> temp = findAdjacencies(player.getOccupiedTiles().get(i));
                for (Coord coord : temp) {
                    setCheckedFalse(coord);
                }
            }
            player.addPoints(cnt);
        }

    }
    public int scoreWorkers(Coord crd){
        if(tiles.get(crd).getType().equals("castle") && !tiles.get(crd).getChecked()){
            tiles.get(crd).setCheck(true);
            return 1;
        }
        else if(tiles.get(crd).getType().equals("action") && !tiles.get(crd).getChecked()){
            tiles.get(crd).setCheck(true);
            return 1;
        }
        else{
            return 0;
        }
    }
    public void scoreMerchants(ArrayList<Player> players) {
        for(int p = 0; p < players.size(); p++){
            ArrayList<Coord>  bulbasaur = players.get(p).getOccupiedTiles();
            ArrayList<ArrayList<Coord>> squirtle = new ArrayList<>();
            for(int i = 0; i < bulbasaur.size(); i++){
                squirtle.add(getCluster(bulbasaur.get(i), players.get(p)));
            }
            removeRepeatsdos(squirtle);
            ArrayList<Integer> pikachu = new ArrayList<>();
            for(int i = 0; i < squirtle.size(); i++){
                int cnt = 0;
                for(int k = 0; k < squirtle.get(i).size(); k++){
                    ArrayList<Coord> charmander = findAdjacencies(squirtle.get(i).get(k));
                    for(int j = 0; j < charmander.size(); j++){
                        if(!tiles.get(j).getTouched() && tiles.get(j).getType().length() > 1){
                            cnt++;
                            tiles.get(j).setTouched(true);
                        }
                    }
                }
                pikachu.add(cnt);
            }
            int x = 0;
            for(int i = 0; i < pikachu.size(); i++){
                if(pikachu.get(i) > x){
                    x = pikachu.get(i);
                }
            }
            if(x < 2){
                players.get(p).addPoints(0);
            }
            else{
                players.get(p).addPoints(4*x);
            }
        }
    }
    public void scoreDiscoverers(ArrayList<Player> players) {
        for (int p = 0; p < players.size(); p++) {
            ArrayList<Double> temp = new ArrayList<Double>();
            for(int i = 0; i < players.get(p).getOccupiedTiles().size(); i++){
                if(!contains(temp, players.get(p).getOccupiedTiles().get(i).getY())) {
                    temp.add(players.get(p).getOccupiedTiles().get(i).getY());
                }
            }
            players.get(p).addPoints(temp.size());
        }
    }
    public void scoreKnights(ArrayList<Player> players) {
        for (int p = 0; p < players.size(); p++) {
            ArrayList<Double> temp = new ArrayList<Double>();
            ArrayList<Integer> cnts = new ArrayList<Integer>();
            for(int i = 0; i < players.get(p).getOccupiedTiles().size(); i++){
                //get arraylist of all y coordinates of all settlements then get the number of settlements on each y coordinate then return the largest value
                if(!contains(temp, players.get(p).getOccupiedTiles().get(i).getY())) {
                    temp.add(players.get(p).getOccupiedTiles().get(i).getY());
                }
            }
            for(int i = 0; i < temp.size(); i++){
                double x = temp.get(i);
                int y = 0;
                for(int k = 0; k < players.get(p).getOccupiedTiles().size(); k++){
                    if(players.get(p).getOccupiedTiles().get(k).getY() == x){
                        y++;
                    }
                }
                cnts.add(y);
            }
            int bigger = 0;
            for(int i = 0; i < cnts.size(); i++){
                if(bigger < cnts.get(i)){
                    bigger = cnts.get(i);
                }
            }
            players.get(p).addPoints(bigger*2);
        }

    }
    public void scoreHermits(ArrayList<Player> players) {
        for(int p = 0; p < players.size(); p++) {
            ArrayList<Integer> clustersize = new ArrayList<>();
            for(int i = 0; i < players.get(p).getOccupiedTiles().size(); i++) {
                ArrayList<Coord> eminem = getCluster(players.get(p).getOccupiedTiles().get(i), players.get(p));
                clustersize.add(eminem.size());
            }
            players.get(p).addPoints(clustersize.size());
        }
    }
    public int scoreLordsHelper(ArrayList<Player> players, int player){
        int ps1 = 0;
        int ps2 = 0;
        int ps3 = 0;
        int ps4 = 0;
        Player first = new Player("hello");
        Player sec = new Player("hello");
        Player third = new Player("hello");
        Player fourth = new Player("hello");
        ArrayList<ArrayList<Integer>> comp = new ArrayList<>();
        ArrayList<Integer> p1 = getNumSettle(players.get(0));
        ArrayList<Integer> p2 = getNumSettle(players.get(1));
        ArrayList<Integer> p3 = getNumSettle(players.get(2));
        ArrayList<Integer> p4 = getNumSettle(players.get(3));
        comp.add(p1);
        comp.add(p2);
        comp.add(p3);
        comp.add(p4);
        ArrayList<ArrayList<Integer>> temp = comp;
        int big = 0;
        for(int i = 0; i < comp.size(); i++){
            if(comp.get(i).get(0) > big){
                big = comp.get(i).get(0);
            }
        }
        int pineapple = 0;
        for(int i = 0; i < comp.size(); i++){
            if(comp.get(i).get(0) < big && comp.get(i).get(0) > pineapple){
                pineapple = comp.get(i).get(0);
            }
        }
        if(big == comp.get(0).get(0)){
            ps1 += 12;
        }
        if(pineapple == comp.get(0).get(0)){
            ps1 += 6;
        }
        if(pineapple == comp.get(1).get(0)){
            ps2 += 6;
        }
        if(pineapple == comp.get(2).get(0)){
            ps3 += 6;
        }
        if(pineapple == comp.get(3).get(0)){
            ps4 += 6;
        }
        if(big == comp.get(1).get(0)){
            ps2 += 12;
        }
        if(big == comp.get(2).get(0)){
            ps3 += 12;
        }
        if(big == comp.get(3).get(0)){
            ps4 += 12;
        }
        int bigg = 0;
        for(int i = 0; i < comp.size(); i++){
            if(comp.get(i).get(1) > bigg){
                bigg = comp.get(i).get(1);
            }
        }
        int pine = 0;
        for(int i = 0; i < comp.size(); i++){
            if(comp.get(i).get(1) < bigg && comp.get(i).get(1) > pine){
                pine = comp.get(i).get(1);
            }
        }
        if(bigg == comp.get(0).get(1)){
            ps1 += 12;
        }
        if(pine == comp.get(0).get(1)){
            ps1 += 6;
        }
        if(pine == comp.get(1).get(1)){
            ps2 += 6;
        }
        if(pine == comp.get(2).get(1)){
            ps3 += 6;
        }
        if(pine == comp.get(3).get(1)){
            ps4 += 6;
        }
        if(bigg == comp.get(1).get(1)){
            ps2 += 12;
        }
        if(bigg == comp.get(2).get(1)){
            ps3 += 12;
        }
        if(bigg == comp.get(3).get(1)){
            ps4 += 12;
        }
        int big3 = 0;
        for(int i = 0; i < comp.size(); i++){
            if(comp.get(i).get(2) > big){
                big3 = comp.get(i).get(2);
            }
        }
        int pin = 0;
        for(int i = 0; i < comp.size(); i++){
            if(comp.get(i).get(2) < big3 && comp.get(i).get(2) > pin){
                pin = comp.get(i).get(2);
            }
        }
        if(big3 == comp.get(0).get(2)){
            ps1 += 12;
        }
        if(pin == comp.get(0).get(2)){
            ps1 += 6;
        }
        if(pin == comp.get(1).get(2)){
            ps2 += 6;
        }
        if(pin == comp.get(2).get(2)){
            ps3 += 6;
        }
        if(pin == comp.get(3).get(2)){
            ps4 += 6;
        }
        if(big3 == comp.get(1).get(2)){
            ps2 += 12;
        }
        if(big3 == comp.get(2).get(2)){
            ps3 += 12;
        }
        if(big3 == comp.get(3).get(2)){
            ps4 += 12;
        }

        int big4 = 0;
        for(int i = 0; i < comp.size(); i++){
            if(comp.get(i).get(3) > big4){
                big4 = comp.get(i).get(3);
            }
        }
        int pi = 0;
        for(int i = 0; i < comp.size(); i++){
            if(comp.get(i).get(3) < big4 && comp.get(i).get(3) > pi){
                pi = comp.get(i).get(3);
            }
        }
        if(big4 == comp.get(0).get(3)){
            ps1 += 12;
        }
        if(pi == comp.get(0).get(3)){
            ps1 += 6;
        }
        if(pi == comp.get(1).get(3)){
            ps2 += 6;
        }
        if(pi == comp.get(2).get(3)){
            ps3 += 6;
        }
        if(pi == comp.get(3).get(3)){
            ps4 += 6;
        }
        if(big4 == comp.get(1).get(3)){
            ps2 += 12;
        }
        if(big4 == comp.get(2).get(3)){
            ps3 += 12;
        }
        if(big4 == comp.get(3).get(3)){
            ps4 += 12;
        }
        if(player == 1){
            return ps1;
        }
        if(player == 2){
            return ps2;
        }
        if(player == 3){
            return ps3;
        }
        if(player == 4){
            return ps4;
        }
        else{
            return 0;
        }
    }
    public void scoreLords(ArrayList<Player> players){
        int i = 0;
        for(int p = 1; p < 4; p++){
            players.get(i).addPoints(scoreLordsHelper(players, p));
            i++;
        }
    }
    public void scoreCitizens(ArrayList<Player> players) {
        for(int p = 0; p < players.size(); p++) {
            ArrayList<Integer> clustersize = new ArrayList<>();
            for(int i = 0; i < players.get(p).getOccupiedTiles().size(); i++){
                ArrayList<Coord> eminem = getCluster(players.get(p).getOccupiedTiles().get(i), players.get(p));
                clustersize.add(eminem.size());
            }
            int big = 0;
            for(int i = 0; i < clustersize.size(); i++){
                if(clustersize.get(i) > big){
                    big = clustersize.get(i);
                }
            }
            if(big%2== 1){
                big -= 1;
            }
            players.get(p).addPoints(big/2);
        }
    }
    public ArrayList<Integer> getNumSettle(Player p){
        ArrayList<Integer> temp = new ArrayList<>();
        int docbrown = 0;
        int mator = 0;
        int shrek = 0;
        int mcqueen = 0;
        for(int i = 0; i < p.getOccupiedTiles().size(); i++){
            if(p.getOccupiedTiles().get(i).getX() >= 10 && p.getOccupiedTiles().get(i).getX() <= 19 ) {
                if(p.getOccupiedTiles().get(i).getY() <= 9) {
                    docbrown++;
                }
            }
            if(p.getOccupiedTiles().get(i).getY() >= 10 && p.getOccupiedTiles().get(i).getY() <= 19 ) {
                if(p.getOccupiedTiles().get(i).getX() <= 9) {
                    shrek++;
                }
            }
            if(p.getOccupiedTiles().get(i).getX() <= 9 && p.getOccupiedTiles().get(i).getY() <= 9){
                mator++;
            }
            if(p.getOccupiedTiles().get(i).getY() >= 10 && p.getOccupiedTiles().get(i).getY() <= 19 ) {
                if(p.getOccupiedTiles().get(i).getX() >= 10 && p.getOccupiedTiles().get(i).getX() <= 19) {
                    mcqueen++;
                }
            }
        }
        temp.add(docbrown);
        temp.add(mator);
        temp.add(shrek);
        temp.add(mcqueen);
        return temp;
    }
    public boolean hasAdjacent(Coord tile, ArrayList<Coord> occupiedTiles) {
        for (int i = 0; i < occupiedTiles.size(); i++) {
            if (occupiedTiles.get(i).getX() + 1 == tile.getX() || occupiedTiles.get(i).getX() + 0.5 == tile.getX() || occupiedTiles.get(i).getX() - 1 == tile.getX() || occupiedTiles.get(i).getX() - 0.5 == tile.getX()) {
                if (occupiedTiles.get(i).getY() + 1 == tile.getY() || occupiedTiles.get(i).getY() + 0.5 == tile.getY() || occupiedTiles.get(i).getY() - 1 == tile.getY() || occupiedTiles.get(i).getY() - 0.5 == tile.getY()) {
                    return true;
                }
            }
        }
        //can use
        return false;
    }
    public boolean isAdjacent(double[] x, double[] y) {
        if (y[0] + 1 == x[0] || y[0] + 0.5 == x[0] || y[0] - 1 == x[0] || y[0] - 0.5 == x[0]) {
            if (y[1] + 1 == x[1] || y[1] + 0.5 == x[1] || y[1] - 1 == x[1] || y[1] - 0.5 == x[1]) {
                return true;
            }
        }
        return false;
    }
    public ArrayList<Coord> getCluster(Coord x, Player p){
        ArrayList<Coord> cluster = new ArrayList<>();
        if(!hasAdjacent(x,p.getOccupiedTiles())){
            cluster.add(x);
            return cluster;
        }
        for(int i = 0; i <  findPlayerAdjacencies(x, p).size(); i++){
            cluster.add(findPlayerAdjacencies(x, p).get(i));
        }
        boolean hasstuff = true;
        while(hasstuff){
            ArrayList<Coord> temp = cluster;
            for(int i = 0; i < temp.size(); i++){
                ArrayList<Coord> spongebob = findPlayerAdjacencies(temp.get(i), p);
                if(spongebob.isEmpty()){
                    hasstuff = false;
                }
                for(int k = 0; k < spongebob.size(); i++){
                    temp.add(spongebob.get(k));
                }
            }
            cluster = temp;
        }
        removeRepeats(cluster);
        return cluster;

    }
    public ArrayList<Coord> findPlayerAdjacencies(Coord coord, Player p){
        ArrayList<Coord> adjacent = findAdjacencies(coord);
        ArrayList<Coord> playeradj = new ArrayList<>();
        for(int i = 0; i < p.getOccupiedTiles().size(); i++){
            for(int k = 0; k < adjacent.size(); k++){
                if(p.getOccupiedTiles().get(i).equals(adjacent.get(k)) && tiles.get(p.getOccupiedTiles().get(i)).getCounted() == false){
                    playeradj.add(p.getOccupiedTiles().get(i));
                    tiles.get(p.getOccupiedTiles().get(i)).setCounted(true);
                }
            }
        }
        return playeradj;
    }
    public void removeRepeats(ArrayList<Coord> x){
        for(int i = 0; i < x.size(); i++){
            for(int k = 0; k < x.size(); i++){
                if(x.get(i).equals(x.get(k))){
                    x.remove(i);
                }
            }
        }
    }
    public void removeRepeatsdos(ArrayList<ArrayList<Coord>> x){
        for(int i = 0; i < x.size(); i++){
            for(int k = 0; k < x.size(); i++){
                if(x.get(i).equals(x.get(k))){
                    x.remove(i);
                }
            }
        }
    }

    public void scoreFarmers(ArrayList<Player> players) {
        for (int p = 0; p < players.size(); p++) {

            boolean one = false;
            boolean two = false;
            boolean three = false;
            boolean four = false;
            for(int i = 0; i < players.get(p).getOccupiedTiles().size(); i++){
                if(players.get(p).getOccupiedTiles().get(i).getX() >= 10 && players.get(p).getOccupiedTiles().get(i).getX() <= 19 ) {
                    if(players.get(p).getOccupiedTiles().get(i).getY() <= 9) {
                        one = true;
                    }
                }
                if(players.get(p).getOccupiedTiles().get(i).getX() <= 9 && players.get(p).getOccupiedTiles().get(i).getY() <= 9 ) {
                    two = true;
                }
                if(players.get(p).getOccupiedTiles().get(i).getY() >= 10 && players.get(p).getOccupiedTiles().get(i).getY() <= 19 ) {
                    if(players.get(p).getOccupiedTiles().get(i).getX() <= 9) {
                        three = true;
                    }
                }
                if(players.get(p).getOccupiedTiles().get(i).getX() >= 10 && players.get(p).getOccupiedTiles().get(i).getX() <= 19 ) {
                    if(players.get(p).getOccupiedTiles().get(i).getY() >= 10 && players.get(p).getOccupiedTiles().get(i).getY() <= 19 ) {
                        four = true;
                    }
                }
            }
            if(!one){
                break;
            }
            if(!two){
                break;
            }
            if(!three){
                break;
            }
            if(!four){
                break;
            }
            ArrayList<Integer> counts = getNumSettle(players.get(p));
            int smaller = 10000;
            for(int i = 0; i < counts.size(); i++){
                if(counts.get(i) < smaller){
                    smaller = counts.get(i);
                }
            }
            players.get(p).addPoints(smaller*3);
        }

    }
//    public ArrayList<HexTile> findValidPlacements() {}
    public HashMap<Coord, HexTile> getBoard(){
        return tiles;
    }
//    public String getBoardTemp(){
//        return tiles.toString();
//    }
    public HashMap<Coord, HexTile> getTiles(){
        return tiles;
    }
//    public String getTilesTemp(){
//        return tiles.toString();
//    }
    public String[][] getBoardArr(){
        return boards;
    }
}
