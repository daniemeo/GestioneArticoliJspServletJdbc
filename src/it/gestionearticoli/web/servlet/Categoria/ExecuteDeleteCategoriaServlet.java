package it.gestionearticoli.web.servlet.categoria;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.gestionearticoli.model.Categoria;
import it.gestionearticoli.service.MyServiceFactory;

/**
 * Servlet implementation class ExecuteDeleteCategoriaServlet
 */
@WebServlet("/ExecuteDeleteCategoriaServlet")
public class ExecuteDeleteCategoriaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExecuteDeleteCategoriaServlet() {
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
		String idCategoriaInput = request.getParameter("idCategoriaDainviare");
		if( idCategoriaInput== null || idCategoriaInput.isEmpty()) {
			try {
	  		  request.setAttribute("errorMessage", "Attenzione sono presenti errori di validazione");
	  		  request.setAttribute("listaCategorieAttribute", MyServiceFactory.getCategoriaServiceInstance().listAll());
				 request.getRequestDispatcher("ListaCategorieServlet").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  	  return;
	  	  
	    
		}
      Categoria categoria= new Categoria();
		
		try {
			
			categoria=MyServiceFactory.getCategoriaServiceInstance().findById(Long.parseLong(idCategoriaInput));
			MyServiceFactory.getCategoriaServiceInstance().rimuovi(categoria);
			
			
		} catch(SQLIntegrityConstraintViolationException ex ) {
			
			request.setAttribute("errorMessage", "Attenzione non puoi eliminare una categoria che ha articoli al suo interno!!");
			//System.out.println("catturata");
			request.getRequestDispatcher("ListaCategorieServlet").forward(request, response);
			//response.sendRedirect(request.getContextPath()+"/ListaCategorieServlet");
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/ListaCategorieServlet");
		
	}

}
