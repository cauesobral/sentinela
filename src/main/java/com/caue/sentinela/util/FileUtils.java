package br.com.sentinela.utils;

import java.io.File;
import java.util.UUID;

public final class FileUtils {

    private FileUtils() {
        throw new UnsupportedOperationException("Classe utilitária.");
    }

    // =========================
    // File name helpers
    // =========================

    public static String getFileName(String path) {
        if (path == null || path.isBlank()) {
            return null;
        }

        return path.substring(path.lastIndexOf("/") + 1)
                .substring(path.lastIndexOf("\\") + 1);
    }

    public static String getExtension(String fileName) {
        if (fileName == null || fileName.isBlank()) {
            return null;
        }

        int lastDot = fileName.lastIndexOf(".");

        if (lastDot == -1) {
            return "";
        }

        return fileName.substring(lastDot + 1).toLowerCase();
    }

    public static String getNameWithoutExtension(String fileName) {
        if (fileName == null || fileName.isBlank()) {
            return null;
        }

        int lastDot = fileName.lastIndexOf(".");

        if (lastDot == -1) {
            return fileName;
        }

        return fileName.substring(0, lastDot);
    }

    // =========================
    // Validation helpers
    // =========================

    public static boolean isPdf(String fileName) {
        return "pdf".equalsIgnoreCase(getExtension(fileName));
    }

    public static boolean isImage(String fileName) {
        String ext = getExtension(fileName);

        if (ext == null) {
            return false;
        }

        return ext.equalsIgnoreCase("png")
                || ext.equalsIgnoreCase("jpg")
                || ext.equalsIgnoreCase("jpeg")
                || ext.equalsIgnoreCase("gif")
                || ext.equalsIgnoreCase("webp");
    }

    public static boolean isEmpty(File file) {
        return file == null || file.length() == 0;
    }

    // =========================
    // Size helpers
    // =========================

    public static long sizeInBytes(File file) {
        if (file == null) {
            return 0;
        }

        return file.length();
    }

    public static double sizeInKB(long bytes) {
        return bytes / 1024.0;
    }

    public static double sizeInMB(long bytes) {
        return bytes / (1024.0 * 1024.0);
    }

    // =========================
    // Name generation
    // =========================

    public static String generateUniqueFileName(String originalFileName) {
        if (originalFileName == null) {
            return UUID.randomUUID().toString();
        }

        String extension = getExtension(originalFileName);

        String baseName = UUID.randomUUID().toString();

        if (extension == null || extension.isBlank()) {
            return baseName;
        }

        return baseName + "." + extension;
    }
}
