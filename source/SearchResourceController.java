package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.net.URL;
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
    @FXML private TableColumn<Resources, Integer> bookLoanDurationColumn;
    @FXML private TableColumn<Resources, Integer> bookNumberOfCopies;
    @FXML private TableColumn<Resources, Integer> bookAvailableCopiesColumn;
    @FXML private TableColumn<Resources, Integer> bookBorrowedCopiesColumn;
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
    @FXML private TableColumn<Resources, Integer> dvdLoanDurationColumn;
    @FXML private TableColumn<Resources, Integer> dvdNumberOfCopies;
    @FXML private TableColumn<Resources, Integer> dvdAvailableCopiesColumn;
    @FXML private TableColumn<Resources, Integer> dvdBorrowedCopiesColumn;
    @FXML private TableColumn<DVD, String> dvdDirectorColumn;
    @FXML private TableColumn<DVD, String> dvdRuntimeColumn;
    @FXML private TableColumn<DVD, String> dvdLanguageColumn;
    @FXML private TableColumn<DVD, String> dvdSubtitlesColumn;

    @FXML private TableView<Laptop> laptopTableView;
    @FXML private TableColumn<Resources, Integer> laptopIDColumn;
    @FXML private TableColumn<Resources, String> laptopTitleColumn;
    @FXML private TableColumn<Resources, String> laptopYearColumn;
    @FXML private TableColumn<Resources, String> laptopImageColumn;
    @FXML private TableColumn<Resources, Integer> laptopLoanDurationColumn;
    @FXML private TableColumn<Resources, Integer> laptopNumberOfCopies;
    @FXML private TableColumn<Resources, Integer> laptopAvailableCopiesColumn;
    @FXML private TableColumn<Resources, Integer> laptopBorrowedCopiesColumn;
    @FXML private TableColumn<Laptop, String> laptopManufacturerColumn;
    @FXML private TableColumn<Laptop, String> laptopModelColumn;
    @FXML private TableColumn<Laptop, String> laptopOperatingSystemColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bookIDColumn.setCellValueFactory(new PropertyValueFactory<Resources, Integer>("ID"));
        bookTitleColumn.setCellValueFactory(new PropertyValueFactory<Resources, String>("title"));
        bookYearColumn.setCellValueFactory(new PropertyValueFactory<Resources, Integer>("year"));
        bookImageColumn.setCellValueFactory(new PropertyValueFactory<Resources, String>("thumbnailImageID"));
        bookLoanDurationColumn.setCellValueFactory(new PropertyValueFactory<Resources, Integer>("loanDuration"));
        bookNumberOfCopies.setCellValueFactory(new PropertyValueFactory<Resources, Integer>("numberOfCopies"));
        bookAvailableCopiesColumn.setCellValueFactory(new PropertyValueFactory<Resources, Integer>("availableCopies"));
        bookBorrowedCopiesColumn.setCellValueFactory(new PropertyValueFactory<Resources, Integer>("borrowedCopies"));
        bookAuthorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        bookPublisherColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("publisher"));
        bookGenreColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("genre"));
        bookISBNColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("ISBN"));
        bookLanguageColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("languages"));

        dvdIDColumn.setCellValueFactory(new PropertyValueFactory<Resources, Integer>("ID"));
        dvdTitleColumn.setCellValueFactory(new PropertyValueFactory<Resources, String>("title"));
        dvdYearColumn.setCellValueFactory(new PropertyValueFactory<Resources, String>("year"));
        dvdImageColumn.setCellValueFactory(new PropertyValueFactory<Resources, String>("thumbnailImageID"));
        dvdLoanDurationColumn.setCellValueFactory(new PropertyValueFactory<Resources, Integer>("loanDuration"));
        dvdNumberOfCopies.setCellValueFactory(new PropertyValueFactory<Resources, Integer>("numberOfCopies"));
        dvdAvailableCopiesColumn.setCellValueFactory(new PropertyValueFactory<Resources, Integer>("availableCopies"));
        dvdBorrowedCopiesColumn.setCellValueFactory(new PropertyValueFactory<Resources, Integer>("borrowedCopies"));
        dvdDirectorColumn.setCellValueFactory(new PropertyValueFactory<DVD, String>("director"));
        dvdRuntimeColumn.setCellValueFactory(new PropertyValueFactory<DVD, String>("runtime"));
        dvdLanguageColumn.setCellValueFactory(new PropertyValueFactory<DVD, String>("language"));
        dvdSubtitlesColumn.setCellValueFactory(new PropertyValueFactory<DVD, String>("subtitleLanguages"));

        laptopIDColumn.setCellValueFactory(new PropertyValueFactory<Resources, Integer>("ID"));
        laptopTitleColumn.setCellValueFactory(new PropertyValueFactory<Resources, String>("title"));
        laptopYearColumn.setCellValueFactory(new PropertyValueFactory<Resources, String>("year"));
        laptopImageColumn.setCellValueFactory(new PropertyValueFactory<Resources, String>("thumbnailImageID"));
        laptopLoanDurationColumn.setCellValueFactory(new PropertyValueFactory<Resources, Integer>("loanDuration"));
        laptopNumberOfCopies.setCellValueFactory(new PropertyValueFactory<Resources, Integer>("numberOfCopies"));
        laptopAvailableCopiesColumn.setCellValueFactory(new PropertyValueFactory<Resources, Integer>("availableCopies"));
        laptopBorrowedCopiesColumn.setCellValueFactory(new PropertyValueFactory<Resources, Integer>("borrowedCopies"));
        laptopManufacturerColumn.setCellValueFactory(new PropertyValueFactory<Laptop, String>("manufacturer"));
        laptopModelColumn.setCellValueFactory(new PropertyValueFactory<Laptop, String>("model"));
        laptopOperatingSystemColumn.setCellValueFactory(new PropertyValueFactory<Laptop, String>("operatingSystem"));

        bookTableView.setItems(getBook());
        dvdTableView.setItems(getDVD());
        laptopTableView.setItems(getLaptop());
    }

    public ObservableList<Book> getBook(){
        ObservableList<Book> book = FXCollections.observableArrayList();
        book.add(new Book(100231, "The Alchemist", 2012, "images/TheAlchemist.png",
                14, 20, 15, 5, "Paulo Coelho",
                "Harper Collins", "Adventure", "12345678", "English"));
        book.add(new Book(100232, "Java for Everyone", 2010, "images/JavaForEveryone.png",
                14, 10, 1, 9, "Cay S. Horstmann",
                "John Wiley & Sons", "Education", "0471791911", "English"));
        return book;
    }

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

}
