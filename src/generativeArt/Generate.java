package generativeArt;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

public class Generate {


    public static void generate(String shapeType, float loops, float strands, float cellW, float cellH, float offsetX, float offsetY, float startX, float startY, float opacity, GraphicsContext graphicsContext) {

        Random rand = new Random();
        int randNum;


            for(int strandNum = 1; strandNum <= strands; strandNum++) {

                float currentX = startX;
                float currentY = startY;

                Color color;
                color = Color.color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble(),opacity);

                for(int loopNum = 1; loopNum <= loops; loopNum++) {

                    if(shapeType.equals("rectangle")) {
                        Shapes.drawRectangle(currentX, currentY, cellW, cellH, color, graphicsContext);
                    }

                    if(shapeType.equals("oval")) {
                        Shapes.drawOval(currentX, currentY, cellW, cellH, color, graphicsContext);
                    }

                    randNum = rand.nextInt(8)+1;

                    //Choose direction
                    switch (randNum) {
                        case 1:
                            currentY -= (cellH + offsetY);
                            break;
                        case 2:
                            currentX += (cellW + offsetX);
                            currentY -= (cellH + offsetY);
                            break;
                        case 3:
                            currentX += (cellW + offsetX);
                            break;
                        case 4:
                            currentX += (cellW + offsetX);
                            currentY += (cellH + offsetY);
                            break;
                        case 5:
                            currentY += (cellH + offsetY);
                            break;
                        case 6:
                            currentX -= (cellW + offsetX);
                            currentY += (cellH + offsetY);
                            break;
                        case 7:
                            currentX -= (cellW + offsetX);
                            break;
                        case 8:
                            currentX -= (cellW + offsetX);
                            currentY -= (cellH + offsetY);
                            break;

                    }

                }
            }
        }

    }
