package Tree;

public class BinarySearchTree {

    // Inner Node class
    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    Node root;

    // Insert function
    Node insert(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.data)
            root.left = insert(root.left, value);
        else if (value > root.data)
            root.right = insert(root.right, value);

        return root;
    }

    // Search function
    boolean search(Node root, int key) {
        if (root == null)
            return false;
        if (root.data == key)
            return true;
        if (key < root.data)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    // Delete a node
    Node delete(Node root, int key) {
        if (root == null) return null;

        if (key < root.data)
            root.left = delete(root.left, key);
        else if (key > root.data)
            root.right = delete(root.right, key);
        else {
            // Node with one or no child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // Node with two children: get inorder successor (min in right subtree)
            root.data = minValue(root.right);

            // Delete inorder successor
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    // Helper: find minimum value in a subtree
    int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    // Inorder traversal (sorted order)
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Main for testing
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.root = bst.insert(bst.root, 50);
        bst.insert(bst.root, 30);
        bst.insert(bst.root, 70);
        bst.insert(bst.root, 20);
        bst.insert(bst.root, 40);
        bst.insert(bst.root, 60);
        bst.insert(bst.root, 80);

        System.out.print("Inorder traversal (sorted): ");
        bst.inorder(bst.root);
        System.out.println();

        System.out.println("Search 40: " + bst.search(bst.root, 40));
        System.out.println("Search 90: " + bst.search(bst.root, 90));

        bst.root = bst.delete(bst.root, 20); // delete leaf
        bst.root = bst.delete(bst.root, 30); // delete node with one child
        bst.root = bst.delete(bst.root, 50); // delete node with two children

        System.out.print("Inorder after deletions: ");
        bst.inorder(bst.root);
        System.out.println();
    }
}
