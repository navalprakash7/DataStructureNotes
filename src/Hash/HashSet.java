package Hash;

public class HashSet<T> {

    // Node class for linked list
    class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private final int SIZE = 10;  // number of buckets
    private Node<T>[] table;      // array of linked lists

    // Constructor
    public HashSet() {
        table = new Node[SIZE];
    }

    // Hash function
    private int hash(T key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    // Add element
    public void add(T value) {
        int index = hash(value);
        Node<T> head = table[index];

        // Check if already exists
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(value)) {
                System.out.println(value + " already exists in set");
                return;
            }
            temp = temp.next;
        }

        // Insert new node at beginning
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        table[index] = newNode;
        System.out.println(value + " added to set");
    }

    // Check if element exists
    public boolean contains(T value) {
        int index = hash(value);
        Node<T> temp = table[index];
        while (temp != null) {
            if (temp.data.equals(value)) return true;
            temp = temp.next;
        }
        return false;
    }

    // Remove element
    public void remove(T value) {
        int index = hash(value);
        Node<T> temp = table[index];
        Node<T> prev = null;

        while (temp != null) {
            if (temp.data.equals(value)) {
                if (prev == null) {
                    table[index] = temp.next;
                } else {
                    prev.next = temp.next;
                }
                System.out.println(value + " removed from set");
                return;
            }
            prev = temp;
            temp = temp.next;
        }
        System.out.println(value + " not found in set");
    }

    // Display set
    public void display() {
        System.out.println("HashSet contents:");
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Bucket " + i + ": ");
            Node<T> temp = table[i];
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(20); // duplicate test

        System.out.println("Contains 20? " + set.contains(20));
        System.out.println("Contains 50? " + set.contains(50));

        set.display();

        set.remove(20);
        set.remove(50);
        set.display();
    }
}
