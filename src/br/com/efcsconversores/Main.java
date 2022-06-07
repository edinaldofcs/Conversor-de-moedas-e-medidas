package br.com.efcsconversores;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import br.com.efcsconversores.tipos.Medida;
import br.com.efcsconversores.tipos.Moeda;
import br.com.efcsconversores.view.Tela;



public class Main {

	public static <T> void main(String[] args) {

		String option = "";
		try {

			option = (JOptionPane.showInputDialog(null, "Selecione uma opção: ", "Escolha de conversores", JOptionPane.PLAIN_MESSAGE,
					null, new Object[] { "Conversor de moedas", "Conversor de medidas" }, "Selecione")).toString();
		} catch (Exception e) {

		}

		if (option == "Conversor de medidas") {
			System.out.println(option);
			Tela<T> produtoCategoriaFrame = new Tela<T>(null, new Medida("-", 0));
			produtoCategoriaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} else if (option == "Conversor de moedas") {
			Tela<T> produtoCategoriaFrame = new Tela<T>(new Moeda("-", "-"), null);
			produtoCategoriaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}

}
