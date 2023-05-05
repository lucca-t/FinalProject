package com.game.finalproject;

import com.game.finalproject.hextile.Tile;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static com.game.finalproject.hextile.Tile.*;


public class MainSceneController {
    @FXML
    private Label settleNum;
    @FXML
    private ImageView bonusTile0,bonusTile1,bonusTile2,bonusTile3,bonusTile4,bonusTile5,bonusTile6,bonusTile7;
    @FXML
    private ImageView infoTile0,infoTile1,infoTile2,infoTile3,currentTerrainCard,firstPlayerToken;
    @FXML
    private ImageView pointCard0,pointCard1,pointCard2;
    @FXML
    private Button confirmPlaceButton,finishTurnButton,prevButton,nextButton,useBonusButton;
    @FXML
    private Label current,playerName;
    private KingdomBuilderMain game;
    private ArrayList<Player> players;
    private int turnNum;
    private boolean end;
    private ArrayList<Card> terrains;
    @FXML
    private Polygon testPolygon;
    @FXML
    private Node balls;
    @FXML
    private AnchorPane container,container2,container3;
    private ArrayList<Coord> chosenSettlements;
    private final static double r = 20; // the inner radius from hexagon center to outer corner
    private final static double n = Math.sqrt(r * r * 0.75); // the inner radius from hexagon center to middle of the axis
    private final static double TILE_HEIGHT = 2 * r;
    private final static double TILE_WIDTH = 2 * n;
    private int displayedPlayer;
    private final static int WINDOW_WIDTH = 800;
    private final static int WINDOW_HEIGHT = 600;



    //s forest, g meadow, c canyon, f flower field, d desert
    @FXML
    private void initialize() {
        game = new KingdomBuilderMain();
        turnNum = game.getTurnNum();
        drawPointsCards();
        players = game.getPlayers();
        drawPlayerInfo(displayedPlayer);
        end = false;
        terrains = game.getTerrains();
        chosenSettlements = new ArrayList<Coord>();
        displayedPlayer = 0;
        drawTheBoards();
    }
        public void runGame() {
        while (!end) {
            for (int j = 0; j < players.size(); j++) {
                Collections.shuffle(game.getTerrains());
                players.get(j).setTerrain(terrains.get(0));
                players.get(j).getTerrain().setVisibility(false);
                terrains.remove(0);
            }

            //shows turnPlayer terrain
            players.get(game.getTurnNum()).getTerrain().setVisibility(true);
            //**repaint player screen with the available tiles

            //determines amount of settlements player can place
            int settlementLimit = 3;
            ArrayList<Action> playerActions = game.getTurnPlayer().getActions();
            String[] actStr = {"Oracle", "Farm", "Oasis", "Tower", "Tavern"};
            ArrayList<String> temp = new ArrayList(Arrays.asList(actStr));
            playerActions.retainAll(temp);
            settlementLimit += playerActions.size();


            for (int i = 0; i < settlementLimit; i++) {
                //retrieve chosen settlement from a mouseclicked event thing
                //while(!game.checkValidPlacement(retrieved coord)) {//paint choose another one, invalid}

            }
            chosenSettlements.clear();
//            playTurn();

            if (game.getTurnNum() == 3) {
                for (int i = 0; i < players.size(); i++) {
                    if (players.get(i).getNumSettlements() == 0) {
                        break;
                    }
                }
            }
//            nextTurn();
        }
        game.endGame();
    }

    public void drawEverything() {
        drawPlayerInfo(displayedPlayer);
        drawPointsCards();
    }
    public void addChosenSettlements(Coord c) {
        chosenSettlements.add(c);
    }


//    public void newRound() {
//        for (int j = 0; j < players.size(); j++) {
//            int choiceTerrain = (int)(Math.random()*25);
//            players.get(j).setTerrain(terrains.get(choiceTerrain));
//            players.get(j).getTerrain().setVisibility(false);
//            terrains.remove(choiceTerrain);
//        }
//
//    }
//
//    public void playTurn(){
//        players.get(turn).getTerrain().setVisibility(true);
//        for (int i = 0; i < settlementCords.size(); i++) {
//            board.getTiles().get(settlementCords.get(i)).setOccupancy(players.get(turn));
//        }
//    }

    @FXML
    void confirmPlace(ActionEvent event) {

    }


    @FXML
    void finishTurn(ActionEvent event) {
        //game.finishTurn();

    }
    @FXML
    void next(ActionEvent event) {
        //using testing thing to test the buttons and stuff
        game.testNextTurnNum();
        displayedPlayer++;
        displayedPlayer = displayedPlayer%4;
        //local turnNum check against game instance "turn",
        //if it equals then display "current", if it doesn't then don't
        drawPlayerInfo(displayedPlayer);
    }

