package tawelib;

import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class AvatarController {

    @FXML
    private Canvas canvas;
    @FXML
    private ColorPicker colourPicker;
    @FXML
    private TextField brushSize;
    @FXML
    private Text selectedTool;

    @FXML
    private Button saveDrawButton;

    @FXML
    private Button cancelDrawButton;

    private double lineX1;
    private double lineY1;

    public void particleTrace() {
        selectedTool.setText("Particle Trace");
        canvas.setOnMouseReleased(null);
        GraphicsContext g = canvas.getGraphicsContext2D();

        canvas.setOnMouseDragged(e -> {
            double size = Double.parseDouble(brushSize.getText());
            double x = e.getX() - size / 2;
            double y = e.getY() - size / 2;
            g.setFill(colourPicker.getValue());
            g.fillOval(x, y, size, size);
        });

    }

    public void line() {
        selectedTool.setText("Line");
        canvas.setOnMouseDragged(null);
        GraphicsContext g = canvas.getGraphicsContext2D();

        canvas.setOnMousePressed(e -> {
            double size = Double.parseDouble(brushSize.getText());
            lineX1 = e.getX() - size / 2;
            lineY1 = e.getY() - size / 2;
        });

        canvas.setOnMouseReleased(e -> {
            double size = Double.parseDouble(brushSize.getText());
            double lineX2 = e.getX() - size / 2;
            double lineY2 = e.getY() - size / 2;

            g.setStroke(colourPicker.getValue());
            g.setLineWidth(size);
            g.strokeLine(lineX1,lineY1,lineX2,lineY2);
        });
    }

    public void eraser() {
        selectedTool.setText("Eraser");
        canvas.setOnMouseReleased(null);
        GraphicsContext g = canvas.getGraphicsContext2D();

        canvas.setOnMouseDragged(e -> {
            double size = Double.parseDouble(brushSize.getText());
            double x = e.getX() - size / 2;
            double y = e.getY() - size / 2;
            g.clearRect(x,y,size,size);
        });
    }

    public void exit() {

        Platform.exit();
    }

    @FXML
    void saveDrawing(ActionEvent event) {
        try{
            //FileChooser fileChooser = new FileChooser();
            //fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("png files (*.png)","*.png"));
            //File file = fileChooser.showSaveDialog(null);
            //File outputFile = new File("...tawelib/images/");
            Image snapshot = canvas.snapshot(null,null);
            ImageIO.write(SwingFXUtils.fromFXImage(snapshot,null), "png", new File("newAvatar.png"));
        } catch (Exception e){
            System.out.println("Failed to save image" + e);
        }
    }


}