package Queue;
//also known as Deque
class DoubleEndedQueue {
    private int[] deque;
    private int front, rear, maxSize;

    DoubleEndedQueue(int size) {
        maxSize = size;
        deque = new int[maxSize];
        front = -1;
        rear = -1;
    }

    void insertFront(int value) {
        if ((front == 0 && rear == maxSize - 1) || (front == rear + 1)) {
            System.out.println("Deque Overflow");
        } else if (front == -1) {
            front = rear = 0;
            deque[front] = value;
        } else if (front == 0) {
            front = maxSize - 1;
            deque[front] = value;
        } else {
            deque[--front] = value;
        }
        System.out.println(value + " inserted at front");
    }

    void insertRear(int value) {
        if ((front == 0 && rear == maxSize - 1) || (front == rear + 1)) {
            System.out.println("Deque Overflow");
        } else if (rear == -1) {
            front = rear = 0;
            deque[rear] = value;
        } else if (rear == maxSize - 1) {
            rear = 0;
            deque[rear] = value;
        } else {
            deque[++rear] = value;
        }
        System.out.println(value + " inserted at rear");
    }

    void deleteFront() {
        if (front == -1) {
            System.out.println("Deque Underflow");
        } else {
            System.out.println(deque[front] + " deleted from front");
            if (front == rear) {
                front = rear = -1;
            } else if (front == maxSize - 1) {
                front = 0;
            } else {
                front++;
            }
        }
    }

    void deleteRear() {
        if (rear == -1) {
            System.out.println("Deque Underflow");
        } else {
            System.out.println(deque[rear] + " deleted from rear");
            if (front == rear) {
                front = rear = -1;
            } else if (rear == 0) {
                rear = maxSize - 1;
            } else {
                rear--;
            }
        }
    }

    void display() {
        if (front == -1) {
            System.out.println("Deque is empty");
        } else {
            System.out.print("Deque elements: ");
            int i = front;
            while (true) {
                System.out.print(deque[i] + " ");
                if (i == rear) break;
                i = (i + 1) % maxSize;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DoubleEndedQueue dq = new DoubleEndedQueue(5);
        dq.insertRear(10);
        dq.insertRear(20);
        dq.insertFront(5);
        dq.display();
        dq.deleteRear();
        dq.deleteFront();
        dq.display();
    }
}
