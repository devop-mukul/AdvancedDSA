import java.util.*;

public class allPossibleFullBinaryTrees {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        List<TreeNode> result = allPossibleFBT(7);
        System.out.println("Number of full binary trees with 7 nodes: " + result.size());
    }

    public static List<TreeNode> recur(int n) {
        if (n % 2 == 0) {
            return List.of();
        }
        if (n == 1) {
            return List.of(new TreeNode(0));
        }

        List<TreeNode> result = new ArrayList<>();
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> leftSubtrees = recur(i);
            List<TreeNode> rightSubtrees = recur(n - i - 1);

            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
     public static List<TreeNode> allPossibleFBT(int n) {

        return recur(n);
    }
}
