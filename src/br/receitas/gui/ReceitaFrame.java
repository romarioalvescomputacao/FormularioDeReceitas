package br.receitas.gui;


import br.receitas.model.Autor;
import br.receitas.model.Receita;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.*;
import java.util.Set;
import java.util.TreeSet;

public class ReceitaFrame extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3720111391981295379L;
	private JTextField txtData;
	private JTextField txtNome;
	private JTextField txtAutor;
	private JTextField txtHashtags;
	private JTextArea txtTexto;
	private Receita receita;
	private boolean salvo = false;
	
	private JPanel criarPainelSuperior() {
		
		var pnl = new JPanel(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(5,5,5,5);
		gc.gridx = 0;
		
		
		//Labels
		gc.gridy = 0;
		pnl.add(new JLabel("Data:"), gc);
		
		gc.gridy = 1;
		pnl.add(new JLabel("Nome:"), gc);
		
		gc.gridy = 2;
		pnl.add(new JLabel("Autor:"), gc);
		
		gc.gridy = 3;
		pnl.add(new JLabel("Hashtags:"), gc);
		
		gc.gridy = 4;
		pnl.add(new JLabel("Texto:"), gc);
		
		
		//Componentes
		gc.anchor = GridBagConstraints.LINE_END;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridx = 1;
		gc.weightx = 3;
		
		txtData = new JTextField();
		txtData.setEditable(false);
		gc.gridy = 0;
		pnl.add(txtData, gc);
		
		txtNome = new JTextField();
		gc.gridy = 1;
		pnl.add(txtNome, gc);
		
		txtAutor = new JTextField();
		gc.gridy = 2;
		pnl.add(txtAutor, gc);
		
		txtHashtags = new JTextField();
		gc.gridy = 3;
		pnl.add(txtHashtags, gc);
		
		return pnl;
		
	}
	private JPanel criarPainelBotoes() {
		var pnl = new JPanel(new FlowLayout(FlowLayout.TRAILING));
		
		var btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(e -> {
			salvo = true; 
			this.dispose();
		});
		pnl.add(btnSalvar);
		
		var btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(e -> this.dispose());
		pnl.add(btnCancel);
		
		return pnl;
	}
	
	//Em seguida, vamos criar o método preencher, que preenche a tela 
	//com base nesse objeto associado:
	
	private void preencher() {
		var fmt = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		txtData.setText(receita.getData().format(fmt));
		txtNome.setText(receita.getNome());
		txtTexto.setText(receita.getTexto());
		if (receita.getAutor() != null) {
		txtAutor.setText(receita.getAutor().getNome());
		}
		txtHashtags.setText(String.join(", ", receita.getHashtags()));
		
	}
	
	
	
	public ReceitaFrame(Receita receita) {
		setModal(true);
		setTitle("Editar receita");
		setSize(400, 480);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		add(criarPainelSuperior(), BorderLayout.PAGE_START);
		txtTexto = new JTextArea();
		txtTexto.setLineWrap(true);
		txtTexto.setWrapStyleWord(true);
		add(txtTexto, BorderLayout.CENTER);
		add(criarPainelBotoes(), BorderLayout.PAGE_END);
		
		if(receita == null) {
			this.receita = new Receita("", "", null);
		}else {
			this.receita = receita;
			
		}
		
		preencher();
	}
	
	public Receita getReceita() {
		receita.setNome(txtNome.getText());
		receita.setTexto(txtTexto.getText());
		receita.setAutor(new Autor(txtAutor.getText()));
		Set<String> hashTags = new TreeSet<>();
		hashTags.add(", ");
		receita.setHashtags(hashTags);
		return receita;
		
	}
	public boolean isSalvo() {
		// TODO Stub de método gerado automaticamente
		return salvo;
	}
	
	
}

