package Task_02;

import java.util.Comparator;

public class AgeComparator implements Comparator<Raccoon> {
    @Override
    public int compare(Raccoon o1, Raccoon o2) {
        return o1.getAge() - o2.getAge();
    }
}
