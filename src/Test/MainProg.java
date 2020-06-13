/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Test.*;
import Entite.Personne;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author aissa
 */
public class MainProg extends Application{

    /**
     * @param args the command line arguments
     */
    
        public void start(Stage primaryStage) throws Exception {
        
            Parent root = FXMLLoader.load(getClass().getResource("/Fxml/AcceuilForm.fxml"));
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Baskalty");
             //   primaryStage.initStyle(StageStyle.UNDECORATED);

        primaryStage.setScene(scene);
        primaryStage.show();
       primaryStage.setResizable(true);
    }
    
    
    public static void main(String[] args) {
      launch(args);
     }
    
}
