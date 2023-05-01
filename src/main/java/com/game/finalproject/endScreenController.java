
package com.game.finalproject;

import javafx.fxml.FXML;
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
        void ReturnBackButtonEntered(MouseEvent event) {
                returnBack.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("returntogamebuttonwithtextdarker.png"))));

        }

        @FXML
        void ReturnBackButtonExited(MouseEvent event) {
                returnBack.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("returntogamebuttonwithtext.png"))));

        }

        @FXML
        void ReturnBackButtonPressed(MouseEvent event) {

        }

        @FXML
        void ReturnBackButtonReleased(MouseEvent event) {

        }

        @FXML
        void playAgainButtonEntered(MouseEvent event) {
                playAgain.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("playagainbuttonwithtextdarker.png"))));

        }

        @FXML
        void playAgainButtonExited(MouseEvent event) {
                playAgain.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("playagainbuttonwithtext.png"))));

        }

        @FXML
        void playAgainButtonPressed(MouseEvent event) {

        }

        @FXML
        void playAgainButtonReleased(MouseEvent event) {

        }

}
