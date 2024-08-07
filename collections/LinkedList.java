package collections;

public class LinkedList {
    private Node head;
    private Node tail;

    private static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (tail != null) {
            tail.next = newNode;
        } else { // Список пуст
            head = newNode;
        }
        tail = newNode;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = newNode;
        }
    }

    public boolean contains(int value) {
        Node current = head;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}
