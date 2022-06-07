package br.com.efcsconversores.tipos;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CotacaoRequest {

	double cotacao;
	
	public CotacaoRequest(Moeda moeda1, Moeda moeda2) {
		try {
			atualizarCotacao(moeda1, moeda2);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void atualizarCotacao(Moeda de, Moeda para) throws IOException, InterruptedException, URISyntaxException {

		var url = "https://economia.awesomeapi.com.br/last/" + de.getSigla() + "-" + para.getSigla() + "";
		HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).header("Content-Type", "application/json")
				.GET().build();

		HttpClient httpClient = HttpClient.newHttpClient();
		var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

		setCotacao(obterCotacao(response.body()));
	}
	
	public static double obterCotacao(String req) {
	    String entrada = req;
	    String regexNum = "(bid\\\":\\\")(\\d{1,}\\.\\d{1,})";

	    Pattern padrao = Pattern.compile(regexNum);
	    Matcher matcher = padrao.matcher(entrada);
	    double valor = 0;

	    while (matcher.find()) {	    
	    	valor = Double.parseDouble(matcher.group(2));
	        valor = Math.round(valor*100.0)/100.0;
	        System.out.println(valor);
	    }
	    
	    return valor;
	    
	}
	
	public void setCotacao(double cotacao) {
		this.cotacao = cotacao;
	}

	public double getCotacao() {
		return this.cotacao;
	}	
	
}
