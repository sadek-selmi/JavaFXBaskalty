/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Entite.Personne;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Cyrine
 */
public class AcceuilUserController implements Initializable {

    @FXML
    private JFXButton vendre;
    @FXML
    private JFXButton evenements;
    @FXML
    private JFXButton maintenance;
    @FXML
    private JFXButton louer;
    @FXML
    private ImageView user;
    @FXML
    private Text bienvenue;

   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
   
    public void setUsername (String user)
    {
        this.bienvenue.setText("Bienvenue,"+user);
    }
    
    private void modiferuser(ActionEvent event) throws IOException {
     
    
    
    }

   @FXML
    private void contact(ActionEvent event) throws IOException {
   
    
    
    }  
    @FXML
    private void mouselogout(MouseEvent event) throws IOException {
 
    
    
    }  

    private void produitsavendre(ActionEvent event) throws IOException {
        
    }

    @FXML
    private void evenements(ActionEvent event) throws IOException {
         evenements.getScene().getWindow().hide();
            Stage produits = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/AccueilEvenement.fxml"));
            Scene scene = new Scene(root);
            produits.setScene(scene);
            produits.show();
            produits.setResizable(false);
    }

    private void maintenance(ActionEvent event) throws IOException {
          maintenance.getScene().getWindow().hide();
            Stage produits = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/FXML/ConfirmationEvenement.fxml"));
            Scene scene = new Scene(root);
            produits.setScene(scene);
            produits.show();
            produits.setResizable(false);
        
    }
    

    private void produitsalouer(ActionEvent event) throws IOException {
 
    }
    

    @FXML
    private void modiferuser(MouseEvent event) throws IOException {
         
    }
    
    
    }