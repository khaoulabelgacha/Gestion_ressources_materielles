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

import com.ocprojet.bdd.ClientDao;
import com.ocprojet.bdd.Dao1;
import com.ocprojet.bdd.DaoFactory;
import com.ocprojet.bdd.DaoPanne;
import com.ocprojet.bean.Besoin;
import com.ocprojet.bean.Fournisseur;
import com.ocprojet.bean.Imprimante;
import com.ocprojet.bean.Offre;
import com.ocprojet.bean.Ordinateur;
import com.ocprojet.bean.Panne;
import com.ocprojet.bean.SoumissionOffre;
import com.ocprojet.bean.User;


/**
 * Servlet implementation class Servlet1
 */
@WebServlet(urlPatterns = {"/Servlet2","/logout","/ajouterRessource","/listerRessourceAff","/listerRessourceNAff","/listerConstat","/listerBesoin","/appeloffre","/offreRecue","/Messages"})
public class Servlet2 extends HttpServlet { 
	private static final long serialVersionUID = 1L;
private ClientDao clientdao;
    
    public void init(){
    	DaoFactory daoFactory = DaoFactory.getInstance();
    	this.clientdao = daoFactory.getClientDao();
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  String url = request.getServletPath();
		  HttpSession SessionUser = request.getSession();
	      Dao1 d = new Dao1();
     	  String username = (String) SessionUser.getAttribute("username");
     	  String password = (String) SessionUser.getAttribute("password");
     	  System.out.println(username+password+"dd");
     	 if(url.equals("/Servlet2")) {
     		System.out.println("session :"+(String)SessionUser.getAttribute("type"));
       	 if(SessionUser.getAttribute("type") == null) {
       		 System.out.println("ddddddddddddd");
	            request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
	        }
       	 else if( SessionUser.getAttribute("type").equals("1")) {
    	    	request.setAttribute("user", d.InfoUser(username, password));
    	    	 List<Besoin> besoin = d.listBesoin();
    	 		request.setAttribute("besoin",besoin);
    	    	request.getServletContext().getRequestDispatcher("/chefDepartement/ChefView.jsp").forward(request, response);
    	     }
       	 else if(SessionUser.getAttribute("type").equals("2")) {
    	    	request.setAttribute("user", d.InfoUser(username, password));
     	    request.getServletContext().getRequestDispatcher("/PersonneDep/PersonneDepView.jsp").forward(request, response);
     	 }
       	 else if(SessionUser.getAttribute("type").equals("3")) {
    	    	request.setAttribute("user", d.InfoUser(username, password));
    	    	DaoPanne de=new DaoPanne();
    			List<Panne> pannes = de.ListerPannesNonTraite();
    			request.setAttribute("pannes", pannes);
    			request.getServletContext().getRequestDispatcher("/ServiceMaintenance/MaintenanceView.jsp").forward(request, response);
   	     }
       	 else if(SessionUser.getAttribute("type").equals("4")) {
    	    	request.setAttribute("user", d.InfoUser(username, password));
    	    	List<Offre> liste = new ArrayList<Offre>();
    			liste = clientdao.getListeOfftre2();
    		    request.setAttribute("listes", liste);
 	        request.getServletContext().getRequestDispatcher("/Fournisseur/FournisseurView.jsp").forward(request, response);
 	     }

    	 else if(SessionUser.getAttribute("type").equals("5")) {
    	    	request.setAttribute("user", d.InfoUser(username, password));
	            request.getServletContext().getRequestDispatcher("/responsableStock/responStockAcceuil.jsp").forward(request, response);
	        }
     	 }
     	 if(url.equals("/logout")) {
     	   SessionUser.invalidate();
      	  request.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
     	 }
     	 if(url.equals("/ajouterRessource")) {
     		 request.setAttribute("fournisseur", d.ListerFournisseur());
     		request.getServletContext().getRequestDispatcher("/responsableStock/ajouterRessource.jsp").forward(request, response);
     	 }
     	 if(url.equals("/listerRessourceAff")) {
     		request.setAttribute("imprAF", d.ListerImprimantAF());
     		request.setAttribute("ordiAF", d.ListerOrdinateurAF());
     		request.getServletContext().getRequestDispatcher("/responsableStock/listerRessourcesAf.jsp").forward(request, response);
     	 }
     	if(url.equals("/listerRessourceNAff")) {
     		request.setAttribute("imprNAF", d.ListerImprimantNAF());
     		request.setAttribute("ordiNAF", d.ListerOrdinateurNAF());
     		request.getServletContext().getRequestDispatcher("/responsableStock/listerRessourceNAf.jsp").forward(request, response);
    	 }
     	if(url.equals("/listerConstat")) {
     		request.setAttribute("panne", d.ListerPanne());
     		request.getServletContext().getRequestDispatcher("/responsableStock/listerConstats.jsp").forward(request, response);
     	}
     	if(url.equals("/listerBesoin")) {
     		request.setAttribute("besoinAp", d.ListerBesoinAp());
     		request.getServletContext().getRequestDispatcher("/responsableStock/listerBesoins.jsp").forward(request, response);
     	}
     	if(url.equals("/appeloffre")) {
     		request.setAttribute("listes", clientdao.getListeOfftre());
     		//request.setAttribute("besoinAp", d.ListerBesoinAp());
     		request.getServletContext().getRequestDispatcher("/responsableStock/appelDoffre.jsp").forward(request, response);
     	}
     	if(url.equals("/offreRecue")) {
     		request.setAttribute("listes", clientdao.getListeSoumission());
     		
     		request.getServletContext().getRequestDispatcher("/responsableStock/offreRecues.jsp").forward(request, response);
     	}
     	if(url.equals("/Messages")) {
     		String cin =d.recupererCin(username);
     		request.setAttribute("listes", d.listMessage(cin));
     		request.getServletContext().getRequestDispatcher("/Fournisseur/FournisseurView2.jsp").forward(request, response);
     	}
     	
     	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Dao1 d = new Dao1();
         String button = request.getParameter("button"); 
         HttpSession SessionUser = request.getSession();
         if(button.equals("login")) {
          
       	  String username = request.getParameter("username");
       	  String password = request.getParameter("password");
       	  System.out.println(username+password);
       	  System.out.println("test : "+d.connexionUser(username,password));
       	     if(d.connexionUser(username,password) == 1) {
       	    	SessionUser.setAttribute("username", username);
       	    	SessionUser.setAttribute("password", password);
       	    	SessionUser.setAttribute("type", "1");
       	    	User u = (User) d.InfoUser(username, password);
       	    	String cin= u.getCin();
       	    	SessionUser.setAttribute("cinUser", cin);

       	    	request.setAttribute("user", d.InfoUser(username, password));
       	    	List<Besoin> besoin = d.listBesoin();
    	 		request.setAttribute("besoin",besoin);
       	    	request.getServletContext().getRequestDispatcher("/chefDepartement/ChefView.jsp").forward(request, response);
       	     }
       	     else if(d.connexionUser(username,password) == 2) {
       	    	SessionUser.setAttribute("username", username);
       	    	SessionUser.setAttribute("password", password);
       	    	SessionUser.setAttribute("type", "2");
       	    	User u = (User) d.InfoUser(username, password);
       	    	String cin= u.getCin();
       	    	SessionUser.setAttribute("cinUser", cin);
       	    	request.setAttribute("user", d.InfoUser(username, password));
        	    request.getServletContext().getRequestDispatcher("/PersonneDep/PersonneDepView.jsp").forward(request, response);
        	 }
       	     else if(d.connexionUser(username,password) == 3) {
       	    	SessionUser.setAttribute("username", username);
       	    	SessionUser.setAttribute("password", password);
       	    	SessionUser.setAttribute("type", "3");
       	    	User u = (User) d.InfoUser(username, password);
       	    	String cin= u.getCin();
       	    	SessionUser.setAttribute("cinUser", cin);
       	    	request.setAttribute("user", d.InfoUser(username, password));
       	    	DaoPanne de=new DaoPanne();
    			List<Panne> pannes = de.ListerPannesNonTraite();
    			request.setAttribute("pannes", pannes);
    			request.getServletContext().getRequestDispatcher("/ServiceMaintenance/MaintenanceView.jsp").forward(request, response);
   	     
      	         }
       	     else if(d.connexionUser(username,password) == 4) {
       	    	SessionUser.setAttribute("username", username);
       	    	SessionUser.setAttribute("password", password);
       	    	SessionUser.setAttribute("type", "4");
       	    	User u = (User) d.InfoUser(username, password);
       	    	String cin= u.getCin();
       	    	SessionUser.setAttribute("cinUser", cin);
       	    	request.setAttribute("user", d.InfoUser(username, password));
       	    	List<Offre> liste = new ArrayList<Offre>();
    			liste = clientdao.getListeOfftre2();
    		    request.setAttribute("listes", liste);
    	        request.getServletContext().getRequestDispatcher("/Fournisseur/FournisseurView.jsp").forward(request, response);
    	     }
       	     else if(d.connexionUser(username,password) == 5) {
       	    	SessionUser.setAttribute("username", username);
       	    	SessionUser.setAttribute("password", password);
       	    	SessionUser.setAttribute("type", "5"); 
       	    	User u = (User) d.InfoUser(username, password);
       	    	String cin= u.getCin();
       	    	SessionUser.setAttribute("cinUser",cin);
       	    	request.setAttribute("user", d.InfoUser(username, password));
       	    	request.setAttribute("imprAF", d.ListerImprimantAF());
         		request.setAttribute("ordiAF", d.ListerOrdinateurAF());
         		request.getServletContext().getRequestDispatcher("/responsableStock/listerRessourcesAf.jsp").forward(request, response);
  	        }
       	  else if(d.connexionUser(username,password) == 0) {
	            request.getServletContext().getRequestDispatcher("/login2.jsp").forward(request, response);
	        } 
         }
         if(button.equals("AjouterRessource")) {
        	 String typeRessource = request.getParameter("typeRessource");
        	 if(typeRessource.equals("imprimante")) {
        		 String codeImp = request.getParameter("codeImp");
        		 String marqueImp = request.getParameter("marqueImp");
        		 String vitesseImp = request.getParameter("vitesseImp");
        		 String resolutionImp = request.getParameter("resolutionImp");
        		 String garantieImp = request.getParameter("garantieImp");
        		 String fournisseurImp = request.getParameter("fournisseurImp");
        		 Imprimante i = new Imprimante();
        		 i.setCode(codeImp);i.setMarque(marqueImp);i.setVitesse(vitesseImp);
        		 i.setResolution(resolutionImp);i.setDureeGarantie(garantieImp);i.setIdF(fournisseurImp);
        		 d.ajouterImprimante(i);
        		 request.setAttribute("imprNAF", d.ListerImprimantNAF());
           		 request.setAttribute("ordiNAF", d.ListerOrdinateurNAF());
        		 request.getServletContext().getRequestDispatcher("/responsableStock/listerRessourceNAf.jsp").forward(request, response);

        	 }
        	 else if(typeRessource.equals("ordinateur")) {
        		 String codePC = request.getParameter("codePC");
        		 String marquePC = request.getParameter("marquePC");
        		 String cpuPC = request.getParameter("cpuPC");
        		 String ecranPC = request.getParameter("ecranPC");
        		 String disquePC = request.getParameter("disquePC");
        		 String ramPC = request.getParameter("ramPC");
        		 String garantiePC = request.getParameter("garantiePC");
        		 String fournisseurPC = request.getParameter("fournisseurPC");
        		 Ordinateur o = new Ordinateur();
        		 o.setCode(codePC);o.setMarque(marquePC);o.setCpu(cpuPC);o.setEcran(ecranPC);o.setDisqueDur(disquePC);
        		 o.setRam(ramPC);o.setDureeGarantie(garantiePC);o.setIdF(fournisseurPC);
        		 d.ajouterOrdinateur(o);
        		request.setAttribute("imprNAF", d.ListerImprimantNAF());
          		request.setAttribute("ordiNAF", d.ListerOrdinateurNAF());
          		request.getServletContext().getRequestDispatcher("/responsableStock/listerRessourceNAf.jsp").forward(request, response);
        	 }
         }
         if(button.equals("addFournisseur")) {
        	 request.getServletContext().getRequestDispatcher("/responsableStock/ajouterFournisseur.jsp").forward(request, response);
         }
         if(button.equals("affDepartement")) {
        	 String codeOrd = request.getParameter("codeOrd");
        	 String codeImp = request.getParameter("codeImp");
        	 if(codeOrd != null) {
        		 request.setAttribute("codeOrd", codeOrd);
        	 }
        	 else if(codeImp != null) {
        		 request.setAttribute("codeImp", codeImp);
        	 }
        	 request.setAttribute("departement", d.ListerDepartement());
        	 request.getServletContext().getRequestDispatcher("/responsableStock/affecterDep.jsp").forward(request, response);
        	 
         }
         if(button.equals("affEnseignant")) {
        	 String codeOrd = request.getParameter("codeOrd");
        	 String codeImp = request.getParameter("codeImp");
        	 if(codeOrd != null) {
        		 request.setAttribute("codeOrd", codeOrd);
        	 }
        	 else if(codeImp != null) {
        		 request.setAttribute("codeImp", codeImp);
        	 }
        	 request.setAttribute("departement", d.ListerDepartement());
        	 request.setAttribute("employee", d.ListerEnseignant());
        	 request.getServletContext().getRequestDispatcher("/responsableStock/affecterEns.jsp").forward(request, response);
        	 
         }
         if(button.equals("affecterDep")) {
        	 String codeOrd = request.getParameter("codeOrd");
        	 String codeImp = request.getParameter("codeImp");
        	 String departt = request.getParameter("departements");
        	 int depart = Integer.parseInt(departt);
        	 
        	 if(codeOrd != null) {
        		 d.modifierOrdinateur(depart,codeOrd);
        		 request.setAttribute("imprNAF", d.ListerImprimantNAF());
          		 request.setAttribute("ordiNAF", d.ListerOrdinateurNAF());
          		 request.getServletContext().getRequestDispatcher("/responsableStock/listerRessourceNAf.jsp").forward(request, response);
        		 
        	 }
        	 else if(codeImp != null) {
        		 d.modifierImprimante(depart,codeOrd);
        		 request.setAttribute("imprNAF", d.ListerImprimantNAF());
          		 request.setAttribute("ordiNAF", d.ListerOrdinateurNAF());
          		 request.getServletContext().getRequestDispatcher("/responsableStock/listerRessourceNAf.jsp").forward(request, response);
        	 }
        	 
         }
         if(button.equals("affEnseignant1")) {
        	 String codeOrd = request.getParameter("codeOrd");
        	 String codeImp = request.getParameter("codeImp");
        	 String departt = request.getParameter("departements");
        	 String idEmp = request.getParameter("employee");
        	 int depart = Integer.parseInt(departt);

        	 
        	 if(codeOrd != null) {
        		 d.modifierOrdinateurE(depart,codeOrd,idEmp);
        		 request.setAttribute("imprNAF", d.ListerImprimantNAF());
          		 request.setAttribute("ordiNAF", d.ListerOrdinateurNAF());
          		 request.getServletContext().getRequestDispatcher("/responsableStock/listerRessourceNAf.jsp").forward(request, response);
        		 
        	 }
        	 else if(codeImp != null) {
        		 d.modifierImprimanteE(depart,codeOrd,idEmp);
        		 request.setAttribute("imprNAF", d.ListerImprimantNAF());
          		 request.setAttribute("ordiNAF", d.ListerOrdinateurNAF());
          		 request.getServletContext().getRequestDispatcher("/responsableStock/listerRessourceNAf.jsp").forward(request, response);
        	 }
         }
         if(button.equals("ajouterFournisseur")) {
        	 String cinF = request.getParameter("cinF");
        	 String nomF = request.getParameter("nomF");
        	 String prenomF = request.getParameter("prenomF");
        	 String emailF = request.getParameter("emailF");
        	 String phoneF = request.getParameter("phoneF");
        	 String societeF = request.getParameter("societeF");
        	 Fournisseur f = new Fournisseur();
        	 f.setCin(cinF);f.setNom(nomF);f.setPrenom(prenomF);f.setEmail(emailF);f.setTelephone(phoneF);f.setNomSociete(societeF);
        	 d.ajouterFournisseur(f);
        	 request.setAttribute("fournisseur", d.ListerFournisseur());
      		request.getServletContext().getRequestDispatcher("/responsableStock/ajouterRessource.jsp").forward(request, response);
         }
         if(button.equals("modifyAF")) {
        	 String idRessourceO = request.getParameter("idRessourceO");
        	 String idRessourceI = request.getParameter("idRessourceI");
        	 if(idRessourceO != null) {
        		 request.setAttribute("ress", "ordinateur");
        	     request.setAttribute("ressource", d.ordinateur(idRessourceO));
        	 } 
        	 else if(idRessourceI != null) {
        		 request.setAttribute("ress", "imprimante");
        		 request.setAttribute("ressource", d.imprimante(idRessourceI));
        		 
        	 }
        	    
        	 request.setAttribute("departement", d.ListerDepartement());
        	 request.setAttribute("employee", d.ListerEnseignant());
        	 request.getServletContext().getRequestDispatcher("/responsableStock/modifierAffectation.jsp").forward(request, response);
         }
         if(button.equals("modifierAfectation")) {
        	 String ress = request.getParameter("ress");
        	 String codeR = request.getParameter("codeR");
        	 String departt = request.getParameter("departements");
        	 int depart = Integer.parseInt(departt);
        	 String idEmp = request.getParameter("employee");
        	 if(ress.equals("ordinateur")) {
        		 d.modifierOrdinateurE(depart,codeR,idEmp);
        		 request.setAttribute("imprAF", d.ListerImprimantAF());
          		 request.setAttribute("ordiAF", d.ListerOrdinateurAF());
          		 request.getServletContext().getRequestDispatcher("/responsableStock/listerRessourcesAf.jsp").forward(request, response);
        	 }
        	 else if(ress.equals("imprimante")) {
        		 d.modifierImprimanteE(depart,codeR,idEmp);
        		 request.setAttribute("imprAF", d.ListerImprimantAF());
          		 request.setAttribute("ordiAF", d.ListerOrdinateurAF());
          		 request.getServletContext().getRequestDispatcher("/responsableStock/listerRessourcesAf.jsp").forward(request, response);
        	 }
         }
         if(button.equals("traiter")) {
        	 String id_p = request.getParameter("id_p");
	      	  int id_pp=Integer.parseInt(id_p);
	      	  Panne p=d.recupererPanne(id_pp);
	      	  request.setAttribute("panne", p);
	      	request.getServletContext().getRequestDispatcher("/responsableStock/traiterConstat.jsp").forward(request, response);
        	 
         }
         if(button.equals("ajouterDecision")) {
        	 String id_p = request.getParameter("id_p");
        	 int id_pp=Integer.parseInt(id_p);
        	 String decision = request.getParameter("Decision");
        	 d.ajoutetDecision(id_pp ,decision);
        	 request.setAttribute("panne", d.ListerPanne());
      		request.getServletContext().getRequestDispatcher("/responsableStock/listerConstats.jsp").forward(request, response);
         }
         if(button.equals("eliminerFournisseur")) {
        	 String idSoumission = request.getParameter("idSoumission");
        	 int idSoumission1=Integer.parseInt(idSoumission);
        	 String messageElim = request.getParameter("messageElim");
        	 String idF = request.getParameter("idF");
        	 clientdao.ajouterMessage(messageElim,idF);
        	 clientdao.supprimerSoumission(idSoumission1);
        	 request.setAttribute("listes", clientdao.getListeSoumission());
      		 request.getServletContext().getRequestDispatcher("/responsableStock/offreRecues.jsp").forward(request, response);
        	 
         }
         if(button.equals("accepterSoumi")) {
        	 String idSoumission = request.getParameter("idSoumission");
        	 int idSoumission1=Integer.parseInt(idSoumission);
        	 String messageElim = request.getParameter("messageElim");
        	 String idF = request.getParameter("idF");
        	 clientdao.ajouterMessage1(messageElim,idF);
        	 clientdao.supprimerSoumission(idSoumission1);
        	 request.setAttribute("listes", clientdao.getListeSoumission());
      		 request.getServletContext().getRequestDispatcher("/responsableStock/offreRecues.jsp").forward(request, response);
        	 
         }
         if(button.equals("appeldoffre")) {
        	 String idoffre = request.getParameter("idoffre");
        	 int id = Integer.parseInt(idoffre);
        	 d.ajouteroffre(id);
        	 request.setAttribute("listes", clientdao.getListeOfftre());
      		 request.getServletContext().getRequestDispatcher("/responsableStock/appelDoffre.jsp").forward(request, response);
        	 
         }
         
         

         
         
         
	}

}
