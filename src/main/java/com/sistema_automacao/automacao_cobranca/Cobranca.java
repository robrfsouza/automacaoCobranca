package com.sistema_automacao.automacao_cobranca;

import java.util.Date;

import com.sistema_automacao.automacao_cobranca.utilitarios.FormatarData;
import com.sistema_automacao.automacao_cobranca.utilitarios.FormatarNumero;

public class Cobranca {
	private String contrato;
	private String mensagem;
	private int empresa;
	private Date dtVencimento;
	private Date dtBoleta;
	private String prestacao;
	private double indice;
	private double amortizacao;
	private double juros;
	private double seguro;
	private double desconto;

	// Generate Constructor
	public Cobranca(String contrato, int empresa, Date dtVencimento, Date dtBoleta, String prestacao, double indice,
			double amortizacao, double juros, double seguro, double desconto, String mensagem) {
		super();
		this.contrato = contrato;
		this.empresa = empresa;
		this.dtVencimento = dtVencimento;
		this.dtBoleta = dtBoleta;
		this.prestacao = prestacao;
		this.indice = indice;
		this.amortizacao = amortizacao;
		this.juros = juros;
		this.seguro = seguro;
		this.desconto = desconto;
		this.mensagem = mensagem;
	}

	public Double calcularEncargo() {
		return amortizacao + juros + seguro;
	}

	public long calcularDiasAtraso() {
		return (dtBoleta.getTime() - dtVencimento.getTime()) / (1000 * 60 * 60 * 24);
	}

	public Double calcularCorrecao() {
		double encargo = calcularEncargo();
		return (indice * encargo) - encargo;
	}

	public Double calcularMora() {
		double encargo = calcularEncargo();
		long diasAtraso = calcularDiasAtraso();
		return (diasAtraso > 0 ? diasAtraso * encargo * 0.000333 : 0);
	}

	public Double calcularMulta() {
		double encargo = calcularEncargo();
		return (calcularCorrecao() + encargo) * 0.02;
	}

	public Double calcularTotal() {
		return calcularEncargo() + calcularCorrecao() + calcularMora() + calcularMulta() - desconto;
	}

	public void imprimirMensagem() {
		double correcao = calcularCorrecao();
		double mora = calcularMora();
		double multa = calcularMulta();

		System.out.println("Vencimento: " + FormatarData.formatarData(dtVencimento)+ "Prestação: " + prestacao
		+ " Amortização: R$ " + FormatarNumero.formatarNumero(amortizacao)+ " Juros: R$ " + FormatarNumero.formatarNumero(juros) +
		" Seguro: R$ " + FormatarNumero.formatarNumero(seguro));

		if (correcao != 0 || mora != 0 || multa != 0 || desconto != 0) {
			System.out.println("Correção: R$ " + FormatarNumero.formatarNumero(correcao) + " Mora: R$ "
					+ FormatarNumero.formatarNumero(mora) + " Multa: R$ " + FormatarNumero.formatarNumero(multa)
					+ " Desconto: R$ " + FormatarNumero.formatarNumero(desconto));
		}

		System.out.println("WhatsApp 21-98233-9951 Ctr " + contrato);

		if (empresa == 1) {
			System.out.println("Recebimento por conta da Tradição Cia Imobiliária");
		} else {
			System.out.println(mensagem);
		}
	}
}
