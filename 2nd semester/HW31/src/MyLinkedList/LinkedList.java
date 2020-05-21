package MyLinkedList;


public class LinkedList<T> {
    private Node head;
    private int count = 0;

    //добавление в конец
    public void add(T e) {
        Node newNode = new Node();
        newNode.setValue(e);
        newNode.setNext(null);
        if (head != null) {
            Node current = head;
            //по итогу цикла в current записана ссылка на последнюю Ноду
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        } else {
            head = newNode;
        }
        count++;
    }

    public T get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index: " + index + " вне границ");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return (T) current.getValue();
    }

    public void remove(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index: " + index + " вне границ");
        }
        if (index == 0) {
            head = head.getNext();
        } else {
            Node beforeRemovable = head;
            for (int i = 0; i < index - 1; i++) {
                beforeRemovable = beforeRemovable.getNext();
            }
            Node nodeToRemove = beforeRemovable.getNext();
            beforeRemovable.setNext(nodeToRemove.getNext());
        }
        count--;
    }
}
