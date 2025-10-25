package Stack;

//Outer class 
class StaticStack {
    private int maxSize;    
    private int[] stack;    
    private int top;     

    //Outer class Constructor
    StaticStack(int size) {
        maxSize = size;
        stack = new int[maxSize];
        top = -1; // stack initially empty
    }

    // Check if stack is empty
    boolean isEmpty() {
        return top == -1;
    }

    // Check if stack is full
    boolean isFull() {
        return top == maxSize - 1;
    }

    // Push function
    void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow");
        } else {
            stack[++top] = value;
            System.out.println(value + " pushed to stack");
        }
    }

    // Pop function
    void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println(stack[top--] + " popped from stack");
        }
    }

    // Peek function
    void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Top element is: " + stack[top]);
        }
    }

    // Display function
    void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.print("Stack elements: ");
            for (int i = top; i >= 0; i--) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    // main function
    public static void main(String[] args) {
        StaticStack s = new StaticStack(5);
        s.display();
    }
}
