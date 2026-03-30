package repositories;

import models.Theatre;

import java.util.*;

public class TheatreRepository {
    private final Map<String, Theatre> theatres = new HashMap<>();

    public void save(Theatre theatre) {
        theatres.put(theatre.getId(), theatre);
    }

    public Theatre findById(String id) {
        return theatres.get(id);
    }

    public List<Theatre> findAll() {
        return new ArrayList<>(theatres.values());
    }

    public List<Theatre> findByCity(String city) {
        List<Theatre> result = new ArrayList<>();
        for (Theatre theatre : theatres.values()) {
            if (theatre.getCity().equalsIgnoreCase(city)) {
                result.add(theatre);
            }
        }
        return result;
    }
}