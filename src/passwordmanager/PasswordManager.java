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
    public void start(Stage mainStage) throws Exception {        
        FXMLLoader mainLoader =  new FXMLLoader(getClass().getResource("FXML/MainFXML.fxml"));
        Parent mainRoot = (Parent) mainLoader.load();
        
        Scene mainScene = new Scene(mainRoot);
        
        mainStage.setScene(mainScene);
        mainStage.show();

        Stage loginStage = new Stage();
        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("FXML/LoginFXML.fxml"));
        Parent loginRoot = (Parent) loginLoader.load();
        
        Scene loginScene = new Scene(loginRoot);
        
        loginStage.setScene(loginScene);
        loginStage.initStyle(StageStyle.UTILITY);
        loginStage.initOwner(mainStage);
        loginStage.initModality(Modality.APPLICATION_MODAL);
        loginStage.showAndWait();
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
