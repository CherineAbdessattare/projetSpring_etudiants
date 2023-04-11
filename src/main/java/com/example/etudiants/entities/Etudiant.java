package com.example.etudiants.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Etudiant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEtudiant;
	private String nom;
	private String prenom;
	private Date dateInscription;
	private String classe;
	private String Email;
	
	
	public Etudiant(String nom, String prenom, Date dateInscription, String classe, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateInscription = dateInscription;
		this.classe = classe;
		Email = email;
	}
	
	public Etudiant() {
		super();
	}
	
	public Long getIdEtudiant() {
		return idEtudiant;
	}
	
	public void setIdEtudiant(Long idEtudiant) {
		this.idEtudiant = idEtudiant;
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
	
	public Date getDateInscription() {
		return dateInscription;
	}
	
	
	public String getClasse() {
		return classe;
	}
	
	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public String toString() {
		return "Etudiant [idEtudiant=" + idEtudiant + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance="
				+ dateInscription + ", classe=" + classe + ", Email=" + Email + "]";
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
		
	}
	

}
