package br.com.efcsconversores.tipos;

public class Medida {

	private String nome;	
	private double medidaEmMetros;
	
	public Medida(String nome, double medida) {
		this.nome = nome;
		this.medidaEmMetros = medida;
	}	
	
	public double getMedidaEmMetros() {
		return medidaEmMetros;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
	
	public double converterMedida(Medida outraMedida, double valor) {
		
		if(outraMedida.getMedidaEmMetros() > this.medidaEmMetros) {
			return this.medidaEmMetros * valor / outraMedida.medidaEmMetros;
		}
		
		return this.medidaEmMetros / outraMedida.medidaEmMetros * valor;

	}
}
