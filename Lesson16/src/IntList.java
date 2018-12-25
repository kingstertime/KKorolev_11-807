public interface IntList {

    int size();

    boolean contains(int e);

    void add(int e);

    int get(int index);

    void remove(int index);

    void sort();

    void addAll (IntList intList);

    int[] toArray();

    int indexOf(int value);

}
