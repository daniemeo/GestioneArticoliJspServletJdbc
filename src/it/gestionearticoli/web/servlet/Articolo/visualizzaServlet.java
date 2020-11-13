package it.gestionearticoli.web.servlet.articolo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.gestionearticoli.model.Articolo;
import it.gestionearticoli.model.Utente;
import it.gestionearticoli.service.MyServiceFactory;
import it.gestionearticoli.service.articolo.ArticoloService;

/**
 * Servlet implementation class visualizza
 */
@WebServlet("/visualizzaServlet")
public class VisualizzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessione = request.getSession();
		Utente utente = (Utente) sessione.getAttribute("utente");
		if( utente== null ){
			request.getRequestDispatcher("index.jsp");
		}
		String parametroIdDellArticoloDiCuiVoglioIlDettaglio = request.getParameter("idDaInviareComeParametro");
		
				
		
		Articolo result;
		try {
			ArticoloService service = MyServiceFactory.getArticoloServiceInstance();
			result = service.findById(Long.parseLong(parametroIdDellArticoloDiCuiVoglioIlDettaglio));
			if (result == null) request.getRequestDispatcher("index.jsp");
			request.setAttribute("articoloPerShow", result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		
		RequestDispatcher dispatcher = request.getRequestDispatcher("show.jsp");
	    dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
