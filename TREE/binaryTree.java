
class tNode {
        int data;
        tNode left, right;
        tNode(int data) {
            this.data = data;
            left = right = null;
        }

        public static void inOrder(tNode root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
        public static void preOrder(tNode root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            inOrder(root.left);
            inOrder(root.right);
        }
        public static void postOrder(tNode root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            inOrder(root.right);
            System.out.print(root.data + " ");;
        }
    }

public class binaryTree {

    public static void main(String[] args) {
        tNode root = new tNode(1);
        root.left = new tNode(2);
        root.right = new tNode(3);
        root.left.left = new tNode(4);

        System.out.print("preOrder: ");
        tNode.preOrder(root);
        System.out.println();

        System.out.print("inOrder: ");
        tNode.inOrder(root);
        
    }
}
