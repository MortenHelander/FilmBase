package filmbase.app;

import filmbase.data.Film;
import filmbase.data.Genre;
import filmbase.data.PlayList;
import filmbase.data.YearComparator;
import java.util.*;

public class FilmBase {
    private List<Film> allFilms = new ArrayList<>();
    private List<Genre>allGenres = new ArrayList<>();
    private Map<Genre, Film> genreFilms = new TreeMap<>();

    public FilmBase(){

    }

    private void initFilms(){
        allFilms.add(new Film("Interstellar", 2014, Genre.ScienceFiction, Genre.Drama, Genre.Action));
        allFilms.add(new Film("Inception", 2010, Genre.ScienceFiction, Genre.Drama, Genre.Thriller));
        allFilms.add(new Film("El Laberinto del Fauno", 2006, Genre.Fantasy, Genre.Horror));
        allFilms.add(new Film("Lord of the Rings: The Fellowship of the Ring", 2001, Genre.Fantasy));
        allFilms.add(new Film("Lord of the Rings: The Two Towers", 2002, Genre.Fantasy));
        allFilms.add(new Film("Lord of the Rings: Return of the King", 2003, Genre.Fantasy));
        allFilms.add(new Film("The Godfather", 1972, Genre.Crime, Genre.Drama ));
        allFilms.add(new Film("The Shawshank Redemption", 1994, Genre.Drama ));
        allFilms.add(new Film("Schindler's List", 1993, Genre.Drama, Genre.War ));
        allFilms.add(new Film("The Great Gatsby", 2013, Genre.Drama ));
        allFilms.add(new Film("Love Actually", 2003, Genre.Romance, Genre.Comedy));
    }

    public void start(){
        System.out.println("FilmBasen er startet");
        initFilms();
        countGenres();
        sortGenres();

        List<Film> efterÅrstal = new ArrayList<>();
        efterÅrstal.addAll(allFilms);
        efterÅrstal.sort(new YearComparator().reversed());

        System.out.println("=== SORTERET EFTER ÅRSTAL ===");
        for(Film film : efterÅrstal){
            System.out.println(film.getTitle() + " (" + film.getYear() + ")");
        }
    }

    private void countGenres(){

        Set<Genre> allGenres = new HashSet<>();

        Map<Genre, Collection<Film>> genreFilms = new HashMap<>();

        for(Film film : allFilms){
            allGenres.addAll(film.getGenres());

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

        System.out.println("Alle film på FilmBasen:");
        for(Genre genre : allGenres){
            System.out.println(genre);

            Collection<Film> filmInThisGenre = genreFilms.get(genre);

            for ( Film film : filmInThisGenre){
                System.out.println(" - " + film.getTitle());
            }
        }

    }

    private void printList(List<Film>films){
        System.out.println("Printing list of all films:");
        for(Film f: films){
            System.out.println(f.getTitle() + " (" + f.getYear() + ") " + f.getGenres());
        }
    }

    private void sortGenres(){
        for(Film film : allFilms){
            for(Genre genre : allGenres){
                genreFilms.put(genre, film);
            }
        }
        System.out.println(genreFilms);
    }

    private void testFiltering(){
        PlayList playlist = new PlayList();
        playlist.addFilm(allFilms.get(0));
        playlist.addFilm(allFilms.get(1));
        playlist.addFilm(allFilms.get(4));
        playlist.addFilm(allFilms.get(7));

        printList(playlist.getPlaylist());
        playlist.removeGenre(Genre.Drama);
        printList(playlist.getPlaylist());
    }

    private void testPlayList(){
        PlayList playList = new PlayList();
        playList.addFilm(allFilms.get(1));
        playList.addFilm(allFilms.get(1));
        playList.addFilm(allFilms.get(4));
        playList.addFilm(allFilms.get(7));
        printList(playList.getPlaylist());
        System.out.println(playList.returnPlayList());
        System.out.println(playList.hasNext());
        playList.playNextFilm();
        System.out.println(playList.returnPlayList());
        playList.playNextFilm();
        System.out.println(playList.returnPlayList());
        playList.playNextFilm();
        System.out.println(playList.returnPlayList());
    }
}
