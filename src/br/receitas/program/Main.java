package br.receitas.program;

import java.awt.EventQueue;
import java.util.Scanner;

import br.receitas.gui.ReceitaFrame;
import br.receitas.model.Receita;
import br.receitas.model.ReceitaDao;

public class Main {
	private ReceitaDao dao = new ReceitaDao();
	Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> new Main().menuPrincipal());
	}
	
	public void menuPrincipal() {
		while (true) {
			System.out.println();
			System.out.println("1 - Criar receita");
			System.out.println("2 - Editar receita");
			System.out.println("3 - Sair");
			System.out.print("Escolha a opção: ");
			var opcao = Integer.parseInt(in.nextLine().trim());
			if (opcao == 1) {
				editar(null);
			} else if (opcao == 2) {
				menuEdicao();
			} else if (opcao == 3) {
				System.exit(0);
			} else {
				System.out.println("Opção inválida!");
			}
		}
	}
	
	private void menuEdicao() {
		System.out.println();
		System.out.println("Receitas:");
		dao.getTodos().forEach(r -> {
			System.out.printf(" %d - %s%n", r.getId(), r.getNome());
		});
		System.out.print("Digite o id da receita a ser editada: ");
		var id = Integer.parseInt(in.nextLine().trim());
		var receita = dao.getPorId(id);
		if (receita == null) {
			System.out.println("Receita inválida!");
		} else {
			editar(receita);
		}
	}
	
	private void editar(Receita receita) {
		ReceitaFrame frmReceita = new ReceitaFrame(receita);
		frmReceita.setVisible(true);
		if (frmReceita.isSalvo()) {
			dao.salvar(frmReceita.getReceita());
			System.out.println("Receita salva!");
		} else {
			System.out.println("Ação cancelada!");
		}
	}

}
