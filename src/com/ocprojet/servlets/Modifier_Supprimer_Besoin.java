package com.ocprojet.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ocprojet.bdd.IchefDepartement;
import com.ocprojet.bdd.ImpChefDepartement;
import com.ocprojet.bean.Besoin;

/**
 * Servlet implementation class Modifier_Supprimer_Besoin
 */
@WebServlet("/Modifier_Supprimer_Besoin")
public class Modifier_Supprimer_Besoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	 private IchefDepartement metier;
	    
	    @Override
	    public void init() throws ServletException {
	    	metier = new ImpChefDepartement();
	    	super.init();
	    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modifier_Supprimer_Besoin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String button= request.getParameter("button");
			
		
		if(button.equals("modifier")) {
			String id_besoin=request.getParameter("id_besoin");	
			int id = Integer.parseInt(id_besoin);
			metier.ModifierBesoin(id);
			
			List<Besoin> besoin = metier.listBesoin();
			
			request.setAttribute("besoin",besoin);
			
			
			this.getServletContext().getRequestDispatcher("/chefDepartement/ChefView.jsp").forward(request, response);
			
				
			}
		if(button.equals("supprimer")) {
			String id_besoin=request.getParameter("id_besoin");
			int id = Integer.parseInt(id_besoin);
			metier.SupprimerBesoin(id);
            List<Besoin> besoin = metier.listBesoin();
			
			request.setAttribute("besoin",besoin);
			
			
			this.getServletContext().getRequestDispatcher("/chefDepartement/ChefView.jsp").forward(request, response);
		}
		
		
		
			/*
      List<Besoin> besoin = metier.listBesoin();
		
		request.setAttribute("besoin",besoin);
		
		
		this.getServletContext().getRequestDispatcher("/chefDepartement/ChefView.jsp").forward(request, response);*/
		
		
		
		
	}
	

}
