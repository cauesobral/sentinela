package com.caue.sentinela.util;

public class StringUtils {
    public static String onlyNumbers(String value) {
        if (value == null) {
            return null;
        }

        return value.replaceAll("\\D", "");
    }
}
