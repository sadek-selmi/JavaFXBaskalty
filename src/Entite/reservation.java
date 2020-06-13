package Entite;

import java.time.LocalDateTime;

public class reservation {
	
	private int id_reservation ; 
	private String document ; 
	private LocalDateTime datestart ; 
	private LocalDateTime dateend ; 
	private int quantity ; 
	private double price ;
	private int user_id ; 
	private int produit ; 
	private Boolean confirmation ;
	
	
	public reservation(int id_reservation, String document, LocalDateTime datestart, LocalDateTime dateend,
			int quantity, double price, int user_id, int produit, Boolean confirmation) {
		super();
		this.id_reservation = id_reservation;
		this.document = document;
		this.datestart = datestart;
		this.dateend = dateend;
		this.quantity = quantity;
		this.price = price;
		this.user_id = user_id;
		this.produit = produit;
		this.confirmation = confirmation;
	}


	public int getId_reservation() {
		return id_reservation;
	}


	public void setId_reservation(int id_reservation) {
		this.id_reservation = id_reservation;
	}


	public String getDocument() {
		return document;
	}


	public void setDocument(String document) {
		this.document = document;
	}


	public LocalDateTime getDatestart() {
		return datestart;
	}


	public void setDatestart(LocalDateTime datestart) {
		this.datestart = datestart;
	}


	public LocalDateTime getDateend() {
		return dateend;
	}


	public void setDateend(LocalDateTime dateend) {
		this.dateend = dateend;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public int getProduit() {
		return produit;
	}


	public void setProduit(int produit) {
		this.produit = produit;
	}


	public Boolean getConfirmation() {
		return confirmation;
	}


	public void setConfirmation(Boolean confirmation) {
		this.confirmation = confirmation;
	} 
	
	
	
	
	
	
	
}