/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author selmi
 */
public class AccueilEvenementController implements Initializable {

    @FXML
    private AnchorPane holderPane;
    @FXML
    private JFXButton mesProduits;
    @FXML
    private JFXButton btnajouter;
    @FXML
    private JFXButton gererMesProduits;
    @FXML
    private JFXButton contacteznous;
    @FXML
    private ImageView logout;
    @FXML
    private ImageView user;
    @FXML
    private JFXButton Event;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void contactezNous(ActionEvent event) throws IOException {
        AnchorPane  ddd  = FXMLLoader.load(getClass().getResource("/FXML/ConfirmationtEvenement.fxml"));
           Node node = (Node)  ddd ;
           holderPane.getChildren().clear();
           holderPane.getChildren().add((Node)  ddd );
           FadeTransition ft = new FadeTransition(Duration.millis(1500));
           ft.setNode( ddd );
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    @FXML
    private void Logout(MouseEvent event) {
    }

    @FXML
    private void ModifierProfile(MouseEvent event) {
    }

    @FXML
    private void Mesevenement(ActionEvent event) throws IOException {
          AnchorPane  gererMesProduits  = FXMLLoader.load(getClass().getResource("/FXML/MyEventAffichage.fxml"));
           Node node = (Node)  gererMesProduits ;
           holderPane.getChildren().clear();
           holderPane.getChildren().add((Node)  gererMesProduits );
           FadeTransition ft = new FadeTransition(Duration.millis(1500));
           ft.setNode( gererMesProduits );
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    @FXML
    private void ajouterEvenement(ActionEvent event) throws IOException {
        AnchorPane AjouterProduit = FXMLLoader.load(getClass().getResource("/FXML/AjoutEvenement.fxml"));
           Node node = (Node) AjouterProduit;
           holderPane.getChildren().clear();
           holderPane.getChildren().add((Node) AjouterProduit);
           FadeTransition ft = new FadeTransition(Duration.millis(1500));
           ft.setNode(AjouterProduit);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    @FXML
    private void GererEvenement(ActionEvent event) throws IOException {
     AnchorPane  gererMesProdd  = FXMLLoader.load(getClass().getResource("/FXML/s.fxml"));
           Node node = (Node)  gererMesProdd ;
           holderPane.getChildren().clear();
           holderPane.getChildren().add((Node)  gererMesProdd );
           FadeTransition ft = new FadeTransition(Duration.millis(1500));
           ft.setNode( gererMesProdd );
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    
    
    
    
    
    
    }

    @FXML
    private void Evenement(ActionEvent event) throws IOException {
           AnchorPane  gererMesProduits  = FXMLLoader.load(getClass().getResource("/FXML/EvenementAffichage.fxml"));
           Node node = (Node)  gererMesProduits ;
           holderPane.getChildren().clear();
           holderPane.getChildren().add((Node)  gererMesProduits );
           FadeTransition ft = new FadeTransition(Duration.millis(1500));
           ft.setNode( gererMesProduits );
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }
    
}
