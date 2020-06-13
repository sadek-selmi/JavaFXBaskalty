/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author benha
 */
public class categorie {
    private int id_categorie;
    private String nom;

    public categorie() {
    }

    public categorie(String nom) {
        this.nom = nom;
    }

    public categorie(int id_categorie, String nom) {
        this.id_categorie = id_categorie;
        this.nom = nom;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "categorie{" + "id_categorie=" + id_categorie + ", nom=" + nom + '}';
    }
    
    
    
}
