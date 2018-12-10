package tawelib;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class BookResourceInfoController {

    @FXML
    private Pane bookResourceInfo;

    @FXML
    private Text numberOfCopies;

    @FXML
    private Button loanItemButton;

    @FXML
    private Text username;

    @FXML
    private ImageView newBookImage;

    @FXML
    private Text bookTitle;

    @FXML
    private Text bookYear;

    @FXML
    private Text bookAuthor;

    @FXML
    private Text bookPublisher;

    @FXML
    private Text bookLanguage;

    @FXML
    private Text uniqueID;

    @FXML
    void loanItem(ActionEvent event) {

    }

}
