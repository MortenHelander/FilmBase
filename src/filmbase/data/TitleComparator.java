package filmbase.data;

import java.util.Comparator;

public class TitleComparator implements Comparator<Film> {
    @Override
    public int compare(Film o1, Film o2) {
        return o1.getTitle().compareToIgnoreCase(o2.getTitle());
    }
}
