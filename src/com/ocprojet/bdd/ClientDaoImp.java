package com.ocprojet.bdd;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.ocprojet.bean.Besoin;
import com.ocprojet.bean.Offre;
import com.ocprojet.bean.Panne;
import com.ocprojet.bean.SoumissionOffre;

import java.util.ArrayList;
import java.util.List;

public class ClientDaoImp implements ClientDao {
	
	private DaoFactory daoFactory ;
	
	public ClientDaoImp(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void AjouterBesoin(Besoin B) {
		// TODO Auto-generated method stub
		Connection connection = null ;
		Statement statement = null;
		ResultSet resultatt = null;
		ResultSet resultat = null;
		java.sql.PreparedStatement preparedStatement = null ;
		
		try {
			connection = daoFactory.getConnection();
			statement = connection.createStatement();
			resultatt  = statement.executeQuery("SET FOREIGN_KEY_CHECKS=0;");
			preparedStatement =  connection.prepareStatement("INSERT INTO Besoin(type ,Qte ,cin) values( ? , ? , ? );");
			preparedStatement.setString(1, B.getType());
			preparedStatement.setInt(2, B.getQte());
			preparedStatement.setString(3, B.getCin());
			preparedStatement.executeUpdate();
			resultatt  = statement.executeQuery("SET FOREIGN_KEY_CHECKS=1;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		updateOffre(B);
	}

	@Override
	public void AjouterPanne(Panne P) {
		// TODO Auto-generated method stub
		Connection connection = null ;
		Statement statement = null;
		ResultSet resultatt = null;
		ResultSet resultat = null;
		java.sql.PreparedStatement preparedStatement = null ;
		
		try {
			connection = daoFactory.getConnection();
			statement = connection.createStatement();
			resultatt  = statement.executeQuery("SET FOREIGN_KEY_CHECKS=0;");
			preparedStatement =  connection.prepareStatement("INSERT INTO panne(explication ,frequence, type, code_ressource,id_emp ,date ) values( ? ,? , ? , ? , ? , NOW() );");
			preparedStatement.setString(1,P.getExplication());
			preparedStatement.setString(2,P.getFrequence());
			preparedStatement.setString(3,P.getType());
			preparedStatement.setString(4,P.getCode_ressource());
			preparedStatement.setString(5, P.getId_emp());
			preparedStatement.executeUpdate();
			resultatt  = statement.executeQuery("SET FOREIGN_KEY_CHECKS=1;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<String> getListeCodeResource(String id_emp) {
		// TODO Auto-generated method stub
				Connection connection = null;
				Statement statement = null;
				ResultSet resultat = null;
				 List<String> liste = new ArrayList<String>();
				try {
					connection = daoFactory.getConnection();
					statement = connection.createStatement();
					resultat = statement.executeQuery("SELECT * FROM  Ordinateur where etat=1 and id_emp='"+id_emp+"';");
					while(resultat.next()){
						String code  = resultat.getString("code");
						liste.add(code);
					}
					resultat = statement.executeQuery("SELECT * FROM  Imprimante where etat=1 and id_emp='"+id_emp+"';");
					while(resultat.next()){
						String code  = resultat.getString("code");
						liste.add(code);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return liste;				
	}
	@Override
	public void updateOffre(Besoin B) {
		Connection connection = null ;
		java.sql.PreparedStatement preparedStatement = null ;
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement =  connection.prepareStatement("UPDATE offre set Qte = Qte + ? ,date = NOW()  where type = ? ");
			preparedStatement.setInt(1, B.getQte());
			preparedStatement.setString(2, B.getType());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Offre> getListeOfftre() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultat = null;
		 List<Offre> liste = new ArrayList<Offre>();
		try {
			connection = daoFactory.getConnection();
			statement = connection.createStatement();
			resultat = statement.executeQuery("SELECT * FROM  Offre where etat = 0;");
			while(resultat.next()){
				int id_offre  = resultat.getInt("id_offre");
				String type  = resultat.getString("type");
				int Qte5 = resultat.getInt("Qte");
				Date date = resultat.getDate("date");
				Offre O = new Offre();
				O.setId_offre(id_offre);
				O.setQte(Qte5);
				O.setType(type);
				O.setDate(date);
				liste.add(O);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;	
	}
	@Override
	public List<Offre> getListeOfftre2() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultat = null;
		 List<Offre> liste = new ArrayList<Offre>();
		try {
			connection = daoFactory.getConnection();
			statement = connection.createStatement();
			resultat = statement.executeQuery("SELECT * FROM  Offre where etat = 1;");
			while(resultat.next()){
				int id_offre  = resultat.getInt("id_offre");
				String type  = resultat.getString("type");
				int Qte5 = resultat.getInt("Qte");
				Date date = resultat.getDate("date");
				Offre O = new Offre();
				O.setId_offre(id_offre);
				O.setQte(Qte5);
				O.setType(type);
				O.setDate(date);
				liste.add(O);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;	
	}

	@Override
	public Offre getOffreId(int id_offre) {
		Offre o = new Offre();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultat = null;
		try {
			connection = daoFactory.getConnection();
			statement = connection.createStatement();
			resultat = statement.executeQuery("SELECT * FROM Offre where id_offre= "+id_offre+" ;");
			
			while(resultat.next()){
				int id_offree = resultat.getInt("id_offre");
				String type = resultat.getString("type");
				int Qte = resultat.getInt("Qte");
				Date date = resultat.getDate("date");
				
				o.setDate(date);
				o.setId_offre(id_offree);
				o.setQte(Qte);
				o.setType(type);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}

	@Override
	public void ajouterSoumission(Offre o, int prix , String cin) {
		Connection connection = null ;
		Statement statement = null;
		ResultSet resultatt = null;
		ResultSet resultat = null;
		java.sql.PreparedStatement preparedStatement = null ;
		
		try {
			connection = daoFactory.getConnection();
			statement = connection.createStatement();
			preparedStatement =  connection.prepareStatement("INSERT INTO soumissionoffre(type ,Qte ,id_fournisseur,prix) values( ? , ? , ? , ? );");
			preparedStatement.setString(1, o.getType());
			preparedStatement.setInt(2, o.getQte());
			preparedStatement.setString(3, cin);
			preparedStatement.setInt(4, prix);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
	@Override
	public List<SoumissionOffre> getListeSoumission() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultat = null;
		 List<SoumissionOffre> liste = new ArrayList<SoumissionOffre>();
		try {
			connection = daoFactory.getConnection();
			statement = connection.createStatement();
			resultat = statement.executeQuery("SELECT * FROM  soumissionoffre;");
			while(resultat.next()){
				int id_soumission  = resultat.getInt("id_soumission");
				String type  = resultat.getString("type");
				int Qte = resultat.getInt("Qte");
				int prix = resultat.getInt("prix");
				String id_fournisseur = resultat.getString("id_fournisseur");
				SoumissionOffre SO = new SoumissionOffre();
				SO.setId_fournisseur(id_fournisseur);
				SO.setPrix(prix);
				SO.setQte(Qte);
				SO.setType(type);
				SO.setId_soumission(id_soumission);
				liste.add(SO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;	
	}

	@Override
	public void supprimerSoumission(int id) {
		Connection connection = null ;
		java.sql.PreparedStatement preparedStatement = null ;
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement =  connection.prepareStatement("DELETE FROM soumissionoffre where id_soumission = ?;");
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void ajouterMessage(String message, String id_f) {
		// TODO Auto-generated method stub
				Connection connection = null ;
				Statement statement = null;
				ResultSet resultatt = null;
				ResultSet resultat = null;
				java.sql.PreparedStatement preparedStatement = null ;
				
				try {
					connection = daoFactory.getConnection();
					statement = connection.createStatement();
					preparedStatement =  connection.prepareStatement("INSERT INTO message(message , id_fournisseur) values(?,?);");
					preparedStatement.setString(1,message);
					preparedStatement.setString(2,id_f);
					preparedStatement.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	public void ajouterMessage1(String message, String id_f) {
		// TODO Auto-generated method stub
				Connection connection = null ;
				Statement statement = null;
				ResultSet resultatt = null;
				ResultSet resultat = null;
				java.sql.PreparedStatement preparedStatement = null ;
				
				try {
					connection = daoFactory.getConnection();
					statement = connection.createStatement();
					preparedStatement =  connection.prepareStatement("INSERT INTO message(message , id_fournisseur,etat) values(?,?,1);");
					preparedStatement.setString(1,message);
					preparedStatement.setString(2,id_f);
					preparedStatement.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	
}
