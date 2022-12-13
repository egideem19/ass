package openassu.management.model;

import java.time.LocalDate;


/**
 * Todo.java
 * This is a model class represents a Todo entity
 * @author Ramesh Fadatare
 *
 */
public class Assurance {

	private Long assuranceID;
	private String nomAssureur;
	private String province;
	private String ville;
	private String assuranceCouvert;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	
	
	protected Assurance() {
		
	}
	
	public Assurance(long assuranceID, String nomAssureur, String province, String ville, String assuranceCouvert, LocalDate dateDebut,LocalDate dateFin) {
		super();
		this.assuranceID = assuranceID;
		this.nomAssureur = nomAssureur;
		this.province = province;
		this.ville = ville;
		this.assuranceCouvert = assuranceCouvert;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	public Assurance(String nomAssureur, String province, String ville, String assuranceCouvert, LocalDate dateDebut, LocalDate dateFin) {
		super();
		this.nomAssureur = nomAssureur;
		this.province = province;
		this.ville = ville;
		this.assuranceCouvert = assuranceCouvert;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	
	public Long getAssuranceID() {
		return assuranceID;
	}

	public void setAssuranceID(Long assuranceID) {
		this.assuranceID = assuranceID;
	}

	public String getNomAssureur() {
		return nomAssureur;
	}
	
	public void setNomAssureur(String nomAssureur) {
		this.nomAssureur = nomAssureur;
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

	

	public String  getAssuranceCouvert() {
		return assuranceCouvert;
	}

	public void setAssuranceCouvert(String assuranceCouvert) {
		this.assuranceCouvert = assuranceCouvert;
	}
	
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateEntre(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (assuranceID ^ (assuranceID >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Assurance other = (Assurance) obj;
		if (assuranceID != other.assuranceID)
			return false;
		return true;
	}
}
