package LinkedList;

public class DoublyLinkedList {

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
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Insertion at end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Insertion at any position
    public void insertAtPos(int data, int position) {
        if (position < 1) return;
        if (position == 1) {
            insertAtStart(data);
            return;
        }
        Node temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp != null) {
            Node newNode = new Node(data);
            newNode.next = temp.next;
            newNode.prev = temp;
            if (temp.next != null) {
                temp.next.prev = newNode;
            } else {
                tail = newNode;
            }
            temp.next = newNode;
        }
    }

    // Deletion at start
    public void deleteStart() {
        if (head == null) return;
        if (head.next == null) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    // Deletion at end
    public void deleteEnd() {
        if (tail == null) return;
        if (tail.prev == null) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    // Deletion at any position
    public void deleteAtPosition(int position) {
        if (position < 1 || head == null) return;
        if (position == 1) {
            deleteStart();
            return;
        }
        Node temp = head;
        for (int i = 1; temp != null && i < position; i++) {
            temp = temp.next;
        }
        if (temp != null) {
            if (temp.next != null) temp.next.prev = temp.prev;
            if (temp.prev != null) temp.prev.next = temp.next;
            if (temp == tail) tail = temp.prev;
        }
    }

    // Traversal forward
    public void displayForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Traversal backward
    public void displayBackward() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.displayForward();
    }
}