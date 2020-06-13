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
public class commande {

    private int id_commande;
    private int id_produit;
    private int id_user;
    private String num_telephone;
    private String ville;
    private String adresse;
    private String instructions_livraisons;
    private float prix_total;

    public commande() {
    }

    @Override
    public String toString() {
        return "commande{" + "id_commande=" + id_commande + ", id_produit=" + id_produit + ", id_user=" + id_user + ", num_telephone=" + num_telephone + ", ville=" + ville + ", adresse=" + adresse + ", instructions_livraisons=" + instructions_livraisons + ", prix_total=" + prix_total + '}';
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNum_telephone() {
        return num_telephone;
    }

    public void setNum_telephone(String num_telephone) {
        this.num_telephone = num_telephone;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getInstructions_livraisons() {
        return instructions_livraisons;
    }

    public void setInstructions_livraisons(String instructions_livraisons) {
        this.instructions_livraisons = instructions_livraisons;
    }

    public float getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(float prix_total) {
        this.prix_total = prix_total;
    }

    public commande(int id_produit, int id_user, String num_telephone, String ville, String adresse, String instructions_livraisons, float prix_total) {
        this.id_produit = id_produit;
        this.id_user = id_user;
        this.num_telephone = num_telephone;
        this.ville = ville;
        this.adresse = adresse;
        this.instructions_livraisons = instructions_livraisons;
        this.prix_total = prix_total;
    }

    public commande(int id_commande, int id_produit, int id_user, String num_telephone, String ville, String adresse, String instructions_livraisons, float prix_total) {
        this.id_commande = id_commande;
        this.id_produit = id_produit;
        this.id_user = id_user;
        this.num_telephone = num_telephone;
        this.ville = ville;
        this.adresse = adresse;
        this.instructions_livraisons = instructions_livraisons;
        this.prix_total = prix_total;
    }

}
