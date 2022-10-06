package com.ocprojet.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.modelmbean.RequiredModelMBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ocprojet.bdd.ClientDao;
import com.ocprojet.bdd.DaoFactory;
import com.ocprojet.bean.Offre;


/**
 * Servlet implementation class Fournisseur
 */
@WebServlet("/Fournisseur")
public class Fournisseur extends HttpServlet {
	private static final long serialVersionUID = 1L;
private ClientDao clientdao;
    
    public void init(){
    	DaoFactory daoFactory = DaoFactory.getInstance();
    	this.clientdao = daoFactory.getClientDao();
    }
    public Fournisseur() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Offre> liste = new ArrayList<Offre>();
		for (Offre offre : liste) {
			System.out.println("sevlet :"+offre.getQte());
		}
		liste = clientdao.getListeOfftre2();
	    request.setAttribute("listes", liste);
		this.getServletContext().getRequestDispatcher("/Fournisseur/FournisseurView.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String button =  request.getParameter("button");
		HttpSession SessionUser = request.getSession();
		String idF = (String) SessionUser.getAttribute("cinUser");
		if(button.equals("interesser")) {
			String id_offre = request.getParameter("id_offre");
			String prix = request.getParameter("prix");
			Offre o=clientdao.getOffreId(Integer.parseInt(id_offre));
			clientdao.ajouterSoumission(o, Integer.parseInt(prix), idF);
			List<Offre> liste = new ArrayList<Offre>();
			liste = clientdao.getListeOfftre2();
		    request.setAttribute("listes", liste);
			this.getServletContext().getRequestDispatcher("/Fournisseur/FournisseurView.jsp").forward(request, response);
		}
	}

}
