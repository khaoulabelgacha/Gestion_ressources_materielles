package com.ocprojet.servlets;

import java.io.IOException;
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
import com.ocprojet.bean.User;

/**
 * Servlet implementation class AjouterBesoin
 */
@WebServlet("/AjouterBesoin")
public class AjouterBesoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private IchefDepartement metier;
    
    @Override
    public void init() throws ServletException {
    	metier = new ImpChefDepartement();
    	super.init();
    }
    
    public AjouterBesoin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession SessionUser = request.getSession();

		request.setAttribute("cin", SessionUser.getAttribute("cinUser"));
		this.getServletContext().getRequestDispatcher("/chefDepartement/AjouterBesoin.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("type");
		String Qte = request.getParameter("Qte");
		String CIN = request.getParameter("CIN");
		Besoin B = new Besoin();
		B.setQte(Integer.parseInt(Qte));
		B.setType(type);
		B.setCin(CIN);
		metier.addBesoin(B);
		 List<Besoin> besoin = metier.listBesoin();
		request.setAttribute("besoin",besoin);
		this.getServletContext().getRequestDispatcher("/chefDepartement/ChefView.jsp").forward(request, response);
		
		
	}

}
