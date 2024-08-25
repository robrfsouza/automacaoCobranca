package com.sistema_automacao.automacao_cobranca;

import java.util.Date;
import java.util.Scanner;

import com.sistema_automacao.automacao_cobranca.utilitarios.FormatarData;
import com.sistema_automacao.automacao_cobranca.utilitarios.FormatarNumero;
import com.sistema_automacao.automacao_cobranca.utilitarios.GeradorArquivo;

public class AutomacaoCobranca {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		//Entrada de dados do usuario
		System.out.print("Contrato: ");
		String contrato = scanner.nextLine();
		
		System.out.print("Número da empresa: ");
		int empresa = scanner.nextInt();
		
		System.out.print("Data de vencimento: (dd/MM/yyyy): ");
		Date dtVencimento = FormatarData.parseData(scanner.next());
		
		System.out.print("Data da boleta: (dd/MM/yyyy): ");
		Date dtBoleta = FormatarData.parseData(scanner.next());
		scanner.nextLine();
		
		System.out.print("Prestacao: ");
		String prestacao = scanner.nextLine();
		
		System.out.print("Índice: ");
		double indice = scanner.nextDouble();
		
		System.out.print("Amortização: R$ ");
		double amortizacao = scanner.nextDouble();
		
		System.out.print("Juros: R$ ");
		double juros = scanner.nextDouble();
		
		System.out.print("Seguro: R$ ");
		double seguro = scanner.nextDouble();
		
		System.out.print("Desconto (caso nao tenha digite ) R$ ");
		double desconto = scanner.nextDouble();
		
		System.out.println("Mensagem: ");
		String mensagem = scanner.nextLine();
		//Criando o objeto Cobranca e imprimindo mensagem
		
		Cobranca cobranca = new Cobranca (contrato, empresa, dtVencimento, dtBoleta, prestacao, indice, amortizacao, juros,
				seguro, desconto, mensagem);
		System.out.println("Total R$ "+ FormatarNumero.formatarNumero(cobranca.calcularTotal()));
		cobranca.imprimirMensagem();
		
		GeradorArquivo gerador = new GeradorArquivo("Cobranca.txt");
		gerador.gerarArquivo(dtBoleta, cobranca.calcularTotal(), mensagem);
		
		
		scanner.close();
		
		//end
	}
}
