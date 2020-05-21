import MyLinkedList.LinkedList;
import mystream.MyList;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add("als");
        list.add("ataz");
        list.add("abc");
        list.add("cbaa");

        MyList list1 = new MyList(list);
        list1.stream();


    }
}
