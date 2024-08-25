package com.sistema_automacao.automacao_cobranca.utilitarios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatarData {
	private static final SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));

	public static String formatarData(Date data) {
		return dataFormatada.format(data);
	}

	public static Date parseData(String dataStr) {
		try {
			return dataFormatada.parse(dataStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return new Date(); // Retorna a data atual em caso de erro
		}
	}

}
