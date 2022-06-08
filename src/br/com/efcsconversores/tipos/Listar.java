package br.com.efcsconversores.tipos;

import java.util.Collection;

/**
 * Interface que representa para gerar um contrato de listagem, recebendo uma
 * moeda, ou uma unidade de medida
 * 
 * @author Edinaldo F. C .Santos
 * @version 0.1
 *
 */
public abstract interface Listar {
		
	public abstract <T> Collection<T> listar();
}