    @FXML
    void previous(ActionEvent event) {
        game.testPrevTurnNum();
        displayedPlayer+=3;
        displayedPlayer = displayedPlayer%4;
        drawPlayerInfo(displayedPlayer);
    }

    @FXML
    void useBonus(ActionEvent event) {

    }

    private void drawInfoCards() {
        //haven't added anything yet until we fs have the new boards in there,
        //will need to add action tile identifier to board class, and call that identifier to set the image
        //something like this \/
        //infoTile0.setImage(new Image(returnImage(game.getBoard().getAction().toString())));
    }

    private void drawPointsCards() {//works
        ArrayList temp = game.getPointsCards();
        pointCard0.setImage(returnImage(temp.get(0).toString()));
        pointCard1.setImage(returnImage(temp.get(1).toString()));
        pointCard2.setImage(returnImage(temp.get(2).toString()));

    }
    private void drawPlayerInfo(int p) {
        playerName.setText("players.get(game.getTurnNum()).toString()");
        int tempTurn = game.getTurnNum() + 1;
        playerName.setText("Player " + tempTurn);
        settleNum.setText("Total Settlements: "+game.getPlayers().get(game.getTurnNum()).getNumSettlements());
        //this will work once the players are actually assigned terrain cards, return error bc null atm
        //currentTerrainCard.setImage(returnImage(game.getPlayers().get(game.getTurnNum()).getTerrain().getType()));
        int temp = players.indexOf(game.getTurnPlayer());
//        switch(p) {
////            int temp = players.indexOf(game.getTurnPlayer());
//            case(temp):
//                if (!game.getTurnPlayer().getTerrain().getVisibility()) {
//                    currentTerrainCard.setImage(returnImage("ResourceCardBack"));
//                }
//                else {
//                    switch(game.getTurnPlayer().getTerrain().getType()) {
//                        case("g"):
//                            currentTerrainCard.setImage(returnImage("MeadowCard"));
//                        case("f"):
//                            currentTerrainCard.setImage(returnImage("FlowerCard"));
//                        case("s"):
//                            currentTerrainCard.setImage(returnImage("ForestCard"));
//                        case("c"):
//                            currentTerrainCard.setImage(returnImage("CanyonCard"));
//                        case("d"):
//                            currentTerrainCard.setImage(returnImage("DesertCard"));
//                    }
//                }
//        }

        currentTerrainCard.setImage(returnImage("shrek"));
        if(game.getTurnNum()==0){
            firstPlayerToken.setImage(new Image(getClass().getResource("images/fPlayer.png").toExternalForm()));
        }
    }

    private String getBoardInfo() {
        String tile0 = "";
        String tile1 = "";
        String tile2 = "";
        String tile3 = "";
        String temp = "";/*
        //tedious way to do it fr, check each board array for the tile info by going through every element
        //(i aint doin allat)
        String[][]tempArr=game.getBoard().getBoardArr();
        for(int x=0;x<100;x++){
            if(tempArr[0][x].equals("Oasis")){
                tile0="Oasis";
            }
            else if(tempArr[0][x].equals("Barn")){
                tile0="Oasis";
            }
            else if(tempArr[0][x].equals("Harbor")){
                tile0="Oasis";
            }
            else if(tempArr[0][x].equals("Oracle")){
                tile0="Oasis";
            }
            else if(tempArr[0][x].equals("Oasis")){
                tile0="Oasis";
            }
            else if(tempArr[0][x].equals("Oasis")){
                tile0="Oasis";
            }
            else if(tempArr[0][x].equals("Oasis")){
                tile0="Oasis";
            }
            else if(tempArr[0][x].equals("Oasis")){
                tile0="Oasis";
            }
            else if(tempArr[0][x].equals("Oasis")){
                tile0="Oasis";
            }

        }

        for(int x =0;x<100;x++){
            for(int y=0; y<4;y++){

            }
        }
        */
        return temp;
    }
    public class Tile extends Polygon {

        private final static double r = 20; // the inner radius from hexagon center to outer corner
        private final static double n = Math.sqrt(r * r * 0.75); // the inner radius from hexagon center to middle of the axis
        private final static double TILE_HEIGHT = 2 * r;
        private final static double TILE_WIDTH = 2 * n;

        private final static int WINDOW_WIDTH = 800;
        private final static int WINDOW_HEIGHT = 600;

