import java.util.Stack;
import java.util.function.Predicate;

import static utils.LeetUtils.TreeNode;

class Solution71718 {

    int[] k = new int[1], result = new int[1];

    public int kthSmallest(TreeNode root, int k) {
        this.k[0] = k;
        inorderIterEarlyStop(root, (node) -> {
            if (--this.k[0] == 0) {
                result[0] = node.val;
                return true;
            }
            return false;
        });
        return result[0];
    }

    void inorderIterEarlyStop(TreeNode root, Predicate<TreeNode> action) {

        Stack<TreeNode> stack = new Stack<>();
        for (TreeNode current = root; current != null; stack.push(current), current = current.left) ;

        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (action.test(top)) {
                return;
            }
            if (top.right != null) {
                for (TreeNode current = top.right; current != null; stack.push(current), current = current.left) ;
            }
        }
    }
}