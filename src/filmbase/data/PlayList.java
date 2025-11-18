package filmbase.data;

import java.util.ArrayList;

public class PlayList {
    private ArrayList<Film>playlist = new ArrayList<>();

    public boolean addFilm(Film film){
        if(hasFilm(film)){
            System.out.println("Can't add "+film.getTitle() + " because it is already on the playlist");
            return false;
        }else {
            playlist.add(film);
            return true;
        }
    }

    public ArrayList<Film> getPlaylist() {
        return playlist;
    }

    public Film playNextFilm(){
        if(playlist.isEmpty()){
            System.out.println("Can't play next movie, because the playlist is empty");
            return null;
        }
        System.out.println("Now playing " + playlist.getFirst().getTitle() + "...");
        playlist.removeFirst();
        if(!playlist.isEmpty()) {
            return playlist.get(0);
        }else{
            return null;
        }
    }

    public boolean hasNext(){
        if(playlist.isEmpty()){
            System.out.println("The playlist is empty!");
            return false;
        }
        String next = playlist.getFirst().getTitle();
        System.out.println("Next up on the playlist is: " + next);
        return true;
    }

    public int playlistSize(){
        return playlist.size();
    }

    public String returnPlayList() {
        String list = "";
        if (playlist.isEmpty()) {
            return "Can't display playlist because it is empty";
        } else {
            for (Film f : playlist) {
                list += f.getTitle() + ", ";
            }
            return "Movies on the playlist: " + list;
        }
    }

    public boolean hasFilm(Film film){
        if(playlist.contains(film)){
            return true;
        }else{
            return false;
        }
    }

    public void removeAll(ArrayList<Film>films){
        playlist.removeAll(films);
    }

    public void removeGenre(Genre genre){
        playlist.removeIf( film -> film.hasGenre(genre));
    }

}