        Tile(double x, double y) {
            // creates the polygon using the corner coordinates
            getPoints().addAll(/*
                    x, y,
                    x, y + r,
                    x + n, y + r * 1.5,
                    x + TILE_WIDTH, y + r,
                    x + TILE_WIDTH, y,
                    x + n, y - r * 0.5*/
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
            setOnMouseClicked(e -> {
                System.out.println("Clicked: " + this);
                //placing method will go here


            });
            setOpacity(.01);
            //could add mouselistener for highlighting maybe
            //highlighting would work by turning the opacity up and it could change how it looks
            //opacity and color could be turned to gray to gray out the stuff
            //polygons are ontop of the images so a lot of possibilities
        }

    }
    public class ImgTile extends ImageView{
        private final static double r = 20; // the inner radius from hexagon center to outer corner
        private final static double n = Math.sqrt(r * r * 0.75); // the inner radius from hexagon center to middle of the axis
        private final static double TILE_HEIGHT = 2 * r;
        private final static double TILE_WIDTH = 2 * n;
        //private ImageView tileHold;
        ImgTile(double x, double y,Image img){
            //something here will add an image it "tileHold"
           // tileHold=new ImageView();
           // ImageView tileHold= new ImageView(returnTileImage( "c"));
           // tileHold.setImage(returnTileImage( "c"));

            /*tileHold.setFitHeight(TILE_HEIGHT);
            tileHold.setFitWidth(TILE_WIDTH);
            tileHold.setX(x);
            tileHold.setY(y);
            tileHold.setVisible(true);*/
            ImageView imgTile = new ImageView(returnTileImage( "w"));
            String[][] tempBoard = game.getBoard().getBoardArr();
            //bypass the weird stuff by just getting the tile form the board arr



            imgTile.setX(x);
            imgTile.setY(y-10);
            imgTile.setFitHeight(40);
            imgTile.setFitWidth(40);


        }


    }
    private void drawTheBoards(){
        AnchorPane tileMap = new AnchorPane();
        AnchorPane imageMap= new AnchorPane();
        AnchorPane setMap = new AnchorPane();

        //Scene content = new Scene(tileMap, WINDOW_WIDTH, WINDOW_HEIGHT);

        //container2 = new AnchorPane();

        container.getChildren().add(tileMap);
        container2.getChildren().add(imageMap);
        container3.getChildren().add(setMap);
        container.setVisible(true);
        container2.setVisible(true);
        container3.setVisible(true);
        container.toFront();

        //container.toBack();
        int rowCount = 20; // how many rows of tiles should be created
        int tilesPerRow = 20; // the amount of tiles that are contained in each row
        int xStartOffset = 40; // offsets the entire field to the right
        int yStartOffset = 40; // offsets the entire field downwards
        for (int x = 0; x < tilesPerRow; x++) {
            for (int y = 0; y < rowCount; y++) {
                double xCoord = x * TILE_WIDTH + (y % 2) * n + xStartOffset;
                double yCoord = y * TILE_HEIGHT * 0.75 + yStartOffset;
                //ImageView imgTile = new ImgTile(xCoord,yCoord);
                //ImageView imgTile = new ImgTile(xCoord,yCoord,returnTileImage( "w"));
                ImageView imgTile = new ImageView(returnTileImage( "w"));
                imgTile.setX(xCoord);
                imgTile.setY(yCoord-10);
                imgTile.setFitHeight(40);
                imgTile.setFitWidth(40);


                Rectangle setTile = new Rectangle();
                setTile.setX(xCoord + 7);
                setTile.setY(yCoord + 2);
                setTile.setWidth(25);
                setTile.setHeight(15);
                setTile.setFill(Color.PINK);
                setMap.getChildren().add(setTile);


                //setColor should corrsepond to player's color

                imageMap.getChildren().add(imgTile);
                //adds created tiles to anchor-pane and creates them
                Polygon tile = new Tile(xCoord, yCoord);
                tileMap.getChildren().add(tile);
            }
        }

    }
    private Image returnImage(String str) {
        Image temp = new Image(getClass().getResource("images/shrek.png").toExternalForm());
        if (str.equals("Citizen"))
            temp = new Image(getClass().getResource("images/CitizenCard.jpg").toExternalForm());
        else if (str.equals("Discoverers"))
            temp = new Image(getClass().getResource("images/DiscovererCard.jpg").toExternalForm());
        else if (str.equals("Farmers"))
            temp = new Image(getClass().getResource("images/FarmerCard.jpg").toExternalForm());
        else if (str.equals("Fishermen"))
            temp = new Image(getClass().getResource("images/FishermanCard.jpg").toExternalForm());
        else if (str.equals("Hermits"))
            temp = new Image(getClass().getResource("images/HermitCard.jpg").toExternalForm());
        else if (str.equals("Knights"))
            temp = new Image(getClass().getResource("images/KnightCard.jpg").toExternalForm());
        else if (str.equals("Lords"))
            temp = new Image(getClass().getResource("images/LordCard.jpg").toExternalForm());
        else if (str.equals("Merchants"))
            temp = new Image(getClass().getResource("images/MerchantCard.jpg").toExternalForm());
        else if (str.equals("Miners"))
            temp = new Image(getClass().getResource("images/MinerCard.jpg").toExternalForm());
        else if (str.equals("Workers"))
            temp = new Image(getClass().getResource("images/WorkerCard.jpg").toExternalForm());
            //terrain cards below
            //dont know the actual names so i guessed
        else if (str.equals("c"))
            temp = new Image(getClass().getResource("images/CanyonCard.jpg").toExternalForm());
        else if (str.equals("d"))
            temp = new Image(getClass().getResource("images/DesertCard.jpg").toExternalForm());
        else if (str.equals("f"))
            temp = new Image(getClass().getResource("images/FlowerCard.jpg").toExternalForm());
        else if (str.equals("g"))
            temp = new Image(getClass().getResource("images/MeadowCard.jpg").toExternalForm());
        else if (str.equals("s"))
            temp = new Image(getClass().getResource("images/ForestCard.jpg").toExternalForm());
        else
            return temp;
        return temp;

    }

