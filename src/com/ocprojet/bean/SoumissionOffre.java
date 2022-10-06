package com.ocprojet.bean;

public class SoumissionOffre {
	int id_soumission;
	String type;
	int qte;
	int prix;
	String id_fournisseur;
	public int getId_soumission() {
		return id_soumission;
	}
	public void setId_soumission(int id_soumission) {
		this.id_soumission = id_soumission;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getId_fournisseur() {
		return id_fournisseur;
	}
	public void setId_fournisseur(String id_fournisseur) {
		this.id_fournisseur = id_fournisseur;
	}
	
	
}
