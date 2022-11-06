package br.receitas.model;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class Receita {
	private int id;
	private LocalDate data;
	private String nome;
	private String texto;
	private Set<String> hashTags = new TreeSet<>();
	private Autor autor;
	
	Receita(int id, LocalDate data, String nome, String texto, Autor autor) {
		this.id = id;
		this.data = data;
		this.nome = nome;
		this.texto = texto;
		this.autor = autor;
	}
	
	public Receita (String nome, String texto, Autor autor) {
		this(-1, LocalDate.now(), nome, texto, autor);
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData() {
		this.data = LocalDate.now();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Set<String> getHashTags() {
		return Collections.unmodifiableSet(hashTags);
	}

	public void setHashtags(Set<String> hashTags) {
		this.hashTags.clear();
		for(var hashtag : hashTags) {
			var hashFinal = hashtag.trim().toLowerCase();
			if(!hashFinal.isEmpty()) {
				this.hashTags.add(hashFinal);
			}
			
		}
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	public String toString() {
		return this.nome;
	}

	
	
	
}
