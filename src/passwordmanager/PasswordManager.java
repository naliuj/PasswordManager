/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author julian
 */
public class PasswordManager extends Application {
    
    
    @Override
    public void start(Stage stage) throws Exception {        
        FXMLLoader loader =  new FXMLLoader(getClass().getResource("FXML/MainFXML.fxml"));
        Parent root = (Parent) loader.load();
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();

        Stage stage2 = new Stage();
        FXMLLoader loader2 = new FXMLLoader(getClass().getResource("FXML/LoginFXML.fxml"));
        Parent root2 = (Parent) loader2.load();
        
        Scene scene2 = new Scene(root2);
        
        stage2.setScene(scene2);
        stage2.show();
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
