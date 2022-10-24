package fr.webTest.webTest.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;






@SuppressWarnings("serial")
public class PersonneDto implements Serializable {

	
	private long id;
	
	private String nom;
	
	private String prenom;
	

	private LocalDate DateDeNaissance; 
	
	int version;

	private int AgeActuelle;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public LocalDate getDateDeNaissance() {
		return DateDeNaissance;
	}

	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		DateDeNaissance = dateDeNaissance;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getAgeActuelle() {
		
		LocalDate DateMaintenant = LocalDate.now();
		
		AgeActuelle = Period.between(this.getDateDeNaissance(), DateMaintenant).getYears();
		return AgeActuelle;
	}

	public void setAgeActuelle(int ageActuelle) {
		AgeActuelle = ageActuelle;
	}
	
	
	

	
	

}
