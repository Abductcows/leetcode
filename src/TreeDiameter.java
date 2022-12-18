import static utils.LeetUtils.TreeNode;

class Solutionmkko {

    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        run(root);
        return max;
    }

    int run(TreeNode root) {

        if (root == null) return 0;
        int leftHeight, rightHeight;
        leftHeight = run(root.left);
        rightHeight = run(root.right);

        max = Math.max(max, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}