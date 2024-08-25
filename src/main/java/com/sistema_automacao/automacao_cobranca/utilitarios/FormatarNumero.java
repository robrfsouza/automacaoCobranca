package com.sistema_automacao.automacao_cobranca.utilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class FormatarNumero {
    private static final NumberFormat numeroFormatado = new DecimalFormat("#,##0.00");
    public static String formatarNumero(double numero) {
        return numeroFormatado.format(numero);
    }
}
