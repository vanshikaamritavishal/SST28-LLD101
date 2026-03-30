package services;

import models.Theatre;
import repositories.TheatreRepository;
import utils.IdGenerator;

import java.util.List;

public class TheatreService {
    private final TheatreRepository theatreRepository;

    public TheatreService(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    public Theatre addTheatre(String name, String city, String address) {
        Theatre theatre = new Theatre(IdGenerator.generateId(), name, city, address);
        theatreRepository.save(theatre);
        return theatre;
    }

    public List<Theatre> showTheatres(String city) {
        return theatreRepository.findByCity(city);
    }
}