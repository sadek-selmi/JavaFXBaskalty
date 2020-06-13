/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;


import static Controlleur.AjoutEvenementController.saveToFileImageNormal;
import Entite.events;
import Entite.theme;
import Service.EvenementService;
import Service.ServiceTheme;
import Test.MainFX;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import org.apache.commons.lang.RandomStringUtils;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author selmi
 */

public class ModifierEvenementController implements Initializable {
public void setproduit(events p) {
        this.pdetails = p;
    }
    events pdetails = new events();

    @FXML
    private AnchorPane ajout;
    @FXML
    private TextField titre;
    @FXML
    private TextField adresse;
    @FXML
    private TextArea prix;
    @FXML
    private TextField place;
    @FXML
    private Button btnimage;
    @FXML
    private JFXDatePicker debut;
    @FXML
    private JFXTimePicker timedebut;
    @FXML
    private JFXTimePicker timefin;
    @FXML
    private JFXDatePicker fin;
    @FXML
    private TextField contenu;
    @FXML
    private ComboBox<String> theme;
    @FXML
    private Label id_verifier_titre;
    @FXML
    private Label id_verifier_adresse;
    @FXML
    private Label d;
    @FXML
    private Label pri;
    @FXML
    private Label p;
    @FXML
    private Label im;
    @FXML
    private ImageView imageV;
   
    /**
     * Initializes the controller class.
     */
        List<theme> liste = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceTheme sc = new ServiceTheme();
        liste = sc.afficher();
 
