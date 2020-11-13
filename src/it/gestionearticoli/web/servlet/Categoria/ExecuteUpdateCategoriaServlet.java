package it.gestionearticoli.web.servlet.categoria;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestionearticoli.model.Categoria;
import it.gestionearticoli.service.MyServiceFactory;

/**
 * Servlet implementation class ExecuteUpdateCategoriaServlet
 */
@WebServlet("/ExecuteUpdateCategoriaServlet")
public class ExecuteUpdateCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteUpdateCategoriaServlet() {
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
		 Categoria categoria;
		try {
			categoria = MyServiceFactory.getCategoriaServiceInstance().findById(Long.parseLong(request.getParameter("idCategoriaDainviare")));
			
			categoria.setNome(request.getParameter("nome")); 
			categoria.setDescrizioneCategoria(request.getParameter("descrizione"));
			MyServiceFactory.getCategoriaServiceInstance().aggiorna(categoria);
			request.setAttribute("listaCategorieAttribute",MyServiceFactory.getCategoriaServiceInstance().listAll() );
			request.setAttribute("successMessage", "Operazione effettuata con successo");
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("categorie.jsp").forward(request, response);
	
	}

}
