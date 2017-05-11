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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import passwordmanager.hash.HashFactory;
import passwordmanager.hash.Hashable;
import passwordmanager.safe.Safe;
import passwordmanager.PasswordManager;

/**
 * FXML Controller class
 *
 * @author julian
 */
public class MainFXMLController implements Initializable {
    
    private String path = "safe.psafe";
    private Safe safe;
    private Hashable hash = new HashFactory().getHash("dummy");
    
    @FXML private PasswordField passwordPasswordField;
    @FXML private VBox loginVBox;
        
    private void showMainWindow() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXML/MainFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void loadSafe() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        safe = (Safe) in.readObject();
        in.close();
        fileIn.close();
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
        if (hash.check(passwordPasswordField.getText(),
                safe.getPasswordHash())) {
            try {
                showMainWindow();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            loadSafe();
        } catch (IOException i) {
            safe = new Safe("password");
            safe.save(path);
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
    }    
    
}
