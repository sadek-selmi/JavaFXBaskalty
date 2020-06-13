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
public class Service {
     private int id_service;
    private String nom_service;

    public Service() {
    }

    public Service(int id_service, String nom_service) {
        this.id_service = id_service;
        this.nom_service = nom_service;
    }

    public int getId_service() {
        return id_service;
    }

    @Override
    public String toString() {
        return "Service{" + "id_service=" + id_service + ", nom_service=" + nom_service + '}';
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

    public String getNom_service() {
        return nom_service;
    }

    public void setNom_service(String nom_service) {
        this.nom_service = nom_service;
    }
    
    
}
