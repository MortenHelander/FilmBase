package filmbase.app;

import filmbase.data.Film;
import filmbase.data.Genre;
import filmbase.data.PlayList;
import filmbase.data.YearComparator;
import filmbase.service.FilmFileParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FilmBase {
    private List<Film> allFilms = new ArrayList<>();
    private List<Genre> allGenres = new ArrayList<>();
    private Map<Genre, Collection<Film>> genreFilms = new HashMap<>();

    public FilmBase() {

    }

    private void initFilms() {
        addFilm(new Film("Interstellar", 2014, Genre.ScienceFiction, Genre.Drama, Genre.Action));
        addFilm(new Film("Inception", 2010, Genre.ScienceFiction, Genre.Drama, Genre.Thriller));
        addFilm(new Film("El Laberinto del Fauno", 2006, Genre.Fantasy, Genre.Horror));
        addFilm(new Film("Lord of the Rings: The Fellowship of the Ring", 2001, Genre.Fantasy));
        addFilm(new Film("Lord of the Rings: The Two Towers", 2002, Genre.Fantasy));
        addFilm(new Film("Lord of the Rings: Return of the King", 2003, Genre.Fantasy));
        addFilm(new Film("The Godfather", 1972, Genre.Crime, Genre.Drama));
        addFilm(new Film("The Shawshank Redemption", 1994, Genre.Drama));
        addFilm(new Film("Schindler's List", 1993, Genre.Drama, Genre.War));
        addFilm(new Film("The Great Gatsby", 2013, Genre.Drama));
        addFilm(new Film("Love Actually", 2003, Genre.Romance, Genre.Comedy));
    }

    public void start() {
        System.out.println("FilmBasen er startet");
        loadFilms();
        printGenres();
        printGenreStatistics();


    }

    private void sortByYear(){
        List<Film> efterÅrstal = new ArrayList<>();
        efterÅrstal.addAll(allFilms);
        efterÅrstal.sort(new YearComparator().reversed());

        System.out.println("=== SORTERET EFTER ÅRSTAL ===");
        for (Film film : efterÅrstal) {
            System.out.println(film.getTitle() + " (" + film.getYear() + ")");
        }
    }

    private void printList(List<Film> films) {
        System.out.println("Printing list of all films:");
        for (Film f : films) {
            System.out.println(f.getTitle() + " (" + f.getYear() + ") " + f.getGenres());
        }
    }

    private void printGenreStatistics(){
        System.out.println("Der er " + allGenres.size() + " genrer i filmbasen");
        for(Genre genres : allGenres){
            System.out.println("- " + genres + ": " +genreFilms.get(genres).size());
        }
    }

    public void loadFilms(){
        var path = Path.of("C:\\Users\\morte\\OneDrive\\Dokumenter\\IdeaProjects\\FilmBase\\src\\movies.csv");
        try {
            List<String> lines = Files.readAllLines(path); //Lav en liste af strings af csv filen
            for(String line : lines){   //For loop af alle linjerne
                if(line.isBlank()) continue; //Spring tomme linjer over
                Film film = FilmFileParser.createFilmFromLine(line); //Lav et nyt film objekt med metoden
                addFilm(film); //Tilføj den nye film
            }
        } catch (IOException e) {
            System.out.println("Unexpected exception");
        }
    }


    private void addFilm(Film film) {
        this.allFilms.add(film);
        for (Genre genre : film.getGenres()) {
            if (!allGenres.contains(genre)) {
                allGenres.add(genre);
            }
        }
        for (Genre genre : film.getGenres()) {
            if (genreFilms.containsKey(genre)) {
                Collection<Film> allFilmsInThisGenre = genreFilms.get(genre);
                allFilmsInThisGenre.add(film);
            } else {
                Collection<Film> allFilmsInThisGenre = new ArrayList<>();
                allFilmsInThisGenre.add(film);

                genreFilms.put(genre, allFilmsInThisGenre);
            }
        }
    }

    private void printGenres(){
        System.out.println("Alle film på FilmBasen:");
        for (Genre genre : allGenres) {
            System.out.println(genre);

            Collection<Film> filmInThisGenre = genreFilms.get(genre);

            for (Film film : filmInThisGenre) {
                System.out.println(" - " + film.getTitle());
            }
        }
    }


}
