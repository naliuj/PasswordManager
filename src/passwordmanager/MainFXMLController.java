/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import passwordmanager.hash.HashFactory;
import passwordmanager.hash.Hashable;
import passwordmanager.safe.Entry;
import passwordmanager.safe.Safe;
import passwordmanager.safe.Serializer;

/**
 * FXML Controller class
 *
 * @author julian
 */
public class MainFXMLController implements Initializable {
    
    private Safe safe;
    private final Hashable hash = new HashFactory().getHash("dummy");
    private Stage stage;
    private Entry selectedEntry;
    
    @FXML private ListView<Entry> listView;
    @FXML private VBox vBox;
    @FXML private Button deleteButton;
    @FXML private Button editButton;
    
    @FXML
    private void newButtonClick(ActionEvent event) throws IOException {
        showEntryWindow(null);
    }
    
    @FXML
    private void editButtonClick(ActionEvent event) {
        try {
            showEntryWindow(selectedEntry);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    
    @FXML
    private void deleteButtonClick(ActionEvent event) {
        try {
            safe.deleteEntry(selectedEntry);
            Serializer.save(safe);
            populateListView(safe.getAllEntries());
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    
    private void populateListView(ArrayList<Entry> entries) {
        ObservableList<Entry> entryList = FXCollections.observableArrayList();
        entries.forEach((e) -> {
            entryList.add((Entry) e);
        });
        listView.setItems(entryList);
        
        listView.getSelectionModel().selectedItemProperty()
                .addListener((ObservableValue<? extends Entry> observable,
                        Entry oldEntry, Entry newEntry) -> {
                    if (newEntry == null) {
                        deleteButton.setDisable(true);
                        editButton.setDisable(true);
                        selectedEntry = null;
                    } else {
                        deleteButton.setDisable(false);
                        editButton.setDisable(false);
                        selectedEntry = newEntry;
                    }
        });
        
    }
    
    private void showEntryWindow(Entry e) throws IOException {
        Stage entryStage = new Stage();
        FXMLLoader entryLoader = new FXMLLoader(getClass().getResource("FXML/EntryFXML.fxml"));
        Parent entryRoot = (Parent) entryLoader.load();
        
        EntryFXMLController entryController = entryLoader.<EntryFXMLController>getController();
        
        entryController.setSafe(safe);
        entryController.setStage(entryStage);
        entryController.setEntry(e);
        
        Scene entryScene = new Scene(entryRoot);
        
        stage = (Stage) vBox.getScene().getWindow();
        
        entryStage.initOwner(stage);
        entryStage.initModality(Modality.WINDOW_MODAL);
        entryStage.initStyle(StageStyle.UTILITY);
        entryStage.setScene(entryScene);
        entryStage.showAndWait();
        
        Serializer.save(safe);
        
        populateListView(safe.getAllEntries());
    }
    
    public void setSafe(Safe safe) {
        this.safe = safe;
        System.out.println("set the safe");
        populateListView(safe.getAllEntries());
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
        
}
