import static utils.LeetUtils.TreeNode;

class Solution9999999999 {

    // NOT SORTED
    public int maxAncestorDiff(TreeNode root) {
        return Math.max(
                mad(root, true),
                mad(root, false)
        );
    }


    int mad(TreeNode current, boolean goLeft) {

        TreeNode node;
        if (goLeft) {
            if (current.left == null) return 0;
            for (node = current.left; node.left != null; node = node.left) ;
        } else {
            if (current.right == null) return 0;
            for (node = current.right; node.right != null; node = node.right) ;
        }

        return Math.max(
                Math.abs(current.val - node.val),
                mad(node, !goLeft)
        );
    }

}