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

        Rasterization.drawSector(canvas.getGraphicsContext2D(), 110, 103, 90, 20, 70);
        Rasterization.drawSector(canvas.getGraphicsContext2D(), 310, 103, 90, 20, 160);
        Rasterization.drawSector(canvas.getGraphicsContext2D(), 510, 103, 90, 20, 250);
        Rasterization.drawSector(canvas.getGraphicsContext2D(), 710, 103, 90, 20, 330);
        Rasterization.drawSector(canvas.getGraphicsContext2D(), 910, 103, 90, 70, 20);

        Rasterization.drawSector(canvas.getGraphicsContext2D(), 110, 303, 90, 110, 160);
        Rasterization.drawSector(canvas.getGraphicsContext2D(), 310, 303, 90, 110, 250);
        Rasterization.drawSector(canvas.getGraphicsContext2D(), 510, 303, 90, 110, 330);
        Rasterization.drawSector(canvas.getGraphicsContext2D(), 710, 303, 90, 110, 20);
        Rasterization.drawSector(canvas.getGraphicsContext2D(), 910, 303, 90, 160, 110);

        Rasterization.drawSector(canvas.getGraphicsContext2D(), 110, 503, 90, 200, 250);
        Rasterization.drawSector(canvas.getGraphicsContext2D(), 310, 503, 90, 200, 330);
        Rasterization.drawSector(canvas.getGraphicsContext2D(), 510, 503, 90, 200, 70);
        Rasterization.drawSector(canvas.getGraphicsContext2D(), 710, 503, 90, 200, 160);
        Rasterization.drawSector(canvas.getGraphicsContext2D(), 910, 503, 90, 250, 200);

        Rasterization.drawSector(canvas.getGraphicsContext2D(), 110, 703, 90, 290, 340);
        Rasterization.drawSector(canvas.getGraphicsContext2D(), 310, 703, 90, 290, 20);
        Rasterization.drawSector(canvas.getGraphicsContext2D(), 510, 703, 90, 290, 160);
        Rasterization.drawSector(canvas.getGraphicsContext2D(), 710, 703, 90, 290, 250);
        Rasterization.drawSector(canvas.getGraphicsContext2D(), 910, 703, 90, 340, 290);

        Rasterization.drawSector(canvas.getGraphicsContext2D(), 1240, 400, 150, 340, 340);
    }

}