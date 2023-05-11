
package com.game.finalproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class endScreenController {

        @FXML
        private ImageView endScreen;

        @FXML
        private ImageView playAgain;

        @FXML
        private ImageView returnBack;
        @FXML
        private Label label1,label2,label3,label4,winLabel,scoreLabel;

        private KingdomBuilderMain game;
        private MainSceneController mcont;
       /* void setGame(KingdomBuilderMain games){
                game=games;
        }*/
       @FXML
       private AnchorPane scoreBox;
        @FXML
        void initialize(KingdomBuilderMain games){
                game=games;
                scoreLabel= new Label();
                scoreLabel.setText(game.getBoard().getTotalScoring());
                scoreLabel.setLayoutX(0);
                scoreLabel.setLayoutY(0);
                scoreLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 11));
                scoreLabel.toFront();
                scoreBox.getChildren().add(scoreLabel);
                label1.setText("Player 1: "+game.getPlayers().get(0).getScore());
                label2.setText("Player 2: "+game.getPlayers().get(1).getScore());
                label3.setText("Player 3: "+game.getPlayers().get(2).getScore());
                label4.setText("Player 4: "+game.getPlayers().get(3).getScore());
                System.out.println();
                System.out.println(game.getBoard().getTotalScoring());
                int max = Integer.MIN_VALUE; // initialize max to the smallest possible integer
                int track=1234;
                for (int i = 0; i < 4; i++) {
                        if (game.getPlayers().get(i).getScore() >= max) {
                                max = game.getPlayers().get(i).getScore();
                        }
                }
                for (int i = 0; i < 4; i++) {
                        if (game.getPlayers().get(i).getScore() ==max) {
                                //max = game.getPlayers().get(i).getScore();
                                track=i;
                        }
                }
               // winLabel.setText("Player "+track+" wins!!");





        }



        @FXML
        void ReturnBackButtonEntered(MouseEvent event) {
//                returnBack.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("returntogamebuttonwithtextdarker.png"))));
                returnBack.setImage(new Image(getClass().getResource("images/returntogamebuttonwithtextdarker.png").toExternalForm()));

        }

        @FXML
        void ReturnBackButtonExited(MouseEvent event) {
//                returnBack.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("returntogamebuttonwithtext.png"))));
                returnBack.setImage(new Image(getClass().getResource("images/returntogamebuttonwithtext.png").toExternalForm()));
        }

        @FXML
        void ReturnBackButtonPressed(MouseEvent event) throws IOException {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainScene.fxml"));


                Scene scene = new Scene(fxmlLoader.load(), 1351, 720);
                Stage stage = (Stage) returnBack.getScene().getWindow();
                stage.setScene(scene);
                MainSceneController mainController= fxmlLoader.getController();
                mainController.initialize(game);


        }

        @FXML
        void ReturnBackButtonReleased(MouseEvent event) {

        }

        @FXML
        void playAgainButtonEntered(MouseEvent event) {
//                playAgain.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("playagainbuttonwithtextdarker.png"))));
                playAgain.setImage(new Image(getClass().getResource("images/playagainbuttonwithtextdarker.png").toExternalForm()));
        }

        @FXML
        void playAgainButtonExited(MouseEvent event) {
//                playAgain.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("playagainbuttonwithtext.png"))));
                playAgain.setImage(new Image(getClass().getResource("images/playagainbuttonwithtext.png").toExternalForm()));
        }

        @FXML
        void playAgainButtonPressed(MouseEvent event) {
                Stage stage = (Stage) playAgain.getScene().getWindow();
                stage.close();

        }

        @FXML
        void playAgainButtonReleased(MouseEvent event) {

        }

}
