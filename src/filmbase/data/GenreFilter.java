package filmbase.data;

import java.util.function.Predicate;

public class GenreFilter implements Predicate<Film> {
    private Genre genre;

    public GenreFilter(Genre genre){
        this.genre = genre;
    }
    @Override
    public boolean test(Film film) {
        return film.hasGenre(genre);
    }
}
