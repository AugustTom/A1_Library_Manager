package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ResourcesController  implements Initializable {

    @FXML
    private TextField resources_searchBar;

    @FXML
    private Button button_search;

    @FXML
    private TabPane resource_resultsTable;

    @FXML
    private Tab resource_bookTab;

    @FXML
    private TableView<?> resource_bookResults;

    @FXML
    private TableColumn<?, ?> resource_id;

    @FXML
    private TableColumn<?, ?> resource_title;

    @FXML
    private TableColumn<?, ?> resource_year;

    @FXML
    private TableColumn<?, ?> resource_image;

    @FXML
    private TableColumn<?, ?> resource_loanDuration;

    @FXML
    private TableColumn<?, ?> resource_numberOfCopies;

    @FXML
    private TableColumn<?, ?> resource_author;

    @FXML
    private TableColumn<?, ?> resource_publisher;

    @FXML
    private TableColumn<?, ?> resource_ISBN;

    @FXML
    private TableColumn<?, ?> resource_bookLanguage;

    @FXML
    private Tab resource_DVDTab;

    @FXML
    private TableView<?> resource_DVDResults;

    @FXML
    private TableColumn<?, ?> resource_runtime;

    @FXML
    private TableColumn<?, ?> resource_dvdLanguage;

    @FXML
    private TableColumn<?, ?> resource_subtitleLanguages;

    @FXML
    private Tab resource_LaptopTab;

    @FXML
    private TableColumn<?, ?> resource_manufacturer;

    @FXML
    private TableColumn<?, ?> resource_model;

    @FXML
    private TableColumn<?, ?> resource_operatingSystem;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
