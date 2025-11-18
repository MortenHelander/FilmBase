package filmbase.data;

import java.util.ArrayList;
import java.util.Collection;

public class Film {
    private String title;
    private int year;
    private Collection<Genre>genres = new ArrayList<>();

    public Film(String title, int year, Genre genre) {
        this.title = title;
        this.year = year;
        this.genres.add(genre);
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

    public void setGenres(Collection<Genre>genres) {
        this.genres=genres;
    }

    public boolean hasGenre(Genre genre){
        return this.genres.contains(genre);
    }
}
