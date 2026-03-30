package services;

import models.Movie;
import repositories.MovieRepository;
import utils.IdGenerator;

public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(String title, String language, int duration, String genre, double basePrice) {
        Movie movie = new Movie(IdGenerator.generateId(), title, language, duration, genre, basePrice);
        movieRepository.save(movie);
        return movie;
    }
}