          liste.forEach((l) -> {
              theme.getItems().add(l.getNom());
           
        });
    }   
     public void init() throws SQLException {
      
 EvenementService sp = new EvenementService();  
        titre.setText(pdetails.getTitre());
        place.setText(Integer.toString(pdetails.getQuantity()));
        prix.setText(Integer.toString(pdetails.getPrix()));
        contenu.setText(pdetails.getContenu());
        theme.setValue(spro.FindNomUsetheme(pdetails.getCategorie()));
        adresse.setText(pdetails.getLocation());
         putImageViewer(pdetails.getImage());
        // debut.setValue( convertToLocalDateViaInstant(pdetails.getDebut()));
           //   fin.setValue( convertToLocalDateViaInstant(pdetails.getFin()));
           debut.setValue(pdetails.getDebut().toLocalDate());
           fin.setValue(pdetails.getFin().toLocalDate());
           timedebut.setValue(LocalTime.now());
           timefin.setValue(LocalTime.now());
    }
     public LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
    return dateToConvert.toInstant()
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
}
public static String saveToFileImageNormal(Image image) throws SQLException, IOException {

        String ext = "jpg";
        File dir = new File("C:\\wamp64\\www\\Pi-dev-final\\web\\uploads\\");
        String name = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(8), ext);
        File outputFile = new File(dir, name);
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        ImageIO.write(bImage, "png", outputFile);
        return name;
    }
     public void putImageViewer(String path){
            FileInputStream input = null;
      
        try {
            input = new FileInputStream("C:\\wamp64\\www\\Pi-dev-final\\web\\uploads\\"+path);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AfficgageeventController.class.getName()).log(Level.SEVERE, null, ex);
        }
            Image imageFile = new Image(input);
            imageV.setImage(imageFile);
           
            
        try {
            input.close();
        } catch (IOException ex) {
            Logger.getLogger(AfficgageeventController.class.getName()).log(Level.SEVERE, null, ex);
        }
          
        } 
                 EvenementService spro = new EvenementService();

   
    @FXML
    private void ajouterEvenement(ActionEvent event) throws SQLException, IOException {
         if ((  verifprix())&&(verifTime())&&
        
       (verifContenu())&&
         
          
       
     
       
     (titre.getText().isEmpty() == false)&&
   
      (verifNumber())&&(verifDatedebut())&&(verifier_adresse())
     
       && (verifDate())
      
                   ){
        
        
           Image img = imageV.getImage();
            String nameImage1 = saveToFileImageNormal(img);
        String tftheme = theme.getValue();
            String tftitre = titre.getText();
            String tfdescription = contenu.getText();
            String tfadresse = adresse.getText();
            String tprix = prix.getText();
            String tquantite = place.getText();
            int tfprix = Integer.parseInt(tprix);
            int tfquantite = Integer.parseInt(tquantite);
                       // Date dd = java.sql.Date.valueOf(debut.getValue().toString());
                         //Date df = java.sql.Date.valueOf(fin.getValue().toString());
int s;
        s=0;
             //   public events( int Id_User, String Titre, String Contenu, String location, Date start,  Date end,String image, int prix, int quantity, theme categorie) {
        //  public events(int Id_Event, String Titre, String Contenu, int Participernumber, int Interstednumber, int commenternumber, String location, String image, int prix, int quantity, String categorie, Date debut, Date Fin) {

            events p = new events(pdetails.getId_Event(),MainFX.user.getId_User(), tftitre, tfdescription, tfadresse,LocalDateTime.of(debut.getValue(), timedebut.getValue()),LocalDateTime.of(fin.getValue(), timefin.getValue()), nameImage1, tfprix, tfquantite,tftheme );
                
           // produit pro = new produit(q, LocalDateTime.now(), n, r, p, d, nameImage1, LocalDateTime.now());
           // pro.setImage(nameImage1);
            EvenementService spro = new EvenementService();
spro.modifierEvent(p) ;
       Image img1 = new Image("/aa.png");
            Notifications notificationBuilder = Notifications.create()
                    .title("Modification")
                    .text("Success")
                    .graphic(new ImageView(img1))
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.TOP_CENTER);

            notificationBuilder.show(); 

place.clear();
            titre.clear();
            adresse.clear();
            prix.clear();
            imageV.setImage(null);
            contenu.clear();

 try {
                AnchorPane newLoadedPane = FXMLLoader.load(getClass().getResource("/FXML/MyEventAffichage.fxml"));

                ajout.getChildren().clear();
                ajout.getChildren().add(newLoadedPane);

            } catch (IOException ex) {
                Logger.getLogger(AjoutEvenementController.class.getName()).log(Level.SEVERE, null, ex);
            }
           

        
        
        
        
        
    }}

    @FXML
    private void RetourEvenement(MouseEvent event) {
    }
     @FXML
    private void verifier_titre(KeyEvent event) {
      if (spro.rechercherparNom(titre.getText())) {
            id_verifier_titre.setText("Titre déja utilisé!");
            id_verifier_titre.setTextFill(Color.RED);
            id_verifier_titre.setVisible(true);
        } else if (titre.getText().isEmpty()) {
            id_verifier_titre.setText("champ vide!");
            id_verifier_titre.setTextFill(Color.RED);
            id_verifier_titre.setVisible(true);
        } else {
            id_verifier_titre.setText("Titre possible!");
            id_verifier_titre.setTextFill(Color.GREEN);
            id_verifier_titre.setVisible(true);

        }
        
    }

    private boolean verifier_adresse() {
        
        
         Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(adresse.getText());
        if (m.find() && m.group().equals(adresse.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validation des champs");
            alert.setHeaderText(null);
            alert.setContentText("Verifier le description de l'event");
            alert.showAndWait();
            return false;
        }
    }

  
   


  private boolean verifContenu() {
        Pattern p = Pattern.compile("[a-zA-Z]+");
        Matcher m = p.matcher(contenu.getText());
        if (m.find() && m.group().equals(contenu.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validation des champs");
            alert.setHeaderText(null);
            alert.setContentText("Verifier le description de l'event");
            alert.showAndWait();
            return false;
        }
    }

    private boolean verifDate() {
       
        if (debut.getValue() != null && fin.getValue() != null) {
          Timestamp dated = Timestamp.valueOf(debut.getValue().atTime(LocalTime.MIDNIGHT));

        Timestamp datef = Timestamp.valueOf(fin.getValue().atTime(LocalTime.MIDNIGHT));
            if (dated.before(datef) || dated.equals(datef)){
            
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validation des champs");
            alert.setHeaderText(null);
            alert.setContentText("date début inférieur à date fin");
            alert.showAndWait();
            return false;
        }}
        return false;
    }
    
     private boolean verifDatedebut() {
       
        if (debut.getValue() != null && fin.getValue() != null) {
          Timestamp dated = Timestamp.valueOf(debut.getValue().atTime(LocalTime.MIDNIGHT));
java.util.Date date = new java.util.Date();
        Timestamp ts = new Timestamp(date.getTime());
            if (ts.before(dated)|| ts.equals(dated)){
            
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validation des champs");
            alert.setHeaderText(null);
            alert.setContentText("date début inférieur à date fin");
            alert.showAndWait();
            return false;
        }}
        return false;
    }
private boolean verifTime() {
        
        if (timedebut.getValue() != null && timefin.getValue() != null) {
          
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validation des champs");
            alert.setHeaderText(null);
            alert.setContentText("Verifier champs time");
            alert.showAndWait();
            return false;
        }
       
    }

    private boolean verifNumber() {
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(place.getText());

        if (m.find() && m.group().equals(place.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validation de nombre de places");
            alert.setHeaderText(null);
            alert.setContentText("Verifier le nombre de places saisis");
            alert.showAndWait();
            return false;
        }
    }

    private boolean verifprix() {
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(prix.getText());

        if (m.find() && m.group().equals(prix.getText())) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Validation de prix");
            alert.setHeaderText(null);
            alert.setContentText("Verifier le prix saisis");
            alert.showAndWait();
            return false;
        }
    }

    @FXML
    private void verifier_prix(KeyEvent event) {
    }

     @FXML
    private void addImage(ActionEvent event) {
            FileChooser fc = new FileChooser();

        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (.png)", "*.PNG");
        fc.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
        File selectedFile = fc.showOpenDialog(null);
        try {
            BufferedImage bufferedImage = ImageIO.read(selectedFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            btnimage.setVisible(false);
            imageV.setImage(image);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
