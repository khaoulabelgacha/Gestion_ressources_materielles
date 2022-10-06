package com.ocprojet.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.ocprojet.bdd.DaoPanne;
import com.ocprojet.bean.Panne;
import java.util.List;

/**
 * Servlet implementation class ServletPanne
 */
@WebServlet("/ServletPanne")
public class ServletPanne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPanne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoPanne d=new DaoPanne();
		List<Panne> pannes = d.ListerPannesNonTraite();
		request.setAttribute("pannes", pannes);
		request.getServletContext().getRequestDispatcher("/ServiceMaintenance/MaintenanceView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String button = request.getParameter("button"); 
        DaoPanne d=new DaoPanne();
      
        
		if( button.equals("toutesPannes")) {
			List<Panne> pannes = d.ListerPannes();
			request.setAttribute("pannes", pannes);
			request.getServletContext().getRequestDispatcher("/ServiceMaintenance/MaintenanceView1.jsp").forward(request, response);
			
		}
		if( button.equals("decidePanne")) {
			List<Panne> pannes = d.ListerPannesdecide();
			request.setAttribute("pannes", pannes);
			request.getServletContext().getRequestDispatcher("/ServiceMaintenance/MaintenanceView2.jsp").forward(request, response);
			
		}
		if( button.equals("nontraiteePanne")) {
			List<Panne> pannes = d.ListerPannesNonTraite();
			request.setAttribute("pannes", pannes);
			request.getServletContext().getRequestDispatcher("/ServiceMaintenance/MaintenanceView.jsp").forward(request, response);
			
		}
		if(button.equals("infoPanne")) {
      	  String id_p = request.getParameter("id_p");
      	  System.out.print("info:"+id_p);
      	  int id_pp=Integer.parseInt(id_p);
      	  Panne p=d.recupererPanne(id_pp);
      	  request.setAttribute("panne", p);
      	  request.getServletContext().getRequestDispatcher("/ServiceMaintenance/InformationPanne.jsp").forward(request, response);
	}
		if(button.equals("ajouterConstat")) {
	      	  String id_p = request.getParameter("id_p");
	      	  int id_pp=Integer.parseInt(id_p);
	      	  Panne p=d.recupererPanne(id_pp);
	      	  request.setAttribute("panne", p);
	      	  request.getServletContext().getRequestDispatcher("/ServiceMaintenance/AjouterConstat.jsp").forward(request, response);
		}
		if(button.equals("ajouterConstat1")) {
	        String id_p = request.getParameter("id_p");
	        System.out.println("ajouter constat:"+id_p);
	      	int id_pp=Integer.parseInt(id_p);
	      	String constat = request.getParameter("constat");
	      	d.modifier_Constat_etat(id_pp, constat);
	      	Panne p=d.recupererPanne(id_pp);
	      	request.setAttribute("panne", p);
	      	request.getServletContext().getRequestDispatcher("/ServiceMaintenance/InformationPanne.jsp").forward(request, response);
		}
		

}
}
