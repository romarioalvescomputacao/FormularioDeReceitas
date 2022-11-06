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
				receitas.get(0).setHashtags("café", "indonésia", "bebida");
				receitas.get(1).setHashtags("ovos", "low-carb", "sem carne");
				receitas.get(2).setHashtags("almoço", "low-carb");
		
	}
	
	private List<Receita> getTodos(){
		return Collections.unmodifiableList(receitas);
	}
}
