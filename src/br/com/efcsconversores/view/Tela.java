package br.com.efcsconversores.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.efcsconversores.tipos.ColecaoMedidas;
import br.com.efcsconversores.tipos.ColecaoMoedas;
import br.com.efcsconversores.tipos.CotacaoRequest;
import br.com.efcsconversores.tipos.Medida;
import br.com.efcsconversores.tipos.Moeda;



public class Tela<T> extends JFrame {

	private static final long serialVersionUID = 1L;

	private JLabel labelConversor, labelConvertido, labelQuantidade, labelResultado;
	private JTextField txtValor, txtResultado;
	private JComboBox<T> comboEscolha1;
	private JComboBox<T> comboExcolha2;
	private JButton botaoSalvar, botaoLimpar;

	@SuppressWarnings("unchecked")
	public Tela(Moeda moedaTemp, Medida medidaTemp) {
		super("Conversor");		
		
		String medidaOuMoeda = "moeda";
		if(moedaTemp == null) {
			medidaOuMoeda = "medida";
		}	
		String option = medidaOuMoeda;
		
		Container container = getContentPane();
		setLayout(null);

		labelConversor = new JLabel("Converter de:");
		labelConvertido = new JLabel("Para: ");
		labelQuantidade = new JLabel("Valor: ");
		labelResultado = new JLabel("Valor: ");

		
		labelConversor.setForeground(Color.BLACK);
		labelConvertido.setForeground(Color.BLACK);
		labelQuantidade.setForeground(Color.BLACK);

		// adicionar na tela
		container.add(labelConversor);
		container.add(labelConvertido);
		container.add(labelQuantidade);

		// campos de texto
		txtValor = new JTextField();
		txtResultado = new JTextField();
		comboEscolha1 = (JComboBox<T>) new JComboBox<Moeda>();
		comboExcolha2 = (JComboBox<T>) new JComboBox<Moeda>();

		// add categoria
		
		Collection<T> unidadeConversivel = null;
		if(option == "medida") {
			comboEscolha1.addItem((T) new Medida("Selecionar", 0));
			comboExcolha2.addItem((T) new Medida("Selecionar", 0));
			unidadeConversivel = (Collection<T>) new ColecaoMedidas().listar();
		}else {
			comboEscolha1.addItem((T) new Moeda("Selecionar", "-"));
			comboExcolha2.addItem((T) new Moeda("Selecionar", "-"));	
			unidadeConversivel = (Collection<T>) new ColecaoMoedas().listar();
		}
		

		for (T valor : unidadeConversivel) {
			comboEscolha1.addItem((T) valor);
			comboExcolha2.addItem((T) valor);
		}

		// left top width height
		labelConvertido.setBounds(30, 80, 240, 15);
		comboExcolha2.setBounds(115, 80, 110, 20);
		labelResultado.setBounds(220, 80, 240, 15);
		txtResultado.setBounds(280, 80, 90, 20);

		labelConversor.setBounds(30, 40, 240, 15);
		comboEscolha1.setBounds(115, 40, 110, 20);
		labelQuantidade.setBounds(240, 40, 240, 15);
		txtValor.setBounds(280, 40, 90, 20);

		container.add(txtValor);
		container.add(txtResultado);
		container.add(comboEscolha1);
		container.add(comboExcolha2);
		
		botaoSalvar = new JButton("Converter");
		botaoLimpar = new JButton("Limpar");

		botaoSalvar.setBounds(205, 145, 90, 20);
		botaoLimpar.setBounds(205, 185, 90, 20);

		container.add(botaoSalvar);
		container.add(botaoLimpar);

		txtResultado.setEditable(false);

		setSize(500, 400);
		setVisible(true);
		setLocationRelativeTo(null);

		botaoSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				converter(option);
			}
		});
		
		botaoLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});

	}

	private void converter(String option) {

		boolean heNumerico = validarNumero(txtValor.getText());		

		if (heNumerico && !txtValor.getText().equals("") && comboEscolha1.getSelectedIndex() != 0
				&& comboExcolha2.getSelectedIndex() != 0) {
			
			String numFormat = txtValor.getText();
			
			if(option == "medida") {
				Medida medida1 = (Medida) comboEscolha1.getSelectedItem();
				Medida medida2 = (Medida) comboExcolha2.getSelectedItem();
				Double valor = Double.parseDouble(numFormat.replace(',', '.'));
				Double valorConvertido = medida1.converterMedida(medida2, valor);
				//valorConvertido = Math.round(valorConvertido * 100.0) / 100.0;
				txtResultado.setEditable(true);
				txtResultado.setText("");
				txtResultado.setText(valorConvertido.toString());	
				
			}else {
				
				CotacaoRequest cotacao = new CotacaoRequest((Moeda) comboEscolha1.getSelectedItem(),
						(Moeda) comboExcolha2.getSelectedItem());
				
				Double novoValor = cotacao.getCotacao() * Double.parseDouble(numFormat.replace(',', '.'));
				novoValor = Math.round(novoValor * 100.0) / 100.0;
				txtResultado.setEditable(true);
				txtResultado.setText(novoValor.toString());				
			}

			
			txtResultado.setEditable(false);
			JOptionPane.showMessageDialog(this, "Conversão realizada com sucesso!!");

		} else {
			JOptionPane.showMessageDialog(this, "Verifique se todos os campos foram preenchidos adequadamente!");
		}
	}
	
	public void limpar() {
		txtResultado.setEditable(true);
		txtResultado.setText("");
		txtResultado.setEditable(false);
		txtValor.setText("");
		comboEscolha1.setSelectedIndex(0);
		comboExcolha2.setSelectedIndex(0);
	}

	public boolean validarNumero(String isNum) {
		try {
			String numFormat = isNum.replace(',', '.');
			@SuppressWarnings("unused")
			double num = Double.parseDouble(numFormat);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}