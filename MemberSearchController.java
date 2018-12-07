package tawelib;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This MemberSearchController Class pairs with the "MemberSearch.fxml" file
 *
 *
 * @author Ronalyn Lilyanne
 * @version 1.0
 * @since 04/12/2018
 */

public class MemberSearchController implements Initializable {

    @FXML
    private Pane memberSearchPage;

    @FXML
    private ListView<?> booksBorrowedResult;

    @FXML
    private ListView<?> dvdsBorrowedResult;

    @FXML
    private ListView<?> laptopsBorrowedResult;

    @FXML
    private TextField fineBalance;

    @FXML
    private TextField finePayment;

    @FXML
    private Button fineUpdateButton;

    @FXML
    private Button memberSearchButton;

    @FXML
    private TextField memberSearchQuery;

    @FXML
    private ListView<?> memberDetailsResults;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
