package filmbase.app;

import filmbase.data.Film;
import filmbase.data.PlayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FilmBase {
    private List<Film> allFilms = new ArrayList<>();

    public FilmBase(){

    }

    private void initFilms(){
        allFilms.add(new Film("Interstellar", 2014));
        allFilms.add(new Film("Inception", 2010));
        allFilms.add(new Film("El Laberinto del Fauno", 2006));
        allFilms.add(new Film("Lord of the Rings: The Fellowship of the Ring", 2001));
        allFilms.add(new Film("Lord of the Rings: The Two Towers", 2002));
        allFilms.add(new Film("Lord of the Rings: Return of the King", 2003));
        allFilms.add(new Film("The Godfather", 1972));
        allFilms.add(new Film("The Shawshank Redemption", 1994));
        allFilms.add(new Film("Schindler's List", 1993));
        allFilms.add(new Film("The Great Gatsby", 2013));
    }

    public void start(){
        System.out.println("FilmBasen er startet");
        initFilms();
        //printList(allFilms);
        testPlayList();
    }

    private void printList(Collection<Film>films){
        System.out.println("Printing list of all films:");
        for(Film f: films){
            System.out.println(f.getTitle() + ", " + f.getYear());
        }
    }

    private void testPlayList(){
        PlayList playList = new PlayList();
        playList.addFilm(allFilms.get(1));
        playList.addFilm(allFilms.get(4));
        playList.addFilm(allFilms.get(7));
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
