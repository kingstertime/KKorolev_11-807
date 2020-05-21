package Task_02;

import java.util.Comparator;

public class NameComparator implements Comparator<Raccoon> {
    @Override
    public int compare(Raccoon o1, Raccoon o2) {
        String name1 = o1.getName();
        String name2 = o2.getName();

        return name1.compareTo(name2);
    }
}
