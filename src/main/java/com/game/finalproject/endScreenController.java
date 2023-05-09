
package com.game.finalproject;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.Objects;


public class endScreenController {

        @FXML
        private ImageView endScreen;

        @FXML
        private ImageView playAgain;

        @FXML
        private ImageView returnBack;
        @FXML
        private Label label1,label2,label3,label4,winLabel;

        private KingdomBuilderMain game;

        @FXML
        private void initialize(){




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
        void ReturnBackButtonPressed(MouseEvent event) {

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

        }

        @FXML
        void playAgainButtonReleased(MouseEvent event) {

        }

}
