package Task_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Predicate;

public class task1 {
    public static void main(String[] args) throws FileNotFoundException {

        Map result = unique(o ->((String)o).charAt(0) =='d');
        System.out.println(result.toString());

    }


    public static Map<String, Integer> unique (Predicate p1) throws FileNotFoundException {
        Map<String, Integer> uniqueStrings = new LinkedHashMap<>();
        File f1 = new File("D:/PEREZALIV/Test/src/Task_01/words");
        Scanner sc = new Scanner(f1);
        while (sc.hasNext()){
            String current = sc.next();
            if (p1.test(current)){
                if (uniqueStrings.containsKey(current)){
                    uniqueStrings.put(current, uniqueStrings.get(current)+1);
                }
                else uniqueStrings.put(current,1);
            }
        }
        Map <String, Integer> uniqueSortedStrings = new LinkedHashMap<>();
        uniqueStrings.entrySet().stream().sorted(Comparator.comparing(t -> t.getValue())).forEach(t -> uniqueSortedStrings.put(t.getKey(),t.getValue()));
        return uniqueSortedStrings;

    }

}