/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Entite.events;
import Service.EvenementService;
import Test.MainFX;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author selmi
 */
public class MyEventController implements Initializable {
 @FXML
    private AnchorPane box1;
    @FXML
    private ImageView image1;
    @FXML
    private Label nom1;
    @FXML
    private Label categorie1;
    @FXML
    private Label reference1;
    @FXML
    private Label prix1;
    @FXML
    private AnchorPane box2;
    @FXML
    private ImageView image2;
    @FXML
    private Label nom2;
    @FXML
    private Label categorie2;
    @FXML
    private Label reference2;
    @FXML
    private Label prix2;
    @FXML
    private AnchorPane box3;
    @FXML
    private ImageView image3;
    @FXML
    private Label nom3;
    @FXML
    private Label categorie3;
    @FXML
    private Label reference3;
    @FXML
    private Label prix3;
    @FXML
    private AnchorPane box4;
    @FXML
    private ImageView image4;
    @FXML
    private Label nom4;
    @FXML
    private Label categorie4;
    @FXML
    private Label reference4;
    @FXML
    private Label prix4;
    @FXML
    private Pagination paginator;
        EvenementService sp = new EvenementService();
    events p1,p2,p3,p4 = new events();

    List<events> listeproduits = new ArrayList<>();
    @FXML
    private AnchorPane kbir;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EvenementService sp = new EvenementService();
        try {
            listeproduits = sp.FindEventByIdUser(MainFX.user.getId_User());
        } catch (SQLException ex) {
            Logger.getLogger(AfficgageeventController.class.getName()).log(Level.SEVERE, null, ex);
        }

