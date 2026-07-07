package br.com.sentinela.utils;

import java.util.regex.Pattern;

public final class CNPJUtils {

    private static final Pattern CNPJ_PATTERN =
            Pattern.compile("\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}");

    private CNPJUtils() {
        throw new UnsupportedOperationException("Classe utilitária.");
    }

    /**
     * Remove qualquer caractere que não seja número.
     */
    public static String unformat(String cnpj) {
        if (cnpj == null) {
            return null;
        }

        return cnpj.replaceAll("\\D", "");
    }

    /**
     * Verifica se o CNPJ possui máscara.
     */
    public static boolean hasMask(String cnpj) {
        if (cnpj == null) {
            return false;
        }

        return CNPJ_PATTERN.matcher(cnpj).matches();
    }

    /**
     * Aplica a máscara XX.XXX.XXX/XXXX-XX.
     */
    public static String format(String cnpj) {
        cnpj = unformat(cnpj);

        if (cnpj == null || cnpj.length() != 14) {
            return cnpj;
        }

        return cnpj.replaceFirst(
                "(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})",
                "$1.$2.$3/$4-$5"
        );
    }

    /**
     * Valida um CNPJ.
     */
    public static boolean isValid(String cnpj) {

        cnpj = unformat(cnpj);

        if (cnpj == null || cnpj.length() != 14) {
            return false;
        }

        if (cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }

        int[] weight1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] weight2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

        int sum = 0;

        for (int i = 0; i < 12; i++) {
            sum += (cnpj.charAt(i) - '0') * weight1[i];
        }

        int remainder = sum % 11;
        int digit1 = (remainder < 2) ? 0 : 11 - remainder;

        sum = 0;

        for (int i = 0; i < 13; i++) {

            int value;

            if (i == 12) {
                value = digit1;
            } else {
                value = cnpj.charAt(i) - '0';
            }

            sum += value * weight2[i];
        }

        remainder = sum % 11;
        int digit2 = (remainder < 2) ? 0 : 11 - remainder;

        return digit1 == (cnpj.charAt(12) - '0')
                && digit2 == (cnpj.charAt(13) - '0');
    }

}