import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;

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

public class BreadthFirstSearch {
    public static void BFS(Node root, List<Integer> result) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()) {
            Node current = q.poll();
            result.add(current.data);
            if (current.left != null) {
                q.add(current.left);
            }
            if (current.right != null) {
                q.add(current.right);
            }
        }
    }
    public static void main(String argp[]) {
        List<Integer> nodes = new ArrayList<>();
        Node root = new Node(1);
        root.left = new Node(2);
        root.left = new Node(6);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);


        BFS(root, nodes);
    }
}


