package Entite;


public class RentProd {
	
	private int rentProd_id ; 
	private int user ; 
	private String model ; 
	private int quantity ; 
	private String marke ; 
	private String localisation ; 
	private String reference ; 
	private double price ; 
	private int rentdays ;
	private Boolean dispo ; 
	private String description ;
	private String image ; 
	private double stars ; 
	private int renter ;
	
	
	
	public RentProd(){

	}
	public RentProd(int rentProd_id, int user, String model, int quantity, String marke, String localisation,
					String reference, double price, int rentdays, Boolean dispo, String description, String image, double stars,
					int renter) {
		super();
		this.rentProd_id = rentProd_id;
		this.user = user;
		this.model = model;
		this.quantity = quantity;
		this.marke = marke;
		this.localisation = localisation;
		this.reference = reference;
		this.price = price;
		this.rentdays = rentdays;
		this.dispo = dispo;
		this.description = description;
		this.image = image;
		this.stars = stars;
		this.renter = renter;
	}
	public int getRentProd_id() {
		return rentProd_id;
	}
	public void setRentProd_id(int rentProd_id) {
		this.rentProd_id = rentProd_id;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getMarke() {
		return marke;
	}
	public void setMarke(String marke) {
		this.marke = marke;
	}
	public String getLocalisation() {
		return localisation;
	}
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getRentdays() {
		return rentdays;
	}
	public void setRentdays(int rentdays) {
		this.rentdays = rentdays;
	}
	public Boolean getDispo() {
		return dispo;
	}
	public void setDispo(Boolean dispo) {
		this.dispo = dispo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getStars() {
		return stars;
	}
	public void setStars(double stars) {
		this.stars = stars;
	}
	public int getRenter() {
		return renter;
	}
	public void setRenter(int renter) {
		this.renter = renter;
	} 
	
	
	
	
	
}


