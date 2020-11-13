package it.gestionearticoli.dao.articolo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.gestionearticoli.dao.AbstractMySQLDAO;
import it.gestionearticoli.model.Articolo;
import it.gestionearticoli.model.Categoria;





public class ArticoloDAOImpl extends AbstractMySQLDAO implements ArticoloDAO {

	@Override
	public List<Articolo> list() throws Exception {
		if (isNotActive()) {
			return null;
		}

		ArrayList<Articolo> result = new ArrayList<Articolo>();
		Articolo articoloTemp = null;
       
		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery("SELECT * FROM articolo A\r\n"
					+ "inner join categoria C on c.idCategoria=A.categoria_fk");

			while (rs.next()) {
				articoloTemp = new Articolo();
				articoloTemp.setCodice(rs.getString("CODICE"));
				articoloTemp.setDescrizione(rs.getString("DESCRIZIONE"));
				articoloTemp.setPrezzo(rs.getInt("PREZZO"));
				articoloTemp.setId(rs.getLong("ID"));
				Categoria categoria= new Categoria();
				categoria.setNome(rs.getString("nome_categoria"));
				categoria.setDescrizioneCategoria(rs.getString("descrizione_categoria"));
				categoria.setIdCategoria(rs.getLong("idCategoria"));
				articoloTemp.setCategoria(categoria);
				result.add(articoloTemp);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public Articolo get(Long id) throws Exception {
		String query="Select * from articolo " + "left join categoria c on c.idCategoria = articolo.categoria_fk" + " where articolo.ID = ?";
		Articolo articolo=null;
		ResultSet resultSet=null;
		
		
		try( PreparedStatement statement= connection.prepareStatement(query)){
			 
			statement.setLong(1, id);
			 resultSet = statement.executeQuery();

            if(resultSet.next()) {
                articolo= new Articolo();
                articolo.setId(resultSet.getLong("id"));
                articolo.setCodice(resultSet.getString("codice"));
                articolo.setDescrizione(resultSet.getString("descrizione"));
                articolo.setPrezzo(resultSet.getInt("prezzo"));
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(resultSet.getLong("categoria_fk"));
                categoria.setNome(resultSet.getString("nome_categoria"));
                categoria.setDescrizioneCategoria(resultSet.getString("descrizione_categoria"));
                if((resultSet.getString("nome_categoria")) == null) {
                	categoria.setNome("null");
                }
                articolo.setCategoria(categoria);
            }
        
            
        
        } catch (SQLException e) {
            e.printStackTrace();
        
        }
        return articolo ;
                
	}



	@Override
	public int update(Articolo input) throws Exception {
		if (isNotActive() || input == null) {
			return -1;
		}

		   int result = 0;

	        String query = "UPDATE articolo\r\n"
	        		+ "inner join categoria on categoria.idCategoria = articolo.categoria_fk\r\n"
	        		+ "SET codice = ? , descrizione=? , prezzo=? , articolo.categoria_fk= ? \r\n"
	        		+ " WHERE id =? \r\n"
	        		+ "";
	        try (
	               
	                PreparedStatement preparedStatement = connection.prepareStatement(query)
	        ) {
	            preparedStatement.setString(1, input.getCodice());
	            preparedStatement.setString(2, input.getDescrizione());
	            preparedStatement.setInt(3,input.getPrezzo());   
	            preparedStatement.setLong(4, input.getCategoria().getIdCategoria());
	            preparedStatement.setLong(4, input.getId());

	            result=preparedStatement.executeUpdate() ;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw e;
	        }
	        return result;
	 }
        	
	

	@Override
	public int insert(Articolo input) throws Exception {
		if (isNotActive() || input == null) {
			return -1;
		}

		int result = 0;
		
        String query="INSERT INTO articolo (codice, descrizione, prezzo, categoria_fk) VALUES (?, ?, ?, ?)";
		try (PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, input.getCodice());
			ps.setString(2, input.getDescrizione());
			ps.setInt(3, input.getPrezzo());
			ps.setLong(4,input.getCategoria().getIdCategoria() );
			result = ps.executeUpdate();
			 ResultSet results= ps.getGeneratedKeys();
			 if(results.next()) {
	             	return results.getInt(1);
	             };
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}

	@Override
	public int delete(Articolo input) throws Exception {
		if (isNotActive())
			return 0;
		        String query = "DELETE FROM articolo WHERE id = ?";
		        
		        try (
		               
		                PreparedStatement preparedStatement = connection.prepareStatement(query)
		        ) {
		            preparedStatement.setLong(1, input.getId());
		            return preparedStatement.executeUpdate() ;
		        } catch (SQLException e) {
		            e.printStackTrace();
		            
		    
		    }
		    return 0;
	}
   
	@Override
	public List<Articolo> findByExample(Articolo input) throws Exception {
		if (isNotActive()) {
			return null;
		}
		Articolo articolo;
		ArrayList<Articolo> result = new ArrayList<Articolo>();
		String query ="SELECT * FROM articolo A left join categoria C on c.idCategoria=A.categoria_fk  where ( A.codice like  ? ) and (A.descrizione like ? ) ";
		try (PreparedStatement ps = connection.prepareStatement(query)){
			ps.setString(1, "%" + input.getCodice() + "%");
			ps.setString(2, "%" + input.getDescrizione() + "%" );
			
			
		   ResultSet results= ps.executeQuery();
		   
		   while(results.next()) {
               articolo= new Articolo();
               articolo.setId(results.getLong("id"));
               articolo.setCodice(  results.getString("codice") );
               articolo.setDescrizione( results.getString("descrizione") );
               articolo.setPrezzo(results.getInt("prezzo"));
               Categoria categoria = new Categoria();
               categoria.setIdCategoria(results.getLong("categoria_fk"));
               categoria.setNome(results.getString("nome_categoria"));
               categoria.setDescrizioneCategoria(results.getString("descrizione_categoria"));
               articolo.setCategoria(categoria);
               
               result.add(articolo);
           }
		   
	} catch (Exception e) {
		e.printStackTrace();
		throw e;
	}
	return result;
		
	}

	@Override
	public void setConnection(Connection connection) {
		this.connection = connection;

	}
 

	public List<Articolo> cercaNomePerCategoria(Long idCategoria) throws Exception {
		if (isNotActive()) {
			return null;
		}
		String query= "SELECT A.CODICE, A.descrizione, A.prezzo , C.idCategoria, C.nome_categoria , C.descrizione_categoria\r\n"
				+ "FROM articolo A\r\n"
				+ "INNER JOIN categoria C ON A.categoria_fk = C.idCategoria\r\n"
				+ " WHERE C.idCategoria = ?";
		
		ArrayList<Articolo> result = new ArrayList<Articolo>();
		
		
		ResultSet resultSet=null;
		
		
		try( PreparedStatement statement= connection.prepareStatement(query)){
			 
			statement.setLong(1, idCategoria);
			 resultSet = statement.executeQuery();
            
            while(resultSet.next()) {
            	Articolo articolo= new Articolo();
                articolo.setCodice(resultSet.getString("CODICE"));
                articolo.setDescrizione(resultSet.getString("descrizione"));
                articolo.setPrezzo(resultSet.getInt("prezzo"));
                Categoria categoria= new Categoria();
                categoria.setIdCategoria(resultSet.getLong("idCategoria"));
                categoria.setNome(resultSet.getString("nome_categoria"));
				categoria.setDescrizioneCategoria(resultSet.getString("descrizione_categoria"));
				
				 if((resultSet.getString("nome_categoria")) == null) {
	                	categoria.setNome("null");
	                }
				 articolo.setCategoria(categoria);
				 result.add(articolo);
            }
        
            
        
        } catch (SQLException e) {
            e.printStackTrace();
        
        }
        return result ;
	}
}
