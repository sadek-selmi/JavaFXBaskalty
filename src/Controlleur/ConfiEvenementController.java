/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Entite.events;
import Service.EvenementService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author selmi
 */
public class ConfiEvenementController implements Initializable {

    @FXML
    private AnchorPane ajout;
   
    @FXML
    private Label text;
    @FXML
    private TextField CHAMPSS;
    @FXML
    private Button pdf;
    events pdetails = new events();
    @FXML
    private AnchorPane mama;
    @FXML
    private Label nom1;
    @FXML
    private Label pr2;
    @FXML
    private Label pr1;
    @FXML
    private Label pr;
    @FXML
    private Button confff;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
public void init() throws SQLException {
    pdf.setVisible(false);
      mama.setVisible(false);
 EvenementService sp = new EvenementService();  
        nom1.setText(pdetails.getTitre());
        
     sp.FindNomUsetheme(pdetails.getCategorie());
       Integer.toString(pdetails.getQuantity());
        pr.setText(Integer.toString(pdetails.getPrix()));
         pr1.setText(pdetails.getDebut().toString());
         pr2.setText(pdetails.getLocation());
     
    }    
       public void setproduit(events p) {
        this.pdetails = p;
    }
    @FXML
    private void confirmation(ActionEvent event) throws SQLException, IOException {
        EvenementService es = new EvenementService();
       
        if(CHAMPSS.getText().isEmpty() == true)
        {
          BoxBlur blur = new BoxBlur(3, 3, 3);
   
        ajout.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("text");
            alert.setHeaderText("saisi code ");
            alert.setContentText("text vide ");
            alert.showAndWait();
             ajout.setEffect(null);     
        }else
        if(es.chercherchamps(CHAMPSS.getText())==0 ){
        
          BoxBlur blur = new BoxBlur(3, 3, 3);
   
        ajout.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Code");
            alert.setHeaderText("Inncorect ");
            alert.setContentText("Saisie un autre fois ");
            alert.showAndWait();
             ajout.setEffect(null);        
        }else{
             es.compterparticipper(es.chercherchamps(CHAMPSS.getText()));
             es.compterNUMBER(es.chercherchamps(CHAMPSS.getText()));
                  BoxBlur blur = new BoxBlur(3, 3, 3);

        ajout.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Code");
            alert.setHeaderText("Correct ");
            alert.setContentText("Merci pour votre participion ");
            alert.showAndWait();
             ajout.setEffect(null); 
             CHAMPSS.setVisible(false);
             confff.setVisible(false);
            pdf.setVisible(true);
       /*  AnchorPane  gererMesProduits  = FXMLLoader.load(getClass().getResource("/FXML/EvenementAffichage.fxml"));
           Node node = (Node)  gererMesProduits ;
           ajout.getChildren().clear();
           ajout.getChildren().add((Node)  gererMesProduits );
           FadeTransition ft = new FadeTransition(Duration.millis(1500));
           ft.setNode( gererMesProduits );
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();*/
        
        
        
        
        
        
        }
        
        
        
        
        
    }

    @FXML
    private void pdf(ActionEvent event) {
        System.out.println("To Printer!");
         PrinterJob job = PrinterJob.createPrinterJob();
           if(job != null){
    Window primaryStage = null;
           job.showPrintDialog(primaryStage); 
                  mama.setVisible(true);

    Node root = mama;
           job.printPage(root);
           job.endJob();
    }
    } 

    @FXML
    private void retour(MouseEvent event) throws IOException {
        AnchorPane  gererMesProduits  = FXMLLoader.load(getClass().getResource("/FXML/EvenementAffichage.fxml"));
           Node node = (Node)  gererMesProduits ;
           ajout.getChildren().clear();
           ajout.getChildren().add((Node)  gererMesProduits );
           FadeTransition ft = new FadeTransition(Duration.millis(1500));
           ft.setNode( gererMesProduits );
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
        
    }
}
