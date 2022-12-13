package openassu.management.model;


public class User {
	private Long idUser;
	private String 	prenom;
	private String 	nom;
	private String email;
	private String password;
	private String categorie;
	private String telephone;
	
	protected User() {
		
	}

	public User(long idUser, String prenom, String nom, String email, String password, String categorie,
			String telephone) {
		super();
		this.idUser = idUser;
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.categorie = categorie;
		this.telephone = telephone;
	}

	public User(String prenom, String nom, String email, String password, String categorie, String telephone) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.email = email;
		this.password = password;
		this.categorie = categorie;
		this.telephone = telephone;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	
	
}