  if (listeproduits.isEmpty()) {
            box1.setVisible(false);
            box2.setVisible(false);
            box3.setVisible(false);
            box4.setVisible(false);
            paginator.setVisible(false);
        } else {
            paginator.setVisible(true);
            //vide.setVisible(false);
            setNbPages();
            try {
                initAnnoncePage(0);
            } catch (IOException ex) {
               System.out.println(ex.getMessage());
            }
        }
  
    }    
    

      private void setNbPages() 
    {

        if (listeproduits.size() % 4 != 0) 
        {
            paginator.setPageCount((listeproduits.size() / 4) + 1);
        } else 
        {
            paginator.setPageCount(listeproduits.size() / 4);
        }

        paginator.currentPageIndexProperty().addListener((obs, oldIndex, newIndex) -> {
            try {
                initAnnoncePage(newIndex.intValue());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        });
    }
        private void initAnnoncePage(int i) throws FileNotFoundException, IOException 
    {

        paginator.setCurrentPageIndex(i);
        List<events> TroisAnnonces = getAnnoncesPage(i);

        if (TroisAnnonces.size() >= 1) 
        {
            p1 = TroisAnnonces.get(0);
            box1.setVisible(true);
             FileInputStream input = null;
           input = new FileInputStream("C:\\wamp64\\www\\Pi-dev-final\\web\\uploads\\"+TroisAnnonces.get(0).getImage());
            Image imageFile = new Image(input);
            image1.setImage(imageFile);
             input.close();
           image1.setImage(imageFile);
            categorie1.setText(TroisAnnonces.get(0).getCategorie());
            nom1.setText(TroisAnnonces.get(0).getTitre());
            prix1.setText(Integer.toString((int) TroisAnnonces.get(0).getPrix()) + "DT");
            reference1.setText(TroisAnnonces.get(0).getLocation());
        } 
        else 
        {
            box1.setVisible(false);
        }

        if (TroisAnnonces.size() >= 2) 
        {
            box2.setVisible(true);

           p2= TroisAnnonces.get(1);
             FileInputStream input = null;
           input = new FileInputStream("C:\\wamp64\\www\\Pi-dev-final\\web\\uploads\\"+TroisAnnonces.get(1).getImage());
            Image imageFile = new Image(input);
            image2.setImage(imageFile);
             input.close();
           image2.setImage(imageFile);
            categorie2.setText(TroisAnnonces.get(1).getCategorie());
            nom2.setText(TroisAnnonces.get(1).getTitre());
            prix2.setText(Integer.toString((int) TroisAnnonces.get(1).getPrix()) + "DT");
            reference2.setText(TroisAnnonces.get(1).getLocation());
          

        } else {
            box2.setVisible(false);
        }

        if (TroisAnnonces.size() >= 3) 
        {
           
            box3.setVisible(true);
           p3 = TroisAnnonces.get(2);
            categorie3.setText(TroisAnnonces.get(2).getCategorie());
             FileInputStream input = null;
           input = new FileInputStream("C:\\wamp64\\www\\Pi-dev-final\\web\\uploads\\"+TroisAnnonces.get(2).getImage());
            Image imageFile = new Image(input);
            image3.setImage(imageFile);
             input.close();
           image3.setImage(imageFile);
            
            nom3.setText(TroisAnnonces.get(2).getTitre());
            prix3.setText(Integer.toString((int) TroisAnnonces.get(2).getPrix()) + "DT");
            reference3.setText(TroisAnnonces.get(2).getLocation());
          
          
        } 
        else 
        {
            box3.setVisible(false);
        }

        if (TroisAnnonces.size() >= 4) 
        {
         
            box4.setVisible(true);
            p4 = TroisAnnonces.get(3);
            categorie4.setText(TroisAnnonces.get(3).getCategorie());
             FileInputStream input = null;
           input = new FileInputStream("C:\\wamp64\\www\\Pi-dev-final\\web\\uploads\\"+TroisAnnonces.get(3).getImage());
            Image imageFile = new Image(input);
            image4.setImage(imageFile);
             input.close();
           image4.setImage(imageFile);
            nom4.setText(TroisAnnonces.get(3).getTitre());
            prix4.setText(Integer.toString((int) TroisAnnonces.get(3).getPrix()) + "DT");
            reference4.setText(TroisAnnonces.get(3).getLocation());
   

        } else 
        {
            box4.setVisible(false);
        }
    }
         private List<events> getAnnoncesPage(int i) 
    {
        int start = 4* i;
        int fin = start + 4;
        if (listeproduits.size() > start) 
        {
            if (listeproduits.size() > fin) 
            {
                return listeproduits.subList(start, fin);
            } else 
            {
                return listeproduits.subList(start, listeproduits.size());
            }
        }
        return listeproduits.subList(0, 2);
    }

   
  
 
    
    
    
    
    @FXML
     private void details0(ActionEvent event) throws IOException, SQLException {
        FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/FXML/ModifierEvenement.fxml"));
        Parent p = Loader.load();
        ModifierEvenementController cont = Loader.getController();
        cont.setproduit(p1);
        cont.init();

        AnchorPane pane = (AnchorPane) image1.getParent().getParent().getParent();
        pane.getChildren().clear();
        pane.getChildren().setAll(p);

    }

    @FXML
    private void details1(ActionEvent event) throws SQLException
    {
        try {
            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/FXML/ModifierEvenement.fxml"));
            
            
            Parent  par = Loader.load();
            
            
            ModifierEvenementController cont = Loader.getController();
            cont.setproduit(p2);
            cont.init();
            
            AnchorPane pane = (AnchorPane) image2.getParent().getParent().getParent();
            pane.getChildren().clear();
            pane.getChildren().setAll(par);
        } catch (IOException ex) {
            Logger.getLogger(AfficgageeventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void details3(ActionEvent event) throws SQLException {
        
        try {
            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/FXML/ModifierEvenement.fxml"));
            
            
            Parent  par = Loader.load();
            
            
            ModifierEvenementController cont = Loader.getController();
            cont.setproduit(p3);
            cont.init();
            
            AnchorPane pane = (AnchorPane) image3.getParent().getParent().getParent();
            pane.getChildren().clear();
            pane.getChildren().setAll(par);
        } catch (IOException ex) {
            Logger.getLogger(AfficgageeventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void details14(ActionEvent event) throws SQLException {
        
         try {
            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/FXML/ModifierEvenement.fxml"));
            
            
            Parent  par = Loader.load();
            
            
            ModifierEvenementController cont = Loader.getController();
            cont.setproduit(p4);
            cont.init();
            
            AnchorPane pane = (AnchorPane) image4.getParent().getParent().getParent();
            pane.getChildren().clear();
            pane.getChildren().setAll(par);
        } catch (IOException ex) {
            Logger.getLogger(AfficgageeventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     private static EvenementService sujetService = new EvenementService();
     private static events evenement_modifié = new events();

    public static events getSujet_modifié() {
        return evenement_modifié;
    }

    public static void setSujet_modifié(events sujet_modifié) {
        MyEventController.evenement_modifié = sujet_modifié;
    }

    @FXML
    private void Sup1(MouseEvent event) throws IOException {
                          sp.supprimerEvent(p1.getId_Event());

          AnchorPane  gererMesProduits  = FXMLLoader.load(getClass().getResource("/FXML/MyEventAffichage.fxml"));
           Node node = (Node)  gererMesProduits ;
           kbir.getChildren().clear();
           kbir.getChildren().add((Node)  gererMesProduits );
           FadeTransition ft = new FadeTransition(Duration.millis(1500));
           ft.setNode( gererMesProduits );
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    @FXML
    private void Sup2(MouseEvent event) throws IOException {
        System.err.println(""+p2.getId_User()+"evelltlt"+p2.getId_Event());
                          sp.supprimerEvent(p2.getId_Event());

          AnchorPane  gererMesProduits  = FXMLLoader.load(getClass().getResource("/FXML/MyEventAffichage.fxml"));
           Node node = (Node)  gererMesProduits ;
           kbir.getChildren().clear();
           kbir.getChildren().add((Node)  gererMesProduits );
           FadeTransition ft = new FadeTransition(Duration.millis(1500));
           ft.setNode( gererMesProduits );
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    @FXML
    private void Sup3(MouseEvent event) throws IOException {
          System.err.println(""+p2.getId_User()+"evelltlt"+p2.getId_Event());
                          sp.supprimerEvent(p3.getId_Event());

          AnchorPane  gererMesProduits  = FXMLLoader.load(getClass().getResource("/FXML/MyEventAffichage.fxml"));
           Node node = (Node)  gererMesProduits ;
           kbir.getChildren().clear();
           kbir.getChildren().add((Node)  gererMesProduits );
           FadeTransition ft = new FadeTransition(Duration.millis(1500));
           ft.setNode( gererMesProduits );
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    @FXML
    private void Sup4(MouseEvent event) throws IOException {
          System.err.println(""+p2.getId_User()+"evelltlt"+p2.getId_Event());
                          sp.supprimerEvent(p4.getId_Event());

          AnchorPane  gererMesProduits  = FXMLLoader.load(getClass().getResource("/FXML/MyEventAffichage.fxml"));
           Node node = (Node)  gererMesProduits ;
           kbir.getChildren().clear();
           kbir.getChildren().add((Node)  gererMesProduits );
           FadeTransition ft = new FadeTransition(Duration.millis(1500));
           ft.setNode( gererMesProduits );
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }
    
}
