package filmbase.data;

import java.util.function.Predicate;

public class DramaFilter implements Predicate<Film> {

    @Override
    public boolean test(Film film) {
        return film.hasGenre(Genre.Drama);
    }
}
