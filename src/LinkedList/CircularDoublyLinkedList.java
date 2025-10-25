package LinkedList;

public class CircularDoublyLinkedList {

    // Inner class or User defined data type
    private class Node {
        int data;
        Node next;
        Node prev;

        // Inner class constructor
        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;

    // Insertion at start
    public void insertAtStart(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            head.next = head.prev = head;
        } else {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        }
    }

    // Insertion at end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
            head.next = head.prev = head;
        } else {
            newNode.prev = tail;
            newNode.next = head;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
        }
    }

    // Insertion at specific position
    public void insertAtPos(int data, int position) {
        if (position < 1) return;
        if (position == 1) {
            insertAtStart(data);
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
        if (temp == tail) tail = newNode;
    }

    // Deletion at start
    public void deleteStart() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
    }

    // Deletion at end
    public void deleteEnd() {
        if (tail == null) return;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        }
    }

    // Deletion at specific position
    public void deleteAtPosition(int position) {
        if (position < 1 || head == null) return;
        if (position == 1) {
            deleteStart();
            return;
        }
        Node temp = head;
        for (int i = 1; i < position && temp.next != head; i++) {
            temp = temp.next;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        if (temp == tail) tail = temp.prev;
    }

    // Traversal forward
    public void displayForward() {
        if (head == null) return;
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // Traversal backward
    public void displayBackward() {
        if (tail == null) return;
        Node temp = tail;
        do {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        } while (temp != tail);
        System.out.println();
    }


    // Main method
    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        list.displayForward();
    }
}
