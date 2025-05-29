import java.util.ArrayList;
import java.util.List;

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

class NodesatKHeight {
    public static void main(String args[]) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.right = new Node(7);
        root.left.right.left = new Node(8);
        root.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(9);

        int k = 3;
        List<Integer> nodesAtK = new ArrayList<>();
        int count = countNodesAtKHeight(root, k, nodesAtK);
        System.out.println("Number of nodes at height " + k + ": " + count);
    }

    static int countNodesAtKHeight(Node root, int k, List<Integer> nodesAtK) {
        if (root == null) {
            return 0;
        }
        if (k == 0) {
            nodesAtK.add(root.data);
            return 1; // Count this node
        }
        int leftCount = countNodesAtKHeight(root.left, k - 1, nodesAtK);
        int rightCount = countNodesAtKHeight(root.right, k - 1, nodesAtK);
        return (leftCount + rightCount);

    }
}
