import java.util.ArrayDeque;
import java.util.HashMap;

import static utils.LeetUtils.TreeNode;

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

}