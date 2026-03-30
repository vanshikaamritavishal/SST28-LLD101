import enums.PaymentMethod;
import enums.SeatType;
import models.*;
import repositories.*;
import services.*;
import utils.IdGenerator;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MovieRepository movieRepository = new MovieRepository();
        TheatreRepository theatreRepository = new TheatreRepository();
        ShowRepository showRepository = new ShowRepository();
        BookingRepository bookingRepository = new BookingRepository();
        UserRepository userRepository = new UserRepository();

        MovieService movieService = new MovieService(movieRepository);
        TheatreService theatreService = new TheatreService(theatreRepository);
        ShowService showService = new ShowService(showRepository, theatreRepository);
        PricingService pricingService = new PricingService();
        BookingService bookingService = new BookingService(bookingRepository, pricingService);

        Admin admin = new Admin(IdGenerator.generateId(), "Admin User", "admin@example.com");
        Customer customer = new Customer(IdGenerator.generateId(), "Vanshika", "vanshika@example.com");

        userRepository.save(admin);
        userRepository.save(customer);

        Movie movie1 = movieService.addMovie("Interstellar", "English", 169, "Sci-Fi", 200);
        Movie movie2 = movieService.addMovie("3 Idiots", "Hindi", 170, "Comedy-Drama", 180);

        Theatre theatre1 = theatreService.addTheatre("PVR Orion", "Bengaluru", "Rajajinagar");
        Theatre theatre2 = theatreService.addTheatre("INOX Forum", "Bengaluru", "Koramangala");

        Screen screen1 = new Screen(IdGenerator.generateId(), "Screen 1");
        screen1.addSeat(new Seat(IdGenerator.generateId(), "A1", SeatType.REGULAR));
        screen1.addSeat(new Seat(IdGenerator.generateId(), "A2", SeatType.REGULAR));
        screen1.addSeat(new Seat(IdGenerator.generateId(), "A3", SeatType.PREMIUM));
        screen1.addSeat(new Seat(IdGenerator.generateId(), "A4", SeatType.PREMIUM));

        theatre1.addScreen(screen1);
        theatre2.addScreen(screen1);

        Show show1 = showService.addShow(movie1, theatre1, screen1, LocalDateTime.of(2026, 4, 4, 19, 0));
        Show show2 = showService.addShow(movie2, theatre2, screen1, LocalDateTime.of(2026, 4, 5, 10, 0));

        System.out.println("Theatres in Bengaluru:");
        List<Theatre> theatres = theatreService.showTheatres("Bengaluru");
        theatres.forEach(System.out::println);

        System.out.println("\nMovies in Bengaluru:");
        List<Movie> movies = showService.showMovies("Bengaluru");
        movies.forEach(System.out::println);

        System.out.println("\nBooking ticket...");
        List<Seat> selectedSeats = Arrays.asList(
                screen1.getSeats().get(0),
                screen1.getSeats().get(1)
        );

        Ticket ticket = bookingService.bookTicket(customer, show1, selectedSeats, PaymentMethod.UPI);
        System.out.println("Booking successful!");
        System.out.println(ticket);
    }
}