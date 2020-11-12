package it.gestionearticoli.service.Articolo;

import java.util.List;

import it.gestionearticoli.dao.Articolo.ArticoloDAO;
import it.gestionearticoli.model.Articolo;

public interface ArticoloService {

	// questo mi serve per injection
	public void setArticoloDao(ArticoloDAO articoloDao);

	public List<Articolo> listAll() throws Exception;

	public Articolo findById(Long idInput) throws Exception;

	public int aggiorna(Articolo input) throws Exception;

	public int inserisciNuovo(Articolo input) throws Exception;

	public int rimuovi(Articolo input) throws Exception;

	public List<Articolo> findByExample(Articolo input) throws Exception;
	
	public List<Articolo> findNameCategoria(Long id) throws Exception;

}
