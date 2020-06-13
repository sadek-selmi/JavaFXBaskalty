/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.*;
import java.time.LocalDateTime;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 *
 * @author 
 */
public class events {
    
     private int Id_Event;
    private int Id_User;
    private String Titre;
    private String Contenu;
    private int nbre_vues;
    private int Participernumber;
    private int Interstednumber;
    private int commenternumber;
    private String location;

    private LocalDateTime start;
    private String image;
    private ImageView imag;
    private Timestamp ENDDD;
    private Timestamp startTT;

    private LocalDateTime end;
    private int prix;
    private int quantity;
    private String categorie;
    private Date debut; 
    private Date Fin ;

    public events() {
    }

    public events(int Id_Event, String Titre, String Contenu, int Participernumber, int Interstednumber, int commenternumber, String location, String image, int prix, int quantity, String categorie, Date debut, Date Fin,Timestamp start,  Timestamp end) {
        this.Id_Event = Id_Event;
        this.Titre = Titre;
        this.Contenu = Contenu;
        this.Participernumber = Participernumber;
        this.Interstednumber = Interstednumber;
        this.commenternumber = commenternumber;
        this.location = location;
        this.image = image;
        this.prix = prix;
        this.quantity = quantity;
        this.categorie = categorie;
        this.debut = debut;
        this.Fin = Fin;
        this.ENDDD=start;
        this.startTT=end;
    }

   
    public events(int Id_Event, String Titre, String Contenu, int Participernumber, int Interstednumber, int commenternumber, String location, String image, int prix, int quantity, String categorie, Date debut, Date Fin) {
        this.Id_Event = Id_Event;
        this.Titre = Titre;
        this.Contenu = Contenu;
        this.Participernumber = Participernumber;
        this.Interstednumber = Interstednumber;
        this.commenternumber = commenternumber;
        this.location = location;
        this.image = image;
        this.prix = prix;
        this.quantity = quantity;
        this.categorie = categorie;
        this.debut = debut;
        this.Fin = Fin;
      
    }

    public events( int Id_User, String Titre, String Contenu, String location, LocalDateTime start,  LocalDateTime end,String image, int prix, int quantity, String categorie,int Participernumber, int Interstednumber, int commenternumber) {
        this.Id_User = Id_User;
        this.Titre = Titre;
        this.Contenu = Contenu;
        this.location = location;
        this.start = start;
        this.image = image;
        this.end = end;
        this.prix = prix;
        this.quantity = quantity;
        this.categorie = categorie;
        this.Participernumber = Participernumber;
        this.Interstednumber = Interstednumber;
        this.commenternumber = commenternumber;
    }
public events(int Id_Event, int Id_User, String Titre, String Contenu, String location, LocalDateTime start,  LocalDateTime end,String image, int prix, int quantity, String categorie) {
               this.Id_Event = Id_Event;

    this.Id_User = Id_User;
        this.Titre = Titre;
        this.Contenu = Contenu;
        this.location = location;
        this.start = start;
        this.image = image;
        this.end = end;
        this.prix = prix;
        this.quantity = quantity;
        this.categorie = categorie;
    
    }

    
    public int getId_Event() {
        return Id_Event;
    }

    public void setId_Event(int Id_Event) {
        this.Id_Event = Id_Event;
    }

    public int getId_User() {
        return Id_User;
    }

    public void setId_User(int Id_User) {
        this.Id_User = Id_User;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String Titre) {
        this.Titre = Titre;
    }

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String Contenu) {
        this.Contenu = Contenu;
    }

    public int getNbre_vues() {
        return nbre_vues;
    }

    public void setNbre_vues(int nbre_vues) {
        this.nbre_vues = nbre_vues;
    }

    public int getParticipernumber() {
        return Participernumber;
    }

    public void setParticipernumber(int Participernumber) {
        this.Participernumber = Participernumber;
    }

    public int getInterstednumber() {
        return Interstednumber;
    }

    public void setInterstednumber(int Interstednumber) {
        this.Interstednumber = Interstednumber;
    }

    public int getCommenternumber() {
        return commenternumber;
    }

    public void setCommenternumber(int commenternumber) {
        this.commenternumber = commenternumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ImageView getImag() {
        return imag;
    }

    public void setImag(ImageView imag) {
        this.imag = imag;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "events{" + "Id_Event=" + Id_Event + ", Id_User=" + Id_User + ", Titre=" + Titre + ", Contenu=" + Contenu + ", nbre_vues=" + nbre_vues + ", Participernumber=" + Participernumber + ", Interstednumber=" + Interstednumber + ", commenternumber=" + commenternumber + ", location=" + location + ", start=" + start + ", image=" + image + ", imag=" + imag + ", ENDDD=" + ENDDD + ", startTT=" + startTT + ", end=" + end + ", prix=" + prix + ", quantity=" + quantity + ", categorie=" + categorie + ", debut=" + debut + ", Fin=" + Fin + '}';
    }

   

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return Fin;
    }

    public void setFin(Date Fin) {
        this.Fin = Fin;
    }

    public Timestamp getENDDD() {
        return ENDDD;
    }

    public void setENDDD(Timestamp ENDDD) {
        this.ENDDD = ENDDD;
    }

    public Timestamp getStartTT() {
        return startTT;
    }

    public void setStartTT(Timestamp startTT) {
        this.startTT = startTT;
    }

   
   

    
    

}
