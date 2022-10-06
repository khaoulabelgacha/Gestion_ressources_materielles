package com.ocprojet.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ocprojet.bdd.IchefDepartement;
import com.ocprojet.bdd.ImpChefDepartement;
import com.ocprojet.bean.Besoin;
import com.ocprojet.bean.Panne;

/**
 * Servlet implementation class AjouterPanne
 */
@WebServlet("/AjouterPanne")
public class AjouterPanne extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    private IchefDepartement metier;
    
    @Override
    public void init() throws ServletException {
    	metier = new ImpChefDepartement();
    	super.init();
    }
    
    
    public AjouterPanne() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession SessionUser = request.getSession();
		String cin = (String) SessionUser.getAttribute("cinUser");
		System.out.println("hdddddddddddddddddddddddddddddddddddddddddd "+cin);
		List<String> adm = metier.listRessource(cin);

		request.setAttribute("ADM",adm);
		this.getServletContext().getRequestDispatcher("/chefDepartement/AjouterPanne.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String explication = request.getParameter("explication");
		String frequence = request.getParameter("frequence");
		String type = request.getParameter("type");
		String CIN = request.getParameter("CIN");
		String code = request.getParameter("code");
		
		Panne P = new Panne(); 
		
		P.setType(type);
		P.setCode_ressource(code);
		P.setExplication(explication);
		P.setFrequence(frequence);
		P.setId_emp(CIN);
		P.setDate("");
		metier.addPanne(P);
		List<Besoin> besoin = metier.listBesoin();
			
		request.setAttribute("besoin",besoin);
		
		this.getServletContext().getRequestDispatcher("/chefDepartement/ChefView.jsp").forward(request, response);
	}

}
