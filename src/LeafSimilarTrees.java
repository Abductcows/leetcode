import java.util.ArrayDeque;

import static utils.LeetUtils.TreeNode;

class Solution333 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        ArrayDeque<TreeNode> s1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> s2 = new ArrayDeque<>();


        return true;
    }

    TreeNode nextLeaf(ArrayDeque<TreeNode> stack) {

        if (stack.isEmpty()) return null;


        TreeNode curr = stack.poll();

        while (true) {


        }
    }

    boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
