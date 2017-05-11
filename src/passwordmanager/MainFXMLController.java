/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import passwordmanager.safe.Safe;

/**
 * FXML Controller class
 *
 * @author julian
 */
public class MainFXMLController implements Initializable {

    private Safe safe;
    
    private void loadSafe(String path) {
        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            safe = (Safe) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
    }
    
    private void saveSafe() {
        try {
            FileOutputStream fileOut = new FileOutputStream(safe.getPath());
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(safe);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    
    @FXML
    private void newButtonClick(ActionEvent event) {
        throw new UnsupportedOperationException("Not supported yet...");
    }
    
    @FXML
    private void editButtonClick(ActionEvent event) {
        throw new UnsupportedOperationException("Not supported yet...");
    }
    
    @FXML private void deleteButtonClick(ActionEvent event) {
        throw new UnsupportedOperationException("Not supported yet...");
    }
    
    @FXML private void loginButtonClick(ActionEvent event) {
        throw new UnsupportedOperationException("Not supported yet...");
    }

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
