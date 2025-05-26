package AdvancedDSA.TREE;

class tNode {
        int data;
        tNode left, right;
        tNode(int data) {
            this.data = data;
            left = right = null;
        }
    }

public class binaryTree {
    

    public static void main(String[] args) {
        tNode root = new tNode(10);
        root.left = new tNode(20);
        root.right = new tNode(30);
        root.left.left = new tNode(40);

        
    }
}
