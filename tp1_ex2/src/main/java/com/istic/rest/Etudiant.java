package com.istic.rest;

public class Etudiant {
	private int id ; 
	private String nom ; 
	private float moyenne; 
	
	public Etudiant() {
		
	}
	
	public Etudiant(int id , String nom , float moyenne) {
		super();
		this.setId(id) ; 
		this.setNom(nom) ; 
		this.setMoyenne(moyenne) ; 
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(float moyenne) {
		this.moyenne = moyenne;
	}

}
