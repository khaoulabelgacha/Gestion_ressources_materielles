package com.ocprojet.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DaoFactory {
	String url= null;
	String username = null;
	String password = null;
	
	// constructeur
	public DaoFactory(String url , String username , String password){
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public static DaoFactory getInstance(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DaoFactory instance = new DaoFactory("jdbc:mysql://localhost/gl_projet", "root","");
		return instance;
	}
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url , username , password);
	}
	
	public ClientDao getClientDao(){
		return new ClientDaoImp(this);
	}
	
}
