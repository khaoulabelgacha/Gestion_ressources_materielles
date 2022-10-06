package com.ocprojet.bean;

public class Panne {
	private int id_p;
	private String type;
	private int etat;
	private String explication;
	private String date;
	private String frequence;
	private String id_emp;
	private String code_ressource;
	private String constat;
	private String decision;
	
	
	public String getConstat() {
		return constat;
	}
	public void setConstat(String constat) {
		this.constat = constat;
	}
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	public int getId_p() {
		return id_p;
	}
	public void setId_p(int id_p) {
		this.id_p = id_p;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCode_ressource() {
		return code_ressource;
	}
	public void setCode_ressource(String code_ressource) {
		this.code_ressource = code_ressource;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	public String getExplication() {
		return explication;
	}
	public void setExplication(String explication) {
		this.explication = explication;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getFrequence() {
		return frequence;
	}
	public void setFrequence(String frequence) {
		this.frequence = frequence;
	}
	public String getId_emp() {
		return id_emp;
	}
	public void setId_emp(String id_emp) {
		this.id_emp = id_emp;
	}
	

}
