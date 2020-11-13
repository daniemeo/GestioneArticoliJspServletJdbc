package it.gestionearticoli.web.servlet.articolo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.gestionearticoli.model.Articolo;
import it.gestionearticoli.model.Utente;
import it.gestionearticoli.service.MyServiceFactory;

/**
 * Servlet implementation class deleteServlet
 */
@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessione = request.getSession();
		Utente utente = (Utente) sessione.getAttribute("utente");
		if( utente== null || "guest".equals(utente.getRuolo()) || "operatore".equals(utente.getRuolo())){
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		try {
			Articolo articolo = MyServiceFactory.getArticoloServiceInstance().findById(Long.parseLong(request.getParameter("idDaInviareComeParametro")));
			if (articolo == null) {
				
				request.setAttribute("errorMessage", "Attenzione!! Questa categoria non esiste!!!");
				
				request.getRequestDispatcher("ListaCategorieServlet").forward(request, response);
				//request.getRequestDispatcher("index.jsp").forward(request, response);
				return;
			}
			
			
			request.setAttribute("delete", articolo);
			
            //alternativa, creare un nuovo articolo, setti id e lo passi a rimuovi.
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("delete.jsp").forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
