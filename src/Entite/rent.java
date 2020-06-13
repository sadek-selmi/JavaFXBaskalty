package Entite;

public class rent {
	
	private int id_rent ; 
	private String nom ; 
	private String prenom ; 
	private String localisation ; 
	private int phone ; 
	private String mail ; 
	private String Type ; 
	private int Iduser ;
	
	
	
	
	
	public rent(int id_rent, String nom, String prenom, String localisation, int phone, String mail, String type,
			int iduser) {
		super();
		this.id_rent = id_rent;
		this.nom = nom;
		this.prenom = prenom;
		this.localisation = localisation;
		this.phone = phone;
		this.mail = mail;
		Type = type;
		Iduser = iduser;
		
		
		
	}
	public int getId_rent() {
		return id_rent;
	}
	public void setId_rent(int id_rent) {
		this.id_rent = id_rent;
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
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public int getIduser() {
		return Iduser;
	}
	public void setIduser(int iduser) {
		Iduser = iduser;
	} 
	
	
	
	
	
}