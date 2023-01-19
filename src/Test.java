import java.util.ArrayDeque;

import static utils.LeetUtils.TreeNode;

class Solution {
    public int rob(TreeNode root) {

        ArrayDeque<TreeNode> nodes = new ArrayDeque<>(128);
        nodes.add(root);
        int depth = 0, nodesLeft = 1, nodesOnNextLevel = 0;
        int[] sums = {0, 0};

        while (!nodes.isEmpty()) {

            TreeNode cur = nodes.remove();
            sums[depth % 2] += cur.val;

            if (cur.left != null) {
                nodes.add(cur.left);
                ++nodesOnNextLevel;
            }

            if (cur.right != null) {
                nodes.add(cur.right);
                ++nodesOnNextLevel;
            }

            if (--nodesLeft == 0) {
                nodesLeft = nodesOnNextLevel;
                nodesOnNextLevel = 0;
                ++depth;
            }
        }

        return Math.max(sums[0], sums[1]);
    }
}