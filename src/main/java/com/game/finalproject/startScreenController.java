package com.game.finalproject;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class startScreenController {


    @FXML
    private ImageView startButton;

    @FXML
    private ImageView startScreen;

    @FXML
    void startButtonEntered(MouseEvent event) {
        //startButton.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("startbuttonhovered2.png"))));
        startButton.setImage(new Image(getClass().getResource("images/startbuttonhovered2.png").toExternalForm()));
    }

    @FXML
    void startButtonExited(MouseEvent event) {
       // startButton.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("startbutton.png"))));
        startButton.setImage(new Image(getClass().getResource("images/startbutton.png").toExternalForm()));
    }

    @FXML
    void startButtonPressed(MouseEvent event)throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1351, 720);
        Stage stage = (Stage) startButton.getScene().getWindow();
        stage.setScene(scene);


    }

    @FXML
    void startButtonReleased(MouseEvent event) {

    }

}