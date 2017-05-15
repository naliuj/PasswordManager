/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import passwordmanager.safe.*;

/**
 *
 * @author julian
 */
public class EntryFXMLController implements Initializable {
    
    private Safe safe;
    private Stage stage;
    
    @FXML private GridPane gridPane;
    @FXML private TextField titleField;
    @FXML private TextField usernameField;
    @FXML private TextField passwordField;
    @FXML private Button saveButton;
    @FXML private Button cancelButton;
    
    public void setSafe(Safe safe) {
        this.safe = safe;
    }
    
    @FXML
    private void saveEntryButtonClick(ActionEvent event) {
        Entry e = new Entry(
                titleField.getText(),
                usernameField.getText(),
                passwordField.getText()
        );
        safe.addEntry(e);
        stage.close();
    }
    
    @FXML
    private void cancelEntryButtonClick(ActionEvent event) {
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stage = (Stage) gridPane.getScene().getWindow();
    }
    
}