    public Image returnTileImage(String str) {
        Image temp = new Image(getClass().getResource("images/shrek.png").toExternalForm());
        if (str.equals("c"))//canyon
            temp = new Image(getClass().getResource("images/canyonTile.png").toExternalForm());
        else if (str.equals("d"))//desert
            temp = new Image(getClass().getResource("images/desertTile.png").toExternalForm());
        else if (str.equals("f"))//flower
            temp = new Image(getClass().getResource("images/flowerTile.png").toExternalForm());
        else if (str.equals("g"))//meadow
            temp = new Image(getClass().getResource("images/meadowTile.png").toExternalForm());
        else if (str.equals("s"))//forest
            temp = new Image(getClass().getResource("images/forestTile.png").toExternalForm());
        else if (str.equals("m"))//mountain
            temp = new Image(getClass().getResource("images/mountainTile.png").toExternalForm());
        else if (str.equals("castle"))//castle
            temp = new Image(getClass().getResource("images/castleTile.png").toExternalForm());
        else if (str.equals("Oasis"))//oasis
            temp = new Image(getClass().getResource("images/oasisTile.png").toExternalForm());
        else if (str.equals("Oracle"))//oracle
            temp = new Image(getClass().getResource("images/oracleTile.png").toExternalForm());
        else if (str.equals("Barn"))//barn
            temp = new Image(getClass().getResource("images/barnTile.png").toExternalForm());
        else if (str.equals("Harbor"))//harbor  ///ik i misnamed it idc \/
            temp = new Image(getClass().getResource("images/shipTile.png").toExternalForm());
        else if (str.equals("Paddock"))//Paddock
            temp = new Image(getClass().getResource("images/paddockTile.png").toExternalForm());
        else if (str.equals("Tavern"))//Tavern
            temp = new Image(getClass().getResource("images/tavernTile.png").toExternalForm());
        else if (str.equals("Tower"))//Tower
            temp = new Image(getClass().getResource("images/towerTile.png").toExternalForm());
        else if (str.equals("w"))//WATER
            temp = new Image(getClass().getResource("images/waterTile.png").toExternalForm());
        else if (str.equals("Ship"))//supposed to be harbor but oopsies
            temp = new Image(getClass().getResource("images/paddockTile.png").toExternalForm());

        else
            return temp;
        return temp;
    }

}



/* TO DO LIST:
* add placement method for polygons
* show first player token(need add boolean to player class i think
* terrain cards assigned to players
* settlements on board
* show action tiles properly
* (maaaaaaaybe draw tiles individually
* actually get the game to work*/

//HOW TO DO IMAGES ALSO THIS LINK SUPER USEFUL DON'T FORGET
/////https://stackoverflow.com/questions/61531317/how-do-i-determine-the-correct-path-for-fxml-files-css-files-images-and-other
/*      URL imageURL = getClass().getResource("images/CanyonCard.jpg");
        Image image = new Image(imageURL.toExternalForm());
        pointCard0.setImage(new Image(getClass().getResource("images/CanyonCard.jpg").toExternalForm()));
*/
//https://www.pragmaticcoding.ca/javafx/hexmap example hexmap build
//v well-made tbh but uses like 30 classes to make its thing


//if there's an error in the images, shrek will show
//red "#ff0000"
//purple "#9d1cff"
//pink "#ff6fd6"
//orange "#ff6600"

