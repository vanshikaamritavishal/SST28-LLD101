package models;

public class Movie {
    private String id;
    private String title;
    private String language;
    private int durationInMinutes;
    private String genre;
    private double basePrice;

    public Movie(String id, String title, String language, int durationInMinutes, String genre, double basePrice) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.durationInMinutes = durationInMinutes;
        this.genre = genre;
        this.basePrice = basePrice;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLanguage() {
        return language;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public String getGenre() {
        return genre;
    }

    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return "Movie{id='" + id + "', title='" + title + "', language='" + language +
                "', duration=" + durationInMinutes + ", genre='" + genre +
                "', basePrice=" + basePrice + "}";
    }
}