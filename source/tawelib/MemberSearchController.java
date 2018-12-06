package tawelib;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

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
    private Button button_memberSearch;

    @FXML
    private TableView<?> memberSearch_result;

    @FXML
    private TableColumn<?, ?> memberSearch_usernameResult;

    @FXML
    private TableColumn<?, ?> memberSearch_firstNameResult;

    @FXML
    private TableColumn<?, ?> memberSearch_lastNameResult;

    @FXML
    private TableColumn<?, ?> memberSearch_addressResult;

    @FXML
    private TableColumn<?, ?> memberSearch_contactNumberResult;

    @FXML
    private TableColumn<?, ?> memberSearch_employmentDateResult;

    @FXML
    private TableColumn<?, ?> memberSearch_staffNumberResult;

    @FXML
    private TextField memberSearch_search;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
