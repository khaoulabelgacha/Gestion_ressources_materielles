package com.ocprojet.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import com.ocprojet.bdd.ClientDao;
import com.ocprojet.bdd.DaoFactory;
import com.ocprojet.bean.Besoin;
import com.ocprojet.bean.Panne;

/**
 * Servlet implementation class PerBesoin
 */
@WebServlet("/PersonneBesoin")
public class PerBesoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ClientDao clientdao;
    
    public void init(){
    	DaoFactory daoFactory = DaoFactory.getInstance();
    	this.clientdao = daoFactory.getClientDao();
    }
    public PerBesoin() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession SessionUser = request.getSession();
		if(action != null){
			if(action.equals("Signaler")){
				 List<String> liste = new ArrayList<String>();
				 String id_emp = (String) SessionUser.getAttribute("cinUser");
				 liste = clientdao.getListeCodeResource(id_emp);
				 request.setAttribute("listes",liste);
				this.getServletContext().getRequestDispatcher("/PersonneDep/SignalerPanne.jsp").forward(request, response);
			}else {
				this.getServletContext().getRequestDispatcher("/PersonneDep/PersonneDepView.jsp").forward(request, response);
			}
		}else {
			this.getServletContext().getRequestDispatcher("/PersonneDep/PersonneDepView.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession SessionUser = request.getSession();
		boolean etat = false;
		if(action != null){
			if(action.equals("ajouterBesoin")){
				String type = request.getParameter("type");
				String Qte = request.getParameter("Qte");
				String cin = (String) SessionUser.getAttribute("cinUser");
				
				Besoin B = new Besoin();
				B.setQte(Integer.parseInt(Qte));
				B.setType(type);
				B.setCin(cin);
				clientdao.AjouterBesoin(B);
				this.getServletContext().getRequestDispatcher("/PersonneDep/PersonneDepView.jsp").forward(request, response);
			}else if(action.equals("signalerPanne")) {
				
				String explication = request.getParameter("explication");
				String frequence = request.getParameter("frequence");
				String type = request.getParameter("type");
				String code = request.getParameter("code");
				String id_emp = (String) SessionUser.getAttribute("cinUser");
				Panne P= new Panne();
				P.setExplication(explication);
				P.setFrequence(frequence);
				P.setType(type);
				P.setCode_ressource(code);
				P.setId_emp(id_emp);
				clientdao.AjouterPanne(P);
				this.getServletContext().getRequestDispatcher("/PersonneDep/PersonneDepView.jsp").forward(request, response);
			}else {
				this.getServletContext().getRequestDispatcher("/PersonneDep/PersonneDepView.jsp").forward(request, response);
			}
		}else {
			this.getServletContext().getRequestDispatcher("/PersonneDep/PersonneDepView.jsp").forward(request, response);
		}
	}
}
