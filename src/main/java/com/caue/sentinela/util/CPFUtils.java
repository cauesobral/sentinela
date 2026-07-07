package br.com.sentinela.utils;

import java.util.regex.Pattern;

public final class CPFUtils {

    private static final Pattern CPF_PATTERN =
            Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");

    private CPFUtils() {
        throw new UnsupportedOperationException("Classe utilitária.");
    }

    /**
     * Remove qualquer caractere que não seja número.
     */
    public static String unformat(String cpf) {
        if (cpf == null) {
            return null;
        }

        return cpf.replaceAll("\\D", "");
    }

    /**
     * Verifica se o CPF possui máscara.
     */
    public static boolean hasMask(String cpf) {
        if (cpf == null) {
            return false;
        }

        return CPF_PATTERN.matcher(cpf).matches();
    }

    /**
     * Aplica a máscara XXX.XXX.XXX-XX.
     */
    public static String format(String cpf) {
        cpf = unformat(cpf);

        if (cpf == null || cpf.length() != 11) {
            return cpf;
        }

        return cpf.replaceFirst(
                "(\\d{3})(\\d{3})(\\d{3})(\\d{2})",
                "$1.$2.$3-$4"
        );
    }

    /**
     * Valida um CPF.
     */
    public static boolean isValid(String cpf) {

        cpf = unformat(cpf);

        if (cpf == null || cpf.length() != 11) {
            return false;
        }

        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        int sum = 0;

        for (int i = 0; i < 9; i++) {
            sum += (cpf.charAt(i) - '0') * (10 - i);
        }

        int remainder = sum % 11;
        int digit1 = (remainder < 2) ? 0 : 11 - remainder;

        sum = 0;

        for (int i = 0; i < 10; i++) {

            int value;

            if (i == 9) {
                value = digit1;
            } else {
                value = cpf.charAt(i) - '0';
            }

            sum += value * (11 - i);
        }

        remainder = sum % 11;
        int digit2 = (remainder < 2) ? 0 : 11 - remainder;

        return digit1 == (cpf.charAt(9) - '0')
                && digit2 == (cpf.charAt(10) - '0');
    }

}