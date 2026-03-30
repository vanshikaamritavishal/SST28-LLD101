package repositories;

import models.Movie;

import java.util.*;

public class MovieRepository {
    private final Map<String, Movie> movies = new HashMap<>();

    public void save(Movie movie) {
        movies.put(movie.getId(), movie);
    }

    public Movie findById(String id) {
        return movies.get(id);
    }

    public List<Movie> findAll() {
        return new ArrayList<>(movies.values());
    }
}