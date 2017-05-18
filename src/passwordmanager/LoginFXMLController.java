/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import passwordmanager.safe.Serializer;

/**
 *
 * @author julian
 */
public class LoginFXMLController implements Initializable {
    
    private Hashable hash = new HashFactory().getHash("dummy");
    private Safe safe;
    private Stage stage;
    private String path = "psafe.safe";
    
    @FXML VBox loginVBox;
    
    @FXML PasswordField passwordPasswordField;
    
    @FXML
    private void loginButtonClick(ActionEvent event) {
        if (hash.check(passwordPasswordField.getText(),
                safe.getPasswordHash())) {
            try {
                showMainDialog();
            } catch (IOException i) {
                i.printStackTrace();
            }
            stage = (Stage) loginVBox.getScene().getWindow();
            stage.close();
        }
    }

    private void showMainDialog() throws IOException {
        Stage mainStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/MainFXML.fxml"));
        Parent root = (Parent) loader.load();
        
        MainFXMLController controller = loader.<MainFXMLController>getController();
        
        controller.setSafe(safe);
        
        Scene scene = new Scene(root);
        
        mainStage.setScene(scene);
        mainStage.show();
        
    }
   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            safe = Serializer.load("safe.psafe");
        } catch (IOException i) {
            safe = new Safe("password", "safe.psafe");
            try {
                Serializer.save(safe);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
    }
    
}