package com.ocprojet.bdd;

import java.util.List;

import com.ocprojet.bean.Besoin;
import com.ocprojet.bean.Panne;



public interface IchefDepartement {
	public List<Besoin> listBesoin();
	public void addBesoin(Besoin b);
	public void addPanne(Panne p);
	public List<String> listRessource(String a);
	public Besoin recupererbesoin(String id_besoin);
	public void ModifierBesoin(int id_besoin);
	public void SupprimerBesoin(int id_besoin);
}
