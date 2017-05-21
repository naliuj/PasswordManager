/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import passwordmanager.safe.Safe;
import passwordmanager.safe.Serializer;

/**
 *
 * @author julian
 */
public class NewSafeController implements Initializable {

    private Stage stage;
    
    @FXML private GridPane gridPane;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private Button saveButton;
    
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    @FXML
    private void checkPassword(KeyEvent event) {
        if (passwordField.getText().equals(confirmPasswordField.getText())) {
            saveButton.setDisable(false);
        } else {
            saveButton.setDisable(true);
        }
    }
    
    @FXML
    private void saveButtonClick(ActionEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        fc.setTitle("Save Safe File");
        File file = fc.showSaveDialog(stage);
        Serializer.save(new Safe(passwordField.getText(), file.getPath()));
    }
    
    @FXML private void cancelButtonClick(ActionEvent event) {
        throw new UnsupportedOperationException("Not supported yet");
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("in initialize");
    }
    
}
