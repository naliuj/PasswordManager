/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager;

import java.io.File;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
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
    
    @FXML Label filePathLabel;
    @FXML VBox loginVBox;
    
    @FXML PasswordField passwordPasswordField;
    
    @FXML
    private void loginButtonClick(ActionEvent event) {
        if (safe == null) {
            Alert alert = new Alert(AlertType.ERROR, "No safe selected!");
            alert.initOwner(stage);
            alert.showAndWait();
            menuFileLoadClick(event);
        } else {
            if (hash.check(passwordPasswordField.getText(),
                    safe.getPasswordHash())) {
                try {
                    showMainDialog();
                } catch (IOException i) {
                    i.printStackTrace();
                }
                stage.close();
            } else {
                Alert alert = new Alert(AlertType.ERROR, "Incorrect password!");
                alert.initOwner(stage);
                alert.showAndWait();
            }
        }
    }
    
    @FXML
    private void menuFileLoadClick(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Safe File");
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            try {
                String path = file.getPath();
                safe = Serializer.load(path);
                filePathLabel.setText(path);
            } catch (IOException i) {
                i.printStackTrace();
            } catch (ClassNotFoundException c) {
                c.printStackTrace();
            }
        }
    }
    
    @FXML
    private void menuFileNewClick(ActionEvent event) throws IOException {
        Stage newSafeStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/NewSafeFXML.fxml"));
        Parent root = (Parent) loader.load();
        
        NewSafeController controller = loader.<NewSafeController>getController();
        
        controller.setStage(newSafeStage);
        
        Scene scene = new Scene(root);
        
        newSafeStage.initOwner(stage);
        newSafeStage.initModality(Modality.WINDOW_MODAL);
        newSafeStage.setScene(scene);
        newSafeStage.showAndWait();
        
    }
    
    private void showMainDialog() throws IOException {
        Stage mainStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/MainFXML.fxml"));
        Parent root = (Parent) loader.load();
        
        MainFXMLController controller = loader.<MainFXMLController>getController();
        
        controller.setSafe(safe);
        controller.setStage(mainStage);
        controller.initListView();
        
        Scene scene = new Scene(root);
        
        mainStage.setScene(scene);
        mainStage.show();
        
    }
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
}
