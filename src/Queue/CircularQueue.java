package Queue;

class CircularQueue {
    private int[] queue;
    private int front, rear, maxSize;

    CircularQueue(int size) {
        maxSize = size;
        queue = new int[maxSize];
        front = -1;
        rear = -1;
    }

    void enqueue(int value) {
        if ((rear + 1) % maxSize == front) {
            System.out.println("Queue Overflow");
        } else {
            if (front == -1) front = 0; // first insertion
            rear = (rear + 1) % maxSize;
            queue[rear] = value;
            System.out.println(value + " enqueued to queue");
        }
    }

    void dequeue() {
        if (front == -1) {
            System.out.println("Queue Underflow");
        } else {
            System.out.println(queue[front] + " dequeued from queue");
            if (front == rear) { // single element
                front = rear = -1;
            } else {
                front = (front + 1) % maxSize;
            }
        }
    }

    void display() {
        if (front == -1) {
            System.out.println("Queue is empty");
        } else {
            System.out.print("Queue elements: ");
            int i = front;
            while (true) {
                System.out.print(queue[i] + " ");
                if (i == rear) break;
                i = (i + 1) % maxSize;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();
        q.dequeue();
        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60);
        q.display();
    }
}
