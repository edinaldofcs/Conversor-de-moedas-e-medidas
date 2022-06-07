package br.com.efcsconversores.tipos;

public class Moeda {

	private String nome;
	private String sigla;
	
	public Moeda(String nome, String sigla){
		this.nome = nome;
		this.sigla = sigla;
	}	

	public String getNome() {
		return nome;
	}		
	
	@Override
	public String toString() {
		return this.nome;
	}

	public String getSigla() {
		return this.sigla;
	}	
	
}
