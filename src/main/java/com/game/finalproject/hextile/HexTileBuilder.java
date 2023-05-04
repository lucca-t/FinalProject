package com.game.finalproject.hextile;


import javafx.beans.binding.Bindings;
import javafx.css.PseudoClass;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Builder;

public class HexTileBuilder implements Builder<Region> {

    //private final TileModel model;

    //private final PseudoClass selected = PseudoClass.getPseudoClass("selected");
    //private final Runnable clickHandler;

    public HexTileBuilder() {
//https://github.com/PragmaticCoding/HexMap
        //https://github.com/PragmaticCoding/HexMapz

    }

    public Region build() {
        StackPane results = new StackPane();
        styleAndSizeTile(results);
        //results.getChildren().addAll(createTerrainSprite(), createCoordinateLabel(), createOccupyingCounter());
        //results.setOnMouseClicked(evt -> clickHandler.run());


        return results;
    }

    private void styleAndSizeTile(StackPane stackPane) {
        /*stackPane.getStyleClass().add("hex-tile");
        stackPane.maxHeightProperty().bind(model.heightProperty());
        stackPane.maxWidthProperty().bind(model.widthProperty());
        stackPane.minHeightProperty().bind(model.heightProperty());
        stackPane.minWidthProperty().bind(model.widthProperty());
        stackPane.setBackground(new Background(new BackgroundFill(model.getTerrainType().colour, null, null)));
        model.selectedProperty().addListener(observable -> stackPane.pseudoClassStateChanged(selected, model.isSelected()));
        model.terrainTypeProperty().addListener(observable -> stackPane.setBackground(new Background(new BackgroundFill(model.getTerrainType().colour, null, null))));
   */
    }





    private ImageView createOccupyingCounter() {
        ImageView counterImage = new ImageView();



        return counterImage;
    }





}
