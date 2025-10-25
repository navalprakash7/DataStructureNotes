package LinkedList;

public class CircularSinglyLinkedList {

    // Inner class or User defined data type
    private class Node {
        int data;
        Node next;

        // Inner class constructor
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    // Insertion at start
    public void insertAtStart(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }

    // Insertion at end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
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
            tail.next = head;
        }
    }

    // Deletion at end
    public void deleteEnd() {
        if (head == null) return;
        if (head == tail) {
            head = tail = null;
            return;
        }
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = head;
        tail = temp;
    }

    // Deletion at position
    public void deleteAtPosition(int position) {
        if (head == null || position < 1) return;
        if (position == 1) {
            deleteStart();
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }
        if (temp.next != head) {
            if (temp.next == tail) tail = temp;
            temp.next = temp.next.next;
        }
    }

    // Traversal
    public void display() {
        if (head == null) return;
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }


    // Main method
    public static void main(String[] args) {
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();
        list.display();
    }
}
