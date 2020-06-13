/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.*;

/**
 *
 * @author hp
 */
public class Comment {

    private int id;
    private int id_event;
    private int id_User;
    private String Contenu_Commentaire;
    private String Temps_Commentaire;

    @Override
    public String toString() {
        return "comment{" + "id=" + id + ", id_event=" + id_event + ", id_User=" + id_User + ", Contenu_Commentaire=" + Contenu_Commentaire + ", Temps_Commentaire=" + Temps_Commentaire + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public int getId_User() {
        return id_User;
    }

    public void setId_User(int id_User) {
        this.id_User = id_User;
    }

    public String getContenu_Commentaire() {
        return Contenu_Commentaire;
    }

    public void setContenu_Commentaire(String Contenu_Commentaire) {
        this.Contenu_Commentaire = Contenu_Commentaire;
    }

    public String getTemps_Commentaire() {
        return Temps_Commentaire;
    }

    public void setTemps_Commentaire(String Temps_Commentaire) {
        this.Temps_Commentaire = Temps_Commentaire;
    }

    public Comment() {
    }

    public Comment(int id, int id_User, String Temps_Commentaire, String Contenu_Commentaire, int id_event) {
        this.id = id;
        this.id_event = id_event;
        this.id_User = id_User;
        this.Contenu_Commentaire = Contenu_Commentaire;
        this.Temps_Commentaire = Temps_Commentaire;
    }

    public Comment(int id_event, int id_User, String Contenu_Commentaire) {
        this.id_event = id_event;
        this.id_User = id_User;
        this.Contenu_Commentaire = Contenu_Commentaire;
    }
    public Comment(int id, int id_event, int id_User, String Contenu_Commentaire) {
        this.id = id;
        this.id_event = id_event;
        this.id_User = id_User;
        this.Contenu_Commentaire = Contenu_Commentaire;
    }

    public Comment( int id_User, String Temps_Commentaire,String Contenu_Commentaire,int id_event) {
        this.id_event = id_event;
        this.id_User = id_User;
        this.Contenu_Commentaire = Contenu_Commentaire;
        this.Temps_Commentaire = Temps_Commentaire;
    }
    


    
}

