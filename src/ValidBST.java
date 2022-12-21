import java.util.HashMap;
import java.util.Stack;
import java.util.function.Predicate;

import static utils.LeetUtils.TreeNode;

class Solutionzeeee {

    //todo

    boolean[] isValid = {true};
    HashMap<TreeNode, Integer> mins = new HashMap<>();
    HashMap<TreeNode, Integer> maxs = new HashMap<>();

    public boolean isValidBST(TreeNode root) {

        postOrderIterEarlyStop(root, (node) -> {
            int max = node.val;
            if (node.left != null) {
                max = maxs.get(node.left);
                if (max >= node.val) {
                    isValid[0] = false;
                    return true;
                }
            }

            int maxRight = node.val;
            if (node.right != null) {
                max =
                maxRight = maxs.get(node.right);
                if (maxRight <= node.val) {
                    isValid[0] = false;
                    return true;
                }
            }
            maxs.put(node, maxRight);
            return false;
        });
        return isValid[0];
    }

    void postOrderIterEarlyStop(TreeNode root, Predicate<TreeNode> action) {

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> toPop = new Stack<>();

        for (TreeNode current = root; current != null; stack.push(current), current = current.left) ;

        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            if (top.right == null) {
                if (action.test(stack.pop())) return;
                continue;
            }

            TreeNode nextPop = toPop.isEmpty() ? null : toPop.peek();
            if (top == nextPop) {
                if (action.test(stack.pop())) return;
                toPop.pop();
            } else {
                toPop.push(top);
                for (TreeNode current = top.right; current != null; stack.push(current), current = current.left) ;
            }
        }
    }
}