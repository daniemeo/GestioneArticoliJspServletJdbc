package it.gestionearticoli.dao.categoria;

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

public class CategoriaDAOImpl extends AbstractMySQLDAO implements CategoriaDAO {
	@Override
	public List<Categoria> list() throws Exception {
		if (isNotActive()) {
			return null;
		}

		ArrayList<Categoria> result = new ArrayList<Categoria>();
		Categoria categoriaTemp = null;

		try (Statement ps = connection.createStatement()) {
			ResultSet rs = ps.executeQuery("select * from categoria");

			while (rs.next()) {
				categoriaTemp = new Categoria();
				categoriaTemp.setIdCategoria(rs.getLong("idCategoria"));
				categoriaTemp.setNome(rs.getString("nome_categoria"));
				categoriaTemp.setDescrizioneCategoria(rs.getString("descrizione_categoria"));
				result.add(categoriaTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
	@Override
	public Categoria get(Long id) throws Exception {
		String query= "Select * from categoria where idCategoria= ?";
		Categoria categoria=new Categoria();
		ResultSet resultSet=null;
		
		
		try( PreparedStatement statement= connection.prepareStatement(query)){
			 
			statement.setLong(1, id);
			 resultSet = statement.executeQuery();

            if(resultSet.next()) {
                categoria = new Categoria();
                categoria.setIdCategoria(resultSet.getLong("idCategoria"));
                categoria.setNome(resultSet.getString("nome_categoria"));
                categoria.setDescrizioneCategoria(resultSet.getString("descrizione_categoria"));
                
                
            }
        
            
        
        } catch (SQLException e) {
            e.printStackTrace();
        
        }
        return categoria ;
                
	}
    
	@Override
	public int update(Categoria input) throws Exception {
		if (isNotActive() || input == null) {
			return -1;
		}

		   int result = 0;

	        String query = "UPDATE categoria SET nome_categoria = ?, descrizione_categoria = ? WHERE idCategoria = ?";
	        try (
	               
	                PreparedStatement preparedStatement = connection.prepareStatement(query)
	        ) {
	            preparedStatement.setString(1, input.getNome());
	            preparedStatement.setString(2, input.getDescrizioneCategoria());
	            preparedStatement.setLong(3, input.getIdCategoria());

	            result=preparedStatement.executeUpdate() ;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw e;
	        }
	        return result;
	 }
        	
	@Override
	public int insert(Categoria input) throws Exception {
		if (isNotActive() || input == null) {
			return -1;
		}

		int result = 0;

		try (PreparedStatement ps = connection
				.prepareStatement("INSERT INTO categoria (nome_categoria, descrizione_categoria) VALUES ( ?, ?);")) {
			ps.setString(1, input.getNome());
			ps.setString(2, input.getDescrizioneCategoria());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return result;
	}
	@Override
	public int delete(Categoria input) throws Exception {
		if (isNotActive())
			return 0;
		        String query = "DELETE FROM categoria WHERE idCategoria = ?";
		        
		        try (
		               
		                PreparedStatement preparedStatement = connection.prepareStatement(query)
		        ) {
		            preparedStatement.setLong(1, input.getIdCategoria());
		            return preparedStatement.executeUpdate()  ;
		        } 	            
		    
	}
	

	@Override
	public List<Categoria> findByExample(Categoria input) throws Exception {
		if (isNotActive()) {
			return null;
		}
		Categoria categoria= null;
		ArrayList<Categoria> result = new ArrayList<Categoria>();
		String query =" SELECT *  "
				+ " FROM categoria C "
				+ " where (C.nome_categoria like ? ) "
				+ " and (C.descrizione_categoria like ? ) "; 
				
		
		try (PreparedStatement ps = connection.prepareStatement(query)){
			ps.setString(1, "%" +  input.getNome()  + "%");
			ps.setString(2,"%" + input.getDescrizioneCategoria() + "%");
		
			
		    ResultSet results= ps.executeQuery();
		
	        while(results.next()) {
            categoria = new Categoria();
            categoria.setIdCategoria(results.getLong("idCategoria"));
            categoria.setNome(results.getString("nome_categoria"));
            categoria.setDescrizioneCategoria(results.getString("descrizione_categoria"));
            result.add(categoria);
        
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
	
	 public Categoria cercaNome(Long idCategoria) throws Exception {
		 String query = "SELECT *  FROM CATEGORIA WHERE idCategoria= ?";
		 Categoria categoria= new Categoria();
		 ResultSet rs = null;
		 
		 try( PreparedStatement statement= connection.prepareStatement(query)){
			 statement.setLong(1, idCategoria);
			 rs = statement.executeQuery();
			 
			 if(rs.next()) {
				 
				 categoria.setIdCategoria(rs.getLong("idCategoria"));
				 categoria.setNome(rs.getString("nome_categoria"));
				 
			 }
			 
		 } catch (SQLException e) {
	            e.printStackTrace();
	        
	        }
	        return categoria ;
	        
	 }
	 
	 public Categoria dettaglioCategoriaListaArticoli(Long idCategoria) throws Exception {
			if (isNotActive()) {
				return null;
			}
			String query= "SELECT A.CODICE, A.descrizione, A.prezzo , C.idCategoria, C.nome_categoria , C.descrizione_categoria\r\n"
					+ "FROM articolo A\r\n"
					+ "INNER JOIN categoria C ON A.categoria_fk = C.idCategoria\r\n"
					+ " WHERE C.idCategoria = ?";
			
			ArrayList<Articolo> listaArticoli = new ArrayList<Articolo>();
			
			
			ResultSet resultSet=null;
			 Categoria categoria= new Categoria();
			
			try( PreparedStatement statement= connection.prepareStatement(query)){
				 
				statement.setLong(1, idCategoria);
				 resultSet = statement.executeQuery();
				
	            while(resultSet.next()) {
	            	Articolo articolo= new Articolo();
	                articolo.setCodice(resultSet.getString("CODICE"));
	                articolo.setDescrizione(resultSet.getString("descrizione"));
	                articolo.setPrezzo(resultSet.getInt("prezzo"));
	                categoria.setIdCategoria(resultSet.getLong("idCategoria"));
	                categoria.setNome(resultSet.getString("nome_categoria"));
					categoria.setDescrizioneCategoria(resultSet.getString("descrizione_categoria"));
					
					 if((resultSet.getString("nome_categoria")) == null) {
		                	categoria.setNome("null");
		                }
					 articolo.setCategoria(categoria);
					 listaArticoli.add(articolo);
	            }
	        
	            
	        
	        } catch (SQLException e) {
	            e.printStackTrace();
	        
	        }
			categoria.setListaArticoli(listaArticoli);
	        return categoria ;
		}
	 
	
	
               
	
	

   



}
