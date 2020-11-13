package it.gestionearticoli.dao.utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import it.gestionearticoli.dao.AbstractMySQLDAO;
import it.gestionearticoli.model.Utente;

public class UtenteDAOImpl extends AbstractMySQLDAO implements UtenteDAO {

	@Override
	public List<Utente> list() throws Exception{
		return null;
	}
	
	@Override
	public Utente get(Long id) throws Exception {
		return null;
	}
	@Override
	public int update(Utente input) throws Exception{
		return 0;
	}
    
	@Override
	public int insert(Utente input) throws Exception{
		return 0;
	}
    
	@Override
	public int delete(Utente input) throws Exception{
		return 0;
	}
    
	@Override
	public List<Utente> findByExample(Utente input) throws Exception{
		return null;
	}
	
	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public Utente findByUsernamePassword(String username, String password) throws Exception {
		if (isNotActive()) {
			return null;
		}
		String query= "SELECT * FROM utente WHERE username= ? and password= ?";
		Utente utente= null;
		ResultSet resultSet=null;

		try( PreparedStatement statement= connection.prepareStatement(query)){
			 
			statement.setString(1, username);
			statement.setString(2, password);
			 resultSet = statement.executeQuery();

            if(resultSet.next()) {
            	utente=new Utente();
                utente.setIdUtente(resultSet.getLong("id_utente"));
                utente.setNome(resultSet.getString("nome"));
                utente.setCognome(resultSet.getString("cognome"));
                utente.setCodiceFiscale(resultSet.getString("cofice_fiscale"));
                utente.setUsername(resultSet.getString("username"));
                utente.setPassword(resultSet.getString("password"));
                utente.setRuolo(resultSet.getString("ruolo"));
            }
            
		 } catch (SQLException e) {
	            e.printStackTrace();
	        
	        }
	        return utente ;
		}

}
		
	
   
