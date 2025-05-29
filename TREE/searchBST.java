
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

public class searchBST {

    public static void inOrder(Node root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
    }

    public static boolean search(Node root, int val) {
        if(root == null) {
            return false;
        }

        if(root.data == val) {
            return true;
        } else if (root.data > val) {
            return search(root.left, val);
        } else {
            return search(root.right, val);
        }
    }

    public static Node insert(Node root, int val) {
        if(root == null) {
            return new Node(val);
        }

        if(root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void main(String[] arg) {
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(5);
        root.right.right = new Node(8);
        root.right.right.left = new Node(6);
        root.right.right.left.right = new Node(7);

        System.out.println(search(root, 5));
        System.out.println(insert(root, 3));
        inOrder(root);
    }
}

