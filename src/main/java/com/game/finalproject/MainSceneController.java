package com.game.finalproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

//HOW TO DO IMAGES ALSO THIS LINK SUPERUSEFULDONTFORGET
/////https://stackoverflow.com/questions/61531317/how-do-i-determine-the-correct-path-for-fxml-files-css-files-images-and-other
/* URL imageURL = getClass().getResource("images/CanyonCard.jpg");
        Image image = new Image(imageURL.toExternalForm());
        pointCard0.setImage(new Image(getClass().getResource("images/CanyonCard.jpg").toExternalForm()));
           */

//if there's an error in the images, shrek will show

public class MainSceneController {

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

    @FXML
    private void initialize(){
        game = new KingdomBuilderMain();
        drawPointsCards();
       // players= game.getPlayers();
        drawPlayerinfo();
    }


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

    private void drawPointsCards()  {
        ArrayList temp = game.getPointsCards();
        pointCard0.setImage(returnImage(temp.get(0).toString()));
        pointCard1.setImage(returnImage(temp.get(1).toString()));
        pointCard2.setImage(returnImage(temp.get(2).toString()));

    }
    private Image returnImage(String str){
        Image temp=new Image(getClass().getResource("images/shrek.png").toExternalForm());

        if(str.equals("Citizen"))
            temp=new Image(getClass().getResource("images/CitizenCard.jpg").toExternalForm());
        else if(str.equals("Discoverers"))
            temp=new Image(getClass().getResource("images/DiscovererCard.jpg").toExternalForm());
        else if(str.equals("Farmers"))
            temp=new Image(getClass().getResource("images/FarmerCard.jpg").toExternalForm());
        else if(str.equals("Fishermen"))
            temp=new Image(getClass().getResource("images/FishermanCard.jpg").toExternalForm());
        else if(str.equals("Hermits"))
            temp=new Image(getClass().getResource("images/HermitCard.jpg").toExternalForm());
        else if(str.equals("Knights"))
            temp=new Image(getClass().getResource("images/KnightCard.jpg").toExternalForm());
        else if(str.equals("Lords"))
            temp=new Image(getClass().getResource("images/LordCard.jpg").toExternalForm());
        else if(str.equals("Merchants"))
            temp=new Image(getClass().getResource("images/MerchantCard.jpg").toExternalForm());
        else if(str.equals("Miners"))
            temp=new Image(getClass().getResource("images/MinerCard.jpg").toExternalForm());
        else if(str.equals("Workers"))
            temp=new Image(getClass().getResource("images/WorkerCard.jpg").toExternalForm());
        //terrain cards below
        //dont know the actual names so i guessed
        else if(str.equals("c"))
            temp=new Image(getClass().getResource("images/CanyonCard.jpg").toExternalForm());
        else if(str.equals("d"))
            temp=new Image(getClass().getResource("images/DesertCard.jpg").toExternalForm());
        else if(str.equals("f"))
            temp=new Image(getClass().getResource("images/FlowerCard.jpg").toExternalForm());
        else if(str.equals("g"))
            temp=new Image(getClass().getResource("images/MeadowCard.jpg").toExternalForm());
        else if(str.equals("s"))
            temp=new Image(getClass().getResource("images/ForestCard.jpg").toExternalForm());
        else
            return temp;
        return temp;

    }

    private void drawPlayerinfo() {
        playerName.setText("players.get(game.getTurnNum()).toString()");
        int tempTurn=game.getTurnNum()+1;
        playerName.setText("Player "+tempTurn);

        //this will work once the players are actually assigned terrain cards, return error bc null atm
        //currentTerrainCard.setImage(returnImage(game.getPlayers().get(game.getTurnNum()).getTerrain().getType()));

        currentTerrainCard.setImage(returnImage("shrek"));

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
