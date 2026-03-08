package com.example.map;

import java.util.List;

public class App {

    public static void main(String[] args) {
        MapDataSource dataSource = new MapDataSource();
        List<MapMarker> markers = dataSource.loadMarkers(20);

        System.out.println("Rendering markers...");
        for (MapMarker marker : markers) {
            marker.render();
        }

        System.out.println("Total markers: " + markers.size());
        System.out.println("Unique styles used: " +
                MarkerStyleFactory.getUniqueStyleCount());
    }
}
