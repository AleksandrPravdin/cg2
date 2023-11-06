package com.example.task02_07;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

public class Rasterization {

    public static void drawSector(
            final GraphicsContext graphicsContext,
            final int x, final int y,
            final int radius,
            final double angle1, final double angle2,
            final Color color) {
        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();
        final double inclinationСoefficient1 = Math.tan(Math.toRadians(angle1));
        final double inclinationСoefficient2 = Math.tan(Math.toRadians(angle2));
        final int quarterangle1 = defineQuarterCircle(angle1);
        final int quarterangle2 = defineQuarterCircle(angle2);

        for (int row = y - radius; row < y + radius; row++) {
            int xLeft = (int) (x - Math.round(Math.sqrt(radius * radius - (row - y) * (row - y))));
            int xRight = (int) (x + Math.round(Math.sqrt(radius * radius - (row - y) * (row - y))));
            for (int col = xLeft; col < xRight; col++) {
                switch (quarterangle1) {
                    case 1:
                        switch (quarterangle2) {
                            case 1:
                            case 2:
                                if ((angle2>=angle1)&&(col >= ((y - row) / inclinationСoefficient2) + x) && (col <= ((y - row) / inclinationСoefficient1) + x)) {
                                    pixelWriter.setColor(col, row, color);
                                } else if((angle2<=angle1)&&((col <= ((y - row) / inclinationСoefficient1) + x) || (col >= ((y - row) / inclinationСoefficient2) + x))) {
                                pixelWriter.setColor(col, row, color);
                            }
                                break;
                            case 3:
                            case 4:
                                if ((row <= y) && (col <= ((y - row) / inclinationСoefficient1) + x)) {
                                    pixelWriter.setColor(col, row, color);
                                } else if ((row >= y) && (col <= ((y - row) / inclinationСoefficient2) + x)) {
                                    pixelWriter.setColor(col, row, color);
                                }
                                break;
                        }
                        break;

                    case 2:
                        switch (quarterangle2) {
                            case 1:
                                if ((col <= x) && (col <= ((y - row) / inclinationСoefficient1) + x)) {
                                    pixelWriter.setColor(col, row, color);
                                } else if ((col >= x) && (col >= ((y - row) / inclinationСoefficient2) + x)) {
                                    pixelWriter.setColor(col, row, color);
                                }
                                break;
                            case 2:
                                if ((angle2>=angle1)&&(col >= ((y - row) / inclinationСoefficient2) + x) && (col <= ((y - row) / inclinationСoefficient1) + x)) {
                                    pixelWriter.setColor(col, row, color);
                                }else if ((angle2<=angle1)&&((col <= ((y - row) / inclinationСoefficient1) + x) || (col >= ((y - row) / inclinationСoefficient2) + x))) {
                                    pixelWriter.setColor(col, row, color);
                                }
                                break;
                            case 3:
                            case 4:
                                if ((row <= y) && (col <= ((y - row) / inclinationСoefficient1) + x)) {
                                    pixelWriter.setColor(col, row, color);
                                } else if ((row >= y) && (col <= ((y - row) / inclinationСoefficient2) + x)) {
                                    pixelWriter.setColor(col, row, color);
                                }
                                break;
                        }
                        break;

                    case 3:
                        switch (quarterangle2) {
                            case 1:
                            case 2:
                                if ((row <= y) && (col >= ((y - row) / inclinationСoefficient2) + x)) {
                                    pixelWriter.setColor(col, row, color);
                                } else if ((row >= y) && (col >= ((y - row) / inclinationСoefficient1) + x)) {
                                    pixelWriter.setColor(col, row, color);
                                }
                                break;
                            case 3:
                            case 4:
                                if ((angle2>=angle1)&&(col >= ((y - row) / inclinationСoefficient1) + x) && (col <= ((y - row) / inclinationСoefficient2) + x)) {
                                    pixelWriter.setColor(col, row, color);
                                }else if ((angle2<=angle1)&&((col >= ((y - row) / inclinationСoefficient1) + x) || (col <= ((y - row) / inclinationСoefficient2) + x))) {
                                    pixelWriter.setColor(col, row, color);
                                }
                                break;
                        }
                        break;

                    case 4:
                        switch (quarterangle2){
                            case 1:
                            case 2:
                                if ((row <= y) && (col >= ((y - row) / inclinationСoefficient2) + x)) {
                                    pixelWriter.setColor(col, row, color);
                                } else if ((row >= y) && (col >= ((y - row) / inclinationСoefficient1) + x)) {
                                    pixelWriter.setColor(col, row, color);
                                }
                                break;
                            case 3:
                                if ((col <= x) && (col <= ((y - row) / inclinationСoefficient2) + x)) {
                                    pixelWriter.setColor(col, row, color);
                                } else if ((col >= x) && (col >= ((y - row) / inclinationСoefficient1) + x)) {
                                    pixelWriter.setColor(col, row, color);
                                }
                                break;
                            case 4:
                                if ((angle2>=angle1)&&(col >= ((y - row) / inclinationСoefficient1) + x) && (col <= ((y - row) / inclinationСoefficient2) + x)) {
                                    pixelWriter.setColor(col, row, color);
                                }else if ((angle1>=angle1)&&((col >= ((y - row) / inclinationСoefficient1) + x) || (col <= ((y - row) / inclinationСoefficient2) + x))) {
                                    pixelWriter.setColor(col, row, color);
                                }
                                break;
                        }
                        break;
                }
            }
        }

    }

    private static int defineQuarterCircle(double angle) {
        if ((angle >= 0) && (angle <= 90)) {
            return 1;
        } else if ((angle >= 90) && (angle <= 180)) {
            return 2;
        } else if ((angle >= 180) && (angle <= 270)) {
            return 3;
        } else if ((angle >= 270) && (angle <= 360)) {
            return 4;
        }
        return 0;
    }
}

