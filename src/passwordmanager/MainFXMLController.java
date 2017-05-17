/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import passwordmanager.hash.HashFactory;
import passwordmanager.hash.Hashable;
import passwordmanager.safe.Entry;
import passwordmanager.safe.Safe;

/**
 * FXML Controller class
 *
 * @author julian
 */
public class MainFXMLController implements Initializable {
    
    private String path = "safe.psafe";
    private Safe safe;
    private final Hashable hash = new HashFactory().getHash("dummy");
    private Stage stage;
    
    @FXML private ListView<Entry> listView;
    @FXML private VBox vBox;
           
    @FXML
    private void newButtonClick(ActionEvent event) {
    }
    
    @FXML
    private void editButtonClick(ActionEvent event) {
        throw new UnsupportedOperationException("Not supported yet...");
    }
    
    @FXML
    private void deleteButtonClick(ActionEvent event) {
        throw new UnsupportedOperationException("Not supported yet...");
    }
    
    private void populateListView(ArrayList<Entry> entries) {
        ObservableList<Entry> entryList = FXCollections.observableArrayList();
        entries.forEach((e) -> {
            entryList.add((Entry) e);
        });
        listView.setItems(entryList);
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
        System.out.println(safe);
//        populateListView(safe.getAllEntries());
    }
        
}
