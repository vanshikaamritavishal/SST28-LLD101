package com.example.tickets;

public final class Validation {

    private Validation() {
    }

    public static void requireNonEmpty(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " must not be empty");
        }
    }

    public static void requireMaxLength(String value, int max, String fieldName) {
        if (value != null && value.length() > max) {
            throw new IllegalArgumentException(fieldName + " must be <= " + max + " characters");
        }
    }

    public static void requireValidId(String id) {
        requireNonEmpty(id, "id");
        requireMaxLength(id, 20, "id");
        if (!id.matches("[A-Z0-9-]+")) {
            throw new IllegalArgumentException("id must match [A-Z0-9-]+");
        }
    }

    public static void requireValidEmail(String email, String fieldName) {
        requireNonEmpty(email, fieldName);
        if (!email.contains("@") || email.startsWith("@") || email.endsWith("@")) {
            throw new IllegalArgumentException(fieldName + " must look like an email");
        }
    }

    public static void requirePriority(String value) {
        try {
            IncidentTicket.Priority.valueOf(value);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("priority must be one of LOW/MEDIUM/HIGH/CRITICAL");
        }
    }

    public static void requireRange(int value, int min, int max, String fieldName) {
        if (value < min || value > max) {
            throw new IllegalArgumentException(fieldName + " must be between " + min + " and " + max);
        }
    }
}
