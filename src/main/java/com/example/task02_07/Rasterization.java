package com.example.task02_07;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

public class Rasterization {

    public static void drawSector(
            final GraphicsContext graphicsContext,
            final int x, final int y,
            final double radius,
            final double angle1, final double angle2) {
        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();

        final double inclinationCoefficient1 = Math.tan(Math.toRadians(angle1));
        final double inclinationCoefficient2 = Math.tan(Math.toRadians(angle2));
        final int quarterAngle1 = defineQuarterCircle(angle1);
        final int quarterAngle2 = defineQuarterCircle(angle2);
        final int interpolationStep = (int) Math.ceil(255 / radius);

        for (int row = (int) (y - radius); row < y + radius; row++) {

            int xLeft = (int) (x - Math.round(Math.sqrt(radius * radius - (row - y) * (row - y))));
            int xRight = (int) (x + Math.round(Math.sqrt(radius * radius - (row - y) * (row - y))));

            for (int col = xLeft; col < xRight; col++) {
                switch (quarterAngle1) {
                    case 1:
                        switch (quarterAngle2) {
                            case 1:
                            case 2:
                                if ((angle2 >= angle1) && (col >= ((y - row) / inclinationCoefficient2) + x) && (col <= ((y - row) / inclinationCoefficient1) + x)) {
                                    pixelWriter.setColor(col, row, calculateColor(interpolationStep, x, y, col, row));
                                } else if ((angle2 <= angle1) && ((col <= ((y - row) / inclinationCoefficient1) + x) || (col >= ((y - row) / inclinationCoefficient2) + x))) {
                                    pixelWriter.setColor(col, row, calculateColor(interpolationStep, x, y, col, row));
                                }
                                break;
                            case 3:
                            case 4:
                                if ((row <= y) && (col <= ((y - row) / inclinationCoefficient1) + x)) {
                                    pixelWriter.setColor(col, row, calculateColor(interpolationStep, x, y, col, row));
                                } else if ((row >= y) && (col <= ((y - row) / inclinationCoefficient2) + x)) {
                                    pixelWriter.setColor(col, row, calculateColor(interpolationStep, x, y, col, row));
                                }
                                break;
                        }
                        break;

                    case 2:
                        switch (quarterAngle2) {
                            case 1:
                                if ((col <= x) && (col <= ((y - row) / inclinationCoefficient1) + x)) {
                                    pixelWriter.setColor(col, row, calculateColor(interpolationStep, x, y, col, row));
                                } else if ((col >= x) && (col >= ((y - row) / inclinationCoefficient2) + x)) {
                                    pixelWriter.setColor(col, row, calculateColor(interpolationStep, x, y, col, row));
                                }
                                break;
                            case 2:
                                if ((angle2 >= angle1) && (col >= ((y - row) / inclinationCoefficient2) + x) && (col <= ((y - row) / inclinationCoefficient1) + x)) {
                                    pixelWriter.setColor(col, row, calculateColor(interpolationStep, x, y, col, row));
                                } else if ((angle2 <= angle1) && ((col <= ((y - row) / inclinationCoefficient1) + x) || (col >= ((y - row) / inclinationCoefficient2) + x))) {
                                    pixelWriter.setColor(col, row, calculateColor(interpolationStep, x, y, col, row));
                                }
                                break;
                            case 3:
                            case 4:
                                if ((row <= y) && (col <= ((y - row) / inclinationCoefficient1) + x)) {
                                    pixelWriter.setColor(col, row, calculateColor(interpolationStep, x, y, col, row));
                                } else if ((row >= y) && (col <= ((y - row) / inclinationCoefficient2) + x)) {
                                    pixelWriter.setColor(col, row, calculateColor(interpolationStep, x, y, col, row));
                                }
                                break;
                        }
                        break;

                    case 3:
                        switch (quarterAngle2) {
                            case 1:
                            case 2:
                                if ((row <= y) && (col >= ((y - row) / inclinationCoefficient2) + x)) {
                                    pixelWriter.setColor(col, row, calculateColor(interpolationStep, x, y, col, row));
                                } else if ((row >= y) && (col >= ((y - row) / inclinationCoefficient1) + x)) {
                                    pixelWriter.setColor(col, row, calculateColor(interpolationStep, x, y, col, row));
                                }
                                break;
                            case 3:
                            case 4:
                                if ((angle2 >= angle1) && (col >= ((y - row) / inclinationCoefficient1) + x) && (col <= ((y - row) / inclinationCoefficient2) + x)) {
                                    pixelWriter.setColor(col, row, calculateColor(interpolationStep, x, y, col, row));
                                } else if ((angle2 <= angle1) && ((col >= ((y - row) / inclinationCoefficient1) + x) || (col <= ((y - row) / inclinationCoefficient2) + x))) {
                                    pixelWriter.setColor(col, row, calculateColor(interpolationStep, x, y, col, row));
                                }
                                break;
                        }
                        break;

                    case 4:
                        switch (quarterAngle2) {
                            case 1:
                            case 2:
                                if ((row <= y) && (col >= ((y - row) / inclinationCoefficient2) + x)) {
                                    pixelWriter.setColor(col, row, calculateColor(interpolationStep, x, y, col, row));
                                } else if ((row >= y) && (col >= ((y - row) / inclinationCoefficient1) + x)) {
                                    pixelWriter.setColor(col, row, calculateColor(interpolationStep, x, y, col, row));
                                }
                                break;
                            case 3:
                                if ((col <= x) && (col <= ((y - row) / inclinationCoefficient2) + x)) {
                                    pixelWriter.setColor(col, row, calculateColor(interpolationStep, x, y, col, row));
                                } else if ((col >= x) && (col >= ((y - row) / inclinationCoefficient1) + x)) {
                                    pixelWriter.setColor(col, row, calculateColor(interpolationStep, x, y, col, row));
                                }
                                break;
                            case 4:
                                if ((angle2 >= angle1) && (col >= ((y - row) / inclinationCoefficient1) + x) && (col <= ((y - row) / inclinationCoefficient2) + x)) {
                                    pixelWriter.setColor(col, row, calculateColor(interpolationStep, x, y, col, row));
                                } else if ((angle2 <= angle1) && ((col >= ((y - row) / inclinationCoefficient1) + x) || (col <= ((y - row) / inclinationCoefficient2) + x))) {
                                    pixelWriter.setColor(col, row, calculateColor(interpolationStep, x, y, col, row));
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

    private static Color calculateColor(int interpolationStep, int x, int y, int col, int row) {
        int rgbOffset = (int) (interpolationStep * Math.round(Math.sqrt((x - col) * (x - col) + (y - row) * (y - row))));
        if (rgbOffset > 255) {
            rgbOffset = 255;
        }
        return Color.rgb(255 - rgbOffset, 0, rgbOffset);
    }
}