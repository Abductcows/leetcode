import com.sun.source.tree.Tree;

import java.util.ArrayDeque;

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

    static class TreeNode {
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
