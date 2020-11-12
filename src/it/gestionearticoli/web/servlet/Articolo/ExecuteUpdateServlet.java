package it.gestionearticoli.web.servlet.Articolo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestionearticoli.model.Articolo;
import it.gestionearticoli.model.Categoria;
import it.gestionearticoli.service.MyServiceFactory;

/**
 * Servlet implementation class ExecuteUpdateServlet
 */
@WebServlet("/ExecuteUpdateServlet")
public class ExecuteUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String IdcategoriaInputParam =request.getParameter("idDaInviareExecuteUpdate");
		String idArticoloDaModificare = request.getParameter("articoloUpdate");
		String codiceInputParam = request.getParameter("codice");
		String descrizioneInputParam = request.getParameter("descrizione");
		String prezzoInputParam = request.getParameter("prezzo");
		Integer prezzo = !prezzoInputParam.isEmpty() ? Integer.parseInt(prezzoInputParam) : 0;
		
		if (codiceInputParam.isEmpty() || descrizioneInputParam.isEmpty() || prezzo < 1) {
			request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
			request.getRequestDispatcher("update.jsp").forward(request, response);
			return;
		}
		   Categoria cat = new Categoria();
		
			cat.setIdCategoria(Long.parseLong(IdcategoriaInputParam));
			
		
		  		
		
			Articolo articolo= new Articolo();
			try {
				articolo.setId(Long.parseLong(idArticoloDaModificare));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			articolo.setCodice(request.getParameter("codice")); 
			articolo.setDescrizione(request.getParameter("descrizione"));
			articolo.setPrezzo(Integer.parseInt(request.getParameter("prezzo")));
			articolo.setCategoria(cat);
		try {
			
			MyServiceFactory.getArticoloServiceInstance().aggiorna(articolo);
			request.setAttribute("listaArticoliAttribute", MyServiceFactory.getArticoloServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("results.jsp").forward(request, response);
		
	} 

}
