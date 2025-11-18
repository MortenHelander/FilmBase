package filmbase.app;

import filmbase.data.Film;
import filmbase.data.Genre;
import filmbase.data.PlayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FilmBase {
    private List<Film> allFilms = new ArrayList<>();

    public FilmBase(){

    }

    private void initFilms(){
        allFilms.add(new Film("Interstellar", 2014, Genre.ScienceFiction));
        allFilms.add(new Film("Inception", 2010, Genre.ScienceFiction));
        allFilms.add(new Film("El Laberinto del Fauno", 2006, Genre.Fantasy));
        allFilms.add(new Film("Lord of the Rings: The Fellowship of the Ring", 2001, Genre.Fantasy));
        allFilms.add(new Film("Lord of the Rings: The Two Towers", 2002, Genre.Fantasy));
        allFilms.add(new Film("Lord of the Rings: Return of the King", 2003, Genre.Fantasy));
        allFilms.add(new Film("The Godfather", 1972, Genre.Crime));
        allFilms.add(new Film("The Shawshank Redemption", 1994, Genre.Drama));
        allFilms.add(new Film("Schindler's List", 1993, Genre.Drama));
        allFilms.add(new Film("The Great Gatsby", 2013, Genre.Drama));
    }

    public void start(){
        System.out.println("FilmBasen er startet");
        initFilms();
        //printList(allFilms);
        testFiltering();
    }

    private void printList(List<Film>films){
        System.out.println("Printing list of all films:");
        for(Film f: films){
            System.out.println(f.getTitle() + " (" + f.getYear() + ") " + f.getGenre());
        }
    }

    private void testFiltering(){
        PlayList playlist = new PlayList();
        playlist.addFilm(allFilms.get(0));
        playlist.addFilm(allFilms.get(1));
        playlist.addFilm(allFilms.get(4));
        playlist.addFilm(allFilms.get(7));

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
