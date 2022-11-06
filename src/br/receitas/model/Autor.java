package br.receitas.model;

public class Autor {
	private int id;
	private String nome;
	private String email;
	private String telefone;
	
	Autor(int id, String nome, String email, String telefone){
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;		
	}
	
	public Autor(String nome, String email, String telefone) {
		this(-1, nome, email, telefone);
	}
	
	public Autor (String nome) {
		this(nome, "", "");
		
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return this.nome;
	}

}
