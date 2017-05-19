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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author julian
 */
public class PasswordManager extends Application {
    
    
    @Override
    public void start(Stage stage) throws Exception {        
        FXMLLoader loader =  new FXMLLoader(getClass().getResource("FXML/LoginFXML.fxml"));
        Parent root = (Parent) loader.load();
        
        LoginFXMLController controller = loader.<LoginFXMLController>getController();
        controller.setStage(stage);
        
        Scene scene = new Scene(root);
        
        stage.initStyle(StageStyle.UTILITY);
        stage.setScene(scene);
        stage.show();

    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
