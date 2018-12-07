package tawelib;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;

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
    private Button memberSearchButton;

    @FXML
    private TextField memberSearchQuery;

    @FXML
    ListView<String> memberDetailsResults = new ListView<String>();

    @FXML
    void selectMemberResult(ActionEvent event) {

        ObservableList<String> data = FXCollections.observableArrayList(
                "chocolate", "salmon", "gold", "coral", "darkorchid",
                "darkgoldenrod", "lightsalmon", "black", "rosybrown", "blue",
                "blueviolet", "brown");

        final Label label = new Label();
        memberDetailsResults.setItems(data);

        memberDetailsResults.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> list) {
                return new ColorRectCell();
            }
        });

        memberDetailsResults.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<String>() {
                    public void changed(ObservableValue<? extends String> ov,
                                        String old_val, String new_val) {
                        label.setText(new_val);
                        label.setTextFill(Color.web(new_val));
                    }
                });
    }
    static class ColorRectCell extends ListCell<String> {
        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            Rectangle rect = new Rectangle(100, 20);
            if (item != null) {
                rect.setFill(Color.web(item));
                setGraphic(rect);
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
