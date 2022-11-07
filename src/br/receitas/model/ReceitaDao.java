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
				"Café Java", "INGREDIENTES\n1 colher de chá...", ad.getPorId(1)),
				new Receita(2, LocalDate.of(2018, 7, 1),
				"Ovos poché", "INGREDIENTES\n1 dúzia de ovos...", ad.getPorId(3)),
				new Receita(5, LocalDate.of(2020, 12, 30),
				"Bife acebolado", "INGREDIENTES\n1 cebola grande...", ad.getPorId(2))
				));
		
				Set<String> hashTags = new TreeSet<>();
				hashTags.add("café");
				hashTags.add("indonésia");
				hashTags.add("bebida");
				receitas.get(0).setHashtags(hashTags);
				
				Set<String> hashTags2 = new TreeSet<>();
				hashTags2.add("ovos");
				hashTags2.add("low-carb");
				hashTags2.add("sem carne");
				receitas.get(1).setHashtags(hashTags2);
				
				Set<String> hashTags3 = new TreeSet<>();
				hashTags3.add("almoço");
				hashTags3.add("low-carb");
				receitas.get(2).setHashtags(hashTags3);
		
	}
	
	private List<Receita> getTodos(){
		return Collections.unmodifiableList(receitas);
	}
}
