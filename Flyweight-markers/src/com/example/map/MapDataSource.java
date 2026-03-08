package com.example.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapDataSource {

    private static final String[] SHAPES = {"PIN", "CIRCLE", "SQUARE"};
    private static final String[] COLORS = {"RED", "GREEN", "BLUE", "YELLOW"};
    private static final int[] SIZES = {8, 10, 12, 16};

    public List<MapMarker> loadMarkers(int count) {
        List<MapMarker> result = new ArrayList<>(count);
        Random random = new Random(42); // deterministic

        for (int i = 0; i < count; i++) {
            double lat = -90 + 180 * random.nextDouble();
            double lng = -180 + 360 * random.nextDouble();
            String label = "M" + i;

            String shape = SHAPES[random.nextInt(SHAPES.length)];
            String color = COLORS[random.nextInt(COLORS.length)];
            int size = SIZES[random.nextInt(SIZES.length)];
            boolean filled = random.nextBoolean();

            // flyweight: get shared style from factory
            MarkerStyle style = MarkerStyleFactory.getStyle(shape, color, size, filled);

            MapMarker marker = new MapMarker(lat, lng, label, style);
            result.add(marker);
        }

        return result;
    }
}
