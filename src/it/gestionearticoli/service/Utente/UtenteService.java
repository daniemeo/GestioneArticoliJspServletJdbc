package it.gestionearticoli.service.Utente;

import java.util.List;

import it.gestionearticoli.dao.Utente.UtenteDAO;
import it.gestionearticoli.model.Utente;

public interface UtenteService {
	
	public void setUtenteDao(UtenteDAO utenteDao);

	public List<Utente> listAll() throws Exception;

	public Utente findById(Long idInput) throws Exception;

	public int aggiorna(Utente input) throws Exception;

	public int inserisciNuovo(Utente input) throws Exception;

	public int rimuovi(Utente input) throws Exception;

	public List<Utente> findByExample(Utente input) throws Exception;
	
	public Utente cercaPerUsernameEPassword(String username, String password) throws Exception;
}
