package tawelib;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SearchResourceController implements Initializable {

    @FXML
    private Pane resourcesScene;

    @FXML
    private TextField resourceSearchBar;

    @FXML
    private Button resourceSearchButton;

    @FXML
    private TabPane resourcesTable;

    @FXML
    private Tab bookTab;

    @FXML
    private Tab dvdTab;

    @FXML
    private Tab laptopTab;

    @FXML private TableView<Book> bookTableView;
    @FXML private TableColumn<Resources, Integer> bookIDColumn;
    @FXML private TableColumn<Resources, String> bookTitleColumn;
    @FXML private TableColumn<Resources, Integer> bookYearColumn;
    @FXML private TableColumn<Resources, String> bookImageColumn;
    @FXML private TableColumn<Resources, ArrayList<Integer>> bookNumberOfCopies;
    @FXML private TableColumn<Book, String> bookAuthorColumn;
    @FXML private TableColumn<Book, String> bookPublisherColumn;
    @FXML private TableColumn<Book, String> bookGenreColumn;
    @FXML private TableColumn<Book, String> bookISBNColumn;
    @FXML private TableColumn<Book, String> bookLanguageColumn;

    @FXML private TableView<DVD> dvdTableView;
    @FXML private TableColumn<Resources, Integer> dvdIDColumn;
    @FXML private TableColumn<Resources, String> dvdTitleColumn;
    @FXML private TableColumn<Resources, String> dvdYearColumn;
    @FXML private TableColumn<Resources, String> dvdImageColumn;
    @FXML private TableColumn<Resources, Integer> dvdNumberOfCopies;
    @FXML private TableColumn<DVD, String> dvdDirectorColumn;
    @FXML private TableColumn<DVD, String> dvdRuntimeColumn;
    @FXML private TableColumn<DVD, String> dvdLanguageColumn;
    @FXML private TableColumn<DVD, String> dvdSubtitlesColumn;

    @FXML private TableView<Laptop> laptopTableView;
    @FXML private TableColumn<Resources, Integer> laptopIDColumn;
    @FXML private TableColumn<Resources, String> laptopTitleColumn;
    @FXML private TableColumn<Resources, String> laptopYearColumn;
    @FXML private TableColumn<Resources, String> laptopImageColumn;
    @FXML private TableColumn<Resources, Integer> laptopNumberOfCopies;
    @FXML private TableColumn<Laptop, String> laptopManufacturerColumn;
    @FXML private TableColumn<Laptop, String> laptopModelColumn;
    @FXML private TableColumn<Laptop, String> laptopOperatingSystemColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bookIDColumn.setCellValueFactory(new PropertyValueFactory<Resources, Integer>("ID"));
        bookTitleColumn.setCellValueFactory(new PropertyValueFactory<Resources, String>("title"));
        bookYearColumn.setCellValueFactory(new PropertyValueFactory<Resources, Integer>("year"));
        bookImageColumn.setCellValueFactory(new PropertyValueFactory<Resources, String>("thumbnailImageID"));
        bookNumberOfCopies.setCellValueFactory(new PropertyValueFactory<Resources, ArrayList<Integer>>("numberOfCopies"));
        bookAuthorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        bookPublisherColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("publisher"));
        bookGenreColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("genre"));
        bookISBNColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("ISBN"));
        bookLanguageColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("languages"));

        dvdIDColumn.setCellValueFactory(new PropertyValueFactory<Resources, Integer>("ID"));
        dvdTitleColumn.setCellValueFactory(new PropertyValueFactory<Resources, String>("title"));
        dvdYearColumn.setCellValueFactory(new PropertyValueFactory<Resources, String>("year"));
        dvdImageColumn.setCellValueFactory(new PropertyValueFactory<Resources, String>("thumbnailImageID"));
        dvdNumberOfCopies.setCellValueFactory(new PropertyValueFactory<Resources, Integer>("numberOfCopies"));
        dvdDirectorColumn.setCellValueFactory(new PropertyValueFactory<DVD, String>("director"));
        dvdRuntimeColumn.setCellValueFactory(new PropertyValueFactory<DVD, String>("runtime"));
        dvdLanguageColumn.setCellValueFactory(new PropertyValueFactory<DVD, String>("language"));
        dvdSubtitlesColumn.setCellValueFactory(new PropertyValueFactory<DVD, String>("subtitleLanguages"));

        laptopIDColumn.setCellValueFactory(new PropertyValueFactory<Resources, Integer>("ID"));
        laptopTitleColumn.setCellValueFactory(new PropertyValueFactory<Resources, String>("title"));
        laptopYearColumn.setCellValueFactory(new PropertyValueFactory<Resources, String>("year"));
        laptopImageColumn.setCellValueFactory(new PropertyValueFactory<Resources, String>("thumbnailImageID"));
        laptopNumberOfCopies.setCellValueFactory(new PropertyValueFactory<Resources, Integer>("numberOfCopies"));
        laptopManufacturerColumn.setCellValueFactory(new PropertyValueFactory<Laptop, String>("manufacturer"));
        laptopModelColumn.setCellValueFactory(new PropertyValueFactory<Laptop, String>("model"));
        laptopOperatingSystemColumn.setCellValueFactory(new PropertyValueFactory<Laptop, String>("operatingSystem"));

        bookTableView.setItems(getBook());
    }

    
/*
    public ObservableList<DVD> getDVD() {
        ObservableList<DVD> dvd = FXCollections.observableArrayList();
        dvd.add(new DVD(102030, "The Godfather", 1972, "image/TheGodFather.png",
                7, 2, 0, 2, "Francis Ford Copola",
                177, "English", "English, Spanish, French"));
        return dvd;
    }

    public ObservableList<Laptop> getLaptop(){
        ObservableList<Laptop> laptop = FXCollections.observableArrayList();
        laptop.add(new Laptop(102034, "HPadasd", 2018, "asdasd.png", 7,
                20, 18, 2, "HP", "asdasdad",
                "Windows 10"));
        return laptop;
    }
    */

}
