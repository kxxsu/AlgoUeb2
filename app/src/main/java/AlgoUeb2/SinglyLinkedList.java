package AlgoUeb2;

public class SinglyLinkedList<T> implements Listable<T> {
    private Node head = null;
    private static int counter = 0;

    private class Node {
        T data;
        Node next;

    }

    @Override
    public void add(T data) {
        addLast(data);
    }

    @Override
    public void add(int index, T data) {

    }

    @Override
    public void addFirst(T data) {
        if (head == null) { // TODO benchmark if if statement is redundant
            addLast(data);
            return;
        } else {
            Node node = head;
            head = new Node();
            head.data = data;
            head.next = node;
        }
        counter++;
    }

    @Override
    public void addLast(T data) {
        Node node = new Node();
        node.data = data;
        node.next = null;

        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        counter++;
    }

    @Override
    public T get(int index) {
        Node node = head;
        int i = 0;
        while (i < index) {
            node = node.next;
            i++;
        }
        if (node == null) {
            return null;
        } else {
            return node.data;
        }
    }

    @Override
    public void set(int index, T data) {
        Node node = head;
        int i = 0;
        while (i < index) {
            node = node.next;
            i++;
        }
        node.data = data;
    }

    @Override
    public void remove(int index) throws Exception {
        Node node = head;
        int i = 0;

        indexOutOfBounds(index);
        if (index >= 0 && index <= (counter - 1)) {
            if (index == 0) {
                head = head.next;
                counter--;
            } else {
                while (i < index - 1) {
                    node = node.next;
                    i++;
                }
                node.next = node.next.next;
            }
        } else if (isEmpty()) {
            throw new Exception("There is nothing to remove");
        }
    }

    @Override
    public void clear() {
        head = null;
        counter = 0;
    }

    @Override
    public int size() {
        return counter;
    }

    @Override
    public void printAll() {
        Node node = head;
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    private void indexOutOfBounds(int index) {
        if(index >= size() || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }
}
