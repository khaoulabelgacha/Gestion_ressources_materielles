package com.ocprojet.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ocprojet.bean.Panne;



public class DaoPanne {
	/******************************** la connexion a la bd ******************************************/

	private Connection connexion;		
	// fonction pour se connecter a la base de données
	private void base() {
	 		//chargement de driver
	 		try {
	 			Class.forName("com.mysql.jdbc.Driver");
	 		} catch (ClassNotFoundException e) {
	 		}
	 		//connexion a la base de données
	 		try {
	 		connexion = DriverManager.getConnection("jdbc:mysql://localhost/gl_projet","root", "");
	 		System.out.println("connexion etablie");
	 		}catch (SQLException e) {
	 			e.printStackTrace();
	 		}
	 		}
		/******************************* lister panne non traite *******************************************/
		public List<Panne> ListerPannesNonTraite(){ 		  
			List<Panne> pannes = new ArrayList<Panne>();
		      base();
			Statement statement = null;
			ResultSet rs = null;
			try {
				
			    //la creation et l'execution de la requete
				statement = connexion.createStatement();
			    rs = statement.executeQuery("SELECT id_p, date, frequence, type, code_ressource, id_emp from panne where etat='0' order by date;");
			   
			    //recuperation de données
			      while (rs.next()) {
			    	int Id_P= rs.getInt(1);
			        String date = rs.getString(2);
			    	String frequence = rs.getString(3);
			    	String type = rs.getString(4);
			    	String code_ressource = rs.getString(5);
			    	String id_emp= rs.getString(6);
			    	Panne p = new Panne();
			    	p.setId_p(Id_P);p.setDate(date);p.setFrequence(frequence);p.setType(type);p.setCode_ressource(code_ressource);
			    	p.setId_emp(id_emp);
			    	p.setEtat(0);
			    	pannes.add(p);
			         }
			    }catch(SQLException e) {
			    }finally {
			    	//fermeture de la connexion
			    	try {
			    		if(rs !=null)
			    			rs.close();
			    		if(statement !=null)
			    			statement.close();
			    		if(connexion !=null)
			    			connexion.close();
			    		
			    	}catch(SQLException ignore) {
			    	}
			    	}
			    
			
			return pannes;
			
		}
		/******************************* recuperer panne *******************************************/
		public Panne recupererPanne(int id_p) {
			Panne p=new Panne();
		      base();
			Statement statement = null;
			ResultSet rs = null;
			try {
				
			    //la creation et l'execution de la requete
				statement = connexion.createStatement();
			    rs = statement.executeQuery("SELECT * from panne where id_p='"+id_p+"';");
			   
			    //recuperation de données
			      while (rs.next()) {
			    	int Id_P= rs.getInt(1);
			        String explication = rs.getString(2);
			        String date = rs.getString(3);
			    	String frequence = rs.getString(4);
			    	String type = rs.getString(5);
			    	String decision = rs.getString(6);
			    	String id_emp= rs.getString(7);
			    	int etat= rs.getInt(8);
			    	String constat= rs.getString(9);
			    	String code_ressource = rs.getString(10);
			    	p.setId_p(Id_P);p.setExplication(explication);p.setDate(date);
			    	p.setFrequence(frequence);p.setType(type);p.setDecision(decision);
			    	p.setId_emp(id_emp);p.setEtat(etat);p.setConstat(constat);
			    	p.setCode_ressource(code_ressource);
			    	
			    	
			         }
			    }catch(SQLException e) {
			    }finally {
			    	//fermeture de la connexion
			    	try {
			    		if(rs !=null)
			    			rs.close();
			    		if(statement !=null)
			    			statement.close();
			    		if(connexion !=null)
			    			connexion.close();
			    		
			    	}catch(SQLException ignore) {
			    	}
			    	}
			    
			
			return p;
		}
		/******************************* lister panne tout *******************************************/
		public List<Panne> ListerPannes(){ 		  
			List<Panne> pannes = new ArrayList<Panne>();
		      base();
			Statement statement = null;
			ResultSet rs = null;
			try {
				
			    //la creation et l'execution de la requete
				statement = connexion.createStatement();
			    rs = statement.executeQuery("SELECT id_p, date, frequence, type, code_ressource, id_emp from panne order by date;");
			   
			    //recuperation de données
			      while (rs.next()) {
			    	int Id_P= rs.getInt(1);
			        String date = rs.getString(2);
			    	String frequence = rs.getString(3);
			    	String type = rs.getString(4);
			    	String code_ressource = rs.getString(5);
			    	String id_emp= rs.getString(6);
			    	Panne p = new Panne();
			    	p.setId_p(Id_P);p.setDate(date);p.setFrequence(frequence);p.setType(type);p.setCode_ressource(code_ressource);
			    	p.setId_emp(id_emp);
			    	p.setEtat(0);
			    	pannes.add(p);
			         }
			    }catch(SQLException e) {
			    }finally {
			    	//fermeture de la connexion
			    	try {
			    		if(rs !=null)
			    			rs.close();
			    		if(statement !=null)
			    			statement.close();
			    		if(connexion !=null)
			    			connexion.close();
			    		
			    	}catch(SQLException ignore) {
			    	}
			    	}
			    
			
			return pannes;
			
		}
		
		/********************************* modifier panne(modifier constat+ modifier etat***********************************************/
		public void modifier_Constat_etat(int id_p ,  String constat) {
			 base();
			 try {
				 System.out.println("vous etes dans dao modifier "+id_p);
						 
				PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE panne set constat= '"+constat+"', etat='1' where id_p='"+id_p+"'");
				preparedStatement.executeUpdate();
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/******************************* lister panne decide *******************************************/
		public List<Panne> ListerPannesdecide(){ 		  
			List<Panne> pannes = new ArrayList<Panne>();
		      base();
			Statement statement = null;
			ResultSet rs = null;
			try {
				
			    //la creation et l'execution de la requete
				statement = connexion.createStatement();
			    rs = statement.executeQuery("SELECT id_p, date, frequence, type, code_ressource, id_emp, constat, decision from panne where etat='2' order by date;");
			   
			    //recuperation de données
			      while (rs.next()) {
			    	int Id_P= rs.getInt(1);
			        String date = rs.getString(2);
			    	String frequence = rs.getString(3);
			    	String type = rs.getString(4);
			    	String code_ressource = rs.getString(5);
			    	String id_emp= rs.getString(6);
			    	String constat= rs.getString(7);
			    	String decision= rs.getString(8);
			    	Panne p = new Panne();
			    	p.setId_p(Id_P);p.setDate(date);p.setFrequence(frequence);p.setType(type);p.setCode_ressource(code_ressource);
			    	p.setId_emp(id_emp);p.setConstat(constat);p.setDecision(decision);
			    	p.setEtat(2);
			    	pannes.add(p);
			         }
			    }catch(SQLException e) {
			    }finally {
			    	//fermeture de la connexion
			    	try {
			    		if(rs !=null)
			    			rs.close();
			    		if(statement !=null)
			    			statement.close();
			    		if(connexion !=null)
			    			connexion.close();
			    		
			    	}catch(SQLException ignore) {
			    	}
			    	}
			    
			
			return pannes;
			
		}
}
