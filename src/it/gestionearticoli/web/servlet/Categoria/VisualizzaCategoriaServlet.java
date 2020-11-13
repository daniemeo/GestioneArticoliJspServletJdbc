package it.gestionearticoli.web.servlet.categoria;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.gestionearticoli.model.Categoria;
import it.gestionearticoli.model.Utente;
import it.gestionearticoli.service.MyServiceFactory;
import it.gestionearticoli.service.categoria.CategoriaService;

/**
 * Servlet implementation class VisualizzaCategoria
 */
@WebServlet("/VisualizzaCategoria")
public class VisualizzaCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaCategoriaServlet() {
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
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
      String parametroIdDellaCategoriaDiCuiVoglioIlDettaglio = request.getParameter("idCategoriaDainviare");
      if(parametroIdDellaCategoriaDiCuiVoglioIlDettaglio == null || parametroIdDellaCategoriaDiCuiVoglioIlDettaglio.isEmpty() ) {
    	  request.getRequestDispatcher("index.jsp").forward(request, response);
    	  return;
    	  
      }
      CategoriaService service = MyServiceFactory.getCategoriaServiceInstance();
      
      Categoria categoria = new Categoria();
      try {
			
			categoria = service.dettaglioCategoriaListaArticoli(Long.parseLong(parametroIdDellaCategoriaDiCuiVoglioIlDettaglio));
			if (categoria== null) request.getRequestDispatcher("index.jsp").forward(request, response);
			request.setAttribute("dettaglioCategoria", categoria);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
    
      request.getRequestDispatcher("visualizzaCategoria.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
