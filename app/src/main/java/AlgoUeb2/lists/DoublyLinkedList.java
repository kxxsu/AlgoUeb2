package AlgoUeb2.lists;

public class DoublyLinkedList<T> implements Listable<T> {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    private class Node {
        T data;
        Node next;
        Node prev;

        Node(Node prev, T data, Node next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public void add(T data) {
        addLast(data);
    }

    @Override
    public void add(int index, T data) {
        if (index == 0 && isEmpty()) {
            addLast(data);
        }
        indexOutOfBounds(index);

    }

    @Override
    public void addFirst(T data) {
        Node moved = head;
        Node node = new Node(null, data, moved);
        head = node;
        if (moved == null) {
            tail = node;
        } else {
            moved.prev = head;
        }
        size++;
    }

    @Override
    public void addLast(T data) {
        Node moved = tail;
        Node node = new Node(moved, data, null);
        tail = node;
        if (moved == null) {
            head = node;
        } else {
            moved.next = tail;
        }
        size++;
    }

    @Override
    public T get(int index) {
        indexOutOfBounds(index);
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
        indexOutOfBounds(index);
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = data;
    }

    @Override
    public void remove(int index) throws Exception {
        indexOutOfBounds(index);

        if (isEmpty()) {
            throw new Exception("List is empty");
        } else if (size == 1) {
            clear();
        } else if (index == 0) {
            head = head.next;
        } else {
            Node node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
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
        if (index >= size() || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }
}
