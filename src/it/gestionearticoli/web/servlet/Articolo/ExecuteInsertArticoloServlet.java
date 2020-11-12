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

@WebServlet("/ExecuteInsertArticoloServlet")
public class ExecuteInsertArticoloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteInsertArticoloServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// validiamo input
		String codiceInputParam = request.getParameter("codice");
		String descrizioneInputParam = request.getParameter("descrizione");
		String prezzoInputStringParam = request.getParameter("prezzo");
		String categoriaInputParam=request.getParameter("listaCategorie");
		//System.out.println(categoriaInputParam);
		Integer prezzo = !prezzoInputStringParam.isEmpty() ? Integer.parseInt(prezzoInputStringParam) : 0;
		Categoria cat = new Categoria();
		if( codiceInputParam == null || codiceInputParam.isEmpty() || descrizioneInputParam== null || descrizioneInputParam.isEmpty() || categoriaInputParam == null || categoriaInputParam.isEmpty() ||prezzo < 1 ) {
	    	  try {
	    		  request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
	    		  request.setAttribute("listaCategorieAttribute", MyServiceFactory.getCategoriaServiceInstance().listAll());
				 request.getRequestDispatcher("insert.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	  return;
	    	  
	      }
		
			cat.setIdCategoria(Long.parseLong(categoriaInputParam));
			
		
		

		//occupiamoci delle operazioni di business
		
		Articolo articoloInstance = new Articolo(codiceInputParam, descrizioneInputParam, prezzo, cat);
		try {
			MyServiceFactory.getArticoloServiceInstance().inserisciNuovo(articoloInstance);
			request.setAttribute("listaArticoliAttribute", MyServiceFactory.getArticoloServiceInstance().listAll());
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
		}

		//andiamo ai risultati
		request.getRequestDispatcher("results.jsp").forward(request, response);

	}

}
