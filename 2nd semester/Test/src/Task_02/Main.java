package Task_02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Raccoon raccoon1 = new Raccoon("Обжоркин", 1);
        Raccoon raccoon2 = new Raccoon("Одноногий", 4);
        List list = new ArrayList();
        list.add(raccoon1);
        list.add(raccoon2);

        AgeComparator ac = new AgeComparator();
        NameComparator nc = new NameComparator();

        Raccoons raccoons = new Raccoons(list);

        Comparator<Raccoon> comparator = (Raccoon s1, Raccoon s2) -> s2.getAge() - s1.getAge();

        System.out.println(raccoon.top10(comparator, 2).toString());

    }
}
