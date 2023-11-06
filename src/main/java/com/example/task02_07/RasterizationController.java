package com.example.task02_07;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;

import javafx.scene.paint.Color;

public class RasterizationController {

    @FXML
    AnchorPane anchorPane;
    @FXML
    private Canvas canvas;

    @FXML
    private void initialize() {
        anchorPane.prefWidthProperty().addListener((ov, oldValue, newValue) -> canvas.setWidth(newValue.doubleValue()));
        anchorPane.prefHeightProperty().addListener((ov, oldValue, newValue) -> canvas.setHeight(newValue.doubleValue()));

        Rasterization.drawSector(canvas.getGraphicsContext2D(),250,250,100,30.0,330.0,Color.YELLOW);
        Rasterization.drawSector(canvas.getGraphicsContext2D(),290,190,15,330.0,330.0,Color.BLACK);
        Rasterization.drawSector(canvas.getGraphicsContext2D(),450,250,65,225.0,45.0,Color.GREEN);
        Rasterization.drawSector(canvas.getGraphicsContext2D(),450,250,55,225.0,45.0,Color.RED);
    }

}