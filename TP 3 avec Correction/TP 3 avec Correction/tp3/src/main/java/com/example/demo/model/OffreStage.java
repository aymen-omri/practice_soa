package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table
public class OffreStage {
	@Id 
	@GeneratedValue
	long code;
	String intitule;
	String specialite;
	
	@ManyToOne 
	@JoinColumn(name="idSociete", nullable=false)
	Societe societe;
	
	public OffreStage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OffreStage(String intitule, String specialite, Societe societe) {
		super();
		this.intitule = intitule;
		this.specialite = specialite;
		this.societe = societe;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public String getSpecialite() {
		return specialite;
	}
	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	public Societe getSociete() {
		return societe;
	}
	public void setSociete(Societe societe) {
		this.societe = societe;
	}
	
}
