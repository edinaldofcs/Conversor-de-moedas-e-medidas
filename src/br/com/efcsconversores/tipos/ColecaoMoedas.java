package br.com.efcsconversores.tipos;

import java.util.Collection;
import java.util.LinkedHashSet;

public class ColecaoMoedas implements Listar {

	private Collection<Moeda> listaDemoedas = new LinkedHashSet<Moeda>();

	private Moeda real = new Moeda("Real", "BRL");
	private Moeda dolar = new Moeda("Dolar", "USD");
	private Moeda euro = new Moeda("Euro", "EUR");
	private Moeda pesoArgentino = new Moeda("Peso Argentino", "ARS");
	private Moeda pesoUruguaio = new Moeda("Peso Uruguaio", "UYU");
	private Moeda libra = new Moeda("Libra", "GBP");
	private Moeda pesoColombiano = new Moeda("Peso Colombiano", "COP");
	private Moeda btc = new Moeda("Bitcoin", "BTC");

	public ColecaoMoedas() {
		listaDemoedas.add(btc);
		listaDemoedas.add(dolar);
		listaDemoedas.add(euro);
		listaDemoedas.add(libra);
		listaDemoedas.add(pesoArgentino);
		listaDemoedas.add(pesoColombiano);
		listaDemoedas.add(pesoUruguaio);
		listaDemoedas.add(real);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> Collection<T> listar() {
		return (Collection<T>) listaDemoedas;
	}

}
