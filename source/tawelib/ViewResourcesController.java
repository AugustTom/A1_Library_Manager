import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewResourcesController implements Initializable {

    @FXML
    private Pane viewResources;

    @FXML
    private TabPane resourcesTable;

    @FXML
    private Tab bookTab;

    @FXML
    private TableView<?> bookTableView;

    @FXML
    private TableColumn<?, ?> bookIDColumn;

    @FXML
    private TableColumn<?, ?> bookTitleColumn;

    @FXML
    private TableColumn<?, ?> bookYearColumn;

    @FXML
    private TableColumn<?, ?> bookImageColumn;

    @FXML
    private TableColumn<?, ?> bookLoanDurationColumn;

    @FXML
    private TableColumn<?, ?> bookNumberOfCopies;

    @FXML
    private TableColumn<?, ?> bookAvailableCopiesColumn;

    @FXML
    private TableColumn<?, ?> bookBorrowedCopiesColumn;

    @FXML
    private TableColumn<?, ?> bookAuthorColumn;

    @FXML
    private TableColumn<?, ?> bookPublisherColumn;

    @FXML
    private TableColumn<?, ?> bookGenreColumn;

    @FXML
    private TableColumn<?, ?> bookISBNColumn;

    @FXML
    private TableColumn<?, ?> bookLanguageColumn;

    @FXML
    private Tab dvdTab;

    @FXML
    private TableView<?> dvdTableView;

    @FXML
    private TableColumn<?, ?> dvdIDColumn;

    @FXML
    private TableColumn<?, ?> dvdTitleColumn;

    @FXML
    private TableColumn<?, ?> dvdYearColumn;

    @FXML
    private TableColumn<?, ?> dvdImageColumn;

    @FXML
    private TableColumn<?, ?> dvdLoanDurationColumn;

    @FXML
    private TableColumn<?, ?> dvdNumberOfCopies;

    @FXML
    private TableColumn<?, ?> dvdAvailableCopiesColumn;

    @FXML
    private TableColumn<?, ?> dvdBorrowedCopiesColumn;

    @FXML
    private TableColumn<?, ?> dvdDirectorColumn;

    @FXML
    private TableColumn<?, ?> dvdRuntimeColumn;

    @FXML
    private TableColumn<?, ?> dvdLanguageColumn;

    @FXML
    private TableColumn<?, ?> dvdSubtitlesColumn;

    @FXML
    private Tab laptopTab;

    @FXML
    private TableView<?> laptopTableView;

    @FXML
    private TableColumn<?, ?> laptopIDColumn;

    @FXML
    private TableColumn<?, ?> laptopTitleColumn;

    @FXML
    private TableColumn<?, ?> laptopYearColumn;

    @FXML
    private TableColumn<?, ?> laptopImageColumn;

    @FXML
    private TableColumn<?, ?> laptopLoanDurationColumn;

    @FXML
    private TableColumn<?, ?> laptopNumberOfCopies;

    @FXML
    private TableColumn<?, ?> laptopAvailableCopiesColumn;

    @FXML
    private TableColumn<?, ?> laptopBorrowedCopiesColumn;

    @FXML
    private TableColumn<?, ?> laptopManufacturerColumn;

    @FXML
    private TableColumn<?, ?> laptopModelColumn;

    @FXML
    private TableColumn<?, ?> laptopOperatingSystemColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

