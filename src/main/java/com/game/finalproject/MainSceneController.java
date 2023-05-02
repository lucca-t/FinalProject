package com.game.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Collections;

import java.util.ArrayList;

//HOW TO DO IMAGES ALSO THIS LINK SUPERUSEFULDONTFORGET
/////https://stackoverflow.com/questions/61531317/how-do-i-determine-the-correct-path-for-fxml-files-css-files-images-and-other
/*      URL imageURL = getClass().getResource("images/CanyonCard.jpg");
        Image image = new Image(imageURL.toExternalForm());
        pointCard0.setImage(new Image(getClass().getResource("images/CanyonCard.jpg").toExternalForm()));
*/

//if there's an error in the images, shrek will show
//red "#ff0000"
//purple "#9d1cff"
//pink "#ff6fd6"
//orange "#ff6600"
public class MainSceneController {
    @FXML
    private Label settleNum;
    @FXML
    private ImageView bonusTile0;

    @FXML
    private ImageView bonusTile1;

    @FXML
    private ImageView bonusTile2;

    @FXML
    private ImageView bonusTile3;

    @FXML
    private ImageView bonusTile4;

    @FXML
    private ImageView bonusTile5;

    @FXML
    private ImageView bonusTile6;

    @FXML
    private ImageView bonusTile7;

    @FXML
    private Button confirmPlaceButton;

    @FXML
    private Label current;

    @FXML
    private ImageView currentTerrainCard;

    @FXML
    private Button finishTurnButton;

    @FXML
    private ImageView firstPlayerToken;

    @FXML
    private ImageView infoTile0;

    @FXML
    private ImageView infoTile1;

    @FXML
    private ImageView infoTile2;

    @FXML
    private ImageView infoTile3;

    @FXML
    private Button nextButton;

    @FXML
    private Label playerName;

    @FXML
    private ImageView pointCard0;

    @FXML
    private ImageView pointCard1;

    @FXML
    private ImageView pointCard2;

    @FXML
    private Button prevButton;

    @FXML
    private Button useBonusButton;
    private KingdomBuilderMain game;

    private ArrayList<Player> players;
    private int turnNum;
    private boolean end;
    private ArrayList<Card> terrains;

    //s forest, g meadow, c canyon, f flower field, d desert
    @FXML
    private void initialize() {
        game = new KingdomBuilderMain();
        turnNum = game.getTurnNum();
        drawPointsCards();
        players = game.getPlayers();
        drawPlayerinfo();
        end = false;
        terrains = game.getTerrains();
    }

        public void runGame() {
        while (!end) {
            for (int j = 0; j < players.size(); j++) {
                Collections.shuffle(game.getTerrains());
                players.get(j).setTerrain(terrains.get(0));
                players.get(j).getTerrain().setVisibility(false);
                terrains.remove(0);
            }
            players.get(game.getTurnNum()).getTerrain().setVisibility(true);
//            playTurn();

            if (game.getTurnNum() == 3) {
                for (int i = 0; i < players.size(); i++) {
                    if (players.get(i).getNumSettlements() == 0) {
                        //might have issues?
                        game.endGame();
                        break;
                    }
                }
            }
//            nextTurn();
        }
    }
//
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

    }

    @FXML
    void next(ActionEvent event) {
        //using testing thing to test the buttons and stuff
        game.testNextTurnNum();
        //local turnNum check against game instance "turn",
        //if it equals then display "current", if it doesn't then don't
        drawPlayerinfo();
    }

    @FXML
    void previous(ActionEvent event) {
        game.testPrevTurnNum();
        drawPlayerinfo();
    }

    @FXML
    void useBonus(ActionEvent event) {

    }

    private void drawInfoCards() {


    }

    private void drawPointsCards() {
        ArrayList temp = game.getPointsCards();
        pointCard0.setImage(returnImage(temp.get(0).toString()));
        pointCard1.setImage(returnImage(temp.get(1).toString()));
        pointCard2.setImage(returnImage(temp.get(2).toString()));

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
            temp = new Image(getClass().getResource("images/CanyonCard.jpg").toExternalForm());
        else if (str.equals("d"))//desert
            temp = new Image(getClass().getResource("images/DesertCard.jpg").toExternalForm());
        else if (str.equals("f"))//flower
            temp = new Image(getClass().getResource("images/FlowerCard.jpg").toExternalForm());
        else if (str.equals("g"))//meadow
            temp = new Image(getClass().getResource("images/MeadowCard.jpg").toExternalForm());
        else if (str.equals("s"))//forest
            temp = new Image(getClass().getResource("images/ForestCard.jpg").toExternalForm());
        else if (str.equals("m"))//mountain
            temp = new Image(getClass().getResource("images/CanyonCard.jpg").toExternalForm());
        else if (str.equals("castle"))//castle
            temp = new Image(getClass().getResource("images/DesertCard.jpg").toExternalForm());
        else if (str.equals("Oasis"))//oasis
            temp = new Image(getClass().getResource("images/DesertCard.jpg").toExternalForm());
        else if (str.equals("castle"))//oracle
            temp = new Image(getClass().getResource("images/DesertCard.jpg").toExternalForm());
        else if (str.equals("castle"))//barn
            temp = new Image(getClass().getResource("images/DesertCard.jpg").toExternalForm());
        else if (str.equals("castle"))//harbor
            temp = new Image(getClass().getResource("images/DesertCard.jpg").toExternalForm());
        else if (str.equals("castle"))//idk
            temp = new Image(getClass().getResource("images/DesertCard.jpg").toExternalForm());


        else
            return temp;
        return temp;
    }

    private void drawPlayerinfo() {
        playerName.setText("players.get(game.getTurnNum()).toString()");
        int tempTurn = game.getTurnNum() + 1;
        playerName.setText("Player " + tempTurn);
        settleNum.setText("Total Settlements: "+game.getPlayers().get(game.getTurnNum()).getNumSettlements());
        //this will work once the players are actually assigned terrain cards, return error bc null atm
        //currentTerrainCard.setImage(returnImage(game.getPlayers().get(game.getTurnNum()).getTerrain().getType()));

        currentTerrainCard.setImage(returnImage("shrek"));

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

/*
    public MainSceneController(){
        game = new KingdomBuilderMain();
        pointCard0= new ImageView();
        pointCard1= new ImageView();
        pointCard2= new ImageView();
        //ArrayList players =game.getPlayers();
        //game.getTurnPlayer();
        //playerName.setText("Player "+game.getTurnNum());
        //drawPlayerinfo();
        drawPointsCards();


        // drawInfoCards();






    }*/
}
/* TO DO LIST:
* add placement method for polygons
* show first player token(need add boolean to player class i think
* terrain cards assigned to players
* settlements on board
* show action tiles properly
* (maaaaaaaybe draw tiles individually
* actually get the game to work*/


