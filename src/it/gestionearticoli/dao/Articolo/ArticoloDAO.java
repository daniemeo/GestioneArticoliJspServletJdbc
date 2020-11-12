package it.gestionearticoli.dao.Articolo;

import java.util.List;

import it.gestionearticoli.dao.IBaseDAO;
import it.gestionearticoli.model.Articolo;

public interface ArticoloDAO extends IBaseDAO<Articolo> {

	public List<Articolo> cercaNomePerCategoria(Long input) throws Exception;
}
