package generativeArt;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Shapes {


    public static void drawRectangle(float x, float y, float w, float h, Color colour, GraphicsContext gc) {
        gc.setFill(colour);
        gc.fillRect(x,y,w,h);
    }

    public static void drawOval(float x, float y, float w, float h, Color colour, GraphicsContext gc) {
        gc.setFill(colour);
        gc.fillOval(x,y,w,h);
    }

}
