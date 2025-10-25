package Hash;

// Custom HashMap implementation using separate chaining
public class HashMap<K, V> {

    // Node class to store key-value pairs
    @SuppressWarnings("hiding")
    class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 10;        // number of buckets
    private Node<K, V>[] table;         // array of linked lists

    // Constructor
    public HashMap() {
        table = new Node[SIZE];
    }

    // Hash function
    private int hash(K key) {
        return Math.abs(key.hashCode()) % SIZE;
    }

    // Put key-value pair
    public void put(K key, V value) {
        int index = hash(key);
        Node<K, V> head = table[index];

        // Check if key already exists
        Node<K, V> temp = head;
        while (temp != null) {
            if (temp.key.equals(key)) {
                temp.value = value;  // update existing key
                return;
            }
            temp = temp.next;
        }

        // Insert new node at beginning of list
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = head;
        table[index] = newNode;
    }

    // Get value by key
    public V get(K key) {
        int index = hash(key);
        Node<K, V> temp = table[index];
        while (temp != null) {
            if (temp.key.equals(key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return null; // not found
    }

    // Remove key-value pair
    public void remove(K key) {
        int index = hash(key);
        Node<K, V> temp = table[index];
        Node<K, V> prev = null;

        while (temp != null) {
            if (temp.key.equals(key)) {
                if (prev == null) {
                    table[index] = temp.next;
                } else {
                    prev.next = temp.next;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    // Display entire HashMap
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            System.out.print("Bucket " + i + ": ");
            Node<K, V> temp = table[i];
            while (temp != null) {
                System.out.print("[" + temp.key + " : " + temp.value + "] -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    // Main function for testing
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);
        map.display();

        System.out.println("Value for key 'B': " + map.get("B"));
        map.remove("A");
        map.display();
    }
}
