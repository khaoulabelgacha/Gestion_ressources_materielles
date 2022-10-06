package com.ocprojet.bean;

public class Besoin {
	private int id_besoin;
	private String type;
	private int Qte;
	private String cin;
	private int etat;
	
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	public int getId_besoin() {
		return id_besoin;
	}
	public void setId_besoin(int id_besoin) {
		this.id_besoin = id_besoin;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQte() {
		return Qte;
	}
	public void setQte(int qte) {
		Qte = qte;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	
	
}
