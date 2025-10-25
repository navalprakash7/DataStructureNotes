package Queue;

class LinearQueue {
    private int[] queue;
    private int front, rear, maxSize;

    // Constructor
    LinearQueue(int size) {
        maxSize = size;
        queue = new int[maxSize];
        front = 0;
        rear = -1;
    }

    // Enqueue operation
    void enqueue(int value) {
        if (rear == maxSize - 1) {
            System.out.println("Queue Overflow");
        } else {
            queue[++rear] = value;
            System.out.println(value + " enqueued to queue");
        }
    }

    // Dequeue operation
    void dequeue() {
        if (front > rear) {
            System.out.println("Queue Underflow");
        } else {
            System.out.println(queue[front++] + " dequeued from queue");
        }
    }

    // Display operation
    void display() {
        if (front > rear) {
            System.out.println("Queue is empty");
        } else {
            System.out.print("Queue elements: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }

    // Main for testing
    public static void main(String[] args) {
        LinearQueue q = new LinearQueue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();
        q.dequeue();
        q.display();
    }
}
