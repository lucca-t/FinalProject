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
   // private KingdomBuilderMain game;
    public MainSceneController(){
      //  game = new KingdomBuilderMain();

        //ArrayList players =game.getPlayers();
        //game.getTurnPlayer();
        //playerName.setText("Player "+game.getTurnNum());
        //drawPlayerinfo();
        //drawPointsCards();
        // drawInfoCards();
      //  currentTerrainCard= new ImageView((new Image("file:CitizenCard.jpg")));





    }

    @FXML
    void confirmPlace(ActionEvent event) {

    }


    @FXML
    void finishTurn(ActionEvent event) {

    }

    @FXML
    void next(ActionEvent event) {

    }

    @FXML
    void previous(ActionEvent event) {

    }

    @FXML
    void useBonus(ActionEvent event) {

    }
    private void drawInfoCards() {



    }

    private void drawPointsCards()  {
        //ArrayList temp = game.getPointsCards();
       /*pointCard0 = new ImageView(returnPointsCards(temp.get(0).toString()));
        pointCard1 = new ImageView(returnPointsCards(temp.get(1).toString()));
        pointCard2 = new ImageView(returnPointsCards(temp.get(2).toString()));*/
        pointCard0 = new ImageView(returnPointsCards("Citizen"));
        pointCard1 = new ImageView(returnPointsCards("Citizen"));
        pointCard2 = new ImageView(returnPointsCards("Citizen"));

    }
    private Image returnPointsCards(String str){
        Image temp=new Image("![](../../../../resources/com/example/demo/images/CitizenCard.jpg)");

        if(str.equals("Citizen"))
            temp=new Image("Graphics/src/main/resources/com/example/demo/images/CitizenCard.jpg");
        else if(str.equals("Discoverers"))
            temp=new Image("/images/DiscovererCard.jpg");
        else if(str.equals("Farmers"))
            temp=new Image("/images/FarmerCard.jpg");
        else if(str.equals("Fishermen"))
            temp=new Image("/images/FishermanCard.jpg");
        else if(str.equals("Hermits"))
            temp=new Image("/images/HermitCard.jpg");
        else if(str.equals("Knights"))
            temp=new Image("/images/KnightCard.jpg");
        else if(str.equals("Lords"))
            temp=new Image("/images/LordCard.jpg");
        else if(str.equals("Merchants"))
            temp=new Image("/images/MerchantCard.jpg");
        else if(str.equals("Miners"))
            temp=new Image("/images/Workers.jpg");
        else
            return temp;
        return temp;

    }

    private void drawPlayerinfo() {


    }


}
