package it.gestionearticoli.dao.categoria;

import it.gestionearticoli.dao.IBaseDAO;
import it.gestionearticoli.model.Categoria;

public interface CategoriaDAO extends IBaseDAO<Categoria>{
	public Categoria cercaNome(Long idCategoria) throws Exception;
	public Categoria dettaglioCategoriaListaArticoli(Long idCategoria) throws Exception;
}
