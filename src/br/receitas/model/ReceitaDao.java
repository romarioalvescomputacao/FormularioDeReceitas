package br.receitas.model;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ReceitaDao {
	private List<Receita> receitas = new ArrayList<>();
	private long tempo = System.currentTimeMillis();
	private int gerarId() {
		return (int) (System.currentTimeMillis() - tempo);
	}
	
	public ReceitaDao() {
		AutorDao ad = new AutorDao();
		receitas.addAll(Arrays.asList(
				new Receita(1, LocalDate.of(2020, 9, 14),
				"Caf� Java", "INGREDIENTES\n1 colher de ch�...", ad.getPorId(1)),
				new Receita(2, LocalDate.of(2018, 7, 1),
				"Ovos poch�", "INGREDIENTES\n1 d�zia de ovos...", ad.getPorId(3)),
				new Receita(5, LocalDate.of(2020, 12, 30),
				"Bife acebolado", "INGREDIENTES\n1 cebola grande...", ad.getPorId(2))
				));
		
				Set<String> hashTags = new TreeSet<>();
				hashTags.add("caf�");
				hashTags.add("indon�sia");
				hashTags.add("bebida");
				receitas.get(0).setHashtags(hashTags);
				
				Set<String> hashTags2 = new TreeSet<>();
				hashTags2.add("ovos");
				hashTags2.add("low-carb");
				hashTags2.add("sem carne");
				receitas.get(1).setHashtags(hashTags2);
				
				Set<String> hashTags3 = new TreeSet<>();
				hashTags3.add("almo�o");
				hashTags3.add("low-carb");
				receitas.get(2).setHashtags(hashTags3);
		
	}
	
	public List<Receita> getTodos(){
		return Collections.unmodifiableList(receitas);
	}
	
	public Receita getPorId(int id) {
		return receitas.stream().filter(r -> r.getId() == id).findFirst().orElse(null);
	}
	
	public void salvar(Receita receita) {
		new AutorDao().salvar(receita.getAutor());
		
		if(receita.getId() == -1) {
			receita.setId(gerarId());
			receitas.add(receita);
		
		} else {
			excluir(receita);
			receitas.add(receita);
		}
	}
	
	public boolean excluir(Receita receita){
		//A receita nunca foi inserida? N�o h� o que excluir
		if(receita.getId() == -1) return false;
		
		//Tentamos remover a receita da lista
		int tamanho = receitas.size();
		receitas = receitas.stream().filter(a -> a.getId() != receita.getId()).collect(Collectors.toList());
		
		//O tamanho da lista diminuiu?
		if(receitas.size() < tamanho) {
			receita.setId(-1);
			return true;
		}
		
		//N�o foi poss�vel excluir?
		return false;
	}
}
