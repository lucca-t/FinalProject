package com.game.finalproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.Objects;

public class startScreenController {


    @FXML
    private ImageView startButton;

    @FXML
    private ImageView startScreen;

    @FXML
    void startButtonEntered(MouseEvent event) {
        startButton.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("startbuttonhovered2.png"))));
    }

    @FXML
    void startButtonExited(MouseEvent event) {
        startButton.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("startbutton.png"))));
    }

    @FXML
    void startButtonPressed(MouseEvent event) {

    }

    @FXML
    void startButtonReleased(MouseEvent event) {

    }

}