package com.ocprojet.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.ocprojet.bean.Besoin;
import com.ocprojet.bean.Panne;



public class ImpChefDepartement implements IchefDepartement {

	@Override
	public List<Besoin> listBesoin() {

		List<Besoin> Adm = new ArrayList<Besoin>();
		
		Connection conn=SingletonConnection.getConnection();
		try {
			
			  PreparedStatement ps = conn.
			  prepareStatement(" select b.id_besoin,b.type,b.Qte,b.etat, e.nom from Besoin b , employe e where b.cin=e.cin  ");
			 
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Besoin b = new Besoin();
				b.setId_besoin(rs.getInt("id_besoin"));
				b.setType(rs.getString("type"));
				b.setQte(rs.getInt("Qte"));
				 b.setCin(rs.getString("nom"));
				 b.setEtat(rs.getInt("etat"));
				Adm.add(b);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Adm;
	}

	@Override
	public void addBesoin(Besoin b) {

		Connection conn=SingletonConnection.getConnection();
		try {
			
			PreparedStatement pss = conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
			ResultSet rs = pss.executeQuery();
			
			PreparedStatement ps= conn.prepareStatement("INSERT INTO Besoin(type ,Qte ,cin) values( ? , ? , ? );");
			
			ps.setString(1, b.getType());
			ps.setInt(2, b.getQte());
			ps.setString(3,b.getCin());
			ps.executeUpdate();
			
			PreparedStatement psss = conn.prepareStatement("SET FOREIGN_KEY_CHECKS=1;");
			ResultSet rss = psss.executeQuery();
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void addPanne(Panne p) {
		Connection conn=SingletonConnection.getConnection();
		try {
			
			PreparedStatement pss = conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
			ResultSet rs = pss.executeQuery();
			
			PreparedStatement ps= conn.prepareStatement("INSERT INTO panne (explication , date , frequence , type , code_ressource , id_emp  ) values( ? , NOW() , ? , ? , ? , ? );");
			
			ps.setString(1, p.getExplication());
			ps.setString(2,p.getFrequence());
			ps.setString(3,p.getType());
			ps.setString(4,p.getCode_ressource());
			ps.setString(5,p.getId_emp());
			ps.executeUpdate();
			
			PreparedStatement psss = conn.prepareStatement("SET FOREIGN_KEY_CHECKS=1;");
			ResultSet rss = psss.executeQuery();
			
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<String> listRessource(String cin ) {
		
			List<String> Adm = new ArrayList<String>();
			
			Connection conn=SingletonConnection.getConnection();
			try {
			
			  PreparedStatement ps =
			  conn.prepareStatement("  select code from  imprimante   where id_emp='"
			  +cin+"' and etat=1;");
			  
			  ResultSet rs = ps.executeQuery();
			  
			  while(rs.next()) { String b;
			  
			  b = rs.getString("code"); Adm.add(b); }
			 
				PreparedStatement ps1 = conn.prepareStatement("  select code from  ordinateur   where id_emp='"+ cin +"' and etat=1;");
				 
				  ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next()) {
					String b;
					
					b = rs1.getString("code");
					
					Adm.add(b);
				}
				
				ps.close();
				ps1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Adm;
	}
	/**************************************************************************************/
	@Override
	public Besoin recupererbesoin(String id_besoin ) {
		
		Besoin b = new Besoin();
			Connection conn=SingletonConnection.getConnection();
			try {
			

				  PreparedStatement ps = conn.
				  prepareStatement(" select b.id_besoin,b.type,b.Qte,e.nom from Besoin b , employe e where b.id_besoin='"+id_besoin+"';");
				 
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					
					b.setId_besoin(rs.getInt("id_besoin"));
					b.setType(rs.getString("type"));
					b.setQte(rs.getInt("Qte"));
					 b.setCin(rs.getString("nom")); 
					
				}
				
				ps.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return b;
	}
	/*******************************************modiifer**************/
	@Override
	public void ModifierBesoin(int id_besoin) {
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement pss = conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
			ResultSet rs = pss.executeQuery();
			PreparedStatement preparedStatement = conn.prepareStatement("UPDATE besoin set etat= '1' where id_besoin='"+id_besoin+"'");
			preparedStatement.executeUpdate();
			PreparedStatement psss = conn.prepareStatement("SET FOREIGN_KEY_CHECKS=1;");
			ResultSet rss = psss.executeQuery();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	/************************************************supprimer********/
	@Override
	public void SupprimerBesoin(int id_besoin) {
		Connection conn=SingletonConnection.getConnection();
		try {
			PreparedStatement pss = conn.prepareStatement("SET FOREIGN_KEY_CHECKS=0;");
			ResultSet rs = pss.executeQuery();
			PreparedStatement preparedStatement = conn.prepareStatement("DELETE from besoin where id_besoin='"+id_besoin+"'");
			preparedStatement.executeUpdate();
			PreparedStatement psss = conn.prepareStatement("SET FOREIGN_KEY_CHECKS=1;");
			ResultSet rss = psss.executeQuery();
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}
	

}
