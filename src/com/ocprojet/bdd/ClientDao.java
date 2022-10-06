package com.ocprojet.bdd;

import com.ocprojet.bean.Besoin;
import com.ocprojet.bean.Offre;
import com.ocprojet.bean.Panne;
import com.ocprojet.bean.SoumissionOffre;

import java.util.ArrayList;
import java.util.List;

public interface ClientDao {
	public void AjouterBesoin(Besoin B);
	public void AjouterPanne(Panne P);
	public List<String> getListeCodeResource(String id_emp);
	public void updateOffre(Besoin B);
	public List<Offre> getListeOfftre();
	public List<Offre> getListeOfftre2();
	public Offre getOffreId(int id_offre);
	public void ajouterSoumission(Offre o,int prix , String cin);
	public List<SoumissionOffre> getListeSoumission();
	public void supprimerSoumission(int id);
	public void ajouterMessage(String message, String id_f);
	public void ajouterMessage1(String message, String id_f);
}

