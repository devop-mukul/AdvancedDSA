// This code defines a binary tree and counts the number of nodes in it.
    class Node {
        Node left;
        Node right;
        int data;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
}

public class CountNodes {
    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(countNodes(root));
    }
}