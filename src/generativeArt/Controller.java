package generativeArt;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;


public class Controller {

    @FXML private TextField startXTF, startYTF, cellWTF, cellHTF, offsetXTF, offsetYTF, strandsTF, loopsTF;
    @FXML private Spinner opacitySpin;

    @FXML public Canvas canvas;

    @FXML
    private ChoiceBox shapeDropdown;

    @FXML private void checkCharNum(KeyEvent e) {
        String c = e.getCharacter();
        if(!"1234567890.".contains(c)) {
            e.consume();
        }
    }

    @FXML private void checkCharNumNeg(KeyEvent e) {
        String c = e.getCharacter();
        if(!"1234567890-.".contains(c)) {
            e.consume();
        }
    }

    @FXML
    GridPane root;

    @FXML
    private void initialize() {

        //Listen for window resize and resize canvas
        root.prefWidthProperty().addListener((ov, oldValue, newValue) -> {
            canvas.setWidth(newValue.doubleValue());
        });

        root.prefHeightProperty().addListener((ov, oldValue, newValue) -> {
            canvas.setHeight(newValue.doubleValue()-100);
        });

        shapeDropdown.setItems(FXCollections.observableArrayList("Rectangle", "Oval", "Hexagon"));
        shapeDropdown.setValue("Rectangle");
    }

    @FXML
    private void generate() {

        //Check no fields are empty and set values of ints
        if(startXTF.getText().equals("")) startXTF.setText(String.valueOf((float)canvas.getWidth()/2));
        float startX = Float.valueOf(startXTF.getText());

        if(startYTF.getText().equals("")) startYTF.setText(String.valueOf((float)canvas.getHeight()/2));
        float startY = Float.valueOf(startYTF.getText());

        if(cellWTF.getText().equals("")) cellWTF.setText("2");
        float cellW = Float.valueOf(cellWTF.getText());

        if(cellHTF.getText().equals("")) cellHTF.setText("2");
        float cellH = Float.valueOf(cellHTF.getText());

        if(offsetXTF.getText().equals("")) offsetXTF.setText("0");
        float offsetX = Float.valueOf(offsetXTF.getText());

        if(offsetYTF.getText().equals("")) offsetYTF.setText("0");
        float offsetY = Float.valueOf(offsetYTF.getText());

        if(strandsTF.getText().equals("")) strandsTF.setText("10");
        float strands = Float.valueOf(strandsTF.getText());

        if(loopsTF.getText().equals("")) loopsTF.setText("100");
        float loops = Float.valueOf(loopsTF.getText());

        float opacity = Float.valueOf(opacitySpin.getValue().toString());

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.BLACK);
        gc.fillRect(0,0, canvas.getWidth(), canvas.getHeight());

        Generate.generate(shapeDropdown.getValue().toString().toLowerCase(), loops, strands, cellW, cellH, offsetX, offsetY, startX, startY, opacity, gc);


    }

}
