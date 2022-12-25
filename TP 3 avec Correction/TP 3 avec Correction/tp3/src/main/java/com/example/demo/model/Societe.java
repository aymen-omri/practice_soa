package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Societe {
	@Id 
	@GeneratedValue
	long idSociete;
	String nomCommercial;
	String activite;
	String pays;
	
	public Societe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Societe(String nomCommercial, String activite, String pays) {
		super();
		this.nomCommercial = nomCommercial;
		this.activite = activite;
	}
	public long getIdSociete() {
		return idSociete;
	}
	public void setIdSociete(long idSociete) {
		this.idSociete = idSociete;
	}
	public String getNomCommercial() {
		return nomCommercial;
	}
	public void setNomCommercial(String nomCommercial) {
		this.nomCommercial = nomCommercial;
	}
	public String getActivite() {
		return activite;
	}
	public void setActivite(String activite) {
		this.activite = activite;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
}
