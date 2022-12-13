import java.util.ArrayDeque;
import java.util.HashMap;

class Solutionnnnnnnnnn {
    HashMap<TreeNode, Integer> sums = new HashMap<>();
    public int maxProduct(TreeNode root) {

        populateSums(root);
        return 0;
    }

    private void populateSums(TreeNode root) {

        TreeNode current = root;
    }

    int nodeSum(TreeNode current) {

        var stack = new ArrayDeque<>();


        if (current == null) return 0;
        return nodeSum(current.left) + nodeSum(current.right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}