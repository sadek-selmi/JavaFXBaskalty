/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.models;

/**
 *
 * @author yaya
 */
public class mecanicien {
    
   
     private int id;
    private String service;
    private String nom;
    private String prenom;

    @Override
    public String toString() {
        return "mecanicien{" + "id=" + id + ", service=" + service + ", nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", image=" + image + ", prix=" + prix + ", num_tel=" + num_tel + ", description=" + description + ", adomicile=" + adomicile + '}';
    }

    public mecanicien() {
    }

    public mecanicien(String service, String nom, String prenom, String mail, String image, float prix, int num_tel, String description, String adomicile) {
        this.service = service;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.image = image;
        this.prix = prix;
        this.num_tel = num_tel;
        this.description = description;
        this.adomicile = adomicile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdomicile() {
        return adomicile;
    }

    public void setAdomicile(String adomicile) {
        this.adomicile = adomicile;
    }
    private String mail;
    private String image;
    private float prix;
private int num_tel;
    private String description;
    private String adomicile; 
  }
