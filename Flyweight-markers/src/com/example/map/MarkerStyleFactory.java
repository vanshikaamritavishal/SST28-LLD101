package com.example.map;

import java.util.HashMap;
import java.util.Map;

public class MarkerStyleFactory {

    private static final Map<String, MarkerStyle> CACHE = new HashMap<>();

    private MarkerStyleFactory() {
    }

    private static String buildKey(String shape, String color, int size, boolean filled) {
        // e.g. "PIN|RED|12|F"
        return shape + "|" + color + "|" + size + "|" + (filled ? "F" : "O");
    }

    public static MarkerStyle getStyle(String shape, String color, int size, boolean filled) {
        String key = buildKey(shape, color, size, filled);
        MarkerStyle style = CACHE.get(key);
        if (style == null) {
            style = new MarkerStyle(shape, color, size, filled);
            CACHE.put(key, style);
        }
        return style;
    }

    public static int getUniqueStyleCount() {
        return CACHE.size();
    }
}
