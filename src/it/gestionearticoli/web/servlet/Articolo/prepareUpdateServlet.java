package it.gestionearticoli.web.servlet.Articolo;

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
 * Servlet implementation class prepareUpdateServlet
 */
@WebServlet("/prepareUpdateServlet")
public class prepareUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Articolo articolo= new Articolo();
    public prepareUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessione = request.getSession();
		Utente utente = (Utente) sessione.getAttribute("utente");
		if( utente== null || "guest".equals(utente.getRuolo())){
			request.getRequestDispatcher("index.jsp");
		}
		
		String idArticolo=request.getParameter("idDaInviareExecuteUpdate");
		
		
			try {
				Articolo articolo= MyServiceFactory.getArticoloServiceInstance().findById(Long.parseLong(idArticolo));
				if (articolo == null) {
					request.getRequestDispatcher("index.jsp");
				}
				request.setAttribute("articoloUpdate", articolo);
				request.setAttribute("listaCategorieAttribute", MyServiceFactory.getCategoriaServiceInstance().listAll());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//articolo = MyServiceFactory.getArticoloServiceInstance().findById(Long.parseLong(request.getParameter("idDaInviareComeParametro")));
			
			//request.setAttribute("desc", articolo);
			request.getRequestDispatcher("update.jsp").forward(request, response);
			
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
