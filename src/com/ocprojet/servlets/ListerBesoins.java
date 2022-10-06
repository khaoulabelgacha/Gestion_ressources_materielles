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
 * Servlet implementation class ListerBesoins
 */
@WebServlet("/ListerBesoins")
public class ListerBesoins extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	 
    private IchefDepartement metier;
    
    @Override
    public void init() throws ServletException {
    	metier = new ImpChefDepartement();
    	super.init();
    }
    
    public ListerBesoins() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
        List<Besoin> besoin = metier.listBesoin();
		request.setAttribute("besoin",besoin);
		request.getServletContext().getRequestDispatcher("/chefDepartement/ChefView.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
