package generativeArt;


import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Curve {

    private double a, b, c;

    private List<Float> yCoords = new ArrayList<>();

    private GraphicsContext gc;

    public Curve(double a, double b, double c, GraphicsContext gc) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.gc = gc;
    }

    public void genYCoords() {

        for(int i = 0; i < gc.getCanvas().getWidth(); i++) {
            yCoords.add((float)a*i);
        }
    }

    public List<Float> getYCoords() {
        return yCoords;
    }

}
