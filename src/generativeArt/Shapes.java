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

    public static void drawHexagon(float x, float y, float w, float h, Color colour, GraphicsContext gc) {
        gc.setFill(colour);

        //Set relative points for hexagon with offset of 1/15 from top and bottom
        double[] xPoints = new double[] {x, x+(w*0.25), x+(w*0.75), x+w, x+(w*0.75), x+(w*0.25)};
        double[] yPoints = new double[] {y+(h*0.5), y+(h*(1f/15f)), y+(h*(1f/15f)), y+(h*0.5), (y+h-(h*(1f/15f))), (y+h-(h*(1f/15f)))};

        gc.fillPolygon(xPoints, yPoints, 6);
    }

}
