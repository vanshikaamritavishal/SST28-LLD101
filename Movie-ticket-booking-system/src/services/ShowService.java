package services;

import models.Movie;
import models.Screen;
import models.Show;
import models.Theatre;
import repositories.ShowRepository;
import repositories.TheatreRepository;
import utils.IdGenerator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ShowService {
    private final ShowRepository showRepository;
    private final TheatreRepository theatreRepository;

    public ShowService(ShowRepository showRepository, TheatreRepository theatreRepository) {
        this.showRepository = showRepository;
        this.theatreRepository = theatreRepository;
    }

    public Show addShow(Movie movie, Theatre theatre, Screen screen, LocalDateTime startTime) {
        Show show = new Show(IdGenerator.generateId(), movie, theatre, screen, startTime);
        showRepository.save(show);
        return show;
    }

    public List<Show> getShowsByCity(String city) {
        List<Show> result = new ArrayList<>();
        for (Show show : showRepository.findAll()) {
            if (show.getTheatre().getCity().equalsIgnoreCase(city)) {
                result.add(show);
            }
        }
        return result;
    }

    public List<Movie> showMovies(String city) {
        List<Movie> movies = new ArrayList<>();
        for (Show show : showRepository.findAll()) {
            if (show.getTheatre().getCity().equalsIgnoreCase(city)) {
                if (!movies.contains(show.getMovie())) {
                    movies.add(show.getMovie());
                }
            }
        }
        return movies;
    }

    public Show getShowById(String showId) {
        return showRepository.findById(showId);
    }
}