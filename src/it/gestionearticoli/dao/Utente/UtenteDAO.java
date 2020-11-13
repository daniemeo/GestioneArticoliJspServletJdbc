package it.gestionearticoli.dao.utente;

import it.gestionearticoli.dao.IBaseDAO;
import it.gestionearticoli.model.Utente;

public interface UtenteDAO extends IBaseDAO<Utente>{
	public Utente findByUsernamePassword(String username, String password) throws Exception;

}
