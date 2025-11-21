package filmbase.data;

import java.util.Comparator;

public class YearComparator implements Comparator<Film> {
    @Override
    public int compare(Film o1, Film o2) {
        if( o1.getYear() < o2.getYear()) {
            return -1;
        }else if( o1.getYear() > o2.getYear()){
            return 1;
        }else{
            return 0;
        }

    }
}
