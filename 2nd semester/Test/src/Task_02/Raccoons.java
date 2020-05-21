package Task_02;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Raccoons {
    private List<Raccoon> list;

    public Raccoons(List<Raccoon> list) {
        this.list = list;
    }

    public List top10(Comparator<Raccoon> comparator, int n){
        if (n > list.size()){
            System.out.println("Out of bounds");
            throw new IllegalArgumentException("...");
        }
        return list.stream().sorted(comparator).limit(n).collect(Collectors.toList());
    }
}
