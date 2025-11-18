package filmbase;

import filmbase.app.FilmBase;

import java.util.*;

public class Main{
    public static void main(String[] args) {
        /*
        FilmBase filmBase = new FilmBase();
        filmBase.start();

         */

        //Collection<String> names = new ArrayList<>();
        Set<String> names = new TreeSet<>();

        names.add("Olive");
        names.add("Morte");
        names.add("Morte");
        names.add("Joe");
        names.add("J.d Vance");
        names.add("Simon");

        for(String name : names){
            System.out.println(name);
        }
    }
}