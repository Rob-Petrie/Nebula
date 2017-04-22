package generativeArt;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.awt.*;
import java.awt.event.ActionListener;


public class Controller {

    @FXML private TextField startXTF, startYTF, cellWTF, cellHTF, offsetXTF, offsetYTF, strandsTF, loopsTF;
    @FXML private Spinner opacitySpin, rSpin, gSpin, bSpin;

    @FXML public Canvas canvas;

    @FXML public ScrollPane controlsScroll;

    @FXML
    private ChoiceBox shapeDropdown;

    private boolean randX = false,
                    randY = false,
                    randW = false,
                    randH = false,
                    randOffsetX = false,
                    randOffsetY = false,
                    randOpacity = false,
                    randCol = true;

    @FXML private void checkCharNum(KeyEvent e) {
        String c = e.getCharacter();
        if(!"1234567890.".contains(c)) {
            e.consume();
        }
    }

    @FXML private void checkCharNumNeg(KeyEvent e) {
        TextField parent = (TextField) e.getSource();
        String c = e.getCharacter();
        if(!"1234567890-.".contains(c) || (parent.getText().contains("-") && "-".contains(c))){
            e.consume();
        }
    }

    @FXML
    GridPane root;

    @FXML
    private void initialize() {

        //Listen for window resize and resize canvas
        root.prefWidthProperty().addListener((ov, oldValue, newValue) -> {
            canvas.setWidth(newValue.doubleValue()-300);
        });

        root.prefHeightProperty().addListener((ov, oldValue, newValue) -> {
            canvas.setHeight(newValue.doubleValue());
        });

        shapeDropdown.setItems(FXCollections.observableArrayList("Rectangle", "Oval", "Hexagon"));
        shapeDropdown.setValue("Rectangle");
    }

    //Set booleans from checkBoxes
    @FXML
    private void setRandX(ActionEvent e) {
        startXTF.setDisable(!startXTF.isDisabled());
        randX = !randX;
    }

    @FXML
    private void setRandY(ActionEvent e) {
        startYTF.setDisable(!startYTF.isDisabled());
        randY = !randY;
    }

    @FXML
    private void setRandW(ActionEvent e) {
        //cellWTF.setDisable(!cellWTF.isDisabled());
        randW = !randW;
    }

    @FXML
    private void setRandH(ActionEvent e) {
        //cellWTF.setDisable(!cellWTF.isDisabled());
        randH = !randH;
    }
    @FXML
    private void setRandOpacity(ActionEvent e) {
        opacitySpin.setDisable(!opacitySpin.isDisabled());
        randOpacity = !randOpacity;
    }

    @FXML
    private void setRandCol(ActionEvent e) {
        rSpin.setDisable(!rSpin.isDisabled());
        gSpin.setDisable(!gSpin.isDisabled());
        bSpin.setDisable(!bSpin.isDisabled());
        randCol = !randCol;
    }

    @FXML
    private void setRandOffsetX(ActionEvent e) {
        randOffsetX = !randOffsetX;
    }

    @FXML
    private void setRandOffsetY(ActionEvent e) {
        randOffsetY = !randOffsetY;
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

        Generate.generate(shapeDropdown.getValue().toString().toLowerCase(), loops, strands, cellW, randW, cellH, randH, offsetX, randOffsetX, offsetY, randOffsetY, startX, randX, startY, randY, opacity, randOpacity,
                (double)rSpin.getValue(), (double)gSpin.getValue(), (double)bSpin.getValue(), randCol, gc);


    }

}
