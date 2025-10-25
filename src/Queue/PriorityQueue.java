package Queue;

class PriorityQueue {
    private int[] data;
    private int[] priority;
    private int size, maxSize;

    PriorityQueue(int size) {
        maxSize = size;
        data = new int[maxSize];
        priority = new int[maxSize];
        this.size = 0;
    }

    void enqueue(int value, int prio) {
        if (size == maxSize) {
            System.out.println("Queue Overflow");
            return;
        }
        int i = size - 1;
        while (i >= 0 && priority[i] < prio) {
            data[i + 1] = data[i];
            priority[i + 1] = priority[i];
            i--;
        }
        data[i + 1] = value;
        priority[i + 1] = prio;
        size++;
        System.out.println(value + " inserted with priority " + prio);
    }

    void dequeue() {
        if (size == 0) {
            System.out.println("Queue Underflow");
        } else {
            System.out.println(data[--size] + " dequeued");
        }
    }

    void display() {
        if (size == 0) {
            System.out.println("Queue is empty");
        } else {
            System.out.print("Queue elements (value:priority): ");
            for (int i = 0; i < size; i++) {
                System.out.print(data[i] + ":" + priority[i] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        PriorityQueue q = new PriorityQueue(5);
        q.enqueue(10, 1);
        q.enqueue(30, 3);
        q.enqueue(20, 2);
        q.display();
        q.dequeue();
        q.display();
    }
}
