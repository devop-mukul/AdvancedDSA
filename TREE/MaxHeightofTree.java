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

public class MaxHeightofTree {
    public static int calcHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(calcHeight(root.left), calcHeight(root.right));
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.right = new Node(7);
        root.left.right.left = new Node(8);
        root.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(9);

        System.out.println(calcHeight(root));
    }
}
