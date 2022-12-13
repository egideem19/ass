package openassu.management.model;

import java.time.LocalDate;

public class Client {
	private Long clientID;
	private String nationalID;
	private String medicalID;
	private String nom;
	private String prenom;
	private String pays;
	private String province;
	private String ville;
	private String quartier;
	private String territoire;
	private String groupement;
	private LocalDate dateNaissance;
	private String lieuNaissance;
	private String genre;
	private String etatCivil;
	private String typeAssurance;
	private String nomAssureur;
	private LocalDate dateDebut;
	private LocalDate dateFin;
		
	
	public Client(long clientID, String nationalID, String medicalID, String nom, String prenom, String pays,
			String province, String ville, String quartier, String territoire, String groupement,
			LocalDate dateNaissance, String lieuNaissance, String genre, String etatCivil, String typeAssurance,
			String nomAssureur, LocalDate dateDebut, LocalDate dateFin) {
		super();
		this.clientID = clientID;
		this.nationalID = nationalID;
		this.medicalID = medicalID;
		this.nom = nom;
		this.prenom = prenom;
		this.pays = pays;
		this.province = province;
		this.ville = ville;
		this.quartier = quartier;
		this.territoire = territoire;
		this.groupement = groupement;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.genre = genre;
		this.etatCivil = etatCivil;
		this.typeAssurance = typeAssurance;
		this.nomAssureur = nomAssureur;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	
	
	
	public Client(String nationalID, String medicalID, String nom, String prenom, String pays, String province,
			String ville, String quartier, String territoire, String groupement, LocalDate dateNaissance,
			String lieuNaissance, String genre, String etatCivil, String typeAssurance, String nomAssureur,
			LocalDate dateDebut, LocalDate dateFin) {
		super();
		this.nationalID = nationalID;
		this.medicalID = medicalID;
		this.nom = nom;
		this.prenom = prenom;
		this.pays = pays;
		this.province = province;
		this.ville = ville;
		this.quartier = quartier;
		this.territoire = territoire;
		this.groupement = groupement;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.genre = genre;
		this.etatCivil = etatCivil;
		this.typeAssurance = typeAssurance;
		this.nomAssureur = nomAssureur;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}



	public Long getClientID() {
		return clientID;
	}
	public void setClientID(Long clientID) {
		this.clientID = clientID;
	}
	public String getNationalID() {
		return nationalID;
	}
	public void setNationalID(String nationalID) {
		this.nationalID = nationalID;
	}
	public String getMedicalID() {
		return medicalID;
	}
	public void setMedicalID(String medicalID) {
		this.medicalID = medicalID;
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
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getQuartier() {
		return quartier;
	}
	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}
	public String getTerritoire() {
		return territoire;
	}
	public void setTerritoire(String territoire) {
		this.territoire = territoire;
	}
	public String getGroupement() {
		return groupement;
	}
	public void setGroupement(String groupement) {
		this.groupement = groupement;
	}
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getLieuNaissance() {
		return lieuNaissance;
	}
	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getEtatCivil() {
		return etatCivil;
	}
	public void setEtatCivil(String etatCivil) {
		this.etatCivil = etatCivil;
	}
	public String getTypeAssurance() {
		return typeAssurance;
	}
	public void setTypeAssurance(String typeAssurance) {
		this.typeAssurance = typeAssurance;
	}
	public String getNomAssureur() {
		return nomAssureur;
	}
	public void setNomAssureur(String nomAssureur) {
		this.nomAssureur = nomAssureur;
	}
	public LocalDate getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}
	public LocalDate getDateFin() {
		return dateFin;
	}
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}
	
	
	

}
