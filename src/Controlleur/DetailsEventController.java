/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;


import Entite.Comment;
import Entite.events;
import Entite.participer;
import Service.CommentaireService;
import Service.EvenementService;
import Service.ParticiperService;
import Test.MainFX;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author selmi
 */
public class DetailsEventController implements Initializable {

    @FXML
    private AnchorPane details;
    @FXML
    private ImageView photo;
    @FXML
    private Label descriptionD;
    @FXML
    private Label categorieD;
    @FXML
    private Label nomD;
    @FXML
    private Label quantiteD;
    @FXML
    private Label prixD;
    @FXML
    private Label referenceD;
    events pdetails = new events();
    @FXML
    private ScrollPane x;
    @FXML
    private VBox msget;
        VBox content2 = new VBox();

    @FXML
    private AnchorPane id_anch;
    @FXML
    private TextArea text_comment;
    @FXML
    private Button id_ajout_Comment;
    @FXML
    private AnchorPane id_send;
    @FXML
    private TextArea text_comment1;
    @FXML
    private Button id_comment_modif;
    @FXML
    private Button id_annuler;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
        
        text_comment.setPromptText("écrire votre commentaire ici ...");
        try {
            afficher_liste_commentaires();
        } catch (SQLException ex) {
            Logger.getLogger(DetailsEventController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }    
  public void setproduit(events p) {
        this.pdetails = p;
    }
   public static Comment getCommentaire_à_modifier() {
        return commentaire_à_modifier;
    }

    public static void setCommentaire_à_modifier(Comment commentaire_à_modifier) {
        DetailsEventController.commentaire_à_modifier = commentaire_à_modifier;
    }
   public void init() throws SQLException {
      
 EvenementService sp = new EvenementService();  
        nomD.setText(pdetails.getTitre());
        categorieD.setText(sp.FindNomUsetheme(pdetails.getCategorie()));
        quantiteD.setText(Integer.toString(pdetails.getQuantity()));
        prixD.setText(Integer.toString(pdetails.getPrix()));
        descriptionD.setText(pdetails.getContenu());
        referenceD.setText(pdetails.getLocation());
         putImageViewer(pdetails.getImage());
     
    }
   
     private HBox wrap;
    private VBox wrap1;
   
   Label textField[] = new Label[150000];

    Button button[] = new Button[150000];
    Button button1[] = new Button[150000];

    CommentaireService commentaireService = new CommentaireService();
    EvenementService sujetService = new EvenementService();
    ParticiperService jaimeService = new ParticiperService();
    private static Comment commentaire_à_modifier = new Comment();
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
  
   
   
   
   
   
   
   
   
     public void putImageViewer(String path){
            FileInputStream input = null;
      
        try {
            input = new FileInputStream("C:\\wamp64\\www\\Pi-dev-final\\web\\uploads\\"+path);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AfficgageeventController.class.getName()).log(Level.SEVERE, null, ex);
        }
            Image imageFile = new Image(input);
            photo.setImage(imageFile);
           
            
        try {
            input.close();
        } catch (IOException ex) {
            Logger.getLogger(AfficgageeventController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        } 
     int i = 0;
    int j = 0;
     private void afficher_liste_commentaires() throws SQLException {
        clearContent(content2);

        List<Comment> ff = commentaireService.readAll(pdetails.getId_Event());
        ff.forEach(e -> {
            //  String thrd = e.getContent();
            //thread = Integer.parseInt(thrd);

            textField[i] = new Label();
            button[j] = new Button();
            button1[j] = new Button();
            textField[i].setText(" " + e.getContenu_Commentaire() + " \n" + e.getTemps_Commentaire() + "\n");
            textField[i].setTranslateX(10);
            textField[i].setAlignment(Pos.TOP_LEFT);
            wrap1 = new VBox();
            //  wrap1.setPrefWidth(id_hbox.getPrefWidth() - 80);
            wrap1.setAlignment(Pos.TOP_LEFT);
            wrap1.getChildren().add(textField[i]);
            if (e.getId_User() == MainFX.user.getId_User()) {
                textField[i].setStyle("-fx-text-fill: red;");

                textField[i].setTranslateX(70);
                button[j].setTranslateX(250);
                button[j].setTranslateY(-30);
                button[j].setText("modifier");
                button[j].setStyle("-fx-text-fill: green;");
                button[j].setAlignment(Pos.TOP_LEFT);
                button[j].setOnMouseClicked(UpdateEventHandler(e));
                button1[j].setTranslateX(250);
                button1[j].setTranslateY(-10);
                button1[j].setText("supprimer");
                button1[j].setStyle("-fx-text-fill: red;");
                button1[j].setAlignment(Pos.TOP_LEFT);
                button1[j].setOnMouseClicked(DeleteEventHandler(e));

                wrap1.getChildren().add(button[j]);
                wrap1.getChildren().add(button1[j]);

                j = j + 1;

            }

            // textField[i].setTranslateX(40);
            wrap = new HBox();
            wrap.setPrefWidth(msget.getPrefWidth() - 80);
            wrap.setAlignment(Pos.TOP_LEFT);

//textField[i].getStyleClass().add("recumsg");
            wrap.getChildren().add(wrap1);
            wrap.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            content2.getChildren().add(wrap);
            content2.setPrefHeight(content2.getPrefHeight() + 88 + textField[i].getPrefHeight() + 88);
            i = i + 1;

            x.setContent(content2);
            x.setVvalue(1.0d);
        });

    }

    @FXML
    void ajoutComment(ActionEvent event) throws SQLException {
        Comment commentaire = new Comment(pdetails.getId_Event(), MainFX.user.getId_User(), text_comment.getText());
        commentaireService.ajouterCommentaire(commentaire);
        text_comment.clear();
        afficher_liste_commentaires();

    }

    private void clearContent(Pane container) {
        container.getChildren().clear();
    }

    private EventHandler<MouseEvent> DeleteEventHandler(Comment commentaire) {
        return event -> {

            commentaireService.supprimerCommentaire(commentaire);

            try {
                afficher_liste_commentaires();
            } catch (SQLException ex) {
                Logger.getLogger(DetailsEventController.class.getName()).log(Level.SEVERE, null, ex);
            }

            Notifications notificationBuilder = Notifications.create()
                    .title("Commentaire Supprimé")
                    .text("Vous avez supprimé votre commentaire")
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_RIGHT);

            notificationBuilder.showError();
        };
    }

    private EventHandler<MouseEvent> UpdateEventHandler(Comment commentaire) {
        return event -> {

            commentaire_à_modifier = commentaire;
            text_comment1.setText(commentaire.getContenu_Commentaire());
            id_anch.setVisible(false);
            id_send.setVisible(true);

        };

    }

    @FXML
    void modifier_commentaire(ActionEvent event) throws SQLException {

        commentaire_à_modifier.setContenu_Commentaire(text_comment1.getText());
        commentaireService.modifierCommentaire(commentaire_à_modifier);
        id_send.setVisible(false);
        id_anch.setVisible(true);

        afficher_liste_commentaires();

    }
    @FXML
 void annuler_modifier_commentaire(ActionEvent event) {
id_send.setVisible(false);
        id_anch.setVisible(true);
    }
    void jaime(ActionEvent event) throws SQLException {
 
    }

    void jaimepas(ActionEvent event) throws SQLException {
 
    }
    
    
    
    
    
    
}
