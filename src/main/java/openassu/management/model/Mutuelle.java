package openassu.management.model;

import java.time.LocalDate;


/**
 * Todo.java
 * This is a model class represents a Todo entity
 * @author Ramesh Fadatare
 *
 */
public class Mutuelle {

	private Long mutuelleID;
	private String nomMutuelle;
	private String province;
	private String ville;
	private String mutuelleCouvert;
	private LocalDate dateEntre;
	
	
	protected Mutuelle() {
		
	}
	
	public Mutuelle(long mutuelleID, String nomMutuelle, String province, String ville, String mutuelleCouvert, LocalDate dateEntre) {
		super();
		this.mutuelleID = mutuelleID;
		this.nomMutuelle = nomMutuelle;
		this.province = province;
		this.ville = ville;
		this.mutuelleCouvert = mutuelleCouvert;
		this.dateEntre = dateEntre;
	}

	public Mutuelle(String nomMutuelle, String province, String ville, String mutuelleCouvert, LocalDate dateEntre) {
		super();
		this.nomMutuelle = nomMutuelle;
		this.province = province;
		this.ville = ville;
		this.mutuelleCouvert = mutuelleCouvert;
		this.dateEntre = dateEntre;
	}
	
	public Long getMutuelleID() {
		return mutuelleID;
	}

	public void setMutuelleID(Long mutuelleID) {
		this.mutuelleID = mutuelleID;
	}

	public String getNomMutuelle() {
		return nomMutuelle;
	}
	
	public void setNomMutuelle(String nomMutuelle) {
		this.nomMutuelle = nomMutuelle;
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

	

	public String  getMutuelleCouvert() {
		return mutuelleCouvert;
	}

	public void setMutuelleCouvert(String mutuelleCouvert) {
		this.mutuelleCouvert = mutuelleCouvert;
	}
	
	public LocalDate getDateEntre() {
		return dateEntre;
	}

	public void setDateEntre(LocalDate dateEntre) {
		this.dateEntre = dateEntre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (mutuelleID ^ (mutuelleID >>> 32));
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
		Mutuelle other = (Mutuelle) obj;
		if (mutuelleID != other.mutuelleID)
			return false;
		return true;
	}
}
