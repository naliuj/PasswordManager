/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager;

import java.net.URL;
import java.util.ArrayList;
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
    private Entry entry;
    
    @FXML private GridPane gridPane;
    @FXML private TextField titleField;
    @FXML private TextField usernameField;
    @FXML private TextField passwordField;
    @FXML private Button saveButton;
    @FXML private Button cancelButton;
    
    public void setSafe(Safe safe) {
        this.safe = safe;
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    public void setEntry(Entry entry) {
        this.entry = entry;
        initEntry();
    }
    
    private void initEntry() {
        if (entry == null) {
            entry = new Entry();
            safe.addEntry(entry);
        } else {
            titleField.setText(entry.getTitle());
            usernameField.setText(entry.getUsername());
            passwordField.setText(entry.getPassword());
        }
    }
    
    @FXML
    private void saveEntryButtonClick(ActionEvent event) {
        entry.setTitle(titleField.getText());
        entry.setUsername(usernameField.getText());
        entry.setPassword(passwordField.getText());
        ArrayList<Entry> e = safe.getAllEntries();
        e.forEach((entry) -> {
            System.out.println(entry.toString());
        });
        stage.close();
    }
    
    @FXML
    private void cancelEntryButtonClick(ActionEvent event) {
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
}
