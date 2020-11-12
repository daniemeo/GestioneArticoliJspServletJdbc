package it.gestionearticoli.service.Utente;

import java.sql.Connection;
import java.util.List;

import it.gestionearticoli.connection.MyConnection;
import it.gestionearticoli.dao.Constants;
import it.gestionearticoli.dao.Utente.UtenteDAO;
import it.gestionearticoli.model.Utente;



public class UtenteServiceImpl implements UtenteService{
	private UtenteDAO utenteDao;
	
	@Override
	public void setUtenteDao(UtenteDAO utenteDao) {
		this.utenteDao = utenteDao;
	}
	
	@Override
	public List<Utente> listAll() throws Exception {
		return null;
	}
    

	@Override
	public Utente findById(Long idInput) throws Exception {
		return null;
	}
	
	@Override
	public int aggiorna(Utente input) throws Exception {
	 return 0;
	}

	@Override
	public int inserisciNuovo(Utente input) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int rimuovi(Utente input) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Utente> findByExample(Utente input) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente cercaPerUsernameEPassword(String username, String password) throws Exception {
			Utente utente =new Utente();
			try (Connection connection = MyConnection.getConnection(Constants.DRIVER_NAME, Constants.CONNECTION_URL)) {
			utenteDao.setConnection(connection);
			utente = utenteDao.findByUsernamePassword(username, password);
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
			
			return utente;
	}
	


}
