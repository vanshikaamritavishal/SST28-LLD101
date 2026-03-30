package repositories;

import models.Show;

import java.util.*;

public class ShowRepository {
    private final Map<String, Show> shows = new HashMap<>();

    public void save(Show show) {
        shows.put(show.getId(), show);
    }

    public Show findById(String id) {
        return shows.get(id);
    }

    public List<Show> findAll() {
        return new ArrayList<>(shows.values());
    }
}