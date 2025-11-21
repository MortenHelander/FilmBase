package filmbase.data;

import java.util.*;

public class Film {
    private String title;
    private int year;
    private Set<Genre> genres = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Film film)) return false;
        return year == film.year && Objects.equals(title, film.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year);
    }

    public Film(String title, int year, Genre... genres) {
        this.title = title;
        this.year = year;
        this.genres.addAll(List.of(genres));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Collection<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre>genres) {
        this.genres=genres;
    }

    public boolean hasGenre(Genre genre){
        return this.genres.contains(genre);
    }

    public void addGenre(Genre genre){
        this.genres.add(genre);
    }

    @Override
    public String toString() {
        return title + " (" + year + ") ";
    }
}
