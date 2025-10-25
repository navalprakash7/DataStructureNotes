package Stack;

class DynamicStack {

    // Inner class or User defined data type
    class Node {
        int data;
        Node next;
        
        //Inner Constructor
        Node(int value) {
            data = value;
            next = null;
        }
    }
    private Node top;
    // Push function
    void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top; // new node points to previous top
        top = newNode;      // new node becomes top
        System.out.println(value + " pushed to stack");
    }

    // Pop function
    void pop() {
        if (top == null) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println(top.data + " popped from stack");
            top = top.next; // move top to next node
        }
    }

    // Peek function
    void peek() {
        if (top == null) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Top element is: " + top.data);
        }
    }

    // Display function
    void display() {
        if (top == null) {
            System.out.println("Stack is empty");
        } else {
            System.out.print("Stack elements: ");
            Node temp = top;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    // Main function
    public static void main(String[] args) {
        DynamicStack s = new DynamicStack();
        s.display();
    }
}
