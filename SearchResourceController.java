package tawelib;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static java.util.stream.Collectors.toList;

/**
 * This SearchResourceController Class pairs with the "SearchResource.fxml" file
 *
 *
 * @author Ronalyn Lilyanne
 * @version 1.0
 * @since 04/12/2018
 */

public class SearchResourceController implements Initializable {

    @FXML
    private Pane searchResource;

    @FXML
    private TextField resourceSearchBar;

    @FXML
    private Button resourceSearchButton;

    @FXML
    private TabPane resourcesTable;

    @FXML
    private Tab bookTab;

    @FXML
    private ListView<String> bookResults;

    @FXML
    private Tab dvdTab;

    @FXML
    private ListView<?> dvdResults;

    @FXML
    private Tab laptopTab;

    @FXML
    private ListView<?> laptopResults;

    @FXML
    void searchResourceButton(ActionEvent event) {
//        ObservableList<String> data = FXCollections.observableArrayList(
//                "chocolate", "salmon", "gold", "coral", "darkorchid",
//                "darkgoldenrod", "lightsalmon", "black", "rosybrown", "blue",
//                "blueviolet", "brown");


        ArrayList <tawelib.Book> books;
        books = Conn.searchResource(resourceSearchBar.getText());
        ArrayList<String> bookTitles = new ArrayList<>();

        for (Book b : books) {
            bookTitles.add(b.getTitle());
        }

        ObservableList data = FXCollections.observableArrayList(bookTitles);

        final Label label = new Label();
        bookResults.setItems(data);


        bookResults.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> ov,
                                        String old_val, String new_val) {
                        label.setTextFill(Color.web(new_val));
                    }
                });
    }


    @FXML
    void searchResourcesQuery(ActionEvent event) {

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("ok");

    }
/*
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

*/

    }
