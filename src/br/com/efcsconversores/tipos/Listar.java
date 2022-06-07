package br.com.efcsconversores.tipos;

import java.util.Collection;

public abstract interface Listar {
		
	public abstract <T> Collection<T> listar();
}
