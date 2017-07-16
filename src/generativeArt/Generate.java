package generativeArt;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;
import java.util.Random;

public class Generate {


    public static void generate(String shapeType, float loops, float strands, float cellW, boolean randW, float cellH, boolean randH, float offsetX, boolean randOffsetX, float offsetY, boolean randOffsetY,
                                float startX, boolean randX, float startY, boolean randY, boolean graphGen, float opacity, boolean randOpacity, double r, double g, double b, boolean randCol, GraphicsContext graphicsContext) {

        Random rand = new Random();
        int randNum;
        int newCellW, newCellH;
        float newXOffset, newYOffset;
        Curve curve = new Curve(0,0,0, graphicsContext);

            //Loop through the strand code.
            for(int strandNum = 1; strandNum <= strands; strandNum++) {

                //Set random origin if booleans are set.
                float currentX, currentY;
                if(randX) {
                    currentX = rand.nextInt((int)graphicsContext.getCanvas().getWidth());
                } else {
                    currentX = startX;
                }

                if(randY) {
                    currentY = rand.nextInt((int)graphicsContext.getCanvas().getHeight());
                } else {
                    currentY = startY;
                }

                if(randOpacity) opacity = rand.nextFloat() * opacity;

                Color color;
                if(randCol) {
                    //Create random colour
                    color = Color.color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble(), opacity);
                } else {
                    color = Color.color(r, g, b, opacity);
                }

                //Set Random cell width and height, depending on which booleans are set.
                if(randW) {
                    newCellW = rand.nextInt((int)cellW)+1;
                } else {
                    newCellW = (int)cellW;
                }

                if(randH) {
                    newCellH = rand.nextInt((int)cellH)+1;
                } else {
                    newCellH = (int)cellH;
                }

                if(graphGen) {

                    curve = new Curve(2, 2, 2, graphicsContext);

                    curve.genYCoords();

                }

                //Start looping for the current strand.
                for(int loopNum = 1; loopNum <= loops; loopNum++) {

                    //Set shape type.
                    if(shapeType.equals("rectangle")) {
                        Shapes.drawRectangle(currentX, currentY, newCellW, newCellH, color, graphicsContext);
                    }

                    if(shapeType.equals("oval")) {
                        Shapes.drawOval(currentX, currentY, newCellW, newCellH, color, graphicsContext);
                    }

                    if(shapeType.equals("hexagon")) {
                        Shapes.drawHexagon(currentX, currentY, newCellW, newCellH, color, graphicsContext);
                    }

                    if(randOffsetX) {
                        newXOffset = rand.nextFloat() * offsetX;
                    } else {
                        newXOffset = offsetX;
                    }

                    if(randOffsetY) {
                        newYOffset = rand.nextFloat() * offsetY;
                    } else {
                        newYOffset = offsetY;
                    }

                    //If the user has selected to generate with graphs, then
                    if(graphGen && currentX <= graphicsContext.getCanvas().getWidth()) {

                        currentY = curve.getYCoords().get((int)currentX);
                        currentX += 1;

                        for(int i = 0; i < curve.getYCoords().size(); i++) {
                            System.out.println(curve.getYCoords().get(i));
                        }


                    } else {

                        randNum = rand.nextInt(8)+1;

                        //Choose direction
                        switch (randNum) {
                            case 1:
                                currentY -= (cellH + newYOffset);
                                break;
                            case 2:
                                currentX += (cellW + newXOffset);
                                currentY -= (cellH + newYOffset);
                                break;
                            case 3:
                                currentX += (cellW + newXOffset);
                                break;
                            case 4:
                                currentX += (cellW + newXOffset);
                                currentY += (cellH + newYOffset);
                                break;
                            case 5:
                                currentY += (cellH + newYOffset);
                                break;
                            case 6:
                                currentX -= (cellW + newXOffset);
                                currentY += (cellH + newYOffset);
                                break;
                            case 7:
                                currentX -= (cellW + newXOffset);
                                break;
                            case 8:
                                currentX -= (cellW + newXOffset);
                                currentY -= (cellH + newYOffset);
                                break;
                        }

                    }

                }
            }
        }

    }
