package AlgoUeb2.lists;

public class SinglyLinkedList<T> implements Listable<T> {
    private Node head = null;
    private int size = 0;

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
        Node node = head;
        Node added = new Node();
        added.data = data;

        if (index == 0) {
            addFirst(data);
        } else if (index - 1 == size) {
            addLast(data);
        } else {
            indexOutOfBounds(index);
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            added.next = node.next;
            node.next = added;
        }
        size++;
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
        size++;
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
        size++;
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
        if (isEmpty()) {
            throw new Exception("The list is empty.");
        }
        if (index >= 0 && index <= (size() - 1)) {
            if (index == 0) {
                head = head.next;
                size--;
            } else {
                while (i < index - 1) {
                    node = node.next;
                    i++;
                }
                node.next = node.next.next;
                size--;
            }
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
