/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Entite.events;
import Entite.produit;
import Service.EvenementService;
import Test.MainFX;
import com.jfoenix.controls.JFXTextField;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.Slider;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.MessagingException;

/**
 * FXML Controller class
 *
 * @author selmi
 */
public class AfficgageeventController implements Initializable {

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
    events p1, p2, p3, p4 = new events();

    List<events> listeproduits = new ArrayList<>();
    @FXML
    private Label P1;
    @FXML
    private Label I1;
    @FXML
    private Label P2;
    @FXML
    private Label I2;
    @FXML
    private Label P4;
    @FXML
    private Label I4;
    @FXML
    private Label P3;
    @FXML
    private Label I3;
    @FXML
    private AnchorPane kbir;
    @FXML
    private Button partiper;
    @FXML
    private Button partipcer2;
    @FXML
    private Button partocer3;
    @FXML
    private Button partiocper4;
    @FXML
    private Label dateee;
    @FXML
    private Label dateeee;
    @FXML
    private Label dateeeee;
    @FXML
    private Label dateeeeee;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EvenementService sp = new EvenementService();
        try {
            listeproduits = sp.readAllS();
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

    @FXML
    private void details0(ActionEvent event) throws IOException, SQLException {
        FXMLLoader Loader = new FXMLLoader();
        Loader.setLocation(getClass().getResource("/FXML/DetailsEvenement.fxml"));
        Parent p = Loader.load();
        DetailsEventController cont = Loader.getController();
        cont.setproduit(p1);
        cont.init();

        AnchorPane pane = (AnchorPane) image1.getParent().getParent().getParent();
        pane.getChildren().clear();
        pane.getChildren().setAll(p);

    }

    @FXML
    private void details1(ActionEvent event) throws SQLException {
        try {
            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/FXML/DetailsEvenement.fxml"));

            Parent par = Loader.load();

            DetailsEventController cont = Loader.getController();
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
            Loader.setLocation(getClass().getResource("/FXML/DetailsEvenement.fxml"));

            Parent par = Loader.load();

            DetailsEventController cont = Loader.getController();
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
            Loader.setLocation(getClass().getResource("/FXML/DetailsEvenement.fxml"));

            Parent par = Loader.load();

            DetailsEventController cont = Loader.getController();
            cont.setproduit(p4);
            cont.init();

            AnchorPane pane = (AnchorPane) image4.getParent().getParent().getParent();
            pane.getChildren().clear();
            pane.getChildren().setAll(par);
        } catch (IOException ex) {
            Logger.getLogger(AfficgageeventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setNbPages() {

        if (listeproduits.size() % 4 != 0) {
            paginator.setPageCount((listeproduits.size() / 4) + 1);
        } else {
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

    private void initAnnoncePage(int i) throws FileNotFoundException, IOException {

        paginator.setCurrentPageIndex(i);
        List<events> TroisAnnonces = getAnnoncesPage(i);

        if (TroisAnnonces.size() >= 1) {
            p1 = TroisAnnonces.get(0);
            box1.setVisible(true);
            FileInputStream input = null;
            input = new FileInputStream("C:\\wamp64\\www\\Pi-dev-final\\web\\uploads\\" + TroisAnnonces.get(0).getImage());
            Image imageFile = new Image(input);
            image1.setImage(imageFile);
            input.close();
            image1.setImage(imageFile);
            if (TroisAnnonces.get(0).getQuantity() == 0) {
                categorie1.setText("Unavailable");
            } else {
                categorie1.setText(Integer.toString((int) TroisAnnonces.get(0).getQuantity()));
            }
            P1.setText(Integer.toString((int) TroisAnnonces.get(0).getParticipernumber()));
            I1.setText(Integer.toString((int) TroisAnnonces.get(0).getInterstednumber()));
            prix1.setText(Integer.toString((int) TroisAnnonces.get(0).getPrix()) + "DT");
            //    System.out.println("eeeeee"+TroisAnnonces.get(0).getDebut().getMonth());
  Date date = new Date();

            Timestamp ts = new Timestamp(date.getTime());
           
           
            if(  ts.before(TroisAnnonces.get(0).getDebut()) ){
            dateee.setText(TroisAnnonces.get(0).getDebut().toString().substring(8, 10) + "/" + TroisAnnonces.get(0).getDebut().toString().substring(6, 7));
      
            }else {
            
             dateee.setText("Expired");
            
            }            nom1.setText(TroisAnnonces.get(0).getTitre());
            reference1.setText(TroisAnnonces.get(0).getLocation());
           
        } else {
            box1.setVisible(false);
        }

        if (TroisAnnonces.size() >= 2) {
            box2.setVisible(true);

            p2 = TroisAnnonces.get(1);
            FileInputStream input = null;
            input = new FileInputStream("C:\\wamp64\\www\\Pi-dev-final\\web\\uploads\\" + TroisAnnonces.get(1).getImage());
            Image imageFile = new Image(input);
            image2.setImage(imageFile);
            input.close();
            image2.setImage(imageFile);
 if (TroisAnnonces.get(1).getQuantity() == 0) {
                categorie2.setText("Unavailable");
            } else {
                categorie2.setText(Integer.toString((int) TroisAnnonces.get(1).getQuantity()));
            }            nom2.setText(TroisAnnonces.get(1).getTitre());
            P2.setText(Integer.toString((int) TroisAnnonces.get(1).getParticipernumber()));
            I2.setText(Integer.toString((int) TroisAnnonces.get(1).getInterstednumber()));
  Date date = new Date();

            Timestamp ts = new Timestamp(date.getTime());
           
           
            if(  ts.before(TroisAnnonces.get(1).getDebut()) ){
            dateeee.setText(TroisAnnonces.get(1).getDebut().toString().substring(8, 10) + "/" + TroisAnnonces.get(1).getDebut().toString().substring(6, 7));
      
            }else {
            
             dateeee.setText("Expired");
            
            }
            prix2.setText(Integer.toString((int) TroisAnnonces.get(1).getPrix()) + "DT");
            reference2.setText(TroisAnnonces.get(1).getLocation());
           

        } else {
            box2.setVisible(false);
        }

        if (TroisAnnonces.size() >= 3) {

            box3.setVisible(true);
            p3 = TroisAnnonces.get(2);
 if (TroisAnnonces.get(2).getQuantity() == 0) {
                categorie3.setText("Unavailable");
            } else {
                categorie3.setText(Integer.toString((int) TroisAnnonces.get(2).getQuantity()));
            }            FileInputStream input = null;
            input = new FileInputStream("C:\\wamp64\\www\\Pi-dev-final\\web\\uploads\\" + TroisAnnonces.get(2).getImage());
            Image imageFile = new Image(input);
            image3.setImage(imageFile);
            input.close();
            image3.setImage(imageFile);
            P3.setText(Integer.toString((int) TroisAnnonces.get(2).getParticipernumber()));
            I3.setText(Integer.toString((int) TroisAnnonces.get(2).getInterstednumber()));
            prix3.setText(Integer.toString((int) TroisAnnonces.get(2).getPrix()) + "DT");
          Date date = new Date();

            Timestamp ts = new Timestamp(date.getTime());
           
           
            if(  ts.before(TroisAnnonces.get(2).getDebut()) ){
            dateeeee.setText(TroisAnnonces.get(2).getDebut().toString().substring(8, 10) + "/" + TroisAnnonces.get(2).getDebut().toString().substring(6, 7));
      
            }else {
            
             dateeeee.setText("Expired");
            
            }
            System.out.println("daaaa"+"eeee"+ts+"eeee"+ts.toString().substring(8, 10));
            nom3.setText(TroisAnnonces.get(2).getTitre());
            reference3.setText(TroisAnnonces.get(2).getLocation());
          

        } else {
            box3.setVisible(false);
        }

        if (TroisAnnonces.size() >= 4) {

            box4.setVisible(true);
            p4 = TroisAnnonces.get(3);
 if (TroisAnnonces.get(3).getQuantity() == 0) {
                categorie4.setText("Unavailable");
            } else {
                categorie4.setText(Integer.toString((int) TroisAnnonces.get(3).getQuantity()));
            }            FileInputStream input = null;
            input = new FileInputStream("C:\\wamp64\\www\\Pi-dev-final\\web\\uploads\\" + TroisAnnonces.get(3).getImage());
            Image imageFile = new Image(input);
            image4.setImage(imageFile);
            input.close();
            image4.setImage(imageFile);
            nom4.setText(TroisAnnonces.get(3).getTitre());
            P4.setText(Integer.toString((int) TroisAnnonces.get(3).getParticipernumber()));
            I4.setText(Integer.toString((int) TroisAnnonces.get(3).getInterstednumber()));
            prix4.setText(Integer.toString((int) TroisAnnonces.get(3).getPrix()) + "DT");
            reference4.setText(TroisAnnonces.get(3).getLocation());
  Date date = new Date();

            Timestamp ts = new Timestamp(date.getTime());
           
           
            if(  ts.before(TroisAnnonces.get(3).getDebut()) ){
            dateeeeee.setText(TroisAnnonces.get(3).getDebut().toString().substring(8, 10) + "/" + TroisAnnonces.get(3).getDebut().toString().substring(6, 7));
      
            }else {
            
             dateeeeee.setText("Expired");
            
            }           

        } else {
            box4.setVisible(false);
        }
    }

    private List<events> getAnnoncesPage(int i) {
        int start = 4 * i;
        int fin = start + 4;
        if (listeproduits.size() > start) {
            if (listeproduits.size() > fin) {
                return listeproduits.subList(start, fin);
            } else {
                return listeproduits.subList(start, listeproduits.size());
            }
        }
        return listeproduits.subList(0, 2);
    }

    @FXML
    private void intersed(ActionEvent event) throws SQLException, IOException {

        EvenementService sp = new EvenementService();
        if (sp.FindIntersed(MainFX.user.getId_User(), p1.getId_Event()) == 0) {

            sp.compterintersted(p1);
            sp.ajouterInterd(MainFX.user.getId_User(), p1.getId_Event());
            BoxBlur blur = new BoxBlur(3, 3, 3);
            box1.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Interested");
            alert.setHeaderText("Success");
            alert.setContentText("");
            alert.showAndWait();
            box1.setEffect(null);
            AnchorPane ddd = FXMLLoader.load(getClass().getResource("/FXML/EvenementAffichage.fxml"));
            kbir.getChildren().clear();
            kbir.getChildren().add((Node) ddd);
        } else {
            sp.supprimerInterd(p1.getId_Event());
            sp.compterinterstedpas(p1);
            BoxBlur blur = new BoxBlur(3, 3, 3);
            box1.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Interested");
            alert.setHeaderText("canceled");
            alert.setContentText("");
            alert.showAndWait();
            box1.setEffect(null);
            AnchorPane ddd = FXMLLoader.load(getClass().getResource("/FXML/EvenementAffichage.fxml"));
            kbir.getChildren().clear();
            kbir.getChildren().add((Node) ddd);

        }
    }

    @FXML
    private void participer(ActionEvent event) throws SQLException, MessagingException, IOException {
        EvenementService sp = new EvenementService();
        
        if(p1.getQuantity()!=0){
        
        if (sp.FindParticiper(MainFX.user.getId_User(), p1.getId_Event()) == 0) {
            sp.compterParticiper(MainFX.user.getId_User(), p1.getId_Event());
            BoxBlur blur = new BoxBlur(3, 3, 3);

            kbir.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Participate");
            alert.setHeaderText("You joined to the event");
            alert.setContentText("See mailbox to confirm");
            alert.showAndWait();
            kbir.setEffect(null);
            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/FXML/ConfirmationtEvenement.fxml"));
            Parent p = Loader.load();
            ConfiEvenementController cont = Loader.getController();
            cont.setproduit(p1);
            cont.init();
            AnchorPane pane = (AnchorPane) image1.getParent().getParent().getParent();
            pane.getChildren().clear();
            pane.getChildren().setAll(p);

        } else if (sp.validerParticiper(MainFX.user.getId_User(), p1.getId_Event()) == 0) {

            BoxBlur blur = new BoxBlur(3, 3, 3);

            kbir.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Participate");
            alert.setHeaderText("You joined to the event");
            alert.setContentText("but not confirmed ");
            alert.showAndWait();
            kbir.setEffect(null);
            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/FXML/ConfirmationtEvenement.fxml"));
            Parent p = Loader.load();
            ConfiEvenementController cont = Loader.getController();
            cont.setproduit(p1);
            cont.init();
            AnchorPane pane = (AnchorPane) image1.getParent().getParent().getParent();
            pane.getChildren().clear();
            pane.getChildren().setAll(p);

        } else if (sp.validerParticiper(MainFX.user.getId_User(), p1.getId_Event()) != 0) {

            BoxBlur blur = new BoxBlur(3, 3, 3);

            kbir.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Participate");
            alert.setHeaderText("You joined to the event");
            alert.setContentText("confirmed");
            alert.showAndWait();
            kbir.setEffect(null);

        }
        }else {
        
        
        BoxBlur blur = new BoxBlur(3, 3, 3);

            kbir.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("FUll");
            alert.setHeaderText("Unavailable Tikcket");
            alert.setContentText("Thanx ");
            alert.showAndWait();
            kbir.setEffect(null);

        
        
        
        
        
        
        
        }
    }

    @FXML
    private void intersed1(ActionEvent event) throws SQLException, IOException {
        EvenementService sp = new EvenementService();
        if (sp.FindIntersed(MainFX.user.getId_User(), p2.getId_Event()) == 0) {

            sp.compterintersted(p2);
            sp.ajouterInterd(MainFX.user.getId_User(), p2.getId_Event());

            BoxBlur blur = new BoxBlur(3, 3, 3);
            box1.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Interested");
            alert.setHeaderText("Success");
            alert.setContentText("");
            alert.showAndWait();
            box1.setEffect(null);
            AnchorPane ddd = FXMLLoader.load(getClass().getResource("/FXML/EvenementAffichage.fxml"));
            kbir.getChildren().clear();
            kbir.getChildren().add((Node) ddd);

        } else {
            sp.supprimerInterd(p2.getId_Event());
            sp.compterinterstedpas(p2);
            BoxBlur blur = new BoxBlur(3, 3, 3);
            box1.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Interested");
            alert.setHeaderText("canceled");
            alert.setContentText("");
            alert.showAndWait();
            box1.setEffect(null);
            AnchorPane ddd = FXMLLoader.load(getClass().getResource("/FXML/EvenementAffichage.fxml"));
            kbir.getChildren().clear();
            kbir.getChildren().add((Node) ddd);

        }
    }

    @FXML
    private void participer1(ActionEvent event) throws SQLException, IOException, MessagingException {
        EvenementService sp = new EvenementService();
       
        
         if(p2.getQuantity()!=0){
        
        
        if (sp.FindParticiper(MainFX.user.getId_User(), p2.getId_Event()) == 0) {
            sp.compterParticiper(MainFX.user.getId_User(), p2.getId_Event());
            BoxBlur blur = new BoxBlur(3, 3, 3);

            kbir.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Participate");
            alert.setHeaderText("You joined to the event");
            alert.setContentText("See mailbox to confirm");
            alert.showAndWait();
            kbir.setEffect(null);
            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/FXML/ConfirmationtEvenement.fxml"));
            Parent p = Loader.load();
            ConfiEvenementController cont = Loader.getController();
            cont.setproduit(p2);
            cont.init();
            AnchorPane pane = (AnchorPane) image2.getParent().getParent().getParent();
            pane.getChildren().clear();
            pane.getChildren().setAll(p);

        } else if (sp.validerParticiper(MainFX.user.getId_User(), p2.getId_Event()) == 0) {

            BoxBlur blur = new BoxBlur(3, 3, 3);

            kbir.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Participate");
            alert.setHeaderText("You joined to the event");
            alert.setContentText("but not confirmed ");
            alert.showAndWait();
            kbir.setEffect(null);
            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/FXML/ConfirmationtEvenement.fxml"));
            Parent p = Loader.load();
            ConfiEvenementController cont = Loader.getController();
            cont.setproduit(p2);
            cont.init();
            AnchorPane pane = (AnchorPane) image2.getParent().getParent().getParent();
            pane.getChildren().clear();
            pane.getChildren().setAll(p);

        } else if (sp.validerParticiper(MainFX.user.getId_User(), p2.getId_Event()) != 0) {

            BoxBlur blur = new BoxBlur(3, 3, 3);

            kbir.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Participate");
            alert.setHeaderText("You joined to the event");
            alert.setContentText("confirmed");
            alert.showAndWait();
            kbir.setEffect(null);

        }}else {
        
        
        BoxBlur blur = new BoxBlur(3, 3, 3);

            kbir.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("FUll");
            alert.setHeaderText("Unavailable Tikcket");
            alert.setContentText("Thanx ");
            alert.showAndWait();
            kbir.setEffect(null);

        
        
        
        
        
        
        
        }

    }

    @FXML
    private void intersed2(ActionEvent event) throws SQLException, IOException {
        EvenementService sp = new EvenementService();
        if (sp.FindIntersed(MainFX.user.getId_User(), p3.getId_Event()) == 0) {

            sp.compterintersted(p3);
            sp.ajouterInterd(MainFX.user.getId_User(), p3.getId_Event());
            BoxBlur blur = new BoxBlur(3, 3, 3);
            box1.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Interested");
            alert.setHeaderText("Success");
            alert.setContentText("");
            alert.showAndWait();
            box1.setEffect(null);
            AnchorPane ddd = FXMLLoader.load(getClass().getResource("/FXML/EvenementAffichage.fxml"));
            kbir.getChildren().clear();
            kbir.getChildren().add((Node) ddd);

        } else {
            sp.supprimerInterd(p3.getId_Event());
            sp.compterinterstedpas(p3);
            BoxBlur blur = new BoxBlur(3, 3, 3);
            box1.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Interested");
            alert.setHeaderText("canceled");
            alert.setContentText("");
            alert.showAndWait();
            box1.setEffect(null);
            AnchorPane ddd = FXMLLoader.load(getClass().getResource("/FXML/EvenementAffichage.fxml"));
            kbir.getChildren().clear();
            kbir.getChildren().add((Node) ddd);

        }
    }

    @FXML
    private void participer2(ActionEvent event) throws IOException, SQLException, MessagingException {
        EvenementService sp = new EvenementService();
     
         if(p3.getQuantity()!=0){
        
        
        if (sp.FindParticiper(MainFX.user.getId_User(), p3.getId_Event()) == 0) {
            sp.compterParticiper(MainFX.user.getId_User(), p3.getId_Event());
            BoxBlur blur = new BoxBlur(3, 3, 3);

            kbir.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Participate");
            alert.setHeaderText("You joined to the event");
            alert.setContentText("See mailbox to confirm");
            alert.showAndWait();
            kbir.setEffect(null);
            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/FXML/ConfirmationtEvenement.fxml"));
            Parent p = Loader.load();
            ConfiEvenementController cont = Loader.getController();
            cont.setproduit(p3);
            cont.init();
            AnchorPane pane = (AnchorPane) image3.getParent().getParent().getParent();
            pane.getChildren().clear();
            pane.getChildren().setAll(p);

        } else if (sp.validerParticiper(MainFX.user.getId_User(), p3.getId_Event()) == 0) {

            BoxBlur blur = new BoxBlur(3, 3, 3);

            kbir.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Participate");
            alert.setHeaderText("You joined to the event");
            alert.setContentText("but not confirmed ");
            alert.showAndWait();
            kbir.setEffect(null);
            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/FXML/ConfirmationtEvenement.fxml"));
            Parent p = Loader.load();
            ConfiEvenementController cont = Loader.getController();
            cont.setproduit(p3);
            cont.init();
            AnchorPane pane = (AnchorPane) image3.getParent().getParent().getParent();
            pane.getChildren().clear();
            pane.getChildren().setAll(p);

        } else if (sp.validerParticiper(MainFX.user.getId_User(), p3.getId_Event()) != 0) {

            BoxBlur blur = new BoxBlur(3, 3, 3);

            kbir.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Participate");
            alert.setHeaderText("You joined to the event");
            alert.setContentText("confirmed");
            alert.showAndWait();
            kbir.setEffect(null);

        }}else {
        
        
        BoxBlur blur = new BoxBlur(3, 3, 3);

            kbir.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("FUll");
            alert.setHeaderText("Unavailable Tikcket");
            alert.setContentText("Thanx ");
            alert.showAndWait();
            kbir.setEffect(null);

        
        
        
        
        
        
        
        }

    }

    @FXML
    private void intersed3(ActionEvent event) throws SQLException, IOException {
        EvenementService sp = new EvenementService();
        if (sp.FindIntersed(MainFX.user.getId_User(), p4.getId_Event()) == 0) {

            sp.compterintersted(p4);
            sp.ajouterInterd(MainFX.user.getId_User(), p4.getId_Event());
            BoxBlur blur = new BoxBlur(3, 3, 3);
            box1.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Interested");
            alert.setHeaderText("Success");
            alert.setContentText("");
            alert.showAndWait();
            box1.setEffect(null);
            AnchorPane ddd = FXMLLoader.load(getClass().getResource("/FXML/EvenementAffichage.fxml"));
            kbir.getChildren().clear();
            kbir.getChildren().add((Node) ddd);
        } else {
            sp.supprimerInterd(p4.getId_Event());
            sp.compterinterstedpas(p4);
            BoxBlur blur = new BoxBlur(3, 3, 3);
            box1.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Interested");
            alert.setHeaderText("canceled");
            alert.setContentText("");
            alert.showAndWait();
            box1.setEffect(null);
            AnchorPane ddd = FXMLLoader.load(getClass().getResource("/FXML/EvenementAffichage.fxml"));
            kbir.getChildren().clear();
            kbir.getChildren().add((Node) ddd);

        }
    }

    @FXML
    private void participer3(ActionEvent event) throws IOException, SQLException, MessagingException {
        EvenementService sp = new EvenementService();
         if(p4.getQuantity()!=0){
        
        
        if (sp.FindParticiper(MainFX.user.getId_User(), p4.getId_Event()) == 0) {
            sp.compterParticiper(MainFX.user.getId_User(), p4.getId_Event());
            BoxBlur blur = new BoxBlur(3, 3, 3);

            kbir.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Participate");
            alert.setHeaderText("You joined to the event");
            alert.setContentText("See mailbox to confirm");
            alert.showAndWait();
            kbir.setEffect(null);
            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/FXML/ConfirmationtEvenement.fxml"));
            Parent p = Loader.load();
            ConfiEvenementController cont = Loader.getController();
            cont.setproduit(p4);
            cont.init();
            AnchorPane pane = (AnchorPane) image4.getParent().getParent().getParent();
            pane.getChildren().clear();
            pane.getChildren().setAll(p);

        } else if (sp.validerParticiper(MainFX.user.getId_User(), p4.getId_Event()) == 0) {

            BoxBlur blur = new BoxBlur(3, 3, 3);

            kbir.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Participate");
            alert.setHeaderText("You joined to the event");
            alert.setContentText("but not confirmed ");
            alert.showAndWait();
            kbir.setEffect(null);
            FXMLLoader Loader = new FXMLLoader();
            Loader.setLocation(getClass().getResource("/FXML/ConfirmationtEvenement.fxml"));
            Parent p = Loader.load();
            ConfiEvenementController cont = Loader.getController();
            cont.setproduit(p4);
            cont.init();
            AnchorPane pane = (AnchorPane) image4.getParent().getParent().getParent();
            pane.getChildren().clear();
            pane.getChildren().setAll(p);

        } else if (sp.validerParticiper(MainFX.user.getId_User(), p4.getId_Event()) != 0) {

            BoxBlur blur = new BoxBlur(3, 3, 3);

            kbir.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Participate");
            alert.setHeaderText("You joined to the event");
            alert.setContentText("confirmed");
            alert.showAndWait();
            kbir.setEffect(null);

        } }else {
        
        
        BoxBlur blur = new BoxBlur(3, 3, 3);

            kbir.setEffect(blur);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("FUll");
            alert.setHeaderText("Unavailable Tikcket");
            alert.setContentText("Thanx ");
            alert.showAndWait();
            kbir.setEffect(null);

        
        
        
        
        
        
        
        }

    }

}
