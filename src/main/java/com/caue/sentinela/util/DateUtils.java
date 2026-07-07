package br.com.sentinela.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public final class DateUtils {

    private static final DateTimeFormatter DATE_FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private DateUtils() {
        throw new UnsupportedOperationException("Classe utilitária.");
    }

    // =========================
    // Parse / Format
    // =========================

    public static LocalDate parseDate(String date) {
        if (date == null || date.isBlank()) {
            return null;
        }

        return LocalDate.parse(date, DATE_FORMATTER);
    }

    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }

        return date.format(DATE_FORMATTER);
    }

    public static LocalDateTime parseDateTime(String dateTime) {
        if (dateTime == null || dateTime.isBlank()) {
            return null;
        }

        return LocalDateTime.parse(dateTime, DATE_TIME_FORMATTER);
    }

    public static String format(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }

        return dateTime.format(DATE_TIME_FORMATTER);
    }

    // =========================
    // Current time helpers
    // =========================

    public static LocalDate today() {
        return LocalDate.now();
    }

    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    // =========================
    // Date arithmetic
    // =========================

    public static LocalDate addDays(LocalDate date, int days) {
        if (date == null) {
            return null;
        }

        return date.plusDays(days);
    }

    public static LocalDate addMonths(LocalDate date, int months) {
        if (date == null) {
            return null;
        }

        return date.plusMonths(months);
    }

    public static LocalDate addYears(LocalDate date, int years) {
        if (date == null) {
            return null;
        }

        return date.plusYears(years);
    }

    // =========================
    // Comparisons
    // =========================

    public static boolean isToday(LocalDate date) {
        return date != null && date.equals(LocalDate.now());
    }

    public static boolean isFuture(LocalDate date) {
        return date != null && date.isAfter(LocalDate.now());
    }

    public static boolean isPast(LocalDate date) {
        return date != null && date.isBefore(LocalDate.now());
    }

    // =========================
    // Calendar utilities
    // =========================

    public static boolean isWeekend(LocalDate date) {
        if (date == null) {
            return false;
        }

        switch (date.getDayOfWeek()) {
            case SATURDAY:
            case SUNDAY:
                return true;
            default:
                return false;
        }
    }

    public static LocalDate firstDayOfMonth(LocalDate date) {
        if (date == null) {
            return null;
        }

        return date.withDayOfMonth(1);
    }

    public static LocalDate lastDayOfMonth(LocalDate date) {
        if (date == null) {
            return null;
        }

        return date.withDayOfMonth(date.lengthOfMonth());
    }

    // =========================
    // Calculations
    // =========================

    public static int calculateAge(LocalDate birthDate) {
        if (birthDate == null) {
            return 0;
        }

        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public static long daysBetween(LocalDate start, LocalDate end) {
        if (start == null || end == null) {
            return 0;
        }

        return ChronoUnit.DAYS.between(start, end);
    }
}