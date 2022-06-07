package br.com.efcsconversores.tipos;

import java.util.Collection;
import java.util.LinkedHashSet;

public class ColecaoMedidas implements Listar {
	
	private Collection<Medida> listaMedidas = new LinkedHashSet<Medida>();

	private Medida km = new Medida("Quilometro", 1000);
	private Medida hm = new Medida("Hectometro", 100);
	private Medida dam = new Medida("Decametro", 10);
	private Medida m = new Medida("Metro", 1);
	private Medida dm = new Medida("Decimetro", 0.1);
	private Medida cm = new Medida("Centimetro", 0.01);
	private Medida mm = new Medida("Milimetro", 0.001);
	

	public ColecaoMedidas() {
		listaMedidas.add(km);
		listaMedidas.add(hm);
		listaMedidas.add(dam);
		listaMedidas.add(m);
		listaMedidas.add(dm);
		listaMedidas.add(cm);
		listaMedidas.add(mm);
	}	
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> Collection<T> listar() {
		return (Collection<T>) listaMedidas;
	}

}
