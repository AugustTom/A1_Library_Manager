package tawelib;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;

import javax.imageio.ImageIO;
import java.io.File;

/**
 * This AvatarController Class pairs with the AvatarMain Class.
 *
 * This class allows the user to draw their own avatar for their account.
 *
 * @author Seb Gappa
 * @version 1.0
 * @since 04/12/2018
 */

public class AvatarController {

    private Image avatar;

    @FXML
    private Canvas canvas;
    @FXML
    private ColorPicker colourPicker;
    @FXML
    private TextField brushSize;
    @FXML
    private Text selectedTool;

    @FXML
    MenuItem saveButton;

    private double lineX1;
    private double lineY1;

     /**
     *The text field is assigned to a string "Particle trace" which describes which tool is currently selected.
     * <br>
     * All other mouse-event assignments are cleared to prevent multiple tools from running simultaneously.
     * <br>
     * A ‘mousedragged’ event is created which reads the brush size and position of the mouse,
     *<br>
     * it then fills an oval with the selected colour and draws it at the mouse position of size "double size".
     */
    private String username;
    
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

    /**
     * The text field is assigned to a string "Line" which describes which tool is currently selected.
     * <br>
     * All other mouse-event assignments are cleared to prevent multiple tools from running simultaneously.
     *<br>
     * 'Mouse click’ and ‘mouse released’ events are created, which read the brush size and position
     * <br>
     * of the mouse (on click and on release), it then strokes a line with the selected colour
     * <br>
     * and draws it at the mouse position of width "double size".
     */
    
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

    /**
     *The text field is assigned to a string "Eraser" which describes which tool
     * <br>
     * is currently selected. All other mouse-event assignments are cleared to
     * <br>
     * prevent multiple tools from running simultaneously.
     * <br>
     * A ‘mousedragged’ event is created which reads the brush size and position of the mouse,
     * <br>
     * it then fills a clear rectangle and draws it at the mouse position of size "double size".
     */
    
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

    /**
     * Uses the build in library "ImageIO" to write a snapshot of the canvas
     * <br>
     * to a ‘png’ file and saves it in the same file path as the source file.
     */
    public void save() {
        // TODO Avatar id gen
            this.avatar = canvas.snapshot(null, null);

        File directory = new File("./src/tawelib/images/avatar" + this.username);
        try {
            this.avatar = canvas.snapshot(null, null);
            ImageIO.write(SwingFXUtils.fromFXImage(this.avatar, null), "png",
                    directory);

        } catch (Exception e) {
            System.out.println("Failed to save: " + e);
        }

    }

    public void setUsername(String username){
        this.username =username;
    }
}
