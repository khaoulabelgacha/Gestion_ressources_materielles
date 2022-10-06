package com.ocprojet.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ocprojet.bean.Besoin;
import com.ocprojet.bean.Departement;
import com.ocprojet.bean.Employee;
import com.ocprojet.bean.Fournisseur;
import com.ocprojet.bean.Imprimante;
import com.ocprojet.bean.Message;
import com.ocprojet.bean.Ordinateur;
import com.ocprojet.bean.Panne;
import com.ocprojet.bean.User;



public class Dao1 {
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
	/*********************************** connection admin ************************************************/
	public int connexionUser(String username,String pass) {
		base();

  	    Statement statement = null;
		ResultSet rs = null;
		try {
			
		    //la creation et l'execution de la requete
			statement = connexion.createStatement();
			rs = statement.executeQuery("SELECT * from user;");
			while(rs.next()) {
				if(rs.getString(1).equals(username) && rs.getString(4).equals(pass)) {
					if(rs.getInt(2) == 1)
						return 1;
					else if(rs.getInt(2) == 2)
						return 2;
					else if(rs.getInt(2) == 3)
						return 3;
					else if(rs.getInt(2) == 4)
						return 4;
					else if(rs.getInt(2) == 5)
						return 5;
					
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
		return 0;
		
	}
	/*********************************** connection admin ************************************************/
	public User InfoUser(String username,String password) {
		base();

  	    Statement statement = null;
		ResultSet rs = null;
		User  u = new User();
		try {
			
		    //la creation et l'execution de la requete
			statement = connexion.createStatement();
			rs = statement.executeQuery("SELECT * from user where username='"+username+"' and password='"+password+"';");
			while(rs.next()) {
		        String user = rs.getString(1);
		    	int type = rs.getInt(2);
		    	String cin = rs.getString(3);
		    	String pass = rs.getString(4);
		    	u.setUsername(user);u.setType(type);u.setCin(cin);u.setPassword(pass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
		return u;
		
	}
	/******************************* lister Fournisseur *******************************************/
	public List<Fournisseur> ListerFournisseur(){ 		  
		List<Fournisseur> fournisseur = new ArrayList<Fournisseur>();
	      base();
		Statement statement = null;
		ResultSet rs = null;
		try {
		    //la creation et l'execution de la requete
			statement = connexion.createStatement();
		    rs = statement.executeQuery("SELECT * from fournisseur;");
		    //recuperation de données
		      while (rs.next()) {
		        String cin = rs.getString(1);
		    	String nom = rs.getString(2);
		    	String prenom = rs.getString(3);
		    	String email = rs.getString(4);
		    	String telephone = rs.getString(5);
		    	String nomSociete = rs.getString(6);
		    	Fournisseur e = new Fournisseur();
		    	e.setCin(cin);e.setNom(nom);e.setPrenom(prenom);e.setEmail(email);e.setTelephone(telephone);e.setNomSociete(nomSociete);
		    	fournisseur.add(e);
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
		return fournisseur;	
	}
	 /**************************************** ajouter ordinateur ***************************************************/
	public void ajouterOrdinateur(Ordinateur ordi) {
		 base();
		 try {

			PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO ordinateur(code,marque,cpu,ecran,disque_dur,ram,duree_garantie,id_f) values(?,?,?,?,?,?,?,?)");
			preparedStatement.setString(1, ordi.getCode());
			preparedStatement.setString(2, ordi.getMarque());
			preparedStatement.setString(3, ordi.getCpu());
			preparedStatement.setString(4, ordi.getEcran());
			preparedStatement.setString(5, ordi.getDisqueDur());
			preparedStatement.setString(6, ordi.getRam());
			preparedStatement.setString(7, ordi.getDureeGarantie());
			preparedStatement.setString(8, ordi.getIdF());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	 /**************************************** ajouter imprimante ***************************************************/
	public void ajouterImprimante(Imprimante impr) {
		 base();
		 try {

			PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO imprimante(code,marque,vitesse,resolution,duree_garantie,id_f) values(?,?,?,?,?,?)");
			preparedStatement.setString(1, impr.getCode());
			preparedStatement.setString(2, impr.getMarque());
			preparedStatement.setString(3, impr.getVitesse());
			preparedStatement.setString(4, impr.getResolution());
			preparedStatement.setString(5, impr.getDureeGarantie());
			preparedStatement.setString(6, impr.getIdF());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/******************************* lister ordinateur non affecter *******************************************/
	public List<Ordinateur> ListerOrdinateurNAF(){ 		  
		List<Ordinateur> ordinateur = new ArrayList<Ordinateur>();
	      base();
		Statement statement = null;
		ResultSet rs = null;
		try {
		    //la creation et l'execution de la requete
			statement = connexion.createStatement();
		    rs = statement.executeQuery("SELECT * from ordinateur where etat = 0;");
		    //recuperation de données
		      while (rs.next()) {
		        String code = rs.getString(1);
		    	String marque = rs.getString(2);
		    	String cpu = rs.getString(3);
		    	String ecran = rs.getString(4);
		    	String disque_dur = rs.getString(5);
		    	String ram = rs.getString(6);
		    	String duree_garantie = rs.getString(7);
		    	String etat = rs.getString(8);
		    	String id_f = rs.getString(9);
		    	String id_emp = rs.getString(10);
		    	String id_dep = rs.getString(11);
		    	Ordinateur o = new Ordinateur();
		    	o.setCode(code);o.setMarque(marque);o.setCpu(cpu);o.setEcran(ecran);
		    	o.setDisqueDur(disque_dur);o.setRam(ram);o.setDureeGarantie(duree_garantie);o.setEtat(etat);
		    	o.setIdF(id_f);o.setIdEmp(id_emp);o.setIdDep(id_dep);
		    	ordinateur.add(o);
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
		return ordinateur;	
	}
	/******************************* lister ordinateur non affecter *******************************************/
	public List<Imprimante> ListerImprimantNAF(){ 		
		
		List<Imprimante> imprimante = new ArrayList<Imprimante>();
	      base();
	      
		Statement statement = null;
		ResultSet rs = null;
		try {
		    //la creation et l'execution de la requete
			statement = connexion.createStatement();
		    rs = statement.executeQuery("SELECT * from imprimante where etat = 0;");
		    //recuperation de données
		      while (rs.next()) {
		        String code = rs.getString(1);
		    	String marque = rs.getString(2);
		    	String vitesse = rs.getString(3);
		    	String resolution = rs.getString(4);
		    	String duree_garantie = rs.getString(5);
		    	String etat = rs.getString(6);
		    	String id_f = rs.getString(7);
		    	String id_emp = rs.getString(8);
		    	String id_dep = rs.getString(9);
		    	Imprimante o = new Imprimante();
		    	System.out.println(code+marque+"allllllo");
		    	o.setCode(code);o.setMarque(marque);o.setVitesse(vitesse);o.setResolution(resolution);
		    	o.setDureeGarantie(duree_garantie);o.setEtat(etat);o.setIdF(id_f);o.setIdEmp(id_emp);o.setIdDep(id_dep);
		    	imprimante.add(o);
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
		return imprimante;	
	}
	/********************************** modifier ordinateur dep ********************************************/
	public void modifierOrdinateur(int dep,String code) {
		 base();
		 System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		 try {

			PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE `ordinateur` set id_dep="+dep+", etat = 1 where code='"+code+"'");

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/********************************** modifier ordinateur dep ********************************************/
	public void modifierImprimante(int dep,String code) {
		 base();
		 try {

			PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE `imprimante` set id_dep="+dep+", etat = 1 where code='"+code+"'");

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/******************************* lister besoin *******************************************/
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

	/********************************** modifier ordinateur ens ********************************************/
	public void modifierOrdinateurE(int dep,String code,String idEmp) {
		 base();
		 try {

			PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE `ordinateur` set id_dep="+dep+",etat = 1, id_emp = '"+idEmp+"'  where code='"+code+"'");

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/********************************** modifier ordinateur ens ********************************************/
	public void modifierImprimanteE(int dep,String code,String idEmp) {
		 base();
		 try {

			PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE `imprimante` set id_dep="+dep+",etat = 1, id_emp = '"+idEmp+"' where code='"+code+"'");

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/******************************* lister Departement *******************************************/
	public List<Departement> ListerDepartement(){ 		  
		List<Departement> dep = new ArrayList<Departement>();
	      base();
		Statement statement = null;
		ResultSet rs = null;
		try {
		    //la creation et l'execution de la requete
			statement = connexion.createStatement();
		    rs = statement.executeQuery(" select * from departement ");
		    //recuperation de données
		      while (rs.next()) {
		    	  int idDep = rs.getInt(1);
		    	  String nom = rs.getString(2);
		    	  String chefDep = rs.getString(3);
		    	  Departement d = new Departement();
		    	  d.setIdDep(idDep);d.setNom(nom);d.setChefDef(chefDep);
		    	  dep.add(d);
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
		return dep;
	}
	/******************************* lister employee *******************************************/
	public List<Employee> ListerEnseignant(){ 		  
		List<Employee> emp = new ArrayList<Employee>();
	      base();
		Statement statement = null;
		ResultSet rs = null;
		try {
		    //la creation et l'execution de la requete
			statement = connexion.createStatement();
		    rs = statement.executeQuery(" select * from employe ");
		    //recuperation de données
		      while (rs.next()) {
		    	  String cin = rs.getString(1);
		    	  String nom = rs.getString(2);
		    	  String prenom = rs.getString(3);
		    	  String email = rs.getString(4);
		    	  String telephone = rs.getString(5);
		    	  int idDep = rs.getInt(6);
		    	  int idLab = rs.getInt(7);
		    	  
		    	  
		    	  Employee d = new Employee();
		    	  d.setCin(cin);d.setNom(nom);d.setPrenom(prenom);d.setEmail(email);d.setTelephone(telephone);
		    	  d.setIdDep(idDep);d.setIdLab(idLab);
		    	  emp.add(d);
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
		return emp;
	}
	/******************************* lister ordinateur affecté *******************************************/
	public List<Imprimante> ListerImprimantAF(){ 		
		
		List<Imprimante> imprimante = new ArrayList<Imprimante>();
	      base();
	      
		Statement statement = null;
		ResultSet rs = null;
		try {
		    //la creation et l'execution de la requete
			statement = connexion.createStatement();
		    rs = statement.executeQuery("SELECT * from imprimante where etat = 1;");
		    //recuperation de données
		      while (rs.next()) {
		        String code = rs.getString(1);
		    	String marque = rs.getString(2);
		    	String vitesse = rs.getString(3);
		    	String resolution = rs.getString(4);
		    	String duree_garantie = rs.getString(5);
		    	String etat = rs.getString(6);
		    	String id_f = rs.getString(7);
		    	String id_emp = rs.getString(8);
		    	String id_dep = rs.getString(9);
		    	Imprimante o = new Imprimante();
		    	System.out.println(code+marque+"allllllo");
		    	o.setCode(code);o.setMarque(marque);o.setVitesse(vitesse);o.setResolution(resolution);
		    	o.setDureeGarantie(duree_garantie);o.setEtat(etat);o.setIdF(id_f);o.setIdEmp(id_emp);o.setIdDep(id_dep);
		    	imprimante.add(o);
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
		return imprimante;	
	}
	/******************************* lister ordinateur affecté *******************************************/
	public List<Ordinateur> ListerOrdinateurAF(){ 		  
		List<Ordinateur> ordinateur = new ArrayList<Ordinateur>();
	      base();
		Statement statement = null;
		ResultSet rs = null;
		try {
		    //la creation et l'execution de la requete
			statement = connexion.createStatement();
		    rs = statement.executeQuery("SELECT * from ordinateur where etat = 1;");
		    //recuperation de données
		      while (rs.next()) {
		        String code = rs.getString(1);
		    	String marque = rs.getString(2);
		    	String cpu = rs.getString(3);
		    	String ecran = rs.getString(4);
		    	String disque_dur = rs.getString(5);
		    	String ram = rs.getString(6);
		    	String duree_garantie = rs.getString(7);
		    	String etat = rs.getString(8);
		    	String id_f = rs.getString(9);
		    	String id_emp = rs.getString(10);
		    	String id_dep = rs.getString(11);
		    	Ordinateur o = new Ordinateur();
		    	o.setCode(code);o.setMarque(marque);o.setCpu(cpu);o.setEcran(ecran);
		    	o.setDisqueDur(disque_dur);o.setRam(ram);o.setDureeGarantie(duree_garantie);o.setEtat(etat);
		    	o.setIdF(id_f);o.setIdEmp(id_emp);o.setIdDep(id_dep);
		    	ordinateur.add(o);
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
		return ordinateur;	
	}
	/******************************* lister Constat *******************************************/
	public List<Panne> ListerPanne(){ 		  
		List<Panne> panne = new ArrayList<Panne>();
	      base();
		Statement statement = null;
		ResultSet rs = null;
		try {
		    //la creation et l'execution de la requete
			statement = connexion.createStatement();
		    rs = statement.executeQuery("SELECT * from panne where etat = 1;");
		    //recuperation de données
		      while (rs.next()) {
		        int id_p = rs.getInt(1);
		    	String explication = rs.getString(2);
		    	String date = rs.getString(3);
		    	String frequence = rs.getString(4);
		    	String type = rs.getString(5);
		    	String decision = rs.getString(6);
		    	String id_emp = rs.getString(7);
		    	int etat = rs.getInt(8);
		    	String constat = rs.getString(9);
		    	String code_ressource = rs.getString(10);
		    	Panne p = new Panne();
		    	p.setId_p(id_p);p.setExplication(explication);p.setDate(date);p.setFrequence(frequence);
		    	p.setType(type);p.setDecision(decision);p.setId_emp(id_emp);p.setEtat(etat);
		    	p.setConstat(constat);p.setCode_ressource(code_ressource);
		    	panne.add(p);
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
		return panne;	
	}
	 /**************************************** ajouter imprimante ***************************************************/
		public void ajouterFournisseur(Fournisseur four) {
			 base();
			 try {

				PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO fournisseur values(?,?,?,?,?,?)");
				preparedStatement.setString(1, four.getCin());
				preparedStatement.setString(2, four.getNom());
				preparedStatement.setString(3, four.getPrenom());
				preparedStatement.setString(4, four.getEmail());
				preparedStatement.setString(5, four.getTelephone());
				preparedStatement.setString(6, four.getNomSociete());
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/******************************* ordinateur *******************************************/
		public Ordinateur ordinateur(String codeo){ 		  
		      base();
			Statement statement = null;
			ResultSet rs = null;
			Ordinateur o = new Ordinateur();
			try {
			    //la creation et l'execution de la requete
				statement = connexion.createStatement();
			    rs = statement.executeQuery("SELECT * from ordinateur where code = '"+codeo+"';");
			    //recuperation de données
			      while (rs.next()) {
			        String code = rs.getString(1);
			    	String marque = rs.getString(2);
			    	String cpu = rs.getString(3);
			    	String ecran = rs.getString(4);
			    	String disque_dur = rs.getString(5);
			    	String ram = rs.getString(6);
			    	String duree_garantie = rs.getString(7);
			    	String etat = rs.getString(8);
			    	String id_f = rs.getString(9);
			    	String id_emp = rs.getString(10);
			    	String id_dep = rs.getString(11);
			    	
			    	o.setCode(code);o.setMarque(marque);o.setCpu(cpu);o.setEcran(ecran);
			    	o.setDisqueDur(disque_dur);o.setRam(ram);o.setDureeGarantie(duree_garantie);o.setEtat(etat);
			    	o.setIdF(id_f);o.setIdEmp(id_emp);o.setIdDep(id_dep);
			    	
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
			return o;	
		}
		/******************************* imprimante *******************************************/
		public Imprimante imprimante(String codeo){ 		
			
		      base();
		      Imprimante o = new Imprimante();
			Statement statement = null;
			ResultSet rs = null;
			try {
			    //la creation et l'execution de la requete
				statement = connexion.createStatement();
			    rs = statement.executeQuery("SELECT * from imprimante where etat = 1;");
			    //recuperation de données
			      while (rs.next()) {
			        String code = rs.getString(1);
			    	String marque = rs.getString(2);
			    	String vitesse = rs.getString(3);
			    	String resolution = rs.getString(4);
			    	String duree_garantie = rs.getString(5);
			    	String etat = rs.getString(6);
			    	String id_f = rs.getString(7);
			    	String id_emp = rs.getString(8);
			    	String id_dep = rs.getString(9);
			    	
			    	System.out.println(code+marque+"allllllo");
			    	o.setCode(code);o.setMarque(marque);o.setVitesse(vitesse);o.setResolution(resolution);
			    	o.setDureeGarantie(duree_garantie);o.setEtat(etat);o.setIdF(id_f);o.setIdEmp(id_emp);o.setIdDep(id_dep);

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
			return o;	
		}
		/******************************* lister besoin *******************************************/
		public List<Besoin> ListerBesoinAp(){ 		  
			List<Besoin> Adm = new ArrayList<Besoin>();
		      base();
			Statement statement = null;
			ResultSet rs = null;
			try {
			    //la creation et l'execution de la requete
				statement = connexion.createStatement();
			    rs = statement.executeQuery(" select b.id_besoin,b.type,b.Qte,e.nom from Besoin b , employe e where b.cin=e.cin and etat = 1 ");
			    //recuperation de données
			      while (rs.next()) {
			    	  Besoin b = new Besoin();
						b.setId_besoin(rs.getInt("id_besoin"));
						b.setType(rs.getString("type"));
						b.setQte(rs.getInt("Qte"));
						 b.setCin(rs.getString("nom")); 
						Adm.add(b);
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
			return Adm;
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
		/********************************* modifier panne(modifier constat+ modifier etat***********************************************/
		public void ajoutetDecision(int id_p ,  String decision) {
			 base();
			 try {
				 System.out.println("vous etes dans dao modifier "+id_p);
						 
				PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE panne set decision= '"+decision+"', etat='2' where id_p='"+id_p+"'");
				preparedStatement.executeUpdate();
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*************************** liste des messages *****************************/
		public List<Message> listMessage(String cin) {

			List<Message> ms = new ArrayList<Message>();
			
			Connection conn=SingletonConnection.getConnection();
			try {
				
				  PreparedStatement ps = conn.
				  prepareStatement(" select message,etat from message where id_fournisseur='"+cin+"'");
				 
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					Message m= new Message();
					m.setMessage(rs.getString(1));
					m.setEtat(rs.getString(2));

					ms.add(m);
				}
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ms;
		}
		/*************************** recuperer cin selon username *****************************/
		public String recupererCin(String username) {
			String cin="";
			
			Connection conn=SingletonConnection.getConnection();
			try {
				
				  PreparedStatement ps = conn.
				  prepareStatement(" select cin from user where username='"+username+"'");
				 
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					cin=rs.getString(1);

				}
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return cin;
		}
		/********************************* modifier panne(modifier constat+ modifier etat***********************************************/
		public void ajouteroffre(int id_p) {
			 base();
			 try {
						 
				PreparedStatement preparedStatement = connexion.prepareStatement("UPDATE offre set etat= 1 where id_offre='"+id_p+"'");
				preparedStatement.executeUpdate();
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
}
