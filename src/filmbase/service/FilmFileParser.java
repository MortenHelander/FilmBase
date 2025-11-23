package filmbase.service;

import filmbase.app.FilmBase;
import filmbase.data.Film;
import filmbase.data.Genre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class FilmFileParser {


    public static Film createFilmFromLine(String line ){
        String[] split = line.split(";");
        String movieTitle = split[0].trim();
        int movieYear = Integer.parseInt(split[1].trim());
        Collection<Genre>genres = new ArrayList<>();
        String[] genreSplit = split[2].split(",");
        for (String s : genreSplit) {
            genres.add(Genre.valueOf(s.trim().replace("-", "")));
        }
        return new Film(movieTitle, movieYear, genres);
    }
}
