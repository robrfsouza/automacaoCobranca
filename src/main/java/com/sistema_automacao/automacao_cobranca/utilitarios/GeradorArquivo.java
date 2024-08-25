package com.sistema_automacao.automacao_cobranca.utilitarios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GeradorArquivo {

	private String arquivoCobranca;

	//constructor
	public GeradorArquivo(String arquivoCobranca) {
		this.arquivoCobranca = arquivoCobranca;
	}
	
	//metodos
	
	public void gerarArquivo (Date dtBoleta, double total, String mensagem) {
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoCobranca))){
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String dataFormatada = sdf.format(dtBoleta);
			
			String linha = dataFormatada + "|" + String.format("%.2f", total) + "|" + mensagem;
			
			writer.write(linha);
			
			System.out.println("Arquivo " + arquivoCobranca + " gerado com sucesso!");
			
			
		} catch (IOException e) {
			System.out.println("Erro ao gerar o arquivo: "+ e.getMessage());
		}
	}

}
