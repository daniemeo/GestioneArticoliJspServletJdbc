package it.gestionearticoli.model;

import java.util.List;

public class Categoria {
	private Long idCategoria;
	private String nome;
	private String descrizioneCategoria;
	private List<Articolo> listaArticoli;

	public Categoria() {
	}

	public Categoria(Long idCategoria) {
		super();
		this.idCategoria = idCategoria;
	}

	public Categoria(String nome, String descrizioneCategoria) {
		this.nome = nome;
		this.descrizioneCategoria = descrizioneCategoria;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizioneCategoria() {
		return descrizioneCategoria;
	}

	public void setDescrizioneCategoria(String descrizioneCategoria) {
		this.descrizioneCategoria = descrizioneCategoria;
	}

	public String toString() {
		String s = nome;
		return s;
	}

	public List<Articolo> getListaArticoli() {
		return listaArticoli;
	}

	public void setListaArticoli(List<Articolo> listaArticoli) {
		this.listaArticoli = listaArticoli;
	}

}
