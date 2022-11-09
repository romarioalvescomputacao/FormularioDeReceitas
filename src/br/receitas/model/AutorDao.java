package br.receitas.model;

import java.util.*;
import java.util.stream.Collectors;

public class AutorDao {
	
	private List<Autor> autores = new ArrayList<>();
	private long tempo = System.currentTimeMillis();
	
	private int gerarId(){
		
		return(int) (System.currentTimeMillis() - tempo);
		
	}
	
	public AutorDao() {
		autores.addAll(Arrays.asList(
			new Autor(1, "Vinícius", "vinigodoy@java.net", "41 9876-5432"),
			new Autor(2, "Paula", "paulo@oracle.com", "62 9999-8877"),
			new Autor(3, "Joana", "joana@profhistoria.org", "11 9955-7744"),
			new Autor(4, "Maria", "carla.maria@edu.org", "11 9878-3443")
				
		));
				
	}
	
	private List<Autor> getTodos(){
	
		return Collections.unmodifiableList(autores);
		
	}

	public Autor getPorId(int id) {
	
		return autores.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
	
	}
	
	public void salvar(Autor autor) {
		
		if(autor == null) return;
		
		if(autor.getId() == -1) {
			autor.setId(gerarId());
			autores.add(autor);
		}else {
			
			excluir(autor);
			autores.add(autor);
			
		}
	}
	
	public boolean excluir (Autor autor) {
		int tamanho = autores.size();
		autores = autores.stream().filter(a -> a.getId() != autor.getId()).collect(Collectors.toList());
		
		if(autores.size() < tamanho) {
			autor.setId(-1);
			return true;
			
		};
		
		return false;
		
	}

}
