package tawelib;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;

/**
 * This AvatarController Class pairs with the AvatarMain Class.
 * <br>
 * This class allows the user to draw their own avatar for their account.
 *
 *
 *@author Seb Gappa
 *@version 1.0
 *@since 04/12/2018
 */

public class AvatarController {

    @FXML
    private Canvas canvas;
    @FXML
    private ColorPicker colourPicker;
    @FXML
    private TextField brushSize;
    @FXML
    private Text selectedTool;

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

    public void save() {
        // TODO Avatar id gen
        File directory = new File("C:\\Users\\ronal\\OneDrive\\Documents\\Uni\\230\\A1_Library_Manager\\source\\tawelib\\images");
        try {
            Image avatar = canvas.snapshot(null, null);
            ImageIO.write(SwingFXUtils.fromFXImage(avatar, null), "png",
                    File.createTempFile("avatar", ".png", directory));

        } catch (Exception e) {
            System.out.println("Failed to save: " + e);
        }
    }
